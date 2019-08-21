package com.adminportalintranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.EquipoPC;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.service.ClienteService;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.EquipoPCService;
import com.adminportalintranet.service.LeadService;
import com.adminportalintranet.service.LicenciaService;
import com.adminportalintranet.service.SerialService;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ConsecutivoOrdenesVentaService consecutivoOrdenesVentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private SerialService serialService;
	
	@Autowired
	private LicenciaService licenciaService;
	
	@Autowired
	private EquipoPCService equipopcservice;
	
	@RequestMapping("/GestionarEquipos")
	public String GestionarEquipos(@RequestParam("id") Long idlead, @RequestParam("serial") String serial, Model model)
	{
		System.out.println("==========================================================Este es el serial=>"+serial);
		System.out.println();
		
		List<EquipoPC> equipos = equipopcservice.findByserial(serial);
		Lead lead = leadService.findOne(idlead);
		
		model.addAttribute("model",model);
		model.addAttribute("equipos",equipos);
		model.addAttribute("lead",lead);
		return "ListarEquipos";
	}
}
