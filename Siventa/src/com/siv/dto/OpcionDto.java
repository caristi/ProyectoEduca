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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="opciones")
public class OpcionDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opc_id")
	private int id;
	
	@Column(name="opc_codigo")
	private int codigo;
	
	@Column(name="op_url")
	private String url;
	
	@Column(name="opc_descripcion")
	private String descripcion;
	
	@Column(name="opc_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="opc_cod_princ")
	@NotFound(action = NotFoundAction.IGNORE)
	private OpcionDto cod_principal;
	
	@Column(name="opc_icon")
	private String iconOpc;
	
	@Column(name="opc_fec_act")
	private Date fecActu;
	
	@Column(name="opc_cod_usr")
	private String codUsr;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public OpcionDto getCod_principal() {
		return cod_principal;
	}

	public void setCod_principal(OpcionDto cod_principal) {
		this.cod_principal = cod_principal;
	}

	public String getIconOpc() {
		return iconOpc;
	}

	public void setIconOpc(String iconOpc) {
		this.iconOpc = iconOpc;
	}
}
