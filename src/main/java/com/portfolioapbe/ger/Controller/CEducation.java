package com.portfolioapbe.ger.Controller;

import com.portfolioapbe.ger.Entity.Education;
import com.portfolioapbe.ger.Service.SEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class CEducation {
    private final SEducation sEducation;

    @Autowired
    public CEducation(SEducation sEducation) {
        this.sEducation = sEducation;
    }
    //Metodos
    @GetMapping("/alledu")
    public ResponseEntity<List<Education>> findEducation() {
        List<Education> educations = sEducation.findEducation();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editedu/{id}")
    public ResponseEntity<Education> editEducation(@RequestBody Education education) {
        Education newEducation = sEducation.editEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addedu")
    public ResponseEntity<Education> addEducation(@RequestBody Education education) {
        Education newEducation=sEducation.addEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteedu/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id) {
        sEducation.deleteEducation(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id) {
        if (sEducation.existsById(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

}
