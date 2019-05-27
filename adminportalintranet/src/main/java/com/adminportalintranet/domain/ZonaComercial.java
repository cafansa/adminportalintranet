package com.adminportalintranet.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="zona_comercial")

public class ZonaComercial {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idZonaComercial;
	
	@NotEmpty
	@Column(name = "nombre_zona", unique = true, nullable = false)
	private String nombreZona;		
	@Column(columnDefinition="text")
	private String descripcionZona;
	private int estado;	
	private long zonaCreadaPor;
	private Date fechaCreacionZona;
	private long zonaEditadaPor;
	private Date fechaEdicionZona;
	
	//Getters & Setters
	public Long getIdZonaComercial() {
		return idZonaComercial;
	}
	public void setIdZonaComercial(Long idZonaComercial) {
		this.idZonaComercial = idZonaComercial;
	}
	public String getNombreZona() {
		return nombreZona;
	}
	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}
	public String getDescripcionZona() {
		return descripcionZona;
	}
	public void setDescripcionZona(String descripcionZona) {
		this.descripcionZona = descripcionZona;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public long getZonaCreadaPor() {
		return zonaCreadaPor;
	}
	public void setZonaCreadaPor(long zonaCreadaPor) {
		this.zonaCreadaPor = zonaCreadaPor;
	}
	public Date getFechaCreacionZona() {
		return fechaCreacionZona;
	}
	public void setFechaCreacionZona(Date fechaCreacionZona) {
		this.fechaCreacionZona = fechaCreacionZona;
	}
	public long getZonaEditadaPor() {
		return zonaEditadaPor;
	}
	public void setZonaEditadaPor(long zonaEditadaPor) {
		this.zonaEditadaPor = zonaEditadaPor;
	}
	public Date getFechaEdicionZona() {
		return fechaEdicionZona;
	}
	public void setFechaEdicionZona(Date fechaEdicionZona) {
		this.fechaEdicionZona = fechaEdicionZona;
	}
	
	
	
	
}
