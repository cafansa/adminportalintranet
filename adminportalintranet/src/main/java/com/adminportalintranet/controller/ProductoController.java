package com.adminportalintranet.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.adminportalintranet.domain.Producto;
import com.adminportalintranet.domain.TipoContrato;
import com.adminportalintranet.service.ProductoService;
import com.adminportalintranet.service.TipoContratoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService; 
	
	@Autowired
	private TipoContratoService tipoContratoService;	
		
	@RequestMapping("/listarProductos")
	public String ListarProductos(Model model) {
		List<Producto> producto = productoService.findAll();
	
		model.addAttribute("productos", producto);
		return "listarProductos";
	}
	
	@RequestMapping("/nuevoProducto")
	public String NuevoProducto(Model model) {
		
		List<TipoContrato> tipoContratos = tipoContratoService.findAllByEstado(1); //Obtener los estados Activos
		model.addAttribute("tipoContratos", tipoContratos);
		
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "nuevoProducto";
	}
	
	
	//GUARDAR UN NUEVO PRODUCTO
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProducto(@ModelAttribute("producto") Producto producto, 
							  //@ModelAttribute("tipo_contrato") String tipo_contrato, 
							  HttpServletRequest request, Model model) {
		
		/*
		//TipoContrato tipoContrato = tipoContratoService.findOne(Long.valueOf(tipo_contrato).longValue());
		//String nombreTipoContrato = tipoContrato.getNombreTipoContrato(); 
		
		producto.setFecha_creacion(new Date());
		//producto.setNombreTipoContrato(nombreTipoContrato);
		
		productoService.save(producto);			
		
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		
		return "redirect:/producto/listarProductos";		
		//return "listarProductos";
		*/
		
		if(!productoService.isNombre_ProductoUnique(producto.getNombre_producto())) {
			boolean existe = true;
			model.addAttribute("existe", existe);
			return "nuevoProducto";//el valor existe en la base de datos
		}
		else {
			producto.setFecha_creacion(new Date());
			productoService.save(producto);
			
			List<Producto> productos = productoService.findAll();
			model.addAttribute("productos", productos);
			
			return "redirect:/producto/listarProductos";	
		}
	}
	
	
	/* CONTROLADOR PARA CONSULTAR LA INFORMACION DE UN PRODUCTO */
	@RequestMapping("/productoInfo")
	public String productoInfo(@RequestParam("id") Long id,  Model model) {
		
		Producto producto = productoService.findOne(id);
										
		model.addAttribute("producto", producto);
		 
		return "productoInfo";
	}
	
	
	/* CONSULTAR LA INFORMACION DE UN PRODUCTO DESDE LA LISTA DE PRODUCTOS DEL PAQUETE */
	@RequestMapping(value= {"/productoInfoFromPaquete/{id}/{idPaquete}"})
	public String productoInfoFromPaquete(@PathVariable("id") Long id,
								 @PathVariable("idPaquete") Long idPaquete,
								Model model) 
	{
		
		Producto producto = productoService.findOne(id);
		
		model.addAttribute("idPaquete", idPaquete);
		model.addAttribute("producto", producto);
		 
		return "productoInfoFromPaquete";
	}
	
	
	/* CONTROLADOR PARA CONSULTAR LA INFORMACION DE UN PRODUCTO DESDE PAQUETESPRODUCTOS */
	//@RequestMapping("/productoInfoPp")
	@RequestMapping(value= {"/productoInfoPp/{id}/{idPaqueteProducto}"})
	public String productoInfoPp(@PathVariable("id") Long id,
								 @PathVariable("idPaqueteProducto") Long idPaqueteProducto,
								Model model) 
	{
		
		Producto producto = productoService.findOne(id);
		
		//model.addAttribute("idPaqueteProducto", idPaqueteProducto);
		model.addAttribute("producto", producto);
		 
		return "productoInfoPp";
	}
	
	/*CONTROLADORES PARA EDITAR UN PRODUCTO */
	@RequestMapping("/editarProducto")
	public String EditarProducto(@RequestParam("id") Long id, Model model) {
		Producto producto = productoService.findOne(id);
		model.addAttribute("producto", producto);
		
		List<TipoContrato> tiposContratos = tipoContratoService.findAllByEstado(1);
		model.addAttribute("tiposContratos",tiposContratos);
				
				
		return "editarProducto";
	}
	
	@RequestMapping(value="/editarProducto", method=RequestMethod.POST)
	public String updateProducto(@ModelAttribute("producto") Producto producto, 							 
							 //@ModelAttribute("tipo_contrato") String tipo_contrato,
							 RedirectAttributes redirectAttributes,
							 HttpServletRequest request, Model model) 
		{
		/*
		producto.setFecha_edicicion(new Date());
		
		productoService.save(producto);
	
		model.addAttribute("Editado", true);
		model.addAttribute("lead", producto);
		 
		//INYECCION DE ATRIBUTOS A LA URL
	    //redirectAttributes.addAttribute("id", idReturn);
		 
		   return "redirect:/producto/listarProductos";			
		//return "leadInfo";
		*/
		
		if(!productoService.isNombre_ProductoUnique(producto.getNombre_producto())) {
			boolean existe = true;
			model.addAttribute("existe", existe);
			return "editarProducto";//el valor existe en la base de datos
		}
		else {
			producto.setFecha_creacion(new Date());
			productoService.save(producto);
			
			model.addAttribute("Editado", true);
			model.addAttribute("producto", producto);
			 
			//INYECCION DE ATRIBUTOS A LA URL
		    //redirectAttributes.addAttribute("id", idReturn);
			 
			return "redirect:/producto/listarProductos";	
		}
		   
	}
	

}
