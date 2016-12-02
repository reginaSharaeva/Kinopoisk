package com.itis.dz.services.impl;

import com.itis.dz.entities.User;
import com.itis.dz.repositories.UserRepository;
import com.itis.dz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public boolean checkUser(String mail) {
        User user = userRepository.getUserByLogin(mail);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String name, String mail, String hash_pass) {
        userRepository.addUser(name,mail,hash_pass);
    }
    public void addTestData(){

        userRepository.addUser(new User("vasya@mail.ru","81dc9bdb52d04dc20036dbd8313ed055", "Василий","Role_User"));
        userRepository.addUser(new User("andrey@mail.ru","81dc9bdb52d04dc20036dbd8313ed055", "Андрей","Role_Admin"));
    }
}
