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
@Table(name="colegios")
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

	@Column(name="col_direccion")
	private String direccion;

	@Column(name="col_telefono")
	private String tlfFijo;

	@Column(name="col_arch_logo", columnDefinition="blob")
	private byte[] image;
	
	@Column(name="cod_usr")
	private String codUsr;

	@Column(name="fec_actu")
	private Date fecAct;
	
	@Column(name="col_email")
	private String email;
	
	@Column(name="col_nom_rep_legal")
	private String nomRepLegal;
	
	@Column(name="col_pagina_web")
	private String paginaWeb;

	@OneToMany(mappedBy="colegioDto",cascade= CascadeType.ALL)
	private Set<UsuarioDto> usuarioDto;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlfFijo() {
		return tlfFijo;
	}

	public void setTlfFijo(String tlfFijo) {
		this.tlfFijo = tlfFijo;
	}

	public String getCodUsr() {
		return codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getFecAct() {
		return fecAct;
	}

	public void setFecAct(Date fecAct) {
		this.fecAct = fecAct;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomRepLegal() {
		return nomRepLegal;
	}

	public void setNomRepLegal(String nomRepLegal) {
		this.nomRepLegal = nomRepLegal;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
}
