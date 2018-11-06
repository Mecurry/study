package com.app.core.service;

import com.app.core.domain.PowerInfo;

import java.util.List;

public interface PowerInfoService {
        List<PowerInfo> findAll();
        void save(PowerInfo p);
}
