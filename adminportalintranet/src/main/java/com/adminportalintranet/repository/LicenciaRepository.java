package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportalintranet.domain.Licencia;

@Repository
public interface LicenciaRepository extends CrudRepository<Licencia, Long>{
	
	Licencia getOne(Long id);
	List<Licencia> findByidlead(Long idlead);
	List<Licencia> findByidserial(Long idserial);
	List<Licencia> findByserial(String serial);
}
