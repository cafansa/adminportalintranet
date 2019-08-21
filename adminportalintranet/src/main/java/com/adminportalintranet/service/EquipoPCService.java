package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.EquipoPC;

public interface EquipoPCService {
	
	EquipoPC save(EquipoPC equipo);
	List<EquipoPC>findAll();
	EquipoPC findOne(Long id);
	List<EquipoPC> findByserial(String serial);

}
