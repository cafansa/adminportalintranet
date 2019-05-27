package com.adminportalintranet.service;

import java.util.List;

import com.adminportalintranet.domain.Cliente;


public interface ClienteService {
	
	Cliente save(Cliente cliente);
	List<Cliente> findAll();
	Cliente findOne(Long id);
	List<Cliente> findAllByConsecutivoOrden(Long consecutivoOrden);

}
