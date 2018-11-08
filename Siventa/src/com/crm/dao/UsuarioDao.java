package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dto.UsuarioDto;

@Repository
public class UsuarioDao{

	private Session sesion;				    							

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int guardar(UsuarioDto usuario){

		int id;

		sesion = sessionFactory.getCurrentSession();

		id = (Integer) sesion.save(usuario);

		return id;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UsuarioDto> listarUsuarios(){

		sesion = sessionFactory.getCurrentSession();

		List<UsuarioDto> listaUsuarios = null;

		listaUsuarios = sesion.createQuery("select u from UsuarioDto u").list();

		return listaUsuarios;
	}

	@Transactional
	public void actualizarUsuario(UsuarioDto usuario){

		sesion = sessionFactory.getCurrentSession();

		sesion.update(usuario);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public UsuarioDto buscarUsuario(String login){

		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();

		sesion = sessionFactory.getCurrentSession();

		usuarios = sesion.createQuery("select u from UsuarioDto u where login = ?").setParameter(0, login).list();

		if(usuarios.size() > 0){
			return usuarios.get(0);
		}else{
			return null;											
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public UsuarioDto consultarUsuario(UsuarioDto usuario){

	  sesion = sessionFactory.getCurrentSession();

	  List<UsuarioDto> usuarios = sesion.createQuery("select u from UsuarioDto u where u.login = :login").setParameter("login", usuario.getLogin()).list();
	
	  if (usuarios != null && usuarios.size() > 0){
		  
		  return usuarios.get(0); 
	  }else{
		  
		  return new UsuarioDto();
	  }
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
