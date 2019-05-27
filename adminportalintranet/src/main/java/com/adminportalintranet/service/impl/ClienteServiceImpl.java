package com.adminportalintranet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportalintranet.domain.Cliente;
import com.adminportalintranet.repository.ClienteRepository;
import com.adminportalintranet.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);		
	}
	
   public List<Cliente> findAll(){
		return (List<Cliente>) clienteRepository.findAll();
	}

	public Cliente findOne(Long id) {
		return clienteRepository.getOne(id);       
	}
	
	public List<Cliente> findAllByConsecutivoOrden(Long consecutivoOrden){
		return (List<Cliente>) clienteRepository.findAllByConsecutivoOrden(consecutivoOrden);
	}
}
