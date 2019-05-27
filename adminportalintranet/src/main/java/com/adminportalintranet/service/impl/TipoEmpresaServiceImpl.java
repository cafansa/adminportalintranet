package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.TipoEmpresa;
import com.adminportalintranet.repository.TipoEmpresaRepository;
import com.adminportalintranet.service.TipoEmpresaService;

@Service
public class TipoEmpresaServiceImpl implements TipoEmpresaService {

	@Autowired
	private TipoEmpresaRepository tipoEmpresaRepository;
	
	public TipoEmpresa save(TipoEmpresa tipoEmpresa) {
		return tipoEmpresaRepository.save(tipoEmpresa);		
	}
	
   public List<TipoEmpresa> findAll(){
		return (List<TipoEmpresa>) tipoEmpresaRepository.findAll();
	}

	public TipoEmpresa findOne(Long id) {
		return tipoEmpresaRepository.getOne(id);       
	}
	
	public TipoEmpresa findOneByNombreTipoEmpresa(String nombreTipoEmpresa) {
		return tipoEmpresaRepository.getOneByNombreTipoEmpresa(nombreTipoEmpresa);       
	}
	
	public boolean isNombreTipoEmpresaUnique(String nombreTipoEmpresa) {
        TipoEmpresa tipoEmpresa = (findOneByNombreTipoEmpresa(nombreTipoEmpresa));	        
        
        if( tipoEmpresa == null) {
        	return true; //NO existe        	
        }else {
        	return false;
        }         
    }
	
}
