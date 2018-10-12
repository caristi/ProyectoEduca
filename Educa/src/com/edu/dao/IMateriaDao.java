package com.edu.dao;

import java.util.List;

import com.edu.dto.AsistenciaDto;
import com.edu.dto.AsistenciaMateriaDto;
import com.edu.dto.MateriaDto;

public interface IMateriaDao {
	
	public void guardarAsistencia(List<AsistenciaDto> listaAsistencia, AsistenciaMateriaDto asistenciaMateria);
	
	public void actualizaAsistencia(AsistenciaDto asistencia);
	
	public void eliminarAsistencia(AsistenciaDto asistencia);
	
	public int guardarMateria(MateriaDto materia);
	
	public List<MateriaDto> listarMaterias();
	
	public List<MateriaDto> listarMateriasDocente(int idDocente);
	
	public List<MateriaDto> buscarMateria(MateriaDto materiaDto);
	
	public List<AsistenciaDto> obtenerAsistenciaRegistrada(int idMateria);
	
	public void actualizarTercero(MateriaDto materia);
}
