package com.edu.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="materias")
public class MateriaDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mat_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "mat_codigo")
	private String codigo;
	
	@Column(name = "mat_nombre")
	private String nombre;
	
	@Column(name = "mat_fec_act")
	private Date fecActu;
	
	@Column(name = "mat_cod_usr")
	private String codUsr;
	
	@ManyToOne
	@JoinColumn(name="gru_id")
	private GrupoDto grupoDto;
	
	@ManyToOne
	@JoinColumn(name="doc_id")
	private DocenteDto docenteDto;
	
	@OneToMany(mappedBy="materiaDto",cascade= CascadeType.ALL)
	private Set<ActividadDto> actividadDto;
	
	@OneToMany(mappedBy="materiaDto",cascade= CascadeType.ALL)
	private Set<AsistenciaDto> asistenciaDto;
	
	@OneToMany(mappedBy="materiaDto",cascade= CascadeType.ALL)
	private Set<AsistenciaMateriaDto> asistenciaMateriaDto;
	
	@OneToMany(mappedBy="materiaDto",cascade= CascadeType.ALL)
	private Set<ResumenClaseDto> resumenClaseDto;
	
	public MateriaDto() {
		
		docenteDto = new DocenteDto();
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GrupoDto getGrupoDto() {
		return grupoDto;
	}
	public void setGrupoDto(GrupoDto grupoDto) {
		this.grupoDto = grupoDto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecActu() {
		return fecActu;
	}

	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public String getCodUsr() {
		return codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public DocenteDto getDocenteDto() {
		return docenteDto;
	}

	public void setDocenteDto(DocenteDto docenteDto) {
		this.docenteDto = docenteDto;
	}
	
}
