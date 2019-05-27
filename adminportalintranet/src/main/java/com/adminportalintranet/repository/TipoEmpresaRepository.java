package com.adminportalintranet.repository;

import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.TipoEmpresa;


public interface TipoEmpresaRepository extends CrudRepository<TipoEmpresa, Long>{
	TipoEmpresa getOne(Long id);

	TipoEmpresa getOneByNombreTipoEmpresa(String nombreTipoEmpresa);

}
