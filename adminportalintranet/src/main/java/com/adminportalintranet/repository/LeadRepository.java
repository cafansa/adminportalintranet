package com.adminportalintranet.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.Lead;

public interface LeadRepository extends CrudRepository<Lead, Long>  {
	
	Lead getOne(Long id);
	
	//Este objeto retormado trae los datos de de la relacion de las tablas lead, pais, estado y ciudad
	//String LISTARLEADSLOCALIZACION = "SELECT ld, ct, cit from Lead ld inner join ld.countryIdfk ct inner join ld.stateIdfk st inner join ld.cityIdfk cit";
	String LISTARLEADSLOCALIZACION = "SELECT ld from Lead ld";

	@Query(LISTARLEADSLOCALIZACION)
	List findMyLeadsLocation(); 

}
