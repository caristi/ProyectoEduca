package com.siv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siv.dto.UsuarioDto;

@Repository
public class UsuarioDaoImpl{

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
	public List<UsuarioDto> buscarUsuario(UsuarioDto usuarioDto){

		String sql = "select u from UsuarioDto u Where  1 = 1 ";

		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();

		sesion = sessionFactory.getCurrentSession();

		if(usuarioDto.getActivo() != null && !usuarioDto.getActivo().isEmpty()){

			sql += "and u.activo = '" + usuarioDto.getActivo() + "' ";
		}

		if(usuarioDto.getLogin() != null && !usuarioDto.getLogin().isEmpty()){

			sql += "and u.login = '" + usuarioDto.getLogin() + "' ";
		}

		if(usuarioDto.getTipDocum() != null && !usuarioDto.getTipDocum().isEmpty()){

			sql += "and u.tipDocum = '" + usuarioDto.getTipDocum() +"' ";
		}

		if(usuarioDto.getNumDocum() != null && !usuarioDto.getNumDocum().isEmpty()){

			sql += "and u.numDocum = '" + usuarioDto.getNumDocum() + "' ";
		}

		if(usuarioDto.getNombre() != null && !usuarioDto.getNombre().isEmpty()){

			sql += "and u.nombre like '%" + usuarioDto.getNombre() + "%' ";
		}

		if(usuarioDto.getApellido1() != null && !usuarioDto.getApellido1().isEmpty()){

			sql += "and u.apellido1 like '%" + usuarioDto.getApellido1() + "%' ";
		}

		if(usuarioDto.getApellido2() != null && !usuarioDto.getApellido2().isEmpty()){

			sql += "and u.apellido2 like '%" + usuarioDto.getApellido2() + "%' ";
		}

		if(usuarioDto.getEmail() != null && !usuarioDto.getEmail().isEmpty()){

			sql += "and u.email like '%" + usuarioDto.getEmail() + "%' ";
		}

		usuarios = sesion.createQuery(sql).list();

		return usuarios;

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

	  List<UsuarioDto> usuarios = sesion.createQuery("select u from UsuarioDto u where login = ?").setParameter(0, usuario.getLogin()).list();
	
	  if (usuarios!=null){
		  
		  return usuarios.get(0); 
	  }else{
		  
		  return new UsuarioDto();
	  }
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
