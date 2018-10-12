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
@Table(name="estudiante")
public class EstudianteDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "est_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "est_codigo")
	private String codigo;
	
	@Column(name = "est_fec_act")
	private Date fecAct;
	
	@Column(name = "est_cod_usr")
	private String codUsr;
	
	@ManyToOne
	@JoinColumn(name="usu_id")
	private UsuarioDto usuarioDto;
	
	@ManyToOne
	@JoinColumn(name="gru_id")
	private GrupoDto grupoDto;
	
	@OneToMany(mappedBy="estudianteDto",cascade= CascadeType.ALL)
	private Set<AsistenciaDto> asistenciaDto;
	
	public EstudianteDto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public GrupoDto getGrupoDto() {
		return grupoDto;
	}

	public void setGrupoDto(GrupoDto grupoDto) {
		this.grupoDto = grupoDto;
	}

	public Date getFecAct() {
		return fecAct;
	}

	public void setFecAct(Date fecAct) {
		this.fecAct = fecAct;
	}

	public String getCodUsr() {
		return codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}
}
