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
@Table(name = "asistenciaMateria")
public class AsistenciaMateriaDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "asimat_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "asimat_fecha")
	private Date fecha;
	
	@Column(name = "asimat_fec_actu")
	private Date fechaActu;
	
	@Column(name = "asimat_cod_usr")
	private String codUsrActu;

	@ManyToOne
	@JoinColumn(name="mat_id")
	private MateriaDto materiaDto;
	
	public AsistenciaMateriaDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFechaActu() {
		return fechaActu;
	}

	public void setFechaActu(Date fechaActu) {
		this.fechaActu = fechaActu;
	}

	public String getCodUsrActu() {
		return codUsrActu;
	}

	public void setCodUsrActu(String codUsrActu) {
		this.codUsrActu = codUsrActu;
	}
}
