package com.adminportalintranet.service;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.domain.security.UserRole;

public interface UserRoleService {
	
	UserRole save(UserRole userrole);
	
	UserRole findByRole(Role role);
	
	UserRole findByRoleAndUser(Role role, User user);
	
	UserRole findOne(Long userRoleId);
}
