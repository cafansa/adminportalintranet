package com.adminportalintranet.service;

import java.util.Date;

public interface PaquetesExistentes {
	
	Long getIdPaqueteProducto(); 
	Long getContador();
	String getNombre();
	Long getPaquete();
	int getStatus();
	String getPaqueteProductoCreadoPor();
	Date getFechaCreacionPaqueteProducto();

}
