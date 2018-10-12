package com.edu.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IActividadDao;
import com.edu.dto.ActividadDto;

public class ActividadDaoImpl implements IActividadDao{
	
	private Session sesion;
	
    private SessionFactory sessionFactory;

    @Transactional
	public int guardar(ActividadDto actividad){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(actividad);
		
		return id;
		
	}
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<ActividadDto> listaActividades(){
    	
    	List<ActividadDto> listaActividades = null;
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	listaActividades = sesion.createQuery("select a from ActividadDto a").list();
    	
    	return listaActividades;
    }
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
