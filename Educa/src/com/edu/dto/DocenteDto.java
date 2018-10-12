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
@Table(name="docentes")
public class DocenteDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "doc_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "doc_cargo")
	private String cargo;
	
	@Column(name = "doc_fec_actu")
	private Date fecAct;
	
	@Column(name = "doc_cod_usr")
	private String codUsr;
	
	@ManyToOne
	@JoinColumn(name="usu_id")
	private UsuarioDto usuarioDto;
	
	public DocenteDto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
}
