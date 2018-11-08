package com.crm.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "usu_id", unique = true, nullable = false)
	private int id;
	
	
	@Column(name = "usu_login")
	private String login;
	
	@Column(name = "usu_contrasena")
	private String contrasena;
	
	@javax.persistence.Transient
	private boolean acceso;
	
	@javax.persistence.Transient
	private String mensajeAcceso;

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
