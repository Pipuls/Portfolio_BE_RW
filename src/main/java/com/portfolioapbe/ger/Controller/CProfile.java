package com.portfolioapbe.ger.Controller;

import com.portfolioapbe.ger.Entity.Profile;
import com.portfolioapbe.ger.Service.SProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class CProfile {
    private final SProfile sProfile;

    @Autowired
    public CProfile(SProfile sProfile) {
        this.sProfile = sProfile;
    }
    //metodos
    @GetMapping("/allprofile")
    public ResponseEntity<List<Profile>> findProfile(){
        List<Profile> profiles = sProfile.findProfile();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Profile> findProfile(@PathVariable("id") Long id) {
        Profile profile = sProfile.findProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Profile> editProfile(@RequestBody Profile profile) {
        Profile newProfile = sProfile.editProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.OK);
    }


}
