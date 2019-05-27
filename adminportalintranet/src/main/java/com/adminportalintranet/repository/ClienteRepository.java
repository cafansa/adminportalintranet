package com.adminportalintranet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adminportalintranet.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente getOne(Long id);
	List<Cliente> findAllByConsecutivoOrden(Long consecutivoOrden);

}
