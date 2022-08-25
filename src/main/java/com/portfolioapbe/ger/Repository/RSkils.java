package com.portfolioapbe.ger.Repository;

import com.portfolioapbe.ger.Entity.Skils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RSkils extends JpaRepository<Skils,Long> {

    //Metodos propios
    public Optional<Skils> findByNameS (String nameS);
    public boolean existsByNameS(String nameS);

    public Optional<Skils> findById(Long id);

    public boolean existsById(Long id);
}
