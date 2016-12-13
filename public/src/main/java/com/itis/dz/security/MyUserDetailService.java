package com.itis.dz.security;

import com.itis.dz.entities.User;
import com.itis.dz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + login + " not found");
        }
        MyUserDetail myUserDetail = new MyUserDetail(user);
        return myUserDetail;
    }

}
