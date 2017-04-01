package com.citywalk.backend.repositary.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.citywalk.backend.model.AppService;

@Transactional
public interface AppServiceJPARepositary extends JpaRepository<AppService, Integer> {

}
