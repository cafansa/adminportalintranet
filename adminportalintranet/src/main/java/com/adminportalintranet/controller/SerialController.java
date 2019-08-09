package com.adminportalintranet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportalintranet.domain.Cliente;
import com.adminportalintranet.domain.ConsecutivoOrdenesVenta;
import com.adminportalintranet.domain.Lead;
import com.adminportalintranet.domain.Licencia;
import com.adminportalintranet.domain.Serial;
import com.adminportalintranet.service.ClienteService;
import com.adminportalintranet.service.ConsecutivoOrdenesVentaService;
import com.adminportalintranet.service.LeadService;
import com.adminportalintranet.service.LicenciaService;
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
	
	@Autowired
	private LicenciaService licenciaService;
	
	@RequestMapping("/GestionarSerial")
	public String GestionarSerial(@RequestParam("id") Long idlead, Model model)
	{
		//Obtención de los datos del Lead que ha generado ordenes ya cerradas es decir un cliente
		Lead lead = leadService.findOne(idlead);
		
		List<Licencia> licencias=new ArrayList<Licencia>();
		//Se busca el serial de acuerdo al lead. 
		Serial serial = serialService.findByidlead(idlead);
		if(serial==null)
		{
			//System.out.println("==========================================================Serial vacio");
			Boolean estado=false;
			List<ConsecutivoOrdenesVenta> consecutivoordenesventa = consecutivoOrdenesVentaService.findConsecsAbiertosCliente(idlead, estado);
			
			List<Cliente>allordenes = new ArrayList<Cliente>();
			int i=0;
			//de acuerdo a las ordenes, se crea un array que va a guardar todos los datos del cliente(lead)
			for(ConsecutivoOrdenesVenta ordendetallada : consecutivoordenesventa)
			{
				//System.out.println("==========================================================Primer for");
				//System.out.println();
				List<Cliente> ordenes = clienteService.findAllByConsecutivoOrden(ordendetallada.getIdOrdenVenta());
				//System.out.println("==========================================================ordenes=>"+ordenes.get(0).getNombrePaqueteComercial());
				//System.out.println();
				/*for(Cliente eachorden : ordenes)
				{
					allordenes.add(i, eachorden);
					i=i+1;
				}*/
				
				for(Cliente eachorden : ordenes)
				{	
					Licencia licenciaaux=new Licencia();
					//System.out.println("==========================================================Segundo for");
					licenciaaux.setIdlead(idlead);
					licenciaaux.setIdPaquete(eachorden.getIdPaqueteComercial());
					licenciaaux.setNombrePaquete(eachorden.getNombrePaqueteComercial());
					//System.out.println("==========================================================ordenes=>"+eachorden.getNombrePaqueteComercial());
					//System.out.println();
					licenciaaux.setCantidadPermitida(0);
					licenciaaux.setCantidadUsada(0);
					licencias.add(i,licenciaaux);
					i=i+1;
				}
				
				//System.out.println("==========================================================indice i=>"+i);
				//System.out.println();
			}
		}
		else
		{
			//System.out.println("==============================================Este es el serial->"+serial.getSerial());
			//System.out.println("");
			
			//Se buscan las licencias de acuerdo al serial
			licencias=licenciaService.findByidserial(serial.getId());
		}
		
		//System.out.println("==========================================================Aqui comienza la impresión=>");
		//System.out.println();
		//for (Licencia elemento : licencias)
            //System.out.print(elemento.getNombrePaquete() + "-");
        
		model.addAttribute("lead",lead);
		model.addAttribute("serial",serial);
		model.addAttribute("licencias",licencias);
		return "DatosSerial";
	}
	
	
	//GUARDAR EL SERIAL
	@RequestMapping(value="/GuardarSerial", method=RequestMethod.POST)
	public String GuardarSerial(@ModelAttribute("lead") Lead lead,
								@RequestParam("idProspecto") String idlead,
								@RequestParam("serialserial") String serialserial,
								@RequestParam("idPaquete[]") Long idPaquete[],
								HttpServletRequest request, Model model)
	{
		Serial serial =new Serial();
		Long idserial;
		String idserialaux=request.getParameter("idserial");
		if(idserialaux==null || idserialaux=="")
			System.out.println();
		else
		{	
			idserial=Long.parseLong(idserialaux);
			serial=serialService.findOne(idserial);
		}
		
		serial.setIdlead(Long.parseLong( idlead ));
		serial.setSerial(serialserial);
		serial.setActivo(true);
		serialService.save(serial);
		
		System.out.println("==========================================================Aqui comienza la impresión en la función de guardado=>");
		System.out.println();
		String nombrepaq=null;
		Integer cantidad=0;
		Integer cantidad_usada=0;
		
		for(Long idpaq :idPaquete)
		{
			Licencia licencias=new Licencia();
			System.out.println("==========================================================DATO->"+idpaq);
			Long idlicencia;
			String idlicenciaaux=request.getParameter("idLicencia_"+idpaq);
			
			if(idlicenciaaux=="")
				licencias=null;
			else
			{
				idlicencia=Long.parseLong(idlicenciaaux);
				licencias=licenciaService.findOne(idlicencia);
			}
			
			nombrepaq=request.getParameter("nombrePaquete_"+idpaq);
			cantidad=Integer.parseInt(request.getParameter("cantidadPermitida_"+idpaq));
			cantidad_usada=Integer.parseInt(request.getParameter("cantidadUsada_"+idpaq));
			System.out.println("==========================================================nombre->"+nombrepaq);
			
			if(licencias==null)
			{
				Licencia licen=new Licencia();
				licen.setCantidadPermitida(cantidad);
				licen.setCantidadUsada(cantidad_usada);
				licen.setIdlead(Long.parseLong( idlead ));
				licen.setIdPaquete(idpaq);
				licen.setIdserial(serial.getId());
				licen.setNombrePaquete(nombrepaq);
				licen.setSerial(serialserial);
				
				licenciaService.save(licen);
			}
			else
			{
				licencias.setCantidadPermitida(cantidad);
				licencias.setCantidadUsada(cantidad_usada);
				licencias.setIdlead(Long.parseLong( idlead ));
				licencias.setIdPaquete(idpaq);
				licencias.setIdserial(serial.getId());
				licencias.setNombrePaquete(nombrepaq);
				licencias.setSerial(serialserial);
				
				licenciaService.save(licencias);
			}
		}
		
		return "redirect:/cliente/listarclientes";
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
