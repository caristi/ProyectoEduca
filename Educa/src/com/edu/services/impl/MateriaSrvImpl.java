package com.edu.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edu.dao.IMateriaDao;
import com.edu.dto.AsistenciaDto;
import com.edu.dto.AsistenciaMateriaDto;
import com.edu.dto.EstudianteDto;
import com.edu.dto.MateriaDto;
import com.edu.dto.TipoAsistenciaDto;
import com.edu.services.IMateriaSrv;

public class MateriaSrvImpl implements IMateriaSrv{
	
	public IMateriaDao materiaDao;
	public EstudianteSrvImpl estudianteSrv;
	
	public void guardarAsistencia(List<AsistenciaDto> listaAsistencia) {
		
		List<AsistenciaDto> listaGuardar  = new ArrayList<AsistenciaDto>(); 
		
		for(AsistenciaDto asistencia: listaAsistencia){

			if(asistencia.getTipoAsistenciaDto().getCodigo() != 5){

				asistencia.setFecha(new Date());
				asistencia.setFechaActu(new Date());
				asistencia.setCodUsrActu("CARISTI");
				
				listaGuardar.add(asistencia);
			}
		}
		
		AsistenciaMateriaDto asistenciaMat = new AsistenciaMateriaDto();
		asistenciaMat.setFecha(new Date());
		asistenciaMat.setFechaActu(new Date());
		asistenciaMat.setCodUsrActu("CARISTI");
		asistenciaMat.setMateriaDto(listaAsistencia.get(0).getMateriaDto());
	
		materiaDao.guardarAsistencia(listaGuardar,asistenciaMat);
	}
	
	public int guardarMateria(MateriaDto materia){
		
		materia.setFecActu(new Date());
		materia.setCodUsr("CARISTI");
		materia.setCodigo(materia.getNombre() + materia.getGrupoDto().getId()) ;
		
		return materiaDao.guardarMateria(materia);
	}
	
	public void actualizarAsistencia(List<AsistenciaDto> listaAsistenciaReg){
		
		for(AsistenciaDto asistencia: listaAsistenciaReg){
			
			if(asistencia.getTipoAsistenciaDto().getCodigo() == 5){
				materiaDao.eliminarAsistencia(asistencia);
			}else{
				asistencia.setFechaActu(new Date());
				asistencia.setCodUsrActu("CARISTI");
				materiaDao.actualizaAsistencia(asistencia);
			}
		}
	}
	
	public List<AsistenciaDto> obtenerListaAsistenciaXEstudiante(int idMateria){
		
		List<EstudianteDto> listaEstudiante = estudianteSrv.consultaEstudiantesXMateria(idMateria);
		
		List<AsistenciaDto> listaAsistencia = new ArrayList<AsistenciaDto>();
		
		for(EstudianteDto estudiante: listaEstudiante){
			
			AsistenciaDto asistencia = new AsistenciaDto();
			MateriaDto materia = new MateriaDto();
			materia.setId(idMateria);
			
			asistencia.setMateriaDto(materia);
			asistencia.setEstudianteDto(estudiante);
			
			TipoAsistenciaDto tipAsis = new TipoAsistenciaDto();
			tipAsis.setCodigo(5);
			asistencia.setTipoAsistenciaDto(tipAsis);
			
			listaAsistencia.add(asistencia);
		}
		
		return listaAsistencia;
	}
	
	public List<AsistenciaDto> obtenerAsistenciaRegistrada(int idMateria){
		
		List<AsistenciaDto> listaAsisRegistra = materiaDao.obtenerAsistenciaRegistrada(idMateria);
		
		return listaAsisRegistra;
	}
	
	public void actualizarTercero(MateriaDto materia){
	
	  materiaDao.actualizarTercero(materia);
	}
	
	public List<MateriaDto> buscarMateria(MateriaDto materiaDto){
		
		return materiaDao.buscarMateria(materiaDto);
	}
	
	public List<MateriaDto> listarMaterias(){
		
		return materiaDao.listarMaterias();
	}
	
	public List<MateriaDto> listarMateriasDocente(int idDocente){
		
		return materiaDao.listarMateriasDocente(idDocente);
	}
	
	public void setMateriaDao(IMateriaDao materiaDao) {
		this.materiaDao = materiaDao;
	}
	
	public void setEstudianteSrv(EstudianteSrvImpl estudianteSrv) {
		this.estudianteSrv = estudianteSrv;
	}

}
