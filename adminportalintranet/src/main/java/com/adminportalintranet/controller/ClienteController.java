package com.adminportalintranet.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adminportalintranet.domain.Cliente;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.domain.PaqueteProducto;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.domain.User;
import com.adminportalintranet.service.ClienteService;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.LeadService;
import com.adminportalintranet.service.PaqueteProductoService;
import com.adminportalintranet.service.ProductoService;
import com.adminportalintranet.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private LeadService leadService;	
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private PaqueteProductoService paqueteProductoService;
	
	@Autowired
	private ConsecutivoOrdenesVentaService consecutivoOrdenesVentaService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/CrearCliente")
	public String CrearCliente(@RequestParam("id") Long id,  Model model) {
		
		Lead lead = leadService.findOne(id);
		Cliente cliente = clienteService.findOne(id);
		//List<TipoContrato> tiposContratos = tipoContratoService.findAllByEstado(1);// EL VALOR 1 SIGNIFICA QUE ESTA ACTIVO
		
		List<PaqueteProducto> paquetes = paqueteProductoService.findAllActiveGroupByIdPaquete(1);//Todos los paquetes comerciales Activos
		List<Producto> productos =  productoService.findAllByEstado(1);
		
		
		model.addAttribute("lead", lead);
		model.addAttribute("cliente", cliente);
		//model.addAttribute("tiposContratos", tiposContratos);	
		model.addAttribute("paquetes", paquetes);
		model.addAttribute("productos", productos);
		
		return "CrearCliente";
	}
	
	/*
	//GUARDAR UN CLIENTE
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String addItemCliente(@ModelAttribute("cliente") Cliente cliente, 							   
								  HttpServletRequest request, Model model) {
			
			cliente.setFechaCreacionCliente(new Date());		
			
			clienteService.save(cliente);			
			
			List<Cliente> itemsDelCliente = clienteService.findAll();
			model.addAttribute("itemsDelCliente", itemsDelCliente);
			
			return "redirect:/paqueteProducto/listarPaquetesProductos";		
			//return "listarProductos";
			
		}
	*/
	
	
	
	
	
	
	//Controlador para el llamado de Ajax para cargar tabla de los items (Paquetes o productos añadidos al prospecto o cliente)
		//GUARDAR LOS DATOS DEL FORMULARIO	
			@RequestMapping(value="/TableItemCliente", method=RequestMethod.POST)
			
			
			//@ResponseBody
			public String TablePaqueteProductos(@RequestBody Producto Producto, Model model) {	  
					
				/*
				Long idProducto = Producto.getId();
				Paquete paquete = paqueteService.findOne(idPaquete);
				String nombrePaquete = paquete.getNombrePaquete();			
				
				Long idProducto = paqueteProducto.getIdProducto();
				Producto producto = productoService.findOne(idProducto);
				String nombreProducto = producto.getNombre_producto();
				
				paqueteProducto.setNombrePaquete(nombrePaquete);
				paqueteProducto.setNombreProducto(nombreProducto);
				paqueteProducto.setFechaCreacionPaqueteProducto(new Date());
			
				paqueteProductoService.save(paqueteProducto);
				
				*/
				
				//return "redirect:/paqueteProducto/nuevoPaqueteProducto";
				return "nuevoPaqueteProducto";
				
				
			}
			
			//ENVIAR DATOS DEL DIV QUE SE ACTUALIZA
			@GetMapping(value="/getTableItemCliente")
			@ResponseBody
			public ModelAndView getTableItemCliente(Model model) 
			{	   
			
			    //List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAllByIdPaquete(idPaquete);
				List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
			    model.addAttribute("paquetesProductos", paquetesProductos);
			    
				return new ModelAndView("listarPaquetesComerciales");  	
			}
			
			/**************************************************************************/
			//Controlador para el llamado de Ajax para cargar tabla de los paquetes o productos agregados a un Cliente
			//GUARDAR LOS DATOS DEL FORMULARIO	
				@RequestMapping(value="/TablePaqueteProductosAddCliente", method=RequestMethod.POST)
				@ResponseBody
				public String TablePaqueteProductosAddCliente(@RequestBody Cliente cliente, Model model) {	  
					
					//LEER LOS DATOS DEL USUARIO EN SESION
					final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
					User usuarioLogged = userService.findByUsername(currentUserName);
					final String nombreUsuario = usuarioLogged.getFirstName();
					final String apellidoUsuario = usuarioLogged.getLastName();
					System.out.println("######################bUsuario en sesion "+currentUserName+" y se llama: "+nombreUsuario+" "+apellidoUsuario);
					
					//Long idCliente;
					Long consecActual = null;
					Long idProspecto = cliente.getIdProspecto();
					Long idPaqueteComercial = cliente.getIdPaqueteComercial();
					System.out.println(">>>>>>>>>>>>>>El id delidPaqueteComercial: "+idPaqueteComercial);
					
					PaqueteProducto paquete = paqueteProductoService.findOne(idPaqueteComercial);					
					String nombrePaqueteComercial = paquete.getNombrePaquete();
					System.out.println(">>>>>>>>>>>>>>El id del nombrePaqueteComercial: "+nombrePaqueteComercial);					
					
					Long idProducto = cliente.getIdProducto();
					System.out.println(">>>>>>>>>>>>>>El id del producto: "+idProducto);
					
					if(idProducto != null) {
						Producto producto = productoService.findOne(idProducto);											
						String nombreProducto = producto.getNombre_producto();
						}
					
					//VERIFICAR SI EL PROSPECTO TIENE ASIGNADO UNO O VARIOS CONSECUTIVOS, SINO ASIGNARLO
					List<ConsecutivoOrdenesVenta> consecutivosList = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(idProspecto, true);
					 if(consecutivosList != null && !consecutivosList.isEmpty()){
						 
						 if(consecutivosList.size() == 1) {
							 consecActual = (Long) consecutivosList.get(0).getIdOrdenVenta(); 							 
						 }
						 else
						 {
							 /* ES NECESARIO RETORNAR EL LA LISTA CON LOS CONSECUTIVOS PARA QUE SE SELECCIONE UNO PARA AÑADIR PRODUCTOS.
							  * SE DIRIJIRA A UNA VISTA PARA QUE SE SELECCIONE UNA ORDEN PARA EDITAR O EN SU DEFECTO SE CREE UNA ORDEN NUEVA
							  * */
						 }
					 } 
					  else
						  //NO EXISTEN CONSECUTVOS, SE GENERA UNO NUEVO
					  {
						 ConsecutivoOrdenesVenta consecutivo = new ConsecutivoOrdenesVenta();
						 consecutivo.setIdLead(idProspecto);
						 consecutivo.setEstado(true);
						 consecutivo.setFechaCreacionConsecutivo(new Date());
						 consecutivo.setCreadoPorConsecutivo("0");
						 
						 consecutivoOrdenesVentaService.save(consecutivo);
						 consecActual = consecutivo.getIdOrdenVenta();//CONSECUTIVO ACTUAL PARA EL LEAD
					 }
					 
					
					//Boolean cerrado = cliente.getCerrado();
					
					
					//VERIFICAR SI EL PRODUCTO PARA EL PAQUETE Y EL TIPO DE CONTRATO EXISTE.
					//List<PaqueteProducto> productoExiste = paqueteProductoService.verificarProductoPaqueteContratoExiste(idPaquete, idProducto, tipoContrato);
					
					Map<String, Object> jsonMap = new HashMap<>();
					Boolean existe;
					/*
					 if(productoExiste != null && !productoExiste.isEmpty()){
						 //SI EXISTE NO SE GUARDA
						 existe = true;				 
					 }
					 else {
						 */
						 	existe = false;
						 	cliente.setConsecutivoOrden(consecActual);
						 	cliente.setCreadoPorCliente("0");
						 	cliente.setFechaCreacionCliente(new Date());
						 	
						 	cliente.setNombrePaqueteComercial(nombrePaqueteComercial);
						 	//cliente.setNombreProducto(nombreProducto);
						 	cliente.setCerrado(false);
						 	
							clienteService.save(cliente);					
					// }
					 
					 jsonMap.put("existe", existe);
					 jsonMap.put("consecutivoOrden", consecActual);
					 return new Gson().toJson(jsonMap);
				}
				
				//ENVIAR DATOS DEL DIV QUE SE ACTUALIZA
				@GetMapping(value="/getTablePaqueteProductosAddedCliente")
				@ResponseBody
				public ModelAndView getTablePaqueteProductosAddedCliente(@RequestParam("consecutivoOrden") Long consecutivoOrden, Model model) 
				{	   
				
				    List<Cliente> paquetesProductos = clienteService.findAllByConsecutivoOrden(consecutivoOrden);
					//List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
				    model.addAttribute("paquetesProductos", paquetesProductos);		    
				    
					return new ModelAndView("listarPaquetesProductosOrdenesVenta");  	
				}
				
	}
