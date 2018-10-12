package com.edu.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidatos")
public class CandidatoDto {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "can_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "can_nombre")
	private String can_nombre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCan_nombre() {
		return can_nombre;
	}
	public void setCan_nombre(String can_nombre) {
		this.can_nombre = can_nombre;
	}
	
	

}
