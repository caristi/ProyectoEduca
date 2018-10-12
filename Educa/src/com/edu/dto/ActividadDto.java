package com.edu.dto;

import java.io.Serializable;
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
@Table(name="actividades")
public class ActividadDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "act_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "act_titulo")
	private String titulo;
	
	@Column(name="act_descripcion")
	private String descripcion;
	
	@Column(name="act_fecha_inicial")
	private Date fechaInicial;
	
	@Column(name="act_fecha_limite")
	private Date fechaLimite;
	
	@ManyToOne
	@JoinColumn(name="mat_id")
	private MateriaDto materiaDto;
	
	public ActividadDto() {
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
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public MateriaDto getMateriaDto() {
		return materiaDto;
	}
	public void setMateriaDto(MateriaDto materiaDto) {
		this.materiaDto = materiaDto;
	}
}
