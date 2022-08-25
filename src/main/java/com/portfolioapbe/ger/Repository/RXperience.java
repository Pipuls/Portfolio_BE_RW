package com.portfolioapbe.ger.Repository;

import com.portfolioapbe.ger.Entity.Xperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RXperience extends JpaRepository<Xperience, Long> {
    public Optional<Xperience> findByCompanyX (String titleE);
    public boolean existsByCompanyX(String titleE);

    public Optional<Xperience> findById(Long id);

    public boolean existsById(Long id);
}
