package com.adminportalintranet.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.Paquete;

public interface PaqueteRepository extends CrudRepository<Paquete, Long>{
	Paquete getOne(Long idPaquete);
	List<Paquete> findAll();
	List<Paquete> findAllByEstado(int PRODUCTOS_ACTIVO);
	Paquete getOneByNombrePaquete(String nombrePaquete);
}
