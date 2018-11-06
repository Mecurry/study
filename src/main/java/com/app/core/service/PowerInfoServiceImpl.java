package com.app.core.service;

import com.app.core.domain.PowerInfo;
import com.app.core.domain.PowerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerInfoServiceImpl implements PowerInfoService {

    @Autowired
    private PowerInfoRepository powerRe;


    @Override
    public List<PowerInfo> findAll() {

        return powerRe.findAll();
    }

    @Override
    public void save(PowerInfo p) {
        powerRe.save(p);
    }

}
