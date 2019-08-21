package com.adminportalintranet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="secuencia", initialValue=1, allocationSize=100)
@Table(name="equipopc")
public class EquipoPC {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuencia")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nequipo;
	private String hash;
	private Long idserial;
	private String serial;
	private Boolean principal;
	private Boolean activo;
	
	public EquipoPC() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNequipo() {
		return nequipo;
	}

	public void setNequipo(String nequipo) {
		this.nequipo = nequipo;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	
}
