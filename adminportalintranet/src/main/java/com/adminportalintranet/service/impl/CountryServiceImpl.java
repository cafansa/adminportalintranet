package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.repository.CountryRepository;
import com.adminportalintranet.domain.Countries;
import com.adminportalintranet.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public Countries save(Countries countries) {
		return countryRepository.save(countries);		
	}
	
   public List<Countries> findAll(){
		return (List<Countries>) countryRepository.findAll();
	}

	public Countries findOne(Long id) {
		return countryRepository.getOne(id);       
	}
	
}
