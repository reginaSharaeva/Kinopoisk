package com.itis.dz.services;

import com.itis.dz.entities.Role;

import javax.transaction.Transactional;

public interface RoleService {
    @Transactional
    Role getRoleById(Long id);

    @Transactional
    void addTestData();
}
