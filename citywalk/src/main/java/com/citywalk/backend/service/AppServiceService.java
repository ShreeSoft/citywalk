package com.citywalk.backend.service;

import java.util.List;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.model.AppService;

public interface AppServiceService {
	
	public AppService save(AppService service) throws CitywalkException;
	
	public void delete(int id) throws CitywalkException;
	
	public List<AppService> findAll() throws CitywalkException;
	
	public AppService update(AppService service) throws CitywalkException;
	
	public AppService findById(int id) throws CitywalkException;
}
