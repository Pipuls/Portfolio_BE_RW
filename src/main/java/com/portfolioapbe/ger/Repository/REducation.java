package com.portfolioapbe.ger.Repository;

import com.portfolioapbe.ger.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface REducation extends JpaRepository<Education, Long> {

    //Metodos propios
    public Optional<Education> findByTitleE (String titleE);
    public boolean existsByTitleE(String titleE);

    public Optional<Education> findById(Long id);

    public boolean existsById(Long id);
}
