package com.portfolioapbe.ger.Controller;

import com.portfolioapbe.ger.Entity.About;
import com.portfolioapbe.ger.Service.SAbout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
public class CAbout {
    private final SAbout sAbout;

    @Autowired
    public CAbout(SAbout sAbout) {
        this.sAbout = sAbout;
    }

    @GetMapping("/allabout")
    public ResponseEntity<List<About>> findAbout() {
        List<About> abouts = sAbout.findAbout();
        return new ResponseEntity<>(abouts, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<About> findAbout(@PathVariable("id")Long id){
        About about = sAbout.findAboutById(id);
        return new ResponseEntity<>(about, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<About> editAbout(@RequestBody About about){
        About newAbout = sAbout.editAbout(about);
        return new ResponseEntity<>(newAbout, HttpStatus.OK);
    }

}
