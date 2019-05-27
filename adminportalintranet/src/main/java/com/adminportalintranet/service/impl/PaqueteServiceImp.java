package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.Paquete;
import com.adminportalintranet.repository.PaqueteRepository;
import com.adminportalintranet.service.PaqueteService;

@Service
public class PaqueteServiceImp implements PaqueteService{
	
	@Autowired
	private PaqueteRepository paqueteRepository; 
	
	public Paquete save(Paquete paquete) {
		return paqueteRepository.save(paquete);		
	}
	
   public List<Paquete> findAll(){
		return (List<Paquete>) paqueteRepository.findAll();
	}

	public Paquete findOne(Long idPaquete) {
		return paqueteRepository.getOne(idPaquete);       
	}
	
	public List<Paquete> findAllByEstado(int PRODUCTOS_ACTIVO){
		return (List<Paquete>) paqueteRepository.findAllByEstado(PRODUCTOS_ACTIVO);
	}
	
	
	public Paquete findOneByNombrePaquete(String nombrePaquete) {
		return paqueteRepository.getOneByNombrePaquete(nombrePaquete);       
	}
	
	public boolean isNombrePaqueteUnique(String nombrePaquete) {
		Paquete paquete = (findOneByNombrePaquete(nombrePaquete));	        
        
        if( paquete == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }	
}
