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
@Table(name = "asistencia")
public class AsistenciaDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "asi_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "asi_fecha")
	private Date fecha;
	
	@Column(name = "asi_fec_actu")
	private Date fechaActu;
	
	@Column(name = "asi_cod_usr")
	private String codUsrActu;

	@ManyToOne
	@JoinColumn(name="mat_id")
	private MateriaDto materiaDto;
	
	@ManyToOne
	@JoinColumn(name="tipasi_cod_asi")
	private TipoAsistenciaDto tipoAsistenciaDto;
	
	@ManyToOne
	@JoinColumn(name="est_id")
	private EstudianteDto estudianteDto;
	
	
	public AsistenciaDto() {
		
		estudianteDto = new EstudianteDto();
		tipoAsistenciaDto = new TipoAsistenciaDto();
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

	public TipoAsistenciaDto getTipoAsistenciaDto() {
		return tipoAsistenciaDto;
	}

	public void setTipoAsistenciaDto(TipoAsistenciaDto tipoAsistenciaDto) {
		this.tipoAsistenciaDto = tipoAsistenciaDto;
	}

	public EstudianteDto getEstudianteDto() {
		return estudianteDto;
	}

	public void setEstudianteDto(EstudianteDto estudianteDto) {
		this.estudianteDto = estudianteDto;
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
