package com.edu.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipoasistencia")
public class TipoAsistenciaDto {
	
	@Id
	@Column(name = "tipasi_cod_asi",unique = true, nullable = false)
	private int codigo;
	
	@Column(name = "tipasi_opcion")
	private String nombre;
	
	@Column(name = "tipasi_visible")
	private String mcaVisible;
	
	@Column(name = "tipasi_envio_email")
	private int envioEmail;
	
	@OneToMany(mappedBy="tipoAsistenciaDto",cascade= CascadeType.ALL)
	private Set<AsistenciaDto> asistenciaDto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEnvioEmail() {
		return envioEmail;
	}

	public void setEnvioEmail(int envioEmail) {
		this.envioEmail = envioEmail;
	}

	public String getMcaVisible() {
		return mcaVisible;
	}

	public void setMcaVisible(String mcaVisible) {
		this.mcaVisible = mcaVisible;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
