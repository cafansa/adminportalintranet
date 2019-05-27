package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.PaqueteProducto;
import com.adminportalintranet.service.PaquetesExistentes;

public interface PaqueteProductoRepository extends CrudRepository<PaqueteProducto, Long>{
	PaqueteProducto getOne(Long idPaqueteProducto);
	
	PaqueteProducto getOneByIdPaquete(Long idPaquete);
	
	List<PaqueteProducto> findAll();	
	List<PaqueteProducto> findAllByEstado(int PRODUCTOS_ACTIVO);	
	List<PaqueteProducto> findAllByIdPaquete(Long idPaquete);	
	
	@Query("select a.idPaqueteProducto, Count(a.idPaqueteProducto) AS contador, a.nombrePaquete as nombre, a.idPaquete as paquete, a.estado as status, a.paqueteProductoCreadoPor, Date(a.fechaCreacionPaqueteProducto) as fechaCreacionPaqueteProducto from PaqueteProducto a Group By a.nombrePaquete")
	public List<PaquetesExistentes> findAllGroupByIdPaquete();
	
	@Query("select a.idPaqueteProducto, Count(a.idPaqueteProducto) AS contador, a.nombrePaquete as nombre, a.idPaquete as paquete, a.estado as status, a.paqueteProductoCreadoPor, Date(a.fechaCreacionPaqueteProducto) as fechaCreacionPaqueteProducto from PaqueteProducto a  where a.idPaquete =:idPaquete Group By a.nombrePaquete")
	public List<PaquetesExistentes> findAllGroupByPaquete(Long idPaquete);
	
	@Query("select a from PaqueteProducto a  where a.estado =:estadoValido Group By a.nombrePaquete")
	public List<PaqueteProducto> findAllActiveGroupByIdPaquete(int estadoValido);
	
	void delete(PaqueteProducto paquete);
	
	//LISTAR LOS PRODUCTOS PARA UN PAQUETE Y UN TIPO DE CONTRATO
	@Query("select m from PaqueteProducto m where m.idPaquete =:idPaqueteComercial and m.tipoContrato=:tipoContrato")
	public List<PaqueteProducto> findAllWhereIdPaqueteComercialAndTipoContrato(Long idPaqueteComercial, int tipoContrato);
	
	
	//VERIFICAR SI EL PRODUCTO A ADICIONAR YA EXISTE PARA EL PAQUETE Y EL TIPO DE CONTRATO SELECCIONADO
	@Query("select m from PaqueteProducto m where m.idPaquete =:idPaqueteComercial and m.idProducto=:idProducto and m.tipoContrato=:tipoContrato")
	public List<PaqueteProducto> verificarProductoPaqueteContratoExiste(Long idPaqueteComercial, Long idProducto, int tipoContrato);
	
	//DETALLE DEL PAQUETE PARA CREAR
	@Query("select b from PaqueteProducto b where b.idPaquete =:idPaquete Group By b.nombrePaquete")
	//public List<PaqueteProducto> detallePaquete(Long idPaquete);
	PaqueteProducto detallePaquete(Long idPaquete);
	
	
	PaqueteProducto getOneByNombrePaquete(String nombrePaquete);
	
}
