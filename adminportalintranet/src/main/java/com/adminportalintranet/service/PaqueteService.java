package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.Paquete;

public interface PaqueteService {
	
	Paquete save(Paquete paquete);
	List<Paquete> findAll();
	List<Paquete> findAllByEstado(int PRODUCTOS_ACTIVO);
	Paquete findOne(Long idPaquete);
	Paquete findOneByNombrePaquete(String nombrePaquete);
	boolean isNombrePaqueteUnique(String nombrePaquete);

}
