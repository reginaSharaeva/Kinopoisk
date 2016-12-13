package com.itis.dz.services;

import com.itis.dz.entities.User;

import javax.transaction.Transactional;

public interface UserService {
    @Transactional
    User getUserByLogin(String login);

    @Transactional
    boolean checkUser(String mail);

    @Transactional
    void addTestData();

    @Transactional
    void addUser(String name, String mail, String hash_pass);
}
