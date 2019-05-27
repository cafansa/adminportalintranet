package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.City;

public interface CityService {
	City save(City city);
	List<City> findAll();
	City findOne(Long id);	
	List<City> findByStateId(int state_id);

}
