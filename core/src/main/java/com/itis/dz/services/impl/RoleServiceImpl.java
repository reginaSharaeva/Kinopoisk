package com.itis.dz.services.impl;

import com.itis.dz.entities.Role;
import com.itis.dz.repositories.RoleRepository;
import com.itis.dz.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }



    public void addTestData(){

        roleRepository.addRole(new Role("Актер"));
        roleRepository.addRole(new Role("Сценарист"));
        roleRepository.addRole(new Role("Режиссер"));


    }

}
