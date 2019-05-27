package com.adminportalintranet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.repository.ConsecutivoOrdenesVentaRepository;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;

@Service
public class ConsecutivoOrdenesVentaServiceImpl implements ConsecutivoOrdenesVentaService {
	
	@Autowired
	private ConsecutivoOrdenesVentaRepository  consecutivoOrdenesVentaRepository;
	
	public ConsecutivoOrdenesVenta save(ConsecutivoOrdenesVenta consecutivoOrdenesVenta) {
		return consecutivoOrdenesVentaRepository.save(consecutivoOrdenesVenta);		
	}
	
   public List<ConsecutivoOrdenesVenta> findAll(){
		return (List<ConsecutivoOrdenesVenta>) consecutivoOrdenesVentaRepository.findAll();
	}

	public ConsecutivoOrdenesVenta findOne(Long idOrdenVenta) {
		return consecutivoOrdenesVentaRepository.getOne(idOrdenVenta);       
	}

	public List<ConsecutivoOrdenesVenta> findConsecsAbiertosCliente(Long idLead, Boolean estado){
		return (List<ConsecutivoOrdenesVenta>) consecutivoOrdenesVentaRepository.findConsecsAbiertosCliente(idLead, estado); 
	}
	
}
