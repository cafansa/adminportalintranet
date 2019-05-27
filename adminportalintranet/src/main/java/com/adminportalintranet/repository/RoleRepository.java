package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role getOne(Long roleId);
	
	Role findByName(String name);
}
