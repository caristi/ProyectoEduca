package com.edu.dao;

import java.util.Date;
import java.util.List;

import com.edu.dto.ReporteDto;

public interface IReportesDao {
	
	public List<ReporteDto> informeInasistenciaXMateria(int codigoMateria);
	
	public List<ReporteDto> informeInasistenciaXEstudiantes(String codigoEstudiante);
	
	public List<ReporteDto> informeInasistenciaXEstudiantesFecha(int codigoEstudiante,int codMateria);
	
	public List<ReporteDto> informeInasistenciaXEstudiantesMateriaFecha(int codigoEstudiante,int codMateria);
	
	public List<ReporteDto> informeInasistenciaXDia(Date fechaDia);
	
	public List<ReporteDto> reporteInasistenciaXTipoInasistencia();
	
	public List<ReporteDto> reporteInasistenciaXEstudiante(String codigoEstu);
	
	public List<ReporteDto> reporteInasistenciaTodosEstudiante();
	
	public List<ReporteDto> reporteInasistenciaXGrupo(String nomGrupo);
}
