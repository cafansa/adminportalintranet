 package com.adminportalintranet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adminportalintranet.domain.TipoContrato;
import com.adminportalintranet.service.TipoContratoService;

@Controller
@RequestMapping("/tipoContrato")
public class TipoContratoController {

	@Autowired
	TipoContratoService tipoContratoService;
	
	@RequestMapping("/listarTipoContrato")
	public String ListarTipoContrato(Model model) {
		List<TipoContrato> tipoContrato = tipoContratoService.findAll();
		model.addAttribute("tipoContratos", tipoContrato);
		return "listarTipoContrato";
	}
	
	@RequestMapping("/nuevoTipoContrato")
	public String NuevoTipoContrato(Model model) {
				
		TipoContrato tipoContrato= new TipoContrato();
		model.addAttribute("tipoContrato", tipoContrato);
		
		return "nuevoTipoContrato";
				
	}
	
	//GUARDAR UN NUEVO TIPO DE CONTRATO
		@RequestMapping(value="/tipoContratoAdd", method=RequestMethod.POST)
		public String addTipoContrato(@ModelAttribute("tipoContrato") TipoContrato tipoContrato, HttpServletRequest request, Model model) 
		{	
			tipoContrato.setFechaCreacionTipoContrato(new Date());
			tipoContratoService.save(tipoContrato);
			
			List<TipoContrato> tipoContratos = tipoContratoService.findAll();
			model.addAttribute("tipoContratos", tipoContratos);
			
			return "redirect:/tipoContrato/listarTipoContrato";
			
			
			/*if(!tipoContratoService.isNombreTipoContratoUnique(tipoContrato.getNombreTipoContrato())) {
				boolean existe = true;
				model.addAttribute("existe", existe);
				return "nuevoTipoContrato";//el valor existe en la base de datos
			}
			else {
				tipoContrato.setFechaCreacionTipoContrato(new Date());
				tipoContratoService.save(tipoContrato);
				
				List<TipoContrato> tipoContratos = tipoContratoService.findAll();
				model.addAttribute("tipoContratos", tipoContratos);
				
				return "redirect:/tipoContrato/listarTipoContrato";
			}*/
			
		}
		
		/* CONTROLADOR PARA CONSULTAR LA INFORMACION DE TIPO DE CONTRATO */
		@RequestMapping("/tipoContratoInfo")
		public String TipoContratoInfo(@RequestParam("idTipoContrato") Long idTipoContrato,  Model model) {
			
			TipoContrato tipoContrato = tipoContratoService.findOne(idTipoContrato);	
			model.addAttribute("tipoContrato", tipoContrato);
			 
			return "tipoContratoInfo";
		}
		
		/*CONTROLADORES PARA EDITAR UN TIPO DE CONTRATO*/
		@RequestMapping("/editarTipoContrato")
		public String EditarTipoContrato(@RequestParam("idTipoContrato") Long idTipoContrato, Model model) {
			TipoContrato tipoContrato = tipoContratoService.findOne(idTipoContrato);
			model.addAttribute("tipoContrato", tipoContrato);
			
			return "editarTipoContrato";
		}
		
		@RequestMapping(value="/editarTipoContrato", method=RequestMethod.POST)
		public String updateTipoContrato(@ModelAttribute("tipoContrato") TipoContrato tipoContrato, 
										 RedirectAttributes redirectAttributes,						 
										 HttpServletRequest request, Model model) 
		{		
			Long idReturn = tipoContrato.getIdTipoContrato();
			
			tipoContrato.setFechaModificacionTipoContrato(new Date());
			tipoContratoService.save(tipoContrato);				
			model.addAttribute("Editado", true);
			model.addAttribute("tipoContrato", tipoContrato);
			 
			
			//INYECCION DE ATRIBUTOS A LA URL
			redirectAttributes.addAttribute("idTipoContrato", idReturn);
			 
			return "redirect:/tipoContrato/tipoContratoInfo";	
			  
			
			/*if(!tipoContratoService.isNombreTipoContratoUnique(tipoContrato.getNombreTipoContrato())) {
				boolean existe = true;
				model.addAttribute("existe", existe);
				return "editarTipoContrato";//el valor existe en la base de datos
			}
			else {
				Long idReturn = tipoContrato.getIdTipoContrato();
				
				tipoContrato.setFechaModificacionTipoContrato(new Date());
				tipoContratoService.save(tipoContrato);				
				model.addAttribute("Editado", true);
				model.addAttribute("tipoContrato", tipoContrato);
				 
				
				//INYECCION DE ATRIBUTOS A LA URL
				 redirectAttributes.addAttribute("idTipoContrato", idReturn);
				 
				  return "redirect:/tipoContrato/tipoContratoInfo";
			}*/
		}
		
		//VERIFICA EL NOMBRE DE DEL TIPO EMPRESA PARA VER SI YA EXISTE
		@GetMapping(value="/verificarNombreTipoContrato")
		@ResponseBody
		public boolean verificarNombreTipoContrato(@RequestParam("nombreTipoContrato") String nombreTipoContrato, Model model) 
		{	
			boolean existe;
			//Map<String, Object> jsonMap = new HashMap<>();
			
			if(!tipoContratoService.isNombreTipoContratoUnique(nombreTipoContrato))
				existe = true;
			else
				existe = false;
			
			//jsonMap.put("existe", existe);
			//jsonMap.put("prueba", "hola");
			//return new Gson().toJson(jsonMap);
			return existe;
		}
}
