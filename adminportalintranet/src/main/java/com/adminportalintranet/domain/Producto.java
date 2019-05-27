package com.adminportalintranet.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@Column(name="productoId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre_producto;
	private String tipoProducto; //1 para Software de aplicaciones, 0 para paquetes de tickets u otros servicios. 	
	
	@Column(columnDefinition="text")
	private String descripcion;
	@Column(columnDefinition="text")
	private String req_hardware;
	@Column(columnDefinition="text")
	private String req_software;
	@Column(columnDefinition="text")
	private String reqComunicaciones;
	private int nroTicketsPeriodo;
	
	private Long licencia_desde;	
	private Long mes_desde;
	private Long noche_fact_desde;
	private int estado;
	
	private long creado_por;
	private Date fecha_creacion;
	private long editado_por;
	private Date fecha_edicicion;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name ="productoId", insertable=false, updatable=false)
	//@JoinColumn(name ="fk_idProducto", nullable = true)
	@JoinColumn(name ="idProducto")
    private PaqueteProducto paquetesProductos;
	*/

	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Producto(Long id, String nombre_producto, String tipoProducto, String descripcion, String req_hardware, String req_software, String reqComunicaciones,
			int nroTicketsPeriodo, Long licencia_desde, Long mes_desde, Long noche_fact_desde, int estado, long creado_por, 
			Date fecha_creacion, long editado_por, Date fecha_edicicion) {
		super();
		this.id = id;
		this.nombre_producto = nombre_producto;	
		this.tipoProducto = tipoProducto;
		this.descripcion = descripcion;
		this.req_hardware = req_hardware;
		this.req_software = req_software;
		this.reqComunicaciones = reqComunicaciones;
		this.nroTicketsPeriodo = nroTicketsPeriodo;
		this.licencia_desde = licencia_desde;
		this.mes_desde = mes_desde;
		this.noche_fact_desde = noche_fact_desde;
		this.estado = estado;
		this.creado_por = creado_por;
		this.fecha_creacion = fecha_creacion;
		this.editado_por = editado_por;
		this.fecha_edicicion = fecha_edicicion;
	}



	//Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}		
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getReq_hardware() {
		return req_hardware;
	}
	public void setReq_hardware(String req_hardware) {
		this.req_hardware = req_hardware;
	}
	public String getReq_software() {
		return req_software;
	}
	public void setReq_software(String req_software) {
		this.req_software = req_software;
	}		
	public String getReqComunicaciones() {
		return reqComunicaciones;
	}
	public void setReqComunicaciones(String reqComunicaciones) {
		this.reqComunicaciones = reqComunicaciones;
	}
	public int getNroTicketsPeriodo() {
		return nroTicketsPeriodo;
	}
	public void setNroTicketsPeriodo(int nroTicketsPeriodo) {
		this.nroTicketsPeriodo = nroTicketsPeriodo;
	}
	public Long getLicencia_desde() {
		return licencia_desde;
	}
	public void setLicencia_desde(Long licencia_desde) {
		this.licencia_desde = licencia_desde;
	}
	public Long getMes_desde() {
		return mes_desde;
	}
	public void setMes_desde(Long mes_desde) {
		this.mes_desde = mes_desde;
	}
	public Long getNoche_fact_desde() {
		return noche_fact_desde;
	}
	public void setNoche_fact_desde(Long noche_fact_desde) {
		this.noche_fact_desde = noche_fact_desde;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public long getCreado_por() {
		return creado_por;
	}
	public void setCreado_por(long creado_por) {
		this.creado_por = creado_por;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public long getEditado_por() {
		return editado_por;
	}
	public void setEditado_por(long editado_por) {
		this.editado_por = editado_por;
	}
	public Date getFecha_edicicion() {
		return fecha_edicicion;
	}
	public void setFecha_edicicion(Date fecha_edicicion) {
		this.fecha_edicicion = fecha_edicicion;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
