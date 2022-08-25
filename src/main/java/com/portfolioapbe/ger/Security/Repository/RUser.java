package com.portfolioapbe.ger.Security.Repository;

import com.portfolioapbe.ger.Security.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RUser extends JpaRepository<User, Integer> {
    //metodos
    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}
