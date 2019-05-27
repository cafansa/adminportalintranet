package com.adminportalintranet.domain;

import java.util.Date;

public class PaquetesExitentesDTO {
	
	Long idPaqueteProducto;
	Long contador;
	String nombre;
	Long paquete;
	int status;
	String paqueteProductoCreadoPor;
	Date fechaCreacionPaqueteProducto;
	
	
	public PaquetesExitentesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaquetesExitentesDTO(Long idPaqueteProducto, Long contador, String nombre, Long paquete, int status, String paqueteProductoCreadoPor,
			Date fechaCreacionPaqueteProducto) {
		super();
		this.idPaqueteProducto = idPaqueteProducto;
		this.contador = contador;
		this.nombre = nombre;
		this.paquete = paquete;
		this.status = status;
		this.paqueteProductoCreadoPor = paqueteProductoCreadoPor;
		this.fechaCreacionPaqueteProducto = fechaCreacionPaqueteProducto;
	}

	//Getters & Setters

	public Long getContador() {
		return contador;
	}


	public void setContador(Long contador) {
		this.contador = contador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Long getPaquete() {
		return paquete;
	}


	public void setPaquete(Long paquete) {
		this.paquete = paquete;
	}
	
	


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getPaqueteProductoCreadoPor() {
		return paqueteProductoCreadoPor;
	}


	public void setPaqueteProductoCreadoPor(String paqueteProductoCreadoPor) {
		this.paqueteProductoCreadoPor = paqueteProductoCreadoPor;
	}


	public Date getFechaCreacionPaqueteProducto() {
		return fechaCreacionPaqueteProducto;
	}


	public void setFechaCreacionPaqueteProducto(Date fechaCreacionPaqueteProducto) {
		this.fechaCreacionPaqueteProducto = fechaCreacionPaqueteProducto;
	}


	public Long getIdPaqueteProducto() {
		return idPaqueteProducto;
	}


	public void setIdPaqueteProducto(Long idPaqueteProducto) {
		this.idPaqueteProducto = idPaqueteProducto;
	}
	
	
	
	
}
