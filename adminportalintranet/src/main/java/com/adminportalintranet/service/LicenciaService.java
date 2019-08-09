package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.Licencia;

public interface LicenciaService {

	Licencia save(Licencia licencia);
	List<Licencia> findAll();
	Licencia findOne(Long id);
	List<Licencia> findByidlead(Long idlead);
	List<Licencia> findByidserial(Long idserial);
	List<Licencia> findByserial(String serial);
}
