package com.adminportalintranet.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.City;


public interface CityRepository extends CrudRepository<City, Long>{

	City getOne(Long id);
	List<City> findByStateId(int state_id);
}
