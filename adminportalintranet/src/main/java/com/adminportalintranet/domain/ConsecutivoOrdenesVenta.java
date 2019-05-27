package com.adminportalintranet.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class ConsecutivoOrdenesVenta {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")	
	private Long idOrdenVenta;
	private Long idLead;
	private Boolean estado;
	private String creadoPorConsecutivo;
	private Date fechaCreacionConsecutivo;	
	private String modificadoPorConsecutivo;
	private Date fechaModificacionConsecutivo;
	
	
	public ConsecutivoOrdenesVenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ConsecutivoOrdenesVenta(Long idOrdenVenta, Long idLead, Boolean estado, String creadoPorConsecutivo,
			Date fechaCreacionConsecutivo, String modificadoPorConsecutivo, Date fechaModificacionConsecutivo) {
		super();
		this.idOrdenVenta = idOrdenVenta;
		this.idLead = idLead;
		this.estado = estado;
		this.creadoPorConsecutivo = creadoPorConsecutivo;
		this.fechaCreacionConsecutivo = fechaCreacionConsecutivo;
		this.modificadoPorConsecutivo = modificadoPorConsecutivo;
		this.fechaModificacionConsecutivo = fechaModificacionConsecutivo;
	}


	public Long getIdOrdenVenta() {
		return idOrdenVenta;
	}


	public void setIdOrdenVenta(Long idOrdenVenta) {
		this.idOrdenVenta = idOrdenVenta;
	}


	public Long getIdLead() {
		return idLead;
	}


	public void setIdLead(Long idLead) {
		this.idLead = idLead;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getCreadoPorConsecutivo() {
		return creadoPorConsecutivo;
	}


	public void setCreadoPorConsecutivo(String creadoPorConsecutivo) {
		this.creadoPorConsecutivo = creadoPorConsecutivo;
	}


	public Date getFechaCreacionConsecutivo() {
		return fechaCreacionConsecutivo;
	}


	public void setFechaCreacionConsecutivo(Date fechaCreacionConsecutivo) {
		this.fechaCreacionConsecutivo = fechaCreacionConsecutivo;
	}


	public String getModificadoPorConsecutivo() {
		return modificadoPorConsecutivo;
	}


	public void setModificadoPorConsecutivo(String modificadoPorConsecutivo) {
		this.modificadoPorConsecutivo = modificadoPorConsecutivo;
	}


	public Date getFechaModificacionConsecutivo() {
		return fechaModificacionConsecutivo;
	}


	public void setFechaModificacionConsecutivo(Date fechaModificacionConsecutivo) {
		this.fechaModificacionConsecutivo = fechaModificacionConsecutivo;
	}
	
}
