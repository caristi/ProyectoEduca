package com.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IGrupoDao;
import com.edu.dto.GrupoDto;

public class GrupoDaoImpl implements IGrupoDao{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarGrupo(GrupoDto materia){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(materia);
		
		return id;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<GrupoDto> listarGrupos(){
    	
    	sesion = sessionFactory.getCurrentSession();
		
		List<GrupoDto> listaGrupo = null;
    	
		listaGrupo = sesion.createQuery("select m from GrupoDto m").list();
    	
    	return listaGrupo;
    }
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<GrupoDto> buscarGrupo(GrupoDto grupoDto){
		
		String sql = "select g from GrupoDto g ";
	    			     
	  	List<GrupoDto> grupos = new ArrayList<GrupoDto>();
	  	
	   	sesion = sessionFactory.getCurrentSession();
	   	
	   	if(grupoDto.getNombre() != null && !grupoDto.getNombre().isEmpty()){
	   		
	   		sql += "Where g.nombre like '%" + grupoDto.getNombre() + "%' ";
	   	}
	   	
	   	grupos = sesion.createQuery(sql).list();
	   			
	   	return grupos;
	}
	
	@Transactional
	public void actualizarGrupo(GrupoDto grupoDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(grupoDto);
	}
    
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
