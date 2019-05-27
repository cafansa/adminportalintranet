package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.PaqueteProducto;

public interface PaqueteProductoService {
	PaqueteProducto save(PaqueteProducto paqueteProducto);
	List<PaqueteProducto> findAll();	
	List<PaquetesExistentes> findAllGroupByIdPaquete();
	
	List<PaquetesExistentes> findAllGroupByPaquete(Long idPaquete);	   	
	
	List<PaqueteProducto> findAllByEstado(int PRODUCTOS_ACTIVO);
	List<PaqueteProducto> findAllByIdPaquete(Long idPaquete);
	
	PaqueteProducto detallePaquete(Long idPaquete);
		
	PaqueteProducto findOne(Long idPaqueteProducto);
	PaqueteProducto findOneByIdPaquete(Long idPaquete);
	
	List<PaqueteProducto> findAllActiveGroupByIdPaquete(int estadoValido);
	
	void delete(PaqueteProducto paquete);
	
	public List<PaqueteProducto> findAllWhereIdPaqueteComercialAndTipoContrato(Long idPaqueteComercial, int tipoContrato);
	
	public List<PaqueteProducto> verificarProductoPaqueteContratoExiste(Long idPaqueteComercial, Long idProducto, int tipoContrato);
	
	PaqueteProducto findOneByNombrePaquete(String nombrePaquete);
	boolean isNombrePaqueteUnique(String nombrePaquete);


}
