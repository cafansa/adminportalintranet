package com.adminportalintranet.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_empresa")
public class TipoEmpresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipoEmpresa;
	
	private String nombreTipoEmpresa;		
	@Column(columnDefinition="text")
	private String descripcionTipoEmpresa;
	private int estado;	
	private long tipoEmpresaCreadaPor;
	private Date fechaCreacionTipoEmpresa;
	private long tipoEmpresaEditadaPor;
	private Date fechaEdicionTipoEmpresa;
	
	
	//Getters & Setters
	
	public Long getIdTipoEmpresa() {
		return idTipoEmpresa;
	}
	public void setIdTipoEmpresa(Long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}
	public String getNombreTipoEmpresa() {
		return nombreTipoEmpresa;
	}
	public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
		this.nombreTipoEmpresa = nombreTipoEmpresa;
	}
	public String getDescripcionTipoEmpresa() {
		return descripcionTipoEmpresa;
	}
	public void setDescripcionTipoEmpresa(String descripcionTipoEmpresa) {
		this.descripcionTipoEmpresa = descripcionTipoEmpresa;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public long getTipoEmpresaCreadaPor() {
		return tipoEmpresaCreadaPor;
	}
	public void setTipoEmpresaCreadaPor(long tipoEmpresaCreadaPor) {
		this.tipoEmpresaCreadaPor = tipoEmpresaCreadaPor;
	}
	public Date getFechaCreacionTipoEmpresa() {
		return fechaCreacionTipoEmpresa;
	}
	public void setFechaCreacionTipoEmpresa(Date fechaCreacionTipoEmpresa) {
		this.fechaCreacionTipoEmpresa = fechaCreacionTipoEmpresa;
	}
	public long getTipoEmpresaEditadaPor() {
		return tipoEmpresaEditadaPor;
	}
	public void setTipoEmpresaEditadaPor(long tipoEmpresaEditadaPor) {
		this.tipoEmpresaEditadaPor = tipoEmpresaEditadaPor;
	}
	public Date getFechaEdicionTipoEmpresa() {
		return fechaEdicionTipoEmpresa;
	}
	public void setFechaEdicionTipoEmpresa(Date fechaEdicionTipoEmpresa) {
		this.fechaEdicionTipoEmpresa = fechaEdicionTipoEmpresa;
	}
	
	
}
