package com.edu.services;

import java.util.List;

import com.edu.dto.AsistenciaDto;
import com.edu.dto.MateriaDto;

public interface IMateriaSrv {
	
	public void guardarAsistencia(List<AsistenciaDto> listaAsistencia);
	
	public void actualizarAsistencia(List<AsistenciaDto> listaAsistenciaReg);
	
	public int guardarMateria(MateriaDto materia);
	
	public List<MateriaDto> listarMaterias();
	
	public List<MateriaDto> listarMateriasDocente(int idDocente);
	
	public List<MateriaDto> buscarMateria(MateriaDto materiaDto);
	
	public void actualizarTercero(MateriaDto materia);
	
	public List<AsistenciaDto> obtenerListaAsistenciaXEstudiante(int idMateria);
	
	public List<AsistenciaDto> obtenerAsistenciaRegistrada(int idMateria);
	
}
