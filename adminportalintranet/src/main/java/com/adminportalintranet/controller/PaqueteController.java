package com.adminportalintranet.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.adminportalintranet.domain.Paquete;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.service.PaqueteService;

@Controller
@RequestMapping("/paquete")
public class PaqueteController {

	@Autowired
	private PaqueteService paqueteService;
	
	@RequestMapping("/listarPaquetes")
	public String ListarPaquetes(Model model) {
		
		List<Paquete> paquetes = paqueteService.findAll();	
		model.addAttribute("paquetes", paquetes);
		
		return "listarPaquetes";
	}
	
	
	@RequestMapping("/nuevoPaquete")
	public String NuevoPaquete(Model model) {
						
		Paquete paquete = new Paquete();
		model.addAttribute("paquete", paquete);
		
		return "nuevoPaquete";
	}
	
	//GUARDAR UN NUEVO PAQUETE
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProducto(@ModelAttribute("paquete") Paquete paquete, 							   
							  HttpServletRequest request, Model model) {
		/*
		paquete.setFechaCreacionPaquete(new Date());		
		
		paqueteService.save(paquete);			
		
		List<Paquete> paquetes = paqueteService.findAll();
		model.addAttribute("paquetes", paquetes);
		
		return "redirect:/paquete/listarPaquetes";		
		//return "listarProductos";
		*/
		
		if(!paqueteService.isNombrePaqueteUnique(paquete.getNombrePaquete())) {
			boolean existe = true;
			model.addAttribute("existe", existe);
			return "nuevoPaquete";//el valor existe en la base de datos
		}
		else {
			paquete.setFechaCreacionPaquete(new Date());					
			paqueteService.save(paquete);			
			
			List<Paquete> paquetes = paqueteService.findAll();
			model.addAttribute("paquetes", paquetes);
			
			return "redirect:/paquete/listarPaquetes";			
		}
		
	}
	
	/* CONTROLADOR PARA CONSULTAR LA INFORMACION DE UN PAQUETE */
	@RequestMapping("/paqueteInfo")
	public String paqueteInfo(@RequestParam("idPaquete") Long idPaquete,  Model model) {
		
		Paquete paquete = paqueteService.findOne(idPaquete);
										
		model.addAttribute("paquete", paquete);
		 
		return "paqueteInfo";
	}
	
	
	/*CONTROLADORES PARA EDITAR UN PAQUETE */
	@RequestMapping("/editarPaquete")
	public String EditarPaquete(@RequestParam("idPaquete") Long idPaquete, Model model) {
		Paquete paquete = paqueteService.findOne(idPaquete);
		model.addAttribute("paquete", paquete);						
				
		return "editarpaquete";
	}
	
	@RequestMapping(value="/editarPaquete", method=RequestMethod.POST)
	public String updatePaquete(@ModelAttribute("paquete") Paquete paquete, 							 							 
							 RedirectAttributes redirectAttributes,
							 HttpServletRequest request, Model model) 
		{						
		/*
		paquete.setFechaModificacionPaquete(new Date());
					
		paqueteService.save(paquete);
	
		model.addAttribute("Editado", true);
		model.addAttribute("paquete", paquete);
		 
	   return "redirect:/paquete/listarPaquetes";	
	   */
		
		if(!paqueteService.isNombrePaqueteUnique(paquete.getNombrePaquete())) {
			boolean existe = true;
			model.addAttribute("existe", existe);
			return "editarpaquete";//el valor existe en la base de datos
		}
		else {
			paquete.setFechaModificacionPaquete(new Date());
			
			paqueteService.save(paquete);
		
			model.addAttribute("Editado", true);
			model.addAttribute("paquete", paquete);
			 
		   return "redirect:/paquete/listarPaquetes";	
		
			}
		}
}