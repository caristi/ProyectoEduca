package com.edu.bean;

import java.util.Date;
import java.util.List;

import org.primefaces.event.ToggleEvent;

import com.edu.dto.EstudianteDto;
import com.edu.dto.ReporteDto;
import com.edu.services.IReportesSrv;

public class ReportesBean {
	
	private IReportesSrv reporteSrv;
	
	private List<ReporteDto> listaReporteMateria;
	private List<ReporteDto> listaReporteEstu;
	private List<ReporteDto> listaReporteEstuFecha;
	private List<ReporteDto> listaReporteEstuDia;
	private List<ReporteDto> listaReporteXtipoInasis;
	private List<ReporteDto> listaReporteTodoEstudi;
	private List<ReporteDto> listaReporteXGrupo;

	private List<EstudianteDto> listaEstudiantes;
	private List<EstudianteDto> listaFiltroEstudiantes;
	
	private EstudianteDto estudianteDto;
	
	private int idMateria;
	private int idEstudiante;
	private int idGrupo;
	private int totalInasistencia;
	
	private String codigoEstu;
	private String nomGrupo;
	
	private Date fechaReporteDia;
	
	public ReportesBean() {
		
		fechaReporteDia = new Date(); 
	}
	
	public void consultarInasistenciaDelDia(){
		
		this.listaReporteEstuDia = reporteSrv.informeInasistenciaXDia(this.fechaReporteDia);
	}
	
	public void consultarInasitenciaPorMateria(){
		
		listaReporteMateria = reporteSrv.informeInasistenciaXMateria(idMateria);
	}
	
	public void consultarInasitenciaPorGrupo(){
		
		listaReporteXGrupo = reporteSrv.reporteInasistenciaXGrupo(nomGrupo);
	}
	
	public void consultarInasistecniaPorEstudianteFecha(ToggleEvent event){
		
		ReporteDto rep = (ReporteDto) event.getData();
		
		//listaReporteEstuFecha = reporteSrv.informeInasistenciaXEstudiantesFecha(rep.getCodigoEst(),idMateria);
		
		listaReporteEstuFecha = reporteSrv.informeInasistenciaXEstudiantesMateriaFecha(rep.getCodigoEst(),idMateria);
	}
	
	public void consultarInasistenciaPorEstudiante(){
		
		listaReporteEstu = reporteSrv.reporteInasistenciaXEstudiante(codigoEstu);
	}
	
	public void consunltarEstudiantes(){
		
		listaEstudiantes = reporteSrv.consultaEstudiantes(idMateria, idGrupo);
	}
	
	public List<ReporteDto> getListaReporteXtipoInasis() {
		listaReporteXtipoInasis = reporteSrv.reporteInasistenciaXTipoInasistencia();
		this.totalInasistencia = listaReporteXtipoInasis.get(0).getCantTotalInasistencia();
		return listaReporteXtipoInasis;
	}
	
	public List<ReporteDto> getListaReporteTodoEstudi() {
		listaReporteTodoEstudi = reporteSrv.reporteInasistenciaTodosEstudiante();
		return listaReporteTodoEstudi;
	}
	
	public List<ReporteDto> getListaReporteMateria() {
		return listaReporteMateria;
	}

	public void setListaReporteMateria(List<ReporteDto> listaReporteMateria) {
		this.listaReporteMateria = listaReporteMateria;
	}
	
	public void setReporteSrv(IReportesSrv reporteSrv) {
		this.reporteSrv = reporteSrv;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public List<ReporteDto> getListaReporteEstu() {
		return listaReporteEstu;
	}

	public void setListaReporteEstu(List<ReporteDto> listaReporteEstu) {
		this.listaReporteEstu = listaReporteEstu;
	}

	public List<ReporteDto> getListaReporteEstuFecha() {
		return listaReporteEstuFecha;
	}

	public void setListaReporteEstuFecha(List<ReporteDto> listaReporteEstuFecha) {
		this.listaReporteEstuFecha = listaReporteEstuFecha;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public List<EstudianteDto> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<EstudianteDto> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<EstudianteDto> getListaFiltroEstudiantes() {
		return listaFiltroEstudiantes;
	}

	public void setListaFiltroEstudiantes(List<EstudianteDto> listaFiltroEstudiantes) {
		this.listaFiltroEstudiantes = listaFiltroEstudiantes;
	}

	public EstudianteDto getEstudianteDto() {
		return estudianteDto;
	}

	public Date getFechaReporteDia() {
		return fechaReporteDia;
	}

	public void setFechaReporteDia(Date fechaReporteDia) {
		this.fechaReporteDia = fechaReporteDia;
	}

	public List<ReporteDto> getListaReporteEstuDia() {
		return listaReporteEstuDia;
	}

	public void setListaReporteEstuDia(List<ReporteDto> listaReporteEstuDia) {
		this.listaReporteEstuDia = listaReporteEstuDia;
	}

	public void setListaReporteXtipoInasis(List<ReporteDto> listaReporteXtipoInasis) {
		this.listaReporteXtipoInasis = listaReporteXtipoInasis;
	}

	public int getTotalInasistencia() {
		return totalInasistencia;
	}

	public void setTotalInasistencia(int totalInasistencia) {
		this.totalInasistencia = totalInasistencia;
	}

	public String getCodigoEstu() {
		return codigoEstu;
	}

	public void setCodigoEstu(String codigoEstu) {
		this.codigoEstu = codigoEstu;
	}

	public void setListaReporteTodoEstudi(List<ReporteDto> listaReporteTodoEstudi) {
		this.listaReporteTodoEstudi = listaReporteTodoEstudi;
	}

	public List<ReporteDto> getListaReporteXGrupo() {
		return listaReporteXGrupo;
	}

	public void setListaReporteXGrupo(List<ReporteDto> listaReporteXGrupo) {
		this.listaReporteXGrupo = listaReporteXGrupo;
	}

	public String getNomGrupo() {
		return nomGrupo;
	}

	public void setNomGrupo(String nomGrupo) {
		this.nomGrupo = nomGrupo;
	}

}
