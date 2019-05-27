package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.security.Role;

public interface RoleService {
	
	Role save(Role role);
	
	List<Role> findAll();
	
	Role findOne(Long roleId);
	
	Role findByName(String name);
}
