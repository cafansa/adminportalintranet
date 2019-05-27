package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.Countries;

public interface CountryService {
	Countries save(Countries countries);
	List<Countries> findAll();
	Countries findOne(Long id);	
}
