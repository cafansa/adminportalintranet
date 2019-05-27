package com.adminportalintranet.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Table(name="ordenes_venta")
public class Cliente {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")	
	private Long idCliente;
	private Long consecutivoOrden;
	private Long idProspecto;
	private Long idPaqueteComercial;
	private String nombrePaqueteComercial;		
	private Long idProducto;
	private String nombreProducto;
	int tipoRegistro; //0 para paquete, 1 para producto	
	Long valorItem;	
	private Boolean cerrado;  //True si el pedido se volvio factura, False si se pueden agregar Items
	private String creadoPorCliente;
	private Date fechaCreacionCliente;
	private String modificadoCliente;	
	private Date fechaModificacionCliente;

	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(Long idCliente, Long consecutivoOrden, Long idProspecto, Long idPaqueteComercial, String nombrePaqueteComercial,
			Long idProducto, String nombreProducto, int tipoRegistro, Long valorItem, Boolean cerrado, String creadoPorCliente,
			Date fechaCreacionCliente, String modificadoCliente, Date fechaModificacionCliente) {
		super();
		this.idCliente = idCliente;
		this.consecutivoOrden = consecutivoOrden;
		this.idProspecto = idProspecto;
		this.idPaqueteComercial = idPaqueteComercial;
		this.nombrePaqueteComercial = nombrePaqueteComercial;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.tipoRegistro = tipoRegistro;
		this.valorItem = valorItem;
		this.cerrado = cerrado;
		this.creadoPorCliente = creadoPorCliente;
		this.fechaCreacionCliente = fechaCreacionCliente;
		this.modificadoCliente = modificadoCliente;
		this.fechaModificacionCliente = fechaModificacionCliente;
	}
	//Getters & Setters

	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}	
	public Long getConsecutivoOrden() {
		return consecutivoOrden;
	}
	public void setConsecutivoOrden(Long consecutivoOrden) {
		this.consecutivoOrden = consecutivoOrden;
	}
	public Long getIdProspecto() {
		return idProspecto;
	}
	public void setIdProspecto(Long idProspecto) {
		this.idProspecto = idProspecto;
	}
	public Long getIdPaqueteComercial() {
		return idPaqueteComercial;
	}
	public void setIdPaqueteComercial(Long idPaqueteComercial) {
		this.idPaqueteComercial = idPaqueteComercial;
	}
	public String getNombrePaqueteComercial() {
		return nombrePaqueteComercial;
	}
	public void setNombrePaqueteComercial(String nombrePaqueteComercial) {
		this.nombrePaqueteComercial = nombrePaqueteComercial;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}	
	public Long getValorItem() {
		return valorItem;
	}
	public void setValorItem(Long valorItem) {
		this.valorItem = valorItem;
	}    
	public Boolean getCerrado() {
		return cerrado;
	}
	public void setCerrado(Boolean cerrado) {
		this.cerrado = cerrado;
	}
	public String getCreadoPorCliente() {
		return creadoPorCliente;
	}
	public void setCreadoPorCliente(String creadoPorCliente) {
		this.creadoPorCliente = creadoPorCliente;
	}
	public Date getFechaCreacionCliente() {
		return fechaCreacionCliente;
	}
	public void setFechaCreacionCliente(Date fechaCreacionCliente) {
		this.fechaCreacionCliente = fechaCreacionCliente;
	}
	public String getModificadoCliente() {
		return modificadoCliente;
	}
	public void setModificadoCliente(String modificadoCliente) {
		this.modificadoCliente = modificadoCliente;
	}
	public Date getFechaModificacionCliente() {
		return fechaModificacionCliente;
	}
	public void setFechaModificacionCliente(Date fechaModificacionCliente) {
		this.fechaModificacionCliente = fechaModificacionCliente;
	}	
}
