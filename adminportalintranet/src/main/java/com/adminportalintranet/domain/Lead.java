package com.adminportalintranet.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="leads_prospectos")
public class Lead {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int country;
	private int state;
	private int city;
	private String countryName;
	private String stateName;
	private String cityName;
	private String empresa;
	private String direccion;
	private String webpage;	
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String codigoPostal;
	private String zona;
	private String zonaNombre;
	private String tipoEmpresa;
	private String NombreTipoEmpresa;
	private String tipoContribuyente;
	private String rut;
	private String contactoPpal;
	private String emailGerente;
	private String telGerente;
	private String Otrocontacto;
	private String emailotro;
	private String telOtro;
	private String fechaCreacion;
	private Date fechaCreacionSistema;
	private Date fechaEdicionSistema;
	private int estado;
	@Column(columnDefinition="text")
	private String notas;
	@Transient
	private MultipartFile imagenEmpresa;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Countries countryIdfk;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private State stateIdfk;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private City cityIdfk;
	*/
	
	//Getters And Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String getZonaNombre() {
		return zonaNombre;
	}

	public void setZonaNombre(String zonaNombre) {
		this.zonaNombre = zonaNombre;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}	
	
	public String getNombreTipoEmpresa() {
		return NombreTipoEmpresa;
	}

	public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
		NombreTipoEmpresa = nombreTipoEmpresa;
	}

	public String getTipoContribuyente() {
		return tipoContribuyente;
	}

	public void setTipoContribuyente(String tipoContribuyente) {
		this.tipoContribuyente = tipoContribuyente;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getContactoPpal() {
		return contactoPpal;
	}

	public void setContactoPpal(String contactoPpal) {
		this.contactoPpal = contactoPpal;
	}

	public String getEmailGerente() {
		return emailGerente;
	}

	public void setEmailGerente(String emailGerente) {
		this.emailGerente = emailGerente;
	}

	public String getTelGerente() {
		return telGerente;
	}

	public void setTelGerente(String telGerente) {
		this.telGerente = telGerente;
	}

	public String getOtrocontacto() {
		return Otrocontacto;
	}

	public void setOtrocontacto(String otrocontacto) {
		Otrocontacto = otrocontacto;
	}

	public String getEmailotro() {
		return emailotro;
	}

	public void setEmailotro(String emailotro) {
		this.emailotro = emailotro;
	}

	public String getTelOtro() {
		return telOtro;
	}

	public void setTelOtro(String telOtro) {
		this.telOtro = telOtro;
	}

	public int getEstado() {
		return estado;
	}
	

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Date getFechaCreacionSistema() {
		return fechaCreacionSistema;
	}

	public void setFechaCreacionSistema(Date fechaCreacionSistema) {
		this.fechaCreacionSistema = fechaCreacionSistema;
	}
	
	public Date getFechaEdicionSistema() {
		return fechaEdicionSistema;
	}

	public void setFechaEdicionSistema(Date fechaEdicionSistema) {
		this.fechaEdicionSistema = fechaEdicionSistema;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	
	public MultipartFile getImagenEmpresa() {
		return imagenEmpresa;
	}

	public void setImagenEmpresa(MultipartFile imagenEmpresa) {
		this.imagenEmpresa = imagenEmpresa;
	}

	/*
	public Countries getCountryIdfk() {
		return countryIdfk;
	}

	public void setCountryIdfk(Countries countryIdfk) {
		this.countryIdfk = countryIdfk;
	}

	public State getStateIdfk() {
		return stateIdfk;
	}

	public void setStateIdfk(State stateIdfk) {
		this.stateIdfk = stateIdfk;
	}

	public City getCityIdfk() {
		return cityIdfk;
	}

	public void setCityIdfk(City cityIdfk) {
		this.cityIdfk = cityIdfk;
	}
*/
	

}
