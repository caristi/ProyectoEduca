package com.siv.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colegio")
public class ColegioDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="col_id")
	private int id;

	@Column(name="col_nit")
	private String codNit;

	@Column(name="col_nombre")
	private String nombre;

	public ColegioDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodNit() {
		return codNit;
	}

	public void setCodNit(String codNit) {
		this.codNit = codNit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
