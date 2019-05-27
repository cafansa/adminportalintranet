package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.City;
import com.adminportalintranet.repository.CityRepository;
import com.adminportalintranet.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	public City save(City city) {
		return cityRepository.save(city);		
	}
	
   public List<City> findAll(){
		return (List<City>) cityRepository.findAll();
	}
   
   	public City findOne(Long id) {
		return cityRepository.getOne(id);       
	}
	
	public List<City> findByStateId(int state_id){ 
		return (List<City>) cityRepository.findByStateId(state_id);
	}
}
