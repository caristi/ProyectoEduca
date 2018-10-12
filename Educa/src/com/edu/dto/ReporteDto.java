package com.edu.dto;

import java.util.Date;
import java.util.List;

public class ReporteDto {
	
	private int codigoEst;
	
	private String nombreEst;
	private String apelledio1Est;
	private String apelledio2Est;
	private String nombreMateria;
	private String nombreGrupo;
	private String telefonoCasa;
	
	private String nombreTipoAsistencia;
	
	private int cantidadSinExcusas;
	private int cantidadConExcusas;
	private int cantidadActivInstitucional;
	private int cantidadTarde;
	private int codigoMateria;
	private int cantTotalInasistencia;
	private int cantXTipoInasistencia;
	
	private float porcentajeInasis;
	private float porcentajeRealInasis;
	
	private Date fechaInasistencia;
	
	private List<SubReporteDto> subReporteDto;
	
	public int getCodigoEst() {
		return codigoEst;
	}
	public void setCodigoEst(int codigoEst) {
		this.codigoEst = codigoEst;
	}
	public String getNombreEst() {
		return nombreEst;
	}
	public void setNombreEst(String nombreEst) {
		this.nombreEst = nombreEst;
	}
	public String getApelledio1Est() {
		return apelledio1Est;
	}
	public void setApelledio1Est(String apelledio1Est) {
		this.apelledio1Est = apelledio1Est;
	}
	public String getApelledio2Est() {
		return apelledio2Est;
	}
	public void setApelledio2Est(String apelledio2Est) {
		this.apelledio2Est = apelledio2Est;
	}
	public int getCantidadSinExcusas() {
		return cantidadSinExcusas;
	}
	public void setCantidadSinExcusas(int cantidadSinExcusas) {
		this.cantidadSinExcusas = cantidadSinExcusas;
	}
	public int getCantidadConExcusas() {
		return cantidadConExcusas;
	}
	public void setCantidadConExcusas(int cantidadConExcusas) {
		this.cantidadConExcusas = cantidadConExcusas;
	}
	public int getCantidadTarde() {
		return cantidadTarde;
	}
	public void setCantidadTarde(int cantidadTarde) {
		this.cantidadTarde = cantidadTarde;
	}
	public int getCodigoMateria() {
		return codigoMateria;
	}
	public void setCodigoMateria(int codigoMateria) {
		this.codigoMateria = codigoMateria;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public Date getFechaInasistencia() {
		return fechaInasistencia;
	}
	public void setFechaInasistencia(Date fechaInasistencia) {
		this.fechaInasistencia = fechaInasistencia;
	}
	public String getNombreTipoAsistencia() {
		return nombreTipoAsistencia;
	}
	public void setNombreTipoAsistencia(String nombreTipoAsistencia) {
		this.nombreTipoAsistencia = nombreTipoAsistencia;
	}
	public List<SubReporteDto> getSubReporteDto() {
		return subReporteDto;
	}
	public void setSubReporteDto(List<SubReporteDto> subReporteDto) {
		this.subReporteDto = subReporteDto;
	}
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	public String getTelefonoCasa() {
		return telefonoCasa;
	}
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}
	public int getCantTotalInasistencia() {
		return cantTotalInasistencia;
	}
	public void setCantTotalInasistencia(int cantTotalInasistencia) {
		this.cantTotalInasistencia = cantTotalInasistencia;
	}
	public int getCantXTipoInasistencia() {
		return cantXTipoInasistencia;
	}
	public void setCantXTipoInasistencia(int cantXTipoInasistencia) {
		this.cantXTipoInasistencia = cantXTipoInasistencia;
	}
	public float getPorcentajeInasis() {
		return porcentajeInasis;
	}
	public void setPorcentajeInasis(float porcentajeInasis) {
		this.porcentajeInasis = porcentajeInasis;
	}
	public float getPorcentajeRealInasis() {
		return porcentajeRealInasis;
	}
	public void setPorcentajeRealInasis(float porcentajeRealInasis) {
		this.porcentajeRealInasis = porcentajeRealInasis;
	}
	public int getCantidadActivInstitucional() {
		return cantidadActivInstitucional;
	}
	public void setCantidadActivInstitucional(int cantidadActivInstitucional) {
		this.cantidadActivInstitucional = cantidadActivInstitucional;
	}
}
