package com.portfolioapbe.ger.Security.Service;

import com.portfolioapbe.ger.Security.Entity.User;
import com.portfolioapbe.ger.Security.Repository.RUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SUser {
    @Autowired
    RUser rUser;

    public Optional<User> getByUserName(String userName){
        return rUser.findByUserName(userName);
    }

    public boolean existsByUserName (String userName){
        return rUser.existsByUserName(userName);
    }
    public boolean existsByEmail (String email){
        return rUser.existsByEmail(email);
    }

    public void save(User user){
        rUser.save(user);
    }
}
