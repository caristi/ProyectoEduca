package com.crm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.UsuarioDao;
import com.crm.dto.UsuarioDto;

public class UsuarioSrv{
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	public UsuarioDto consultarUsuario(UsuarioDto usuario){
		
		String login = usuario.getLogin();
		String contrasena = usuario.getContrasena();
		
		usuario =  usuarioDao.consultarUsuario(usuario);
		
		usuario.setAcceso(true);
		
		if(!login.toUpperCase().equals(usuario.getLogin())){
			
			usuario.setAcceso(false);
			usuario.setMensajeAcceso("El login no existe en el sistema.");
			
		}else if(!contrasena.equals(usuario.getContrasena())){
			usuario.setAcceso(false);
			usuario.setMensajeAcceso("La contraseña es errada.");			
		}
		
		return usuario;
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
