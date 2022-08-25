package com.portfolioapbe.ger.Service;

import com.portfolioapbe.ger.Entity.Education;
import com.portfolioapbe.ger.Repository.REducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SEducation {
    private final REducation rEducation;

    @Autowired
    public SEducation(REducation rEducation) {
        this.rEducation = rEducation;
    }

    //Metodos
    public Education addEducation(Education education) {
        return rEducation.save(education);
    }

    public List<Education> findEducation() {
        return rEducation.findAll();
    }

    public Education editEducation(Education education) {
        return rEducation.save(education);
    }

    public void deleteEducation(Long id) {
        rEducation.deleteById(id);
    }

    public Optional<Education> getOne(Long id) {
        return rEducation.findById(id);
    }

    public Optional<Education> getByTitleE(String titleE) {
        return rEducation.findByTitleE(titleE);
    }

    public boolean existsById(Long id) {
        return rEducation.existsById(id);
    }

    public boolean existsByTitleE(String titleE) {
        return rEducation.existsByTitleE(titleE);
    }


}
