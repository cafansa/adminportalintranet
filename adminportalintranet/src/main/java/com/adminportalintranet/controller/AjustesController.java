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

import com.adminportalintranet.domain.City;
import com.adminportalintranet.domain.Countries;
import com.adminportalintranet.domain.State;
import com.adminportalintranet.domain.TipoEmpresa;
import com.adminportalintranet.domain.ZonaComercial;
import com.adminportalintranet.service.CityService;
import com.adminportalintranet.service.CountryService;
import com.adminportalintranet.service.StateService;
import com.adminportalintranet.service.TipoEmpresaService;
import com.adminportalintranet.service.ZonaComercialService;

@Controller
@RequestMapping("/ajustes")
public class AjustesController {
	
	@Autowired
	private ZonaComercialService zonaComercialService; 
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	
	@RequestMapping("/listarZonas")
	public String ListarZonas(Model model) {
	List<ZonaComercial> zonasComerciales = zonaComercialService.findAll();
    model.addAttribute("zonasComerciales", zonasComerciales);
		return "listarZonas";
	}
	
	@RequestMapping("/NuevaZona")
	public String NuevoLead(Model model) {
		
		List<Countries> countriess = countryService.findAll();
		model.addAttribute("countriess",countriess);
		
		State states = new State();
		City cities = new City();
		
		//int pais = 47;
		//List<State> states = stateService.findByCountryId(pais);
		
		//int state_id=776; 
		//List<City> cities = cityService.findByStateId(state_id);
		model.addAttribute("states", states);
		model.addAttribute("cities", cities);
		
		ZonaComercial zonaComercial = new ZonaComercial();
		model.addAttribute("zonaComercial", zonaComercial);
		
		return "NuevaZona";
	}
	
	@RequestMapping(value="/zonaAdd", method=RequestMethod.POST)
	public String addLead(@ModelAttribute("zonaComercial") ZonaComercial zonaComercial,						
						  HttpServletRequest request, Model model) {
		/*
		zonaComercial.setFechaCreacionZona(new Date());
		zonaComercialService.save(zonaComercial);
		
		List<ZonaComercial> zonasComerciales = zonaComercialService.findAll();
		model.addAttribute("zonasComerciales", zonasComerciales);
		
		return "redirect:/ajustes/listarZonas";
		//return "listarZonas";
		*/
		
		/*
		if(!zonaComercialService.isZonaComercialNombreZonaUnique(zonaComercial.getIdZonaComercial(), zonaComercial.getNombreZona())){
            
            return "registration";
        }
        */
		
		
		if(!zonaComercialService.isNombreZonaUnique(zonaComercial.getNombreZona())) {
			boolean existe = true;
			model.addAttribute("existe", existe);
			return "NuevaZona";//el valor existe en la base de datos
		}
		else {
			zonaComercial.setFechaCreacionZona(new Date());
			zonaComercialService.save(zonaComercial);
			
			List<ZonaComercial> zonasComerciales = zonaComercialService.findAll();
			model.addAttribute("zonasComerciales", zonasComerciales);
			
			return "redirect:/ajustes/listarZonas";
		}
		
	}
	
	
	@RequestMapping("/zonaComercialInfo")
	public String ZonaComercialInfo(@RequestParam("idZonaComercial") Long idZonaComercial,  Model model) {
		
		ZonaComercial zonaComercial = zonaComercialService.findOne(idZonaComercial);	
		
		model.addAttribute("zonaComercial", zonaComercial);
		
		
		return "zonaComercialInfo";
	}
	
	/*CONTROLADORES PARA EDITAR UNA ZONA*/
	@RequestMapping("/editarZonaComercial")
	public String EditarZonaComercial(@RequestParam("idZonaComercial") Long idZonaComercial, Model model) {
		ZonaComercial zonaComercial = zonaComercialService.findOne(idZonaComercial);
		model.addAttribute("zonaComercial", zonaComercial);
		
		return "editarZonaComercial";
	}
	
	@RequestMapping(value="/editarZonaComercial", method=RequestMethod.POST)
	public String updateZonaComercial(@ModelAttribute("zonaComercial") ZonaComercial zonaComercial, HttpServletRequest request, Model model) {		
		
		/*
		zonaComercial.setFechaEdicionZona(new Date());
		zonaComercialService.save(zonaComercial);		
		
		model.addAttribute("Editado", true);
		model.addAttribute("zonaComercial", zonaComercial);
		
		return "redirect:/ajustes/zonaComercialInfo";*/
		
		if(!zonaComercialService.isNombreZonaUnique(zonaComercial.getNombreZona())) {
			
			model.addAttribute("existe", true);
			return "editarZonaComercial";//el valor existe en la base de datos
		}
		else {
			zonaComercial.setFechaCreacionZona(new Date());
			zonaComercialService.save(zonaComercial);
			
			model.addAttribute("zonaComercial", zonaComercial);			
			return "redirect:/ajustes/zonaComercialInfo";			
		}
			
	}
	
	
	
	
	//Controlador para el llamado de Ajax para cargar los estados o Dptos	
		@GetMapping(value="/getCountryStateValues")
		@ResponseBody
		public List<State> getCountryStateValues(@RequestParam("country_id") int country) {	   
		
		    List<State> states = stateService.findByCountryId(country);
		    return states;  	
		}

		//Controlador para el llamado de Ajax para cargar las ciudades	
		@GetMapping(value="/getStateCityValues")
		@ResponseBody
		public List<City> getStateCityValues(@RequestParam("state_id") int state) {	   
		
		    List<City> cities = cityService.findByStateId(state);
		    return cities;  	
		}
		
		
////////////////////////////////////////////		}
//TIPOS DE EMPRESAS
////////////////////////////////////////////		    
		@RequestMapping("/listarTiposEmpresas")
		public String ListartiposEmpresas(Model model) {
		List<TipoEmpresa>tiposEmpresas = tipoEmpresaService.findAll();
	    model.addAttribute("tiposEmpresas", tiposEmpresas);
			return "listarTiposEmpresas";
		}
		
		@RequestMapping("/nuevoTipoEmpresa")
		public String NuevoTipoEmpresa(Model model) {
			
			TipoEmpresa tipoEmpresa = new TipoEmpresa();
			model.addAttribute("tipoEmpresa", tipoEmpresa);
			
			return "nuevoTipoEmpresa";
		}
		
		@RequestMapping(value="/tipoEmpresaAdd", method=RequestMethod.POST)
		public String TipoEmpresaLead(@ModelAttribute("tipoEmpresa") TipoEmpresa tipoEmpresa,						
							  HttpServletRequest request, Model model) {
			/*
			tipoEmpresa.setFechaCreacionTipoEmpresa(new Date());
			tipoEmpresaService.save(tipoEmpresa);
			
			List<TipoEmpresa> tiposEmpresas =tipoEmpresaService.findAll();
			model.addAttribute("tiposEmpresas", tiposEmpresas);
			
			return "redirect:/ajustes/listarTiposEmpresas";
			*/
			
			if(!tipoEmpresaService.isNombreTipoEmpresaUnique(tipoEmpresa.getNombreTipoEmpresa())) {
				boolean existe = true;
				model.addAttribute("existe", existe);
				return "nuevoTipoEmpresa";//el valor existe en la base de datos
			}
			else {
				tipoEmpresa.setFechaCreacionTipoEmpresa(new Date());
				tipoEmpresaService.save(tipoEmpresa);
				
				List<TipoEmpresa> tiposEmpresas =tipoEmpresaService.findAll();
				model.addAttribute("tiposEmpresas", tiposEmpresas);
				
				return "redirect:/ajustes/listarTiposEmpresas";
			}

		}
		
		
		@RequestMapping("/tipoEmpresaInfo")
		public String TipoEmpresaInfo(@RequestParam("idTipoEmpresa") Long idTipoEmpresa,  Model model) {
			
			TipoEmpresa tipoEmpresa = tipoEmpresaService.findOne(idTipoEmpresa);	
			
			model.addAttribute("tipoEmpresa", tipoEmpresa);
			return "tipoEmpresaInfo";
		}
		
		/*CONTROLADORES PARA EDITAR TIPO DE EMPRESA*/
		@RequestMapping("/editarTipoEmpresa")
		public String EditarTipoEmpresa(@RequestParam("idTipoEmpresa") Long idTipoEmpresa, Model model) {
			TipoEmpresa tipoEmpresa = tipoEmpresaService.findOne(idTipoEmpresa);
			model.addAttribute("tipoEmpresa", tipoEmpresa);
			
			return "editarTipoEmpresa";
		}
		
		@RequestMapping(value="/editarTipoEmpresa", method=RequestMethod.POST)
		public String updateTipoEmpresa(@ModelAttribute("tipoEmpresa") TipoEmpresa tipoEmpresa, HttpServletRequest request, Model model) {		
			
			/*
			tipoEmpresa.setFechaEdicionTipoEmpresa(new Date());
			tipoEmpresaService.save(tipoEmpresa);		
			
			model.addAttribute("Editado", true);
			model.addAttribute("tipoEmpresa", tipoEmpresa);		
			
			return "redirect:/ajustes/tipoEmpresaInfo";
			*/
			
			if(!tipoEmpresaService.isNombreTipoEmpresaUnique(tipoEmpresa.getNombreTipoEmpresa())) {
				boolean existe = true;
				model.addAttribute("existe", existe);
				return "editarTipoEmpresa";//el valor existe en la base de datos
			}
			else {
				tipoEmpresa.setFechaCreacionTipoEmpresa(new Date());
				tipoEmpresaService.save(tipoEmpresa);
				
				model.addAttribute("tipoEmpresa", tipoEmpresa);		
				
				return "redirect:/ajustes/tipoEmpresaInfo";
			}
			

		}
		
}
