package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.Serial;

public interface SerialService {
	
	Serial save(Serial serial);
	List<Serial> findAll();
	Serial findOne(Long id);
	Serial findByidlead(Long idlead);

}
