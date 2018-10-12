package com.edu.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resumenclase")
public class ResumenClaseDto {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "res_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "res_titulo")
	private String titulo;
	
	@Column(name = "res_descripcion")
	private String descripcion;
	
	
	@Column(name = "res_fecha")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="mat_id")
	private MateriaDto materiaDto;
	
	
	public ResumenClaseDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MateriaDto getMateriaDto() {
		return materiaDto;
	}

	public void setMateriaDto(MateriaDto materiaDto) {
		this.materiaDto = materiaDto;
	}
}
