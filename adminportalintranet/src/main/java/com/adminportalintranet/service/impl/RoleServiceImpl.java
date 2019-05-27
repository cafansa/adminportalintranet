package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.security.Role;
import com.adminportalintranet.repository.RoleRepository;
import com.adminportalintranet.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository RoleRepository;
	
	public Role save(Role role) {
		return RoleRepository.save(role);
	}
	
	public List<Role> findAll() {
		return (List<Role>) RoleRepository.findAll();
	}
	
	public Role findOne(Long roleId) {
		return RoleRepository.getOne(roleId);
	}
	
	public Role findByName(String name) {
		return RoleRepository.findByName(name);
	}
}
