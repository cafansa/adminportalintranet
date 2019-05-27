package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.TipoContrato;

public interface TipoContratoService {
	
	TipoContrato save(TipoContrato tipoContrato);
	List<TipoContrato> findAll();
	TipoContrato findOne(Long id);
	List<TipoContrato> findAllByEstado(int estadoTipoContrato);
	public TipoContrato findOneByNombreTipoContrato(String nombreTipoContrato);
	boolean isNombreTipoContratoUnique(String nombreTipoContrato);

}
