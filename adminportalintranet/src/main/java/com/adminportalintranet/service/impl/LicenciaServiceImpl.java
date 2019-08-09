package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.Licencia;
import com.adminportalintranet.repository.LicenciaRepository;
import com.adminportalintranet.service.LicenciaService;

@Service
public class LicenciaServiceImpl implements LicenciaService{
	
	@Autowired LicenciaRepository licenciaRepository;
	
	public Licencia save(Licencia licencia) {
		return licenciaRepository.save(licencia);		
	}
	
   public List<Licencia> findAll(){
		return (List<Licencia>) licenciaRepository.findAll();
	}

	public Licencia findOne(Long id) {
		return licenciaRepository.getOne(id);       
	}
	
	public List<Licencia> findByidlead(Long idlead){
		return licenciaRepository.findByidlead(idlead);
	}
	
	public List<Licencia> findByidserial(Long idserial) {
		return licenciaRepository.findByidserial(idserial);
	}
	
	public List<Licencia> findByserial(String serial) {
		return licenciaRepository.findByserial(serial);
	}
}
