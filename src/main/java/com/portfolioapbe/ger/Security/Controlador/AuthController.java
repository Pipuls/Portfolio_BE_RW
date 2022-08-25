package com.portfolioapbe.ger.Security.Controlador;

import com.portfolioapbe.ger.Dto.Message;
import com.portfolioapbe.ger.Security.Dto.DtoJwt;
import com.portfolioapbe.ger.Security.Dto.NewUser;
import com.portfolioapbe.ger.Security.Dto.UserLogin;
import com.portfolioapbe.ger.Security.Entity.Rol;
import com.portfolioapbe.ger.Security.Entity.User;
import com.portfolioapbe.ger.Security.Enums.RolName;
import com.portfolioapbe.ger.Security.Jwt.JwtProvider;
import com.portfolioapbe.ger.Security.Service.SRol;
import com.portfolioapbe.ger.Security.Service.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SUser sUser;

    @Autowired
    SRol sRol;

    @Autowired
    JwtProvider jwtProvider;

    //metodos
    @PostMapping("/new")
    public ResponseEntity<?> newU(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Nombre de usuario o email incorrectos"), HttpStatus.BAD_REQUEST);
        if (sUser.existsByUserName(newUser.getUserName()))
            return new ResponseEntity(new Message("El nombre ya se encuentra en la base de datos"), HttpStatus.BAD_REQUEST);
        if (sUser.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("La dirección de correo ya se encuentra en la base de datos"), HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getName(), newUser.getUserName(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(sRol.getByRolName(RolName.ROLE_USER) .get());
        if (newUser.getRoles().contains("admin"))
            roles.add(sRol.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        sUser.save(user);
        return new ResponseEntity(new Message("Usuario guardado"),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<DtoJwt> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Nombre de usuario o password incorrectos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLogin.getUserName(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        DtoJwt dtoJwt = new DtoJwt(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(dtoJwt, HttpStatus.OK);
    }
}
