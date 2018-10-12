package com.edu.dao;

import java.util.List;

import com.edu.dto.DocenteDto;
import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;

public interface IUsuarioDao {
	
	public int guardar(UsuarioDto usuario);
	
	public int guardarDocente(DocenteDto docente, UsuarioDto usuario);
	
	public int guardarEstudiante(EstudianteDto estudiante, UsuarioDto usuario);
	
	public List<UsuarioDto> listarUsuarios();
	
	public void actualizarUsuario(UsuarioDto usuario);
	
	public UsuarioDto buscarUsuario(String login);
	
	public List<UsuarioDto> buscarUsuario(UsuarioDto usuarioDto);
	
	public UsuarioDto consultarUsuario(UsuarioDto usuario);

}
