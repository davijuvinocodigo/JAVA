package com.base.inic.model.repository;

import com.base.inic.model.domain.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppInfoRepository extends JpaRepository<AppInfo, Long> {
    
}
