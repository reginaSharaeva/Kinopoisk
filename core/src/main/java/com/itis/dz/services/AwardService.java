package com.itis.dz.services;

import com.itis.dz.entities.Award;

import javax.transaction.Transactional;


public interface AwardService {

    @Transactional
    Award getAwardById(Long id);

    @Transactional
    void addTestData();
}
