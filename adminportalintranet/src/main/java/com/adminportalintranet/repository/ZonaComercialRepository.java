package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.ZonaComercial;

public interface ZonaComercialRepository extends CrudRepository<ZonaComercial, Long>{

	ZonaComercial getOne(Long id);
	//List<ZonaComercial> findAll();
	ZonaComercial getOneByNombreZona(String nombreZona);
	//boolean isNombreZonaUnique(String nombreZona); 
}
