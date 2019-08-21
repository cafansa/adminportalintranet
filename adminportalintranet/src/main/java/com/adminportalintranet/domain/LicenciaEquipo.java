package com.adminportalintranet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="secuencia", initialValue=1, allocationSize=1)
@Table(name="licencia_equipo")
public class LicenciaEquipo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="secuencia")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long idlicencia;
	private String nombrelicencia;
	private Long equipoid;
	private String nequipo;
	private String hash;
	private Long idserial;
	private String serial;
	private Long idlead;
	private String activo;
	
	public LicenciaEquipo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdlicencia() {
		return idlicencia;
	}

	public void setIdlicencia(Long idlicencia) {
		this.idlicencia = idlicencia;
	}

	public String getNombrelicencia() {
		return nombrelicencia;
	}

	public void setNombrelicencia(String nombrelicencia) {
		this.nombrelicencia = nombrelicencia;
	}

	public Long getEquipoid() {
		return equipoid;
	}

	public void setEquipoid(Long equipoid) {
		this.equipoid = equipoid;
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

	public Long getIdlead() {
		return idlead;
	}

	public void setIdlead(Long idlead) {
		this.idlead = idlead;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}
