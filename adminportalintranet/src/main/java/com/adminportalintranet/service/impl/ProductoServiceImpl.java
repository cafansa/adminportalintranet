package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.repository.ProductoRepository;
import com.adminportalintranet.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto save(Producto producto) {
		return productoRepository.save(producto);		
	}
	
   public List<Producto> findAll(){
		return (List<Producto>) productoRepository.findAll();
	}

	public Producto findOne(Long id) {
		return productoRepository.getOne(id);       
	}
	
	public List<Producto> findAllByEstado(int PRODUCTOS_ACTIVO){
		return (List<Producto>) productoRepository.findAllByEstado(PRODUCTOS_ACTIVO);
	}
	
	
	public Producto findOneBynombre_producto(String nombre_producto) {
		return productoRepository.getOneBynombre_producto(nombre_producto);       
	}
	
	public boolean isNombre_ProductoUnique(String nombre_producto) {
		Producto producto = (findOneBynombre_producto(nombre_producto));	        
        
        if( producto == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }

	
}
