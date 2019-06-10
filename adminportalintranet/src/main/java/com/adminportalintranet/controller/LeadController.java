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

import com.adminportalintranet.domain.City;
import com.adminportalintranet.domain.Cliente;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.domain.Countries;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.domain.PaqueteProducto;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.domain.State;
import com.adminportalintranet.domain.TipoEmpresa;
import com.adminportalintranet.domain.ZonaComercial;
import com.adminportalintranet.service.CityService;
import com.adminportalintranet.service.ClienteService;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.CountryService;
import com.adminportalintranet.service.LeadService;
import com.adminportalintranet.service.PaqueteProductoService;
import com.adminportalintranet.service.ProductoService;
import com.adminportalintranet.service.StateService;
import com.adminportalintranet.service.TipoEmpresaService;
import com.adminportalintranet.service.ZonaComercialService;

@Controller
@RequestMapping("/lead")
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ZonaComercialService zonaComercialService;
	
	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	
	@Autowired
	private ConsecutivoOrdenesVentaService consecutivoOrdenesVentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private PaqueteProductoService paqueteProductoService;
	
	

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addLead(@ModelAttribute("lead") Lead lead,
						  @ModelAttribute("countriess") String countriess,
						  @ModelAttribute("states") String states,
						  @ModelAttribute("cities") String cities,
						  @ModelAttribute("zona") String zona,
						  @ModelAttribute("tipoEmpresa") String tipoEmpresa,						  
						  HttpServletRequest request, Model model) {
		
		//Lead lead = new Lead();		
		//model.addAttribute("lead", lead);
		
		String countryName;
		String stateName;
		String cityName;
		String tipoDeEmpresaName;
		String zonaName;
		
		Countries country = countryService.findOne(Long.valueOf(countriess).longValue());
		countryName = country.getName();
		
		State state = stateService.findOne(Long.valueOf(states).longValue());
		stateName = state.getName();
		
		City city = cityService.findOne(Long.valueOf(cities).longValue());
		cityName= city.getName();		
		
		TipoEmpresa tipoDeEmpresa = tipoEmpresaService.findOne(Long.valueOf(tipoEmpresa).longValue());
		tipoDeEmpresaName = tipoDeEmpresa.getNombreTipoEmpresa();
		
		ZonaComercial zonaComercial = zonaComercialService.findOne(Long.valueOf(zona).longValue());
		zonaName = zonaComercial.getNombreZona();

		lead.setFechaCreacionSistema(new Date());
		lead.setCountryName(countryName);
		lead.setStateName(stateName);
		lead.setCityName(cityName);	
		lead.setNombreTipoEmpresa(tipoDeEmpresaName);
		lead.setZonaNombre(zonaName);
		lead.setCountry(Integer.parseInt(countriess));
		lead.setState(Integer.parseInt(states));
		lead.setCity(Integer.parseInt(cities));
		
		leadService.save(lead);
		
		List<Lead> leads = leadService.findAll();
		model.addAttribute("leads", leads);
		
		return "redirect:/lead/listarLeads";
		//return "listarLeads";
	}
	
	//copia seguridad funcion
	/* CONTROLADOR PARA CONSULTAR LA INFORMACION DE UN LEAD */
	/*@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") Long id,  Model model) {
		
		Lead lead = leadService.findOne(id);
		
		//inicio comentario /*
		//ENCONTRAR EL OBLJETO PARA PONER EL NOMBRE DEL PAIS
		int idPais = lead.getCountry();		
		Countries country = countryService.findOne(Long.valueOf(idPais));
		
		//ENCONTRAR EL OBLJETO PARA PONER EL NOMBRE DEL ESTADO
		int idEstado = lead.getState();
		State state = stateService.findOne(Long.valueOf(idEstado));

		//ENCONTRAR EL OBLJETO PARA PONER EL NOMBRE DE LA CIUDAD
		int idCiudad = lead.getCity();
		City city = cityService.findOne(Long.valueOf(idCiudad));
		
		
		
		model.addAttribute("country", country);	
		model.addAttribute("state", state);
		model.addAttribute("city", city);
		//  fin comentado 
		String idZona = lead.getZona();
		ZonaComercial zonaComercial = zonaComercialService.findOne(Long.valueOf(idZona));
		
		String idTipoEmpresa = lead.getTipoEmpresa();
		TipoEmpresa tipoEmpresa = tipoEmpresaService.findOne(Long.valueOf(idTipoEmpresa));
		
		model.addAttribute("zonaComercial", zonaComercial);
		model.addAttribute("tipoEmpresa", tipoEmpresa);		
		model.addAttribute("lead", lead);
		 
		return "leadInfo";
	}*/
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") Long id,  Model model) {
		
		Lead lead = leadService.findOne(id);
		
		String idZona = lead.getZona();
		ZonaComercial zonaComercial = zonaComercialService.findOne(Long.valueOf(idZona));
		
		String idTipoEmpresa = lead.getTipoEmpresa();
		TipoEmpresa tipoEmpresa = tipoEmpresaService.findOne(Long.valueOf(idTipoEmpresa));
		
		Boolean estado=true;
		
		List<ConsecutivoOrdenesVenta> consecutivoordenesventa = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(id, estado);
		
		model.addAttribute("zonaComercial", zonaComercial);
		model.addAttribute("tipoEmpresa", tipoEmpresa);		
		model.addAttribute("lead", lead);
		
		if(consecutivoordenesventa.size() == 1)
		{
			List<Cliente> cliente = clienteService.findAllByConsecutivoOrden(consecutivoordenesventa.get(0).getIdOrdenVenta());
		
			//List<TipoContrato> tiposContratos = tipoContratoService.findAllByEstado(1);// EL VALOR 1 SIGNIFICA QUE ESTA ACTIVO
			
			List<PaqueteProducto> paquetes = paqueteProductoService.findAllActiveGroupByIdPaquete(1);//Todos los paquetes comerciales Activos
			List<Producto> productos =  productoService.findAllByEstado(1);
			
			
			model.addAttribute("lead", id);
			model.addAttribute("cliente", cliente.get(0));
			//model.addAttribute("tiposContratos", tiposContratos);	
			model.addAttribute("paquetes", paquetes);
			model.addAttribute("productos", productos);
			model.addAttribute("consecutivoOrden", consecutivoordenesventa.get(0).getIdOrdenVenta());
			
			return "redirect:/cliente/CrearClientexLead?id="+id+"&consecutivoOrden="+consecutivoordenesventa.get(0).getIdOrdenVenta();
		}
		else	
			return "leadInfo";
	}
	
	@RequestMapping("/NuevoLead")
	public String NuevoLead(Model model) {
		
		List<Countries> countriess = countryService.findAll();
		model.addAttribute("countriess",countriess);
		
		List<ZonaComercial> zonasComerciales = zonaComercialService.findAll();
		List<TipoEmpresa> tiposEmpresas = tipoEmpresaService.findAll();
		
		State states = new State();
		City cities = new City();
		
		//int pais = 47;
		//List<State> states = stateService.findByCountryId(pais);
		
		//int state_id=776; 
		//List<City> cities = cityService.findByStateId(state_id);
		
		//Es necesario adicionarlas porque se estan inyectando a traves de ajax
		model.addAttribute("states", states);
		model.addAttribute("cities", cities);
		
		model.addAttribute("zonasComerciales", zonasComerciales);
		model.addAttribute("tiposEmpresas", tiposEmpresas);
		
		Lead lead = new Lead();
		model.addAttribute("lead", lead);
		
		return "NuevoLead";
	}
	
	@RequestMapping("/listarLeads")
	public String listarLeads(Model model) {
		
		//List<Lead> leads = leadService.findMyLeadsLocation();		
		List<Lead> leads = leadService.findAll();
		List<TipoEmpresa> tiposEmpresas = tipoEmpresaService.findAll();	
		
		model.addAttribute("tiposEmpresas", tiposEmpresas);
		model.addAttribute("leads", leads);
		return "listarLeads";
	}			
	
	/*CONTROLADORES PARA EDITAR UN LEAD*/
	@RequestMapping("/EditarLead")
	public String EditarLead(@RequestParam("id") Long id, Model model) {
		Lead lead = leadService.findOne(id);
		model.addAttribute("lead", lead);
		
		List<Countries> countriess = countryService.findAll();
		model.addAttribute("countriess",countriess);
		
		List<ZonaComercial> zonasComerciales = zonaComercialService.findAll();
		List<TipoEmpresa> tiposEmpresas = tipoEmpresaService.findAll();
		
		State states = new State();
		City cities = new City();
		
		//Es necesario adicionarlas porque se estan inyectando a traves de ajax
		model.addAttribute("states", states);
		model.addAttribute("cities", cities);
				
		model.addAttribute("zonasComerciales", zonasComerciales);
		model.addAttribute("tiposEmpresas", tiposEmpresas);
		model.addAttribute("zonasComerciales", zonasComerciales);
		
		return "EditarLead";
	}
	
	@RequestMapping(value="/EditarLead", method=RequestMethod.POST)
	public String updateLead(@ModelAttribute("lead") Lead lead, 
							 @ModelAttribute("countriess") String countriess,
							 @ModelAttribute("states") String states,
							 @ModelAttribute("cities") String cities,
							 @ModelAttribute("zona") String zona,
							 @ModelAttribute("tipoEmpresa") String tipoEmpresa,
							 RedirectAttributes redirectAttributes,
							 HttpServletRequest request, Model model) 
		{		
		Long idReturn = lead.getId();
		String countryName;
		String stateName;
		String cityName;
		String tipoDeEmpresaName;
		String zonaName;
		
		Countries country = countryService.findOne(Long.valueOf(countriess).longValue());
		countryName = country.getName();
		
		State state = stateService.findOne(Long.valueOf(states).longValue());
		stateName = state.getName();
		
		City city = cityService.findOne(Long.valueOf(cities).longValue());
		cityName= city.getName();		
		
		TipoEmpresa tipoDeEmpresa = tipoEmpresaService.findOne(Long.valueOf(tipoEmpresa).longValue());
		tipoDeEmpresaName = tipoDeEmpresa.getNombreTipoEmpresa();
		
		ZonaComercial zonaComercial = zonaComercialService.findOne(Long.valueOf(zona).longValue());
		zonaName = zonaComercial.getNombreZona();

		lead.setFechaEdicionSistema(new Date());
		lead.setCountryName(countryName);
		lead.setStateName(stateName);
		lead.setCityName(cityName);		
		lead.setNombreTipoEmpresa(tipoDeEmpresaName);
		lead.setZonaNombre(zonaName);
		lead.setCountry(Integer.parseInt(countriess));
		lead.setState(Integer.parseInt(states));
		lead.setCity(Integer.parseInt(cities));
		
		leadService.save(lead);
		/*List<Lead> leads = leadService.findAll();
		model.addAttribute("leadList", leads);	
		return "listarLeads";
		*/
		
		model.addAttribute("Editado", true);
		model.addAttribute("lead", lead);
		 
		//INYECCION DE ATRIBUTOS A LA URL
		 redirectAttributes.addAttribute("id", idReturn);
		 
		   return "redirect:/lead/leadInfo";			
		//return "leadInfo";		
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

	
	
}