package com.base.inic.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.inic.model.domain.AppInfo;
import com.base.inic.model.repository.AppInfoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AppInfoService{

    private final Logger log = LoggerFactory.getLogger(AppInfoService.class);

    @Autowired
    private AppInfoRepository appInfoRepository;


    public AppInfo save(AppInfo appInfo) {
        log.debug("Request to save AppInfo : {}", appInfo);
        return appInfoRepository.save(appInfo);
    }

    @Transactional(readOnly = true)
    public List<AppInfo> findAll() {
        log.debug("Request to get all AppInfo");
        return appInfoRepository.findAll();
    }
}
