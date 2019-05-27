package com.adminportalintranet.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paquetes")
public class Paquete {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long idPaquete;
	
	private String nombrePaquete;
	@Column(columnDefinition="text")
	private String detallePaquete;
	
	@Column(name="estado")
	private int estado;
	
	private Date fechaCreacionPaquete;
	private String paqueteCreadoPor;
	private Date fechaModificacionPaquete;
	private String paqueteModificadoPor;
	
	
	//Getters & Setters
		
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
	public String getDetallePaquete() {
		return detallePaquete;
	}
	public void setDetallePaquete(String detallePaquete) {
		this.detallePaquete = detallePaquete;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estadoPaquete) {
		this.estado = estadoPaquete;
	}
	public Date getFechaCreacionPaquete() {
		return fechaCreacionPaquete;
	}
	public void setFechaCreacionPaquete(Date fechaCreacionPaquete) {
		this.fechaCreacionPaquete = fechaCreacionPaquete;
	}
	public String getPaqueteCreadoPor() {
		return paqueteCreadoPor;
	}
	public void setPaqueteCreadoPor(String paqueteCreadoPor) {
		this.paqueteCreadoPor = paqueteCreadoPor;
	}
	public Date getFechaModificacionPaquete() {
		return fechaModificacionPaquete;
	}
	public void setFechaModificacionPaquete(Date fechaModificacionPaquete) {
		this.fechaModificacionPaquete = fechaModificacionPaquete;
	}
	public String getPaqueteModificadoPor() {
		return paqueteModificadoPor;
	}
	public void setPaqueteModificadoPor(String paqueteModificadoPor) {
		this.paqueteModificadoPor = paqueteModificadoPor;
	}
	
		
}
