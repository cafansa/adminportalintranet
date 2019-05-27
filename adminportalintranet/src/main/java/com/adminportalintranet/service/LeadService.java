package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.Lead;

public interface LeadService {
	
	Lead save(Lead lead);
	List<Lead> findAll();
	Lead findOne(Long id);
	List <Lead> findMyLeadsLocation(); 

}
