package com.portfolioapbe.ger.Security.Service;

import com.portfolioapbe.ger.Security.Entity.Rol;
import com.portfolioapbe.ger.Security.Enums.RolName;
import com.portfolioapbe.ger.Security.Repository.RRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SRol {
    @Autowired
    RRol rRol;
    //metodos
    public Optional<Rol> getByRolName(RolName rolName){
        return rRol.findByRolName(rolName);
    }
    public void save(Rol rol){
       rRol.save(rol);
    }

}
