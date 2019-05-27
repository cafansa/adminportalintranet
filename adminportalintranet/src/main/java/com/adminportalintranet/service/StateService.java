package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.State;

public interface StateService {

	State save(State state);
	List<State> findAll();
	State findOne(Long id);	
	List<State> findByCountryId(int country_id);
}
