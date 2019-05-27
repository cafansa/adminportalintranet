package com.adminportalintranet.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_contrato")
public class TipoContrato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipoContrato;
	//@NotBlank(message="El nombre del tipo de contrato no puede ser vacio!!")
    @Column(name = "nombre_tipo_contrato", nullable = false)
	private String nombreTipoContrato;
	//@NotBlank(message="La descripción del tipo de contrato no puede ser vacio!!")
    @Column(name = "descripcion_tipo_contrato", nullable = false)
	private String decripcionTipoContrato;
	private int estado;
	@Column(name = "creado_por", nullable = true)
	private String creadoPorTipoContrato;
	@Column(name = "fecha_creacion", nullable = true)
	private Date fechaCreacionTipoContrato;
	@Column(name = "modificado_por", nullable = true)
	private String modificadoPorTipoContrato;
	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacionTipoContrato;
	
	
	//getters & Setters
	public Long getIdTipoContrato() {
		return idTipoContrato;
	}
	public void setIdTipoContrato(Long idTipoContato) {
		this.idTipoContrato = idTipoContato;
	}
	public String getNombreTipoContrato() {
		return nombreTipoContrato;
	}
	public void setNombreTipoContrato(String nombreTipoContrato) {
		this.nombreTipoContrato = nombreTipoContrato;
	}
	public String getDecripcionTipoContrato() {
		return decripcionTipoContrato;
	}
	public void setDecripcionTipoContrato(String decripcionTipoContrato) {
		this.decripcionTipoContrato = decripcionTipoContrato;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getCreadoPorTipoContrato() {
		return creadoPorTipoContrato;
	}
	public void setCreadoPorTipoContrato(String creadoPorTipoContrato) {
		this.creadoPorTipoContrato = creadoPorTipoContrato;
	}
	public Date getFechaCreacionTipoContrato() {
		return fechaCreacionTipoContrato;
	}
	public void setFechaCreacionTipoContrato(Date fechaCreacionTipoContrato) {
		this.fechaCreacionTipoContrato = fechaCreacionTipoContrato;
	}
	public String getModificadoPorTipoContrato() {
		return modificadoPorTipoContrato;
	}
	public void setModificadoPorTipoContrato(String modificadoPorTipoContrato) {
		this.modificadoPorTipoContrato = modificadoPorTipoContrato;
	}
	public Date getFechaModificacionTipoContrato() {
		return fechaModificacionTipoContrato;
	}
	public void setFechaModificacionTipoContrato(Date fechaModificacionTipoContrato) {
		this.fechaModificacionTipoContrato = fechaModificacionTipoContrato;
	}

	
}
