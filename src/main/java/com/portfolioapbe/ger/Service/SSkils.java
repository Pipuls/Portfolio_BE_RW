package com.portfolioapbe.ger.Service;

import com.portfolioapbe.ger.Entity.Skils;
import com.portfolioapbe.ger.Repository.RSkils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SSkils {
    private final RSkils rSkils;

    @Autowired
    public SSkils(RSkils rSkils) {
        this.rSkils = rSkils;
    }

    //Metodos
    public Skils addSkils(Skils skils) {
        return rSkils.save(skils);
    }

    public List<Skils> findSkils() {
        return rSkils.findAll();
    }

    public Skils editSkils(Skils skils) {
        return rSkils.save(skils);
    }

    public void deleteSkils(Long id) {
        rSkils.deleteById(id);
    }

    public Optional<Skils> getOne(Long id) {
        return rSkils.findById(id);
    }

    public Optional<Skils> getByNameS(String nameS) {
        return rSkils.findByNameS(nameS);
    }

    public boolean existsById(Long id) {
        return rSkils.existsById(id);
    }

    public boolean existsByNameS(String nameS) {
        return rSkils.existsByNameS(nameS);
    }
}
