package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.State;
import com.adminportalintranet.repository.StateRepository;
import com.adminportalintranet.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository; 
	
	public State save(State state) {
		return stateRepository.save(state);		
	}
	
   public List<State> findAll(){
		return (List<State>) stateRepository.findAll();
	}
   
   	public State findOne(Long id) {
		return stateRepository.getOne(id);       
	}
	
	public List<State> findByCountryId(int country_id){ 
		return (List<State>) stateRepository.findByCountryId(country_id);
	}
}
