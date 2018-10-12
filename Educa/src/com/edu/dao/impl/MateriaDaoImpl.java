package com.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IMateriaDao;
import com.edu.dto.AsistenciaDto;
import com.edu.dto.AsistenciaMateriaDto;
import com.edu.dto.MateriaDto;

public class MateriaDaoImpl implements IMateriaDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public void guardarAsistencia(List<AsistenciaDto> listaAsistencia, AsistenciaMateriaDto asistenciaMateria) {
		
	  sesion = sessionFactory.getCurrentSession();
	  
	  for(AsistenciaDto asistencia: listaAsistencia){
		  
		 sesion.save(asistencia);
	  }
	  sesion.save(asistenciaMateria);
	}
    
    @Transactional
    public void actualizaAsistencia(AsistenciaDto asistencia){
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	sesion.update(asistencia);
    }
    
    @Transactional
    public void eliminarAsistencia(AsistenciaDto asistencia){
    
    	sesion = sessionFactory.getCurrentSession();
    	
    	sesion.delete(asistencia);
    }

    @Transactional
	public int guardarMateria(MateriaDto materia){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(materia);
		
		return id;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<MateriaDto> listarMaterias(){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<MateriaDto> listaMaterias = null;
    	
		listaMaterias = sesion.createQuery("select m from MateriaDto m").list();
    	
    	return listaMaterias;
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<MateriaDto> listarMateriasDocente(int idDocente){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<MateriaDto> listaMaterias = null;
    	
		listaMaterias = sesion.createQuery("select m from MateriaDto m Where m.docenteDto.id = :idDocente").setParameter("idDocente", idDocente).list();
    	
    	return listaMaterias;
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<MateriaDto> buscarMateria(MateriaDto materiaDto){
		
		String sql = "select m from MateriaDto m Where  1 = 1 ";
	    			     
	  	List<MateriaDto> materias = new ArrayList<MateriaDto>();
	  	
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	if(materiaDto.getNombre() != null && !materiaDto.getNombre().isEmpty()){
	   		
	   		sql += "and m.nombre like '%" + materiaDto.getNombre() + "%' ";
	   	}
	   	
	   	if(materiaDto.getGrupoDto() != null && materiaDto.getGrupoDto().getId() > 0){
	   		
	   		sql += "and m.grupoDto.id = " + materiaDto.getGrupoDto().getId();
	   	}
	   	
	   	materias = sesion.createQuery(sql).list();
	   			
	   	return materias;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AsistenciaDto> obtenerAsistenciaRegistrada(int idMateria){

		sesion = sessionFactory.getCurrentSession();

		List<AsistenciaDto> listaAsistenciaDto = null;

		listaAsistenciaDto = sesion.createQuery("select a from AsistenciaDto a Where a.materiaDto.id = :idMat and a.fecha = CURDATE()").setParameter("idMat", idMateria).list();

		return listaAsistenciaDto;
	}
	
	@Transactional
	public void actualizarTercero(MateriaDto materia){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(materia);
	}
    
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
