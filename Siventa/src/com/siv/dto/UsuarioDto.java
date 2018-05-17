package com.siv.dto;

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
@Table(name="usuarios")
public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "usu_id", unique = true, nullable = false)
	private int id;
	
	
	@Column(name = "usu_login")
	private String login;
	
	@Column(name = "usu_password")
	private String contrasena;
	
	@Column(name = "usu_activo")
	private String activo;
	
	@Column(name = "usu_tip_docum")
	private String tipDocum;
	
	@Column(name = "usu_num_docum")
	private String numDocum;
	
	@Column(name = "usu_nombre")
	private String nombre;
	
	@Column(name = "usu_apellido1")
	private String apellido1;
	
	@Column(name = "usu_apellido2")
	private String apellido2;
	
	@Column(name = "usu_direccion")
	private String direccion;
	
	@Column(name = "usu_telefono_casa")
	private String numTlfHogar;
	
	@Column(name = "usu_celular")
	private String numCelular;
	
	@Column(name = "usu_email")
	private String email;

	@Column(name = "usu_cod_usr")
	private String codUsr;
	
	@Column(name = "usu_fec_actu")
	private Date fecActu;
	
	
	@javax.persistence.Transient
	private boolean acceso;
	
	@javax.persistence.Transient
	private String mensajeAcceso;
	
	@ManyToOne
	@JoinColumn(name="col_id")
	private ColegioDto colegioDto;
	
	public UsuarioDto() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumTlfHogar() {
		return numTlfHogar;
	}
	public void setNumTlfHogar(String numTlfHogar) {
		this.numTlfHogar = numTlfHogar;
	}
	public String getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipDocum() {
		return tipDocum;
	}
	public void setTipDocum(String tipDocum) {
		this.tipDocum = tipDocum;
	}
	public String getNumDocum() {
		return numDocum;
	}
	public void setNumDocum(String numDocum) {
		this.numDocum = numDocum;
	}
	public String getCodUsr() {
		return codUsr;
	}
	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}
	public Date getFecActu() {
		return fecActu;
	}
	public void setFecActu(Date fecActu) {
		this.fecActu = fecActu;
	}

	public ColegioDto getColegioDto() {
		return colegioDto;
	}
	public void setColegioDto(ColegioDto colegioDto) {
		this.colegioDto = colegioDto;
	}

	public boolean isAcceso() {
		return acceso;
	}

	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	public String getMensajeAcceso() {
		return mensajeAcceso;
	}

	public void setMensajeAcceso(String mensajeAcceso) {
		this.mensajeAcceso = mensajeAcceso;
	}
}
