package com.adminportalintranet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="licencias")
public class Licencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long idserial;
	private String serial;
	private Long idlead;
	private Long idPaquete;
	private String nombrePaquete;
	private int cantidadPermitida;
	private int cantidadUsada;
	
	public Licencia() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdserial() {
		return idserial;
	}

	public void setIdserial(Long idserial) {
		this.idserial = idserial;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Long getIdlead() {
		return idlead;
	}

	public void setIdlead(Long idlead) {
		this.idlead = idlead;
	}

	public Long getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Long idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public int getCantidadPermitida() {
		return cantidadPermitida;
	}

	public void setCantidadPermitida(int cantidadPermitida) {
		this.cantidadPermitida = cantidadPermitida;
	}

	public int getCantidadUsada() {
		return cantidadUsada;
	}

	public void setCantidadUsada(int cantidadUsada) {
		this.cantidadUsada = cantidadUsada;
	}

		
}
