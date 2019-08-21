package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.EquipoPC;
import com.adminportalintranet.repository.EquipoPCRepository;
import com.adminportalintranet.service.EquipoPCService;

@Service
public class EquipoPCServiceImpl implements EquipoPCService{
	
	@Autowired EquipoPCRepository equipopcrepository;
	
	public EquipoPC save(EquipoPC equipo){
		return equipopcrepository.save(equipo);
	}
	
	public List<EquipoPC> findAll(){
		return (List<EquipoPC>)equipopcrepository.findAll();
	}
	
	public EquipoPC findOne(Long id) {
		return equipopcrepository.getOne(id);
	}
	
	public List<EquipoPC> findByserial(String serial){
		return equipopcrepository.findByserial(serial);
	}
	
}
