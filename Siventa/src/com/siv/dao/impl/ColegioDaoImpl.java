package com.siv.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.siv.dto.ColegioDto;

public class ColegioDaoImpl{
	
	private Session sesion;				    							
	
	@Autowired
    private SessionFactory sessionFactory;
	
    @Transactional
	public int guardarColegio(ColegioDto colegioDto){
    	
    	int id;
		
		sesion = sessionFactory.getCurrentSession();
		
	    id = (Integer) sesion.save(colegioDto);
		
		return id;
	}
    
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
