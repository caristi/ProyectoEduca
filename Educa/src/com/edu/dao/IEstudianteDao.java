package com.edu.dao;

import java.util.List;

import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;

public interface IEstudianteDao {
	
	public List<EstudianteDto> consultaEstudiantesXMateria(int idMateria);
	
	public List<EstudianteDto> consultaEstudiantes(int idMateria,int idGrupo);
	
	public List<UsuarioDto> consultaTodosEstudiantesSinRelacion();
	
	public void guardarRelacionEstudianteGrupo(List<EstudianteDto> listaEstudiantes);

}
