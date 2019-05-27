package com.adminportalintranet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.adminportalintranet.domain.Paquete;
import com.adminportalintranet.domain.PaqueteProducto;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.domain.TipoContrato;
import com.adminportalintranet.repository.PaqueteProductoRepository;
import com.adminportalintranet.service.PaqueteProductoService;
import com.adminportalintranet.service.PaqueteService;
import com.adminportalintranet.service.PaquetesExistentes;
import com.adminportalintranet.service.ProductoService;
import com.adminportalintranet.service.TipoContratoService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/paqueteProducto")
public class PaqueteProductoController {

	@Autowired
	private PaqueteProductoService paqueteProductoService;
	
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private TipoContratoService tipoContratoService;
	
	//@Autowired
	//private PaqueteProductoRepository paqueteProductoRepository; 
	

	private PaqueteProductoRepository paqueteProductoRepository; 

	//llamado para obtener objeto de query  personalizado para agrupar los paquetes comerciales y sus cantidades de productos
	//usando una interfas y un DAO "PaquetesExitentesDTO"
	@Autowired
	public PaqueteProductoController(PaqueteProductoRepository paqueteProductoRepository) {
		this.paqueteProductoRepository = paqueteProductoRepository;
	}
		
	
	@RequestMapping("/listarPaquetesProductos")	
	public String ListarPaquetesProductos(Model model) {			
		
		//List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
		List<PaquetesExistentes> paquetesProductos = paqueteProductoRepository.findAllGroupByIdPaquete();
		
		model.addAttribute("paquetesProductos", paquetesProductos);
				
		return "listarPaquetesProductos";
	}
	
	//////////////////////////////////
	//CONSULTAR EL PAQUETE COMERCIAL 
	@RequestMapping(value= {"/ConsultarPaqueteComercial/{idPaquete}"})
	public String ConsultarPaqueteComercial(@PathVariable("idPaquete") Long idPaquete, Model model) {
		
		
		//LISTAR LOS PRODUCTOS EXISTENTES EN EL PAQUETE COMERCIAL		
		List<PaqueteProducto> paqueteProductos = paqueteProductoRepository.findAllByIdPaquete(idPaquete);
		model.addAttribute("paqueteProductos", paqueteProductos);	
		
		//ITERAR LA LISTA DE PRODUCTOS PARA OBTENER EL ID
		Producto prod = new Producto();
		List<Producto> productos = new ArrayList(); 
		Long vlrPaquete = (long) 0;
		
		String tickets="";
		int control = 0;
		
		 for ( int i=0; i<paqueteProductos.size();i++){
	         //System.out.println(" --- Id del producto: "+ paqueteProductos.get(i).getIdProducto());
	         prod = (Producto) productoService.findOne(paqueteProductos.get(i).getIdProducto());	         
	         productos.add(prod);	         	         
	         
	         if(control == 0)// CUANDO SE ENCUENTRE UN SERVICIO DE TICKETS YA NO INGRESA MAS A LA VALIDACION
	         {
		         if(prod.getTipoProducto().equals("0"))//El producto es un servicio 
		         {
		        	 tickets = String.valueOf(prod.getNroTicketsPeriodo());
		        	 control = 1;
		         }
		         else 
		         {
		        	 tickets = "NO TIENE TICKETS";
		         }
	         }
	         
	         vlrPaquete = vlrPaquete + prod.getLicencia_desde();
	         //System.out.println(">>>>>>>>>>>>>>El valor del paquete es: "+vlrPaquete);
	     }
		
		 model.addAttribute("idPaquete", idPaquete);
		 model.addAttribute("productos", productos);//ESTA LISTA CONTIENE LOS DATOS DE TODOS LOS PRODUCTOS DEL PAQUETE
		 model.addAttribute("vlrPaquete",vlrPaquete); //ENVIO EL VALOR CALCULADO AL MODELO
		 model.addAttribute("tickets",tickets);
		
		//DATOS DEL PAQUETE
		PaqueteProducto detallePaquete = paqueteProductoService.detallePaquete(idPaquete);
		model.addAttribute("detallePaquete", detallePaquete);			
	
		return "ConsultarPaqueteComercial";
	}
	
	/*public String ListarPaquetesProductos(ModelMap mapa){
	       List<Object[]> result = paqueteProductoRepository.findAllGroupByIdPaquete();
	       Map<Long,String> map = null;
	       if(result != null && !result.isEmpty()){
	          map = new HashMap<Long,String>();
	          for (Object[] object : result) {
	            map.put(((Long)object[0]),(String) object[1]);
	          }
	       }
	       
	       mapa.addAttribute("paquetesProductos", map);  
	       //return map;
	       return "listarPaquetesProductos";
	     }*/
	
	
	@RequestMapping("/nuevoPaqueteProducto")
	public String NuevoPaqueteProducto(@ModelAttribute("paqueteProducto") PaqueteProducto paqueteProducto, Model model) {
		
		List<Paquete> paquetes = paqueteService.findAll();
		
		List<Producto> productos = productoService.findAll();
		
		List<TipoContrato> tipoContratos = tipoContratoService.findAllByEstado(1); //Obtener los estados Activos
		model.addAttribute("tipoContratos", tipoContratos);
		
		Long idPaquete = paqueteProducto.getIdPaquete();
		List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAllByIdPaquete(idPaquete);
		
		model.addAttribute("paquetes", paquetes);
		model.addAttribute("productos", productos);
		model.addAttribute("paquetesProductos", paquetesProductos);
		
		return "nuevoPaqueteProducto";
	}
	
	//GUARDAR UN NUEVO PAQUETE-PRODUCTO
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addPaqueteProducto(@ModelAttribute("paqueteProducto") PaqueteProducto paqueteProducto, 							   
							  HttpServletRequest request, Model model) {
		/*
		paqueteProducto.setFechaCreacionPaqueteProducto(new Date());		
		
		paqueteProductoService.save(paqueteProducto);			
		
		List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
		model.addAttribute("paquetesProductos", paquetesProductos);
		
		return "redirect:/paqueteProducto/listarPaquetesProductos";		
		//return "listarProductos";
		*/
	
		if(!paqueteProductoService.isNombrePaqueteUnique(paqueteProducto.getNombrePaquete())) {
			boolean existe = true;
			
			System.out.println(">>>>>>>>>El Boleano es: " + existe );
			
			model.addAttribute("existe", existe);
			return "nuevoPaqueteProducto";//el valor existe en la base de datos
		}
		else {
			paqueteProducto.setFechaCreacionPaqueteProducto(new Date());		
			
			paqueteProductoService.save(paqueteProducto);			
			
			List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
			model.addAttribute("paquetesProductos", paquetesProductos);
			
			return "redirect:/paqueteProducto/listarPaquetesProductos";	
		}
		
		
	}
	/*
	//eliminar un producto de un paquete
	@RequestMapping(value= {"/deleteProduct/{idPaqueteProducto}"})
	public String DeleteProduct(@PathVariable("idPaqueteProducto") Long idPaqueteProducto,
			Model model) 
	{
		PaqueteProducto paquete = paqueteProductoService.findOne(idPaqueteProducto);
		
		paqueteProductoService.delete(paquete);
		
		List<Paquete> paquetes = paqueteService.findAll();
		
		List<Producto> productos = productoService.findAll();
		
		List<TipoContrato> tipoContratos = tipoContratoService.findAllByEstado(1); //Obtener los estados Activos
		model.addAttribute("tipoContratos", tipoContratos);
		model.addAttribute("paquetes", paquetes);
		model.addAttribute("productos", productos);
		
		return "redirect:/paqueteProducto/nuevoPaqueteProducto";
	}
	*/	

	
	//Controlador para el llamado de Ajax para cargar tabla de los productos agregados a un paquete
	//GUARDAR LOS DATOS DEL FORMULARIO	
		@RequestMapping(value="/TablePaqueteProductos", method=RequestMethod.POST)
		@ResponseBody
		public String TablePaqueteProductos(@RequestBody PaqueteProducto paqueteProducto, Model model) {	  
			
			Long idPaquete = paqueteProducto.getIdPaquete();
			Paquete paquete = paqueteService.findOne(idPaquete);
			String nombrePaquete = paquete.getNombrePaquete();			
			
			Long idProducto = paqueteProducto.getIdProducto();
			Producto producto = productoService.findOne(idProducto);
			String nombreProducto = producto.getNombre_producto();
			int tipoContrato = paqueteProducto.getTipoContrato();
			
			//VERIFICAR SI EL PRODUCTO PARA EL PAQUETE Y EL TIPO DE CONTRATO EXISTE.
			List<PaqueteProducto> productoExiste = paqueteProductoService.verificarProductoPaqueteContratoExiste(idPaquete, idProducto, tipoContrato);
			
			Map<String, Object> jsonMap = new HashMap<>();
			Boolean existe;
			
			 if(productoExiste != null && !productoExiste.isEmpty()){
				 //SI EXISTE NO SE GUARDA
				 existe = true;				 
			 }
			 else {
				 	existe = false;
					paqueteProducto.setNombrePaquete(nombrePaquete);
					paqueteProducto.setNombreProducto(nombreProducto);
					paqueteProducto.setFechaCreacionPaqueteProducto(new Date());
					paqueteProductoService.save(paqueteProducto);					
			 }
			 
			 jsonMap.put("existe", existe);
			 jsonMap.put("nombreProducto", nombreProducto);
			 return new Gson().toJson(jsonMap);
			 
			 /*
			 Gson gson = new Gson();
			 String json = gson.toJson(jsonMap);
			 return json;
			 */
			 
			 
			 //return "nuevoPaqueteProducto";
		}
		
		//ENVIAR DATOS DEL DIV QUE SE ACTUALIZA
		@GetMapping(value="/getTablePaqueteProductos")
		@ResponseBody
		public ModelAndView getTablePaqueteProductos(@RequestParam("idPaquete") Long idPaquete, Model model) 
		{	   
		
		    List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAllByIdPaquete(idPaquete);
			//List<PaqueteProducto> paquetesProductos = paqueteProductoService.findAll();
		    model.addAttribute("paquetesProductos", paquetesProductos);		    
		    
			return new ModelAndView("listarPaquetesComerciales");  	
		}
		
		//ACTUALLIZAR TABLA SI PAQUETE + CONTRATO CONTIENEN PRODUCTOS
				@GetMapping(value="/getTablePaqueteProductosExisten")
				@ResponseBody
				public ModelAndView getTablePaqueteProductosExisten(@RequestParam("idPaqueteComercial") Long idPaqueteComercial,
																	@RequestParam("tipoContrato") int tipoContrato, Model model) 
				{	   
				
				    List<PaqueteProducto> paquetesProductosExisten = paqueteProductoService.findAllWhereIdPaqueteComercialAndTipoContrato(idPaqueteComercial,tipoContrato);
				    model.addAttribute("paquetesProductos", paquetesProductosExisten);
				    
					return new ModelAndView("listarPaquetesComerciales");  	
				}
		
				
				//Borrar un Producto de un paquete y actualizar la tabla
				@GetMapping(value="/borrarActualizar")
				@ResponseBody
				public ModelAndView borrarActualizar(@RequestParam("idPaqueteProducto") Long idPaqueteProducto,
													@RequestParam("idPaqueteComercial") Long idPaqueteComercial,
													@RequestParam("tipoContrato") int tipoContrato, Model model) 
				{	   
				
					PaqueteProducto paquete = paqueteProductoService.findOne(idPaqueteProducto);					
					paqueteProductoService.delete(paquete);
					
					
				    List<PaqueteProducto> paquetesProductosExisten = paqueteProductoService.findAllWhereIdPaqueteComercialAndTipoContrato(idPaqueteComercial,tipoContrato);
				    model.addAttribute("paquetesProductos", paquetesProductosExisten);
				    
					return new ModelAndView("listarPaquetesComerciales");  	
				}
		
				
		
		
}