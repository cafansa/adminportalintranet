package com.adminportalintranet.service;

import java.util.List;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;

public interface ConsecutivoOrdenesVentaService {
	
	ConsecutivoOrdenesVenta save(ConsecutivoOrdenesVenta consecutivoOrdenesVenta);
	List<ConsecutivoOrdenesVenta> findAll();
	ConsecutivoOrdenesVenta findOne(Long idOrdenVenta);
	List<ConsecutivoOrdenesVenta> findConsecsAbiertosCliente(Long idLead, Boolean estado);
	 

}
