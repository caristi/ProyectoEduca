package com.edu.services.impl;

import java.util.Date;
import java.util.List;

import com.edu.dao.IEstudianteDao;
import com.edu.dao.IReportesDao;
import com.edu.dto.EstudianteDto;
import com.edu.dto.ReporteDto;
import com.edu.services.IReportesSrv;

public class ReportesSrvImpl implements IReportesSrv{

	IReportesDao reporteDao;
	IEstudianteDao estudianteDao;
	
	public List<ReporteDto> informeInasistenciaXMateria(int codMateria){
	
		return reporteDao.informeInasistenciaXMateria(codMateria);
	}
	
	public List<ReporteDto> informeInasistenciaXEstudiantes(String codigoEstudiante){
		return reporteDao.informeInasistenciaXEstudiantes(codigoEstudiante);
	}
	
	public List<ReporteDto> informeInasistenciaXEstudiantesFecha(int codigoEstudiante,int codMateria) {
		return reporteDao.informeInasistenciaXEstudiantesFecha(codigoEstudiante,codMateria);
	}
	
	public List<EstudianteDto> consultaEstudiantes(int idMateria,int idGrupo){
		
		return estudianteDao.consultaEstudiantes(idMateria, idGrupo);
	}
	
	public List<ReporteDto> informeInasistenciaXEstudiantesMateriaFecha(int codigoEstudiante,int codMateria){
		
		return reporteDao.informeInasistenciaXEstudiantesMateriaFecha(codigoEstudiante, codMateria);
	}
	
	public List<ReporteDto> informeInasistenciaXDia(Date fechaDia){
		
		return reporteDao.informeInasistenciaXDia(fechaDia);
	}
	
	public List<ReporteDto> reporteInasistenciaXTipoInasistencia(){
		
		return reporteDao.reporteInasistenciaXTipoInasistencia();
	}
	
	public List<ReporteDto> reporteInasistenciaXEstudiante(String codigoEstu){
		
		return reporteDao.reporteInasistenciaXEstudiante(codigoEstu);
	}
	
	public List<ReporteDto> reporteInasistenciaTodosEstudiante(){
		
		return reporteDao.reporteInasistenciaTodosEstudiante();
	}
	
	public List<ReporteDto> reporteInasistenciaXGrupo(String nomGrupo){
		
		return reporteDao.reporteInasistenciaXGrupo(nomGrupo);
	}
	
	public void setReporteDao(IReportesDao reporteDao) {
		this.reporteDao = reporteDao;
	}
	
	public void setEstudianteDao(IEstudianteDao estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
}
