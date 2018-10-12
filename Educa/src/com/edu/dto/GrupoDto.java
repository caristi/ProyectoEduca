package com.edu.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupos")
public class GrupoDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gru_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "gru_nombre")
	private String nombre;
	
	@Column(name = "gru_fec_actu")
	private Date fecActu;
	
	@Column(name = "gru_cod_usr")
	private String codUsr;
	
	@Column(name = "gru_ciclo")
	private String ciclo;
	
	@OneToMany(mappedBy="grupoDto",cascade= CascadeType.ALL)
	private Set<MateriaDto> materiasDto;
	
	@OneToMany(mappedBy="grupoDto",cascade = CascadeType.ALL)
	private Set<EstudianteDto> estudianteDto;
	
	public GrupoDto() {
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

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
}
