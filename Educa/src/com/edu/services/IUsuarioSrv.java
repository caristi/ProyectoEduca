package com.edu.services;

import java.util.List;

import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;


public interface IUsuarioSrv {
	
	public int guardar(UsuarioDto usuario, EstudianteDto estudiante);
	
	public List<UsuarioDto> listarUsuarios();
	
	public void actualizarTercero(UsuarioDto usuario);
	
	public List<UsuarioDto> buscarUsuario(UsuarioDto usuarioDto);
	
	public UsuarioDto buscarUsuario(String login);
	
	public UsuarioDto consultarUsuario(UsuarioDto usuario);
	
}
