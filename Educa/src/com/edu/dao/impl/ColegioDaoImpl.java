package com.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;			

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IColegioDao;
import com.edu.dto.ColegioDto;

public class ColegioDaoImpl implements IColegioDao{
	
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
    
    @SuppressWarnings("unchecked")
	@Transactional
    public ColegioDto buscarColegio(ColegioDto colegioDto){

    	String sql = "select c from ColegioDto c ";

    	List<ColegioDto> colegios = new ArrayList<ColegioDto>();
    	ColegioDto colegio = new ColegioDto();

    	sesion = sessionFactory.getCurrentSession();

    	colegios = sesion.createQuery(sql).list();
    	
    	if(colegios.size() > 0){
    		
    		colegio = colegios.get(0);
    	}

    	return colegio;
    }
    
	@Transactional
	public void actualizarColegio(ColegioDto colegioDto){
		
		sesion = sessionFactory.getCurrentSession();
		
		sesion.update(colegioDto);
	}
    
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
