package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.adminportalintranet.domain.Serial;

@Repository
public interface SerialRepository extends CrudRepository<Serial, Long> {
	
	Serial getOne(Long id);
	Serial findByidlead(Long idlead);

}
