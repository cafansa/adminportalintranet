package com.adminportalintranet.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.TipoContrato;

public interface TipoContratoRepository extends CrudRepository <TipoContrato, Long> {

	//int estadoTipoContrato = 1;
	TipoContrato getOne(Long id);
	TipoContrato getOneByNombreTipoContrato(String nombreTipoContrato);
	List<TipoContrato> findAllByEstado(int estadoTipoContrato);
}
