package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.Serial;
import com.adminportalintranet.repository.SerialRepository;
import com.adminportalintranet.service.SerialService;

@Service
public class SerialServiceImpl implements SerialService{

	@Autowired SerialRepository serialRepository;
	
	public Serial save(Serial serial) {
		return serialRepository.save(serial);		
	}
	
   public List<Serial> findAll(){
		return (List<Serial>) serialRepository.findAll();
	}

	public Serial findOne(Long id) {
		return serialRepository.getOne(id);       
	}
	
	public Serial findByidlead(Long idlead){
		return serialRepository.findByidlead(idlead);
	}
}
