package com.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IMenuDao;
import com.edu.dto.OpcionDto;

public class MenuDaoImpl implements IMenuDao {

	private Session sesion;				    							

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<OpcionDto> consultarOpciones() {

		String sql = "select o from OpcionDto o ";

		List<OpcionDto> opciones = new ArrayList<OpcionDto>();

		sesion = sessionFactory.getCurrentSession();

		opciones = sesion.createQuery(sql).list();
		
		return opciones;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
