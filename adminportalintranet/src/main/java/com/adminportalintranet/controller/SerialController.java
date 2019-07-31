package com.adminportalintranet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.Cliente;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.domain.Serial;
import com.adminportalintranet.service.ClienteService;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.LeadService;
import com.adminportalintranet.service.SerialService;

@Controller
@RequestMapping("/serial")
public class SerialController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ConsecutivoOrdenesVentaService consecutivoOrdenesVentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private SerialService serialService;
	
	@RequestMapping("/GestionarSerial")
	public String GestionarSerial(@RequestParam("id") Long idlead, Model model)
	{
		//Obtención de los datos del Lead que ha generado ordenes ya cerradas es decir un cliente
		Lead lead = leadService.findOne(idlead);
		
		Boolean estado=false;
		List<ConsecutivoOrdenesVenta> consecutivoordenesventa = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(idlead, estado);
		
		List<Cliente>allordenes = new ArrayList<Cliente>();
		int i=0;
		
		//de acuerdo a las ordenes, se crea un array que va a guardar todos los datos del cliente(lead)
		for(ConsecutivoOrdenesVenta ordendetallada : consecutivoordenesventa)
		{
			List<Cliente> ordenes = clienteService.findAllByConsecutivoOrden(ordendetallada.getIdOrdenVenta());
			for(Cliente eachorden : ordenes)
			{
				allordenes.add(i, eachorden);
				i=i+1;
			}
		}
		
		//Se busca el serial de acuerdo al lead. 
		Serial serial = serialService.findByidlead(idlead);
		if(serial==null)
			System.out.println("==========================================================Esta vacio");
		else
			System.out.println("==========================================================Este es el serial->"+serial.getSerial());
		
		model.addAttribute("lead",lead);
		model.addAttribute("serial",serial);
		
		//Se buscan las licencias de acuerdo al serial
		
		return "DatosSerial";
	}
	
	
	@RequestMapping("/GestionarLicencias")
	public String GestionarLicencias(@RequestParam("id") Long idlead, Model model)
	{
		Lead lead = leadService.findOne(idlead);
		
		Boolean estado=false;
		List<ConsecutivoOrdenesVenta> consecutivoordenesventa = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(idlead, estado);
		
		List<Cliente>allordenes = new ArrayList<Cliente>();
		int i=0;
		for(ConsecutivoOrdenesVenta ordendetallada : consecutivoordenesventa)
		{
			List<Cliente> ordenes = clienteService.findAllByConsecutivoOrden(ordendetallada.getIdOrdenVenta());
			for(Cliente eachorden : ordenes)
			{
				allordenes.add(i, eachorden);
				i=i+1;
			}
		}
		
		model.addAttribute("lead",lead);
		return "LicenciasyEquipos";
	}
}
