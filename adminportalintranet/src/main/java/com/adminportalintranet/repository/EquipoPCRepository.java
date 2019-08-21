package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportalintranet.domain.EquipoPC;

@Repository
public interface EquipoPCRepository extends CrudRepository<EquipoPC, Long>{
	
	EquipoPC getOne(Long id);
	List<EquipoPC> findByserial(String serial);
}
