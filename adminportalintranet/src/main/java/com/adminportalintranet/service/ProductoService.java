package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.Producto;


public interface ProductoService {

	Producto save(Producto producto);
	List<Producto> findAll();
	List<Producto> findAllByEstado(int PRODUCTOS_ACTIVO);
	
	Producto findOne(Long id);
	Producto findOneBynombre_producto(String nombre_producto);
	boolean isNombre_ProductoUnique(String nombre_producto);
}
