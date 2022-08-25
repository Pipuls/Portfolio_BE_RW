package com.portfolioapbe.ger.Controller;

import com.portfolioapbe.ger.Entity.Education;
import com.portfolioapbe.ger.Entity.Xperience;
import com.portfolioapbe.ger.Service.SXperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xperience")
public class CXperience {
    private final SXperience sXperience;

    @Autowired
    public CXperience(SXperience sXperience) {
        this.sXperience = sXperience;
    }

    //Metodos
    @GetMapping("/allxp")
    public ResponseEntity<List<Xperience>> findXperience() {
        List<Xperience> xperiences = sXperience.findXperience();
        return new ResponseEntity<>(xperiences, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editxp/{id}")
    public ResponseEntity<Xperience> editXperience(@RequestBody Xperience xperience) {
        Xperience newXperience = sXperience.editXperience(xperience);
        return new ResponseEntity<>(newXperience, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addxp")
    public ResponseEntity<Xperience> addXperience(@RequestBody Xperience xperience) {
        Xperience newXperience=sXperience.addXperience(xperience);
        return new ResponseEntity(newXperience, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletexp/{id}")
    public ResponseEntity<?> deleteXperience(@PathVariable("id") Long id) {
        sXperience.deleteXperience(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Xperience> getById(@PathVariable("id") Long id) {
        if (sXperience.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Xperience xperience = sXperience.getOne(id).get();
        return new ResponseEntity(xperience, HttpStatus.OK);
    }
}
