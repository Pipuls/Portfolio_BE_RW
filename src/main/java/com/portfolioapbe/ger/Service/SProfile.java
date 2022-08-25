package com.portfolioapbe.ger.Service;

import com.portfolioapbe.ger.Entity.Profile;
import com.portfolioapbe.ger.Exception.UserNotFoundException;
import com.portfolioapbe.ger.Repository.RProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SProfile {
    private final RProfile rProfile;

    @Autowired
    public SProfile(RProfile rProfile) {
        this.rProfile = rProfile;
    }

    //Métodos
    public Profile addProfile(Profile profile){
        return rProfile.save(profile);
    }

    public List<Profile> findProfile(){
        return rProfile.findAll();
    }

    public Profile editProfile(Profile profile){
        return rProfile.save(profile);
    }

    public void deleteProfile(Long id){
        rProfile.deleteById(id);
    }

    public Profile findProfileById (Long id){
        return rProfile.findById(id).orElseThrow(() -> new UserNotFoundException("Persona no encontrada"));
    }
}
