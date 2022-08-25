package com.portfolioapbe.ger.Controller;

import com.portfolioapbe.ger.Entity.Skils;
import com.portfolioapbe.ger.Service.SSkils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skil")
public class CSkils {
    private final SSkils sSkils;

    @Autowired
    public CSkils(SSkils sSkils) {
        this.sSkils = sSkils;
    }

    //Metodos
    @GetMapping("/allskils")
    public ResponseEntity<List<Skils>> findSkils() {
        List<Skils> skils = sSkils.findSkils();
        return new ResponseEntity<>(skils, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editskils/{id}")
    public ResponseEntity<Skils> editSkils(@RequestBody Skils skils) {
        Skils newSkils = sSkils.editSkils(skils);
        return new ResponseEntity<>(newSkils, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addskils")
    public ResponseEntity<Skils> addSkils(@RequestBody Skils skils) {
        Skils newSkils=sSkils.addSkils(skils);
        return new ResponseEntity(newSkils, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteskils/{id}")
    public ResponseEntity<?> deleteSkils(@PathVariable("id") Long id) {
        sSkils.deleteSkils(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skils> getById(@PathVariable("id") Long id) {
        if (sSkils.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Skils skils = sSkils.getOne(id).get();
        return new ResponseEntity(skils, HttpStatus.OK);
    }
}
