package com.portfolioapbe.ger.Service;

import com.portfolioapbe.ger.Entity.About;
import com.portfolioapbe.ger.Exception.UserNotFoundException;
import com.portfolioapbe.ger.Repository.RAbout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SAbout {
    private final RAbout rAbout;

    @Autowired
    public SAbout(RAbout rAbout) {
        this.rAbout = rAbout;
    }
    //Métodos
    public About addAbout(About about){
        return rAbout.save(about);
    }
    public List<About> findAbout(){
        return rAbout.findAll();
    }
    public About editAbout(About about){
        return rAbout.save(about);
    }
    public void deleteAbout(Long id){
        rAbout.deleteById(id);
    }
    public About findAboutById (Long id) {
        return rAbout.findById(id).orElseThrow(() -> new UserNotFoundException("Descripcion de persona no encontrada"));
    }
}
