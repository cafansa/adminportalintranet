package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.PaqueteProducto;
import com.adminportalintranet.repository.PaqueteProductoRepository;
import com.adminportalintranet.service.PaqueteProductoService;
import com.adminportalintranet.service.PaquetesExistentes;

@Service
public class PaqueteProductoServiceImpl implements PaqueteProductoService{


	@Autowired
	private PaqueteProductoRepository paqueteProductoRepository; 
	
	public PaqueteProducto save(PaqueteProducto paqueteProducto) {
		return paqueteProductoRepository.save(paqueteProducto);		
	}
	
   public List<PaqueteProducto> findAll(){
		return (List<PaqueteProducto>) paqueteProductoRepository.findAll();
	}
    
   public List<PaquetesExistentes> findAllGroupByIdPaquete(){
		return (List<PaquetesExistentes>) paqueteProductoRepository.findAllGroupByIdPaquete();
	}
   
   public List<PaquetesExistentes> findAllGroupByPaquete(Long idPaquete){
		return (List<PaquetesExistentes>) paqueteProductoRepository.findAllGroupByPaquete(idPaquete);
	}
   
   
   public PaqueteProducto detallePaquete(Long idPaquete){
	   return paqueteProductoRepository.detallePaquete(idPaquete);
   }

	public PaqueteProducto findOne(Long idPaqueteProducto) {
		return paqueteProductoRepository.getOne(idPaqueteProducto);       
	}
	
	public PaqueteProducto findOneByIdPaquete(Long idPaquete) {
		return paqueteProductoRepository.getOneByIdPaquete(idPaquete);       
	}
	
	public List<PaqueteProducto> findAllByEstado(int PRODUCTOS_ACTIVO){
		return (List<PaqueteProducto>) paqueteProductoRepository.findAllByEstado(PRODUCTOS_ACTIVO);
	}

	@Override
	public List<PaqueteProducto> findAllByIdPaquete(Long idPaquete) {
		return (List<PaqueteProducto>) paqueteProductoRepository.findAllByIdPaquete(idPaquete);
	}	
	
	
	public List<PaqueteProducto> findAllActiveGroupByIdPaquete(int estadoValido){
		return(List<PaqueteProducto>) paqueteProductoRepository.findAllActiveGroupByIdPaquete(estadoValido);
	}
	
	@Override
	public void delete(PaqueteProducto paquete) {
		paqueteProductoRepository.delete(paquete);
	}
	
	public List<PaqueteProducto> findAllWhereIdPaqueteComercialAndTipoContrato(Long idPaqueteComercial, int tipoContrato){
		return (List<PaqueteProducto>) paqueteProductoRepository.findAllWhereIdPaqueteComercialAndTipoContrato(idPaqueteComercial,tipoContrato);
	}
	
	public List<PaqueteProducto> verificarProductoPaqueteContratoExiste(Long idPaqueteComercial, Long idProducto, int tipoContrato){
		return (List<PaqueteProducto>) paqueteProductoRepository.verificarProductoPaqueteContratoExiste(idPaqueteComercial, idProducto, tipoContrato);		
	}
	
	
	public PaqueteProducto findOneByNombrePaquete(String nombrePaquete) {
		return paqueteProductoRepository.getOneByNombrePaquete(nombrePaquete);       
	}
	
	public boolean isNombrePaqueteUnique(String nombrePaquete) {
		PaqueteProducto paquete = (findOneByNombrePaquete(nombrePaquete));	        
        
        if( paquete == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }
	
}
