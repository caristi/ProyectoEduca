package com.edu.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.dao.IUsuarioDao;
import com.edu.dto.ColegioDto;
import com.edu.dto.DocenteDto;
import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;
import com.edu.services.IUsuarioSrv;

public class UsuarioSrvImpl implements IUsuarioSrv{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	public int guardar(UsuarioDto usuario, EstudianteDto estudiante) {
		
		ColegioDto colegio = new ColegioDto();
		
		colegio.setId(1);
		
		usuario.setColegioDto(colegio);
		usuario.setCodUsr("CARISTI");
		usuario.setFecActu(new Date());
		
		if(usuario.getTipoUsuarioDto().getId() == 2){
			estudiante.setFecAct(usuario.getFecActu());
			estudiante.setCodUsr(usuario.getCodUsr());
			
			return usuarioDao.guardarEstudiante(estudiante,usuario);
			
		}else{
			DocenteDto docente = new DocenteDto();
			docente.setFecAct(usuario.getFecActu());
			docente.setCodUsr(usuario.getCodUsr());
			
			if(usuario.getTipoUsuarioDto().getId() == 4){
				docente.setCargo("Administrador");
			}else{
				docente.setCargo("Docente");
			}
			
			return usuarioDao.guardarDocente(docente,usuario);
		}
	}
	
	public List<UsuarioDto> listarUsuarios(){
		
		return usuarioDao.listarUsuarios();
	}
	
	public List<UsuarioDto> buscarUsuario(UsuarioDto usuarioDto){
		
		return usuarioDao.buscarUsuario(usuarioDto);
	}
	
	public void actualizarTercero(UsuarioDto usuario){

		usuarioDao.actualizarUsuario(usuario);
	}
	
	public UsuarioDto buscarUsuario(String login){
		
		return usuarioDao.buscarUsuario(login);
	}

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
	
	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
