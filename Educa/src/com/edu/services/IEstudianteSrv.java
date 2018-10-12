package com.edu.services;

import java.util.List;

import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;

public interface IEstudianteSrv {
	
	public List<EstudianteDto> consultaEstudiantesXMateria(int idMateria);
	
	public List<UsuarioDto> consultaTodosEstudiantesSinRelacion();
	
	public void guardarRelacionEstudianteGrupo(List<UsuarioDto> listaEstudiantes, int idGrupo);

}
