package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.ZonaComercial;
import com.adminportalintranet.repository.ZonaComercialRepository;
import com.adminportalintranet.service.ZonaComercialService;

@Service
public class ZonaComercialServiceImpl implements ZonaComercialService{
	@Autowired
	private ZonaComercialRepository zonaComercialRepository;
	
	public ZonaComercial save(ZonaComercial zonaComercial) {
		return zonaComercialRepository.save(zonaComercial);		
	}
	
   public List<ZonaComercial> findAll(){
		return (List<ZonaComercial>) zonaComercialRepository.findAll();
	}

	public ZonaComercial findOne(Long id) {
		return zonaComercialRepository.getOne(id);       
	}
	
	public ZonaComercial findOneByNombreZona(String nombreZona) {
		return zonaComercialRepository.getOneByNombreZona(nombreZona);       
	}
	
	public boolean isNombreZonaUnique(String nombreZona) {
        ZonaComercial zona = (findOneByNombreZona(nombreZona));	
        //return ( zona == null || (zona != null));        
        
        if( zona == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }
}
