package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.Producto;

public interface ProductoRepository  extends CrudRepository<Producto, Long> {
	Producto getOne(Long id);
	List<Producto> findAll();
	List<Producto> findAllByEstado(int PRODUCTOS_ACTIVO);	

	@Query("select p from Producto p  where p.nombre_producto =:nombre_producto")
	Producto getOneBynombre_producto(String nombre_producto);
	
}
