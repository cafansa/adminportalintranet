package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.TipoContrato;
import com.adminportalintranet.repository.TipoContratoRepository;
import com.adminportalintranet.service.TipoContratoService;

@Service
public class TipoContratoServiceImpl implements TipoContratoService{
	
	@Autowired
	TipoContratoRepository tipoContratoRepository;
	
	public TipoContrato save(TipoContrato tipoContrato) {
		return tipoContratoRepository.save(tipoContrato);		
	}
	
   public List<TipoContrato> findAll(){
		return (List<TipoContrato>) tipoContratoRepository.findAll();
	}

	public TipoContrato findOne(Long id) {
		return tipoContratoRepository.getOne(id);       
	}
	
	public List<TipoContrato> findAllByEstado(int estadoTipoContrato) {
		return (List<TipoContrato>) tipoContratoRepository.findAllByEstado(estadoTipoContrato);       
	}
	
	public TipoContrato findOneByNombreTipoContrato(String nombreTipoContrato) {
		return tipoContratoRepository.getOneByNombreTipoContrato(nombreTipoContrato);       
	}
	
	public boolean isNombreTipoContratoUnique(String nombreTipoContrato) {
        TipoContrato tipoContrato = (findOneByNombreTipoContrato(nombreTipoContrato));	        
        
        if( tipoContrato == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }

}
