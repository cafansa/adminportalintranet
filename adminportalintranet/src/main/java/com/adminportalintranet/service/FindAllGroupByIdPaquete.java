package com.adminportalintranet.service;

import java.util.Date;
import java.util.List;


public interface FindAllGroupByIdPaquete {

	Long getIdPaqueteProducto();
	Long getCantidad();
	String getNombrePaquete();
	String getPaqueteProductoCreadoPor();
	Date getFechaCreacionPaqueteProducto();
	List<FindAllGroupByIdPaquete> findAllGroupByIdPaquete();
	
}
