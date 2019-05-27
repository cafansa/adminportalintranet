package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.repository.LeadRepository;
import com.adminportalintranet.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService{
	
	@Autowired
	private LeadRepository leadRepository;
	
	public Lead save(Lead lead) {
		return leadRepository.save(lead);		
	}
	
   public List<Lead> findAll(){
		return (List<Lead>) leadRepository.findAll();
	}

	public Lead findOne(Long id) {
		return leadRepository.getOne(id);       
	}
	
	@SuppressWarnings("unchecked")
	public List<Lead> findMyLeadsLocation()
	{
		return (List<Lead>) leadRepository.findMyLeadsLocation();
	} 
}
