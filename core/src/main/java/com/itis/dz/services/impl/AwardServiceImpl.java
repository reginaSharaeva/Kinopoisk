package com.itis.dz.services.impl;

import com.itis.dz.entities.Award;
import com.itis.dz.repositories.AwardRepository;
import com.itis.dz.services.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardRepository awardRepository;

    public Award getAwardById(Long id) {
        return awardRepository.getAwardById(id);
    }



    public void addTestData(){

        awardRepository.addAward(new Award("лучший актер"));
        awardRepository.addAward(new Award("лучший режиссер"));
        awardRepository.addAward(new Award("лучший сценарист"));

    }


}
