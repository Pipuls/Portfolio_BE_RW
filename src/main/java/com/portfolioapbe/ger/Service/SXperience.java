package com.portfolioapbe.ger.Service;


import com.portfolioapbe.ger.Entity.Education;
import com.portfolioapbe.ger.Entity.Xperience;
import com.portfolioapbe.ger.Repository.RXperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SXperience {
    private final RXperience rXperience;

    @Autowired
    public SXperience(RXperience rXperience) {
        this.rXperience = rXperience;
    }

    public Xperience addXperience(Xperience xperience) {
        return rXperience.save(xperience);
    }

    public List<Xperience> findXperience() { return rXperience.findAll();
    }

    public Xperience editXperience(Xperience xperience) {
        return rXperience.save(xperience);
    }

    public void deleteXperience(Long id) {
        rXperience.deleteById(id);
    }

    public Optional<Xperience> getOne(Long id) {
        return rXperience.findById(id);
    }

    public Optional<Xperience> getByCompanyX(String companyX) {
        return rXperience.findByCompanyX(companyX);
    }

    public boolean existsById(Long id) {
        return rXperience.existsById(id);
    }

    public boolean existsByCompanyX(String companyX) {
        return rXperience.existsByCompanyX(companyX);
    }
}
