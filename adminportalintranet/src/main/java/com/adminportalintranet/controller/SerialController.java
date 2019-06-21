package com.adminportalintranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.LeadService;

@Controller
@RequestMapping("/serial")
public class SerialController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ConsecutivoOrdenesVentaService consecutivoOrdenesVentaService;
	
	@RequestMapping("/GestionarSerial")
	public String GestionarSerial(@RequestParam("id") Long idlead, Model model)
	{
		Lead lead = leadService.findOne(idlead);
		
		Boolean estado=false;
		List<ConsecutivoOrdenesVenta> consecutivoordenesventa = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(idlead, estado);
		
		model.addAttribute("lead",lead);
		return "insertarDatosSerial";
	}
	
}
