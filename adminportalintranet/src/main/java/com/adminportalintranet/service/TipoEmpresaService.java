package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.TipoEmpresa;


public interface TipoEmpresaService {
	TipoEmpresa save(TipoEmpresa tipoEmpresa);
	List<TipoEmpresa> findAll();
	TipoEmpresa findOne(Long id);
	
	public TipoEmpresa findOneByNombreTipoEmpresa(String nombreTipoEmpresa);
	boolean isNombreTipoEmpresaUnique(String nombreTipoEmpresa);

}
