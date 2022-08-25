package com.portfolioapbe.ger.Security.Service;

import com.portfolioapbe.ger.Security.Entity.MainUser;
import com.portfolioapbe.ger.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SUserDetailsImpl implements UserDetailsService {

    @Autowired
    SUser sUser;

    //metodos
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = sUser.getByUserName(username).get();
        return MainUser.build(user);
    }
}
