package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.Countries;

public interface CountryRepository extends CrudRepository<Countries, Long> {

	Countries getOne(Long id);
}
