package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.State;

public interface StateRepository extends CrudRepository<State, Long> {
	
	State getOne(Long id);
	List<State> findByCountryId(int country_id);
	}
