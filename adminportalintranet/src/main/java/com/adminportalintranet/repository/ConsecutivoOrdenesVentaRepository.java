package com.adminportalintranet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;

public interface ConsecutivoOrdenesVentaRepository extends CrudRepository<ConsecutivoOrdenesVenta, Long> {
	
	ConsecutivoOrdenesVenta getOne(Long idOrdenVenta);
	
	//OBTENER LA LISTA DE CONSECUTIVOS  ACTIVOS PARA UN CLIENTE
	@Query("select a from ConsecutivoOrdenesVenta a where a.idLead =:idLead and a.estado=:estado")
	public List<ConsecutivoOrdenesVenta> findConsecsAbiertosCliente(Long idLead, Boolean estado);
	
	//OBTENER LA LISTA DE CONSECUTIVOS POR ESTADO
	@Query("select distinct a from ConsecutivoOrdenesVenta a where a.estado=:estado")
	public List<ConsecutivoOrdenesVenta> findConsecsByEstado(Boolean estado);
	
}
