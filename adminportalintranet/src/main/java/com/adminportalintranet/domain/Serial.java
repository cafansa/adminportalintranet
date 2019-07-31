package com.adminportalintranet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="serial")
public class Serial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String serial;
	private Long idlead;
	
	public Serial() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
