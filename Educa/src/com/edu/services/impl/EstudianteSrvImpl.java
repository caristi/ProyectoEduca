package com.edu.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edu.dao.IEstudianteDao;
import com.edu.dto.EstudianteDto;
import com.edu.dto.GrupoDto;
import com.edu.dto.UsuarioDto;
import com.edu.services.IEstudianteSrv;

public class EstudianteSrvImpl implements IEstudianteSrv{
	
	IEstudianteDao estudianteDao;
	
	public List<EstudianteDto> consultaEstudiantesXMateria(int idMateria){
		return estudianteDao.consultaEstudiantesXMateria(idMateria);
	}
	
	public List<UsuarioDto> consultaTodosEstudiantesSinRelacion(){
		return estudianteDao.consultaTodosEstudiantesSinRelacion();
	}
	
	public void guardarRelacionEstudianteGrupo(List<UsuarioDto> listaEstudiantes, int idGrupo){
		
		List<EstudianteDto> lisEst = new ArrayList<EstudianteDto>();
		EstudianteDto estudiante;
		
	   GrupoDto grupoDto = new GrupoDto();
	   grupoDto.setId(idGrupo);
		
		for(UsuarioDto usuario: listaEstudiantes){
			
			estudiante = new EstudianteDto();
			
			estudiante.setUsuarioDto(usuario);
			estudiante.setGrupoDto(grupoDto);
			estudiante.setFecAct(new Date());
			estudiante.setCodigo(usuario.getId()+"");
			estudiante.setCodUsr("CARISTI");
			
			lisEst.add(estudiante);
		}
		
	    estudianteDao.guardarRelacionEstudianteGrupo(lisEst);
	}
	
	public void setEstudianteDao(IEstudianteDao estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
}
