package com.edu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IResumenClaseDao;
import com.edu.dto.ResumenClaseDto;

public class ResumenClaseDaoImpl implements IResumenClaseDao {
	
	
	private Session sesion;
	
    private SessionFactory sessionFactory;
	
    @Transactional
	public int crearResumenClase(ResumenClaseDto resumenClase){
		
		int id;
		
		sesion = sessionFactory.getCurrentSession();
		
		id = (Integer) sesion.save(resumenClase);
		
		return id;
		
	}
    
	@SuppressWarnings("unchecked")
	@Transactional
    public List<ResumenClaseDto> listaResumenesClases(){
    	
    	List<ResumenClaseDto> resumenesClases = null;
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	resumenesClases = sesion.createQuery("select r from ResumenClaseDto r").list();
    	
    	return resumenesClases;
    }
    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
