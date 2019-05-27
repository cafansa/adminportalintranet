package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.User;

public interface UserRepository extends CrudRepository <User, Long>{
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User getOne(Long id);
}
