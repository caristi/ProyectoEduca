package com.edu.services;

import java.util.List;

import com.edu.dto.DocenteDto;
import com.edu.dto.UsuarioDto;

public interface IDocenteSrv {
	
	public List<DocenteDto> consultaTodosDocentes();
	
	public DocenteDto consultaDocente(int idDoc);
	
	public void guardarRelacionDocenteMateria(List<UsuarioDto> listaDocentes, int idMateria);

}
