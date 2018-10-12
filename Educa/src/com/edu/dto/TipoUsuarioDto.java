package com.edu.dto;

import java.io.Serializable;
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
@Table(name="tipousuarios")
public class TipoUsuarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipusu_id", unique = true, nullable = false)
	private int id;
	
	@Column(name="tipusu_nombre")
	private String nombre;
	
	@Column(name="tipusu_cod_usr")
	private String codUsr;
	
	@Column(name="tipusu_fec_actu")
	private Date fecAct;
	
	@OneToMany(mappedBy="tipoUsuarioDto",cascade= CascadeType.ALL)
	private Set<UsuarioDto> usuarioDto;

	public TipoUsuarioDto() {
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

	public String getCodUsr() {
		return codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public Date getFecAct() {
		return fecAct;
	}

	public void setFecAct(Date fecAct) {
		this.fecAct = fecAct;
	}
	
}
