package com.citywalk.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.model.AppService;
import com.citywalk.backend.repositary.impl.AppServiceJPARepositary;
import com.citywalk.backend.service.AppServiceService;

@Service
@Repository
public class AppServiceServiceImpl implements AppServiceService{

	@Autowired
	private AppServiceJPARepositary appServiceJPARepositary;
	
	@Override
	@Transactional
	public AppService save(AppService service) throws CitywalkException {
		service = appServiceJPARepositary.save(service);
		return service;
	}

	@Override
	@Transactional
	public void delete(int id) throws CitywalkException {
		appServiceJPARepositary.delete(id);
		return;
	}

	@Override
	@Transactional
	public List<AppService> findAll() throws CitywalkException {
		List<AppService> services = appServiceJPARepositary.findAll();
		return services;
	}

	@Override
	@Transactional
	public AppService update(AppService service) throws CitywalkException {
		AppService updatedService = appServiceJPARepositary.findOne(service.getId());
		
		if (updatedService == null)
			throw new CitywalkException("Order not found");

		updatedService.setImagePath(service.getImagePath());
		updatedService.setName(service.getName());
		updatedService.setStatus(service.getStatus());
		return updatedService;
	}

	@Override
	@Transactional
	public AppService findById(int id) throws CitywalkException {
		AppService appService = appServiceJPARepositary.findOne(id);
		return appService;
	}

}
