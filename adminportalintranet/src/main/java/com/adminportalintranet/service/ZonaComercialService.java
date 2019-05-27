package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.ZonaComercial;

public interface ZonaComercialService {
	
	ZonaComercial save(ZonaComercial zonaComercial);
	List<ZonaComercial> findAll();
	ZonaComercial findOne(Long id);
	
	ZonaComercial findOneByNombreZona(String nombreZona);
	boolean isNombreZonaUnique(String nombreZona);

}
