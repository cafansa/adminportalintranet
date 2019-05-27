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
@Table(name="paquetes_productos")
public class PaqueteProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long idPaqueteProducto;
	private Long idPaquete;
	private String nombrePaquete;
	
	/*
	@OneToMany(mappedBy="paquetesProductos", cascade = CascadeType.ALL)
	private List<Producto> productos;
	*/
	
	//@Column(nullable= true)
	private Long idProducto;
	private String nombreProducto;
	
	@Column(columnDefinition="text")
	private String descripcion;
	
	private int tipoContrato;

	private int estado;
	private String paqueteProductoCreadoPor;
	private Date fechaCreacionPaqueteProducto;	
	private String paqueteProductoEditadoPor;
	private Date fechaEdicionPaqueteProducto;
	
	public PaqueteProducto() {
		//super();
		// TODO Auto-generated constructor stub
	}
		



	//public PaqueteProducto(Long idPaqueteProducto, Long idPaquete, String nombrePaquete, List<Producto> productos,
	public PaqueteProducto(Long idPaqueteProducto, Long idPaquete, String nombrePaquete,
			Long idProducto, String nombreProducto, String descripcion, int tipoContrato, int estado,
			String paqueteProductoCreadoPor, Date fechaCreacionPaqueteProducto, String paqueteProductoEditadoPor,
			Date fechaEdicionPaqueteProducto) {
		super();
		this.idPaqueteProducto = idPaqueteProducto;
		this.idPaquete = idPaquete;
		this.nombrePaquete = nombrePaquete;
		//this.productos = productos;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.tipoContrato = tipoContrato;
		this.estado = estado;
		this.paqueteProductoCreadoPor = paqueteProductoCreadoPor;
		this.fechaCreacionPaqueteProducto = fechaCreacionPaqueteProducto;
		this.paqueteProductoEditadoPor = paqueteProductoEditadoPor;
		this.fechaEdicionPaqueteProducto = fechaEdicionPaqueteProducto;
	}




	//Getters & Setters
	public Long getIdPaqueteProducto() {
		return idPaqueteProducto;
	}
	public void setIdPaqueteProducto(Long idPaqueteProducto) {
		this.idPaqueteProducto = idPaqueteProducto;
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

	/*
	
	public List<Producto> getProductos() {
		return productos;
	}




	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
*/



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}		
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}		
	
	public int getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(int tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
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
	public String getPaqueteProductoEditadoPor() {
		return paqueteProductoEditadoPor;
	}
	public void setPaqueteProductoEditadoPor(String paqueteProductoEditadoPor) {
		this.paqueteProductoEditadoPor = paqueteProductoEditadoPor;
	}
	public Date getFechaEdicionPaqueteProducto() {
		return fechaEdicionPaqueteProducto;
	}
	public void setFechaEdicionPaqueteProducto(Date fechaEdicionPaqueteProducto) {
		this.fechaEdicionPaqueteProducto = fechaEdicionPaqueteProducto;
	}

	/*
	public Long getContador() {
		return contador;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}*/
	
	
	
	
}
