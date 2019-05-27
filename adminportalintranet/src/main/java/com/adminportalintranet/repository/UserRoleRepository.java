package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.domain.security.UserRole;

public interface UserRoleRepository extends CrudRepository <UserRole, Long>{
	UserRole findByRole(Role role);
	
	UserRole findByRoleAndUser(Role role, User user);
	
	UserRole getOne(Long userRoleId);
}
