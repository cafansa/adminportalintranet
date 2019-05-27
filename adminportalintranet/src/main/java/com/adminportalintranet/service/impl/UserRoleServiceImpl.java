package com.adminportalintranet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.User;
import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.domain.security.UserRole;
import com.adminportalintranet.repository.UserRoleRepository;
import com.adminportalintranet.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleRepository userroleRepository;
	
	@Override
	public UserRole findByRole(Role role) {
		return userroleRepository.findByRole(role);
	}
	
	@Override
	public UserRole findByRoleAndUser(Role role, User user) {
		return userroleRepository.findByRoleAndUser(role,user);
	}
	
	@Override
	public UserRole findOne(Long userRoleId) {
		return userroleRepository.getOne(userRoleId);
	}
	
	public UserRole save(UserRole userrole) {
		return userroleRepository.save(userrole);
	}
}
