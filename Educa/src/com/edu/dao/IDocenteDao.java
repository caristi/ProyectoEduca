package com.edu.dao;

import java.util.List;

import com.edu.dto.DocenteDto;

public interface IDocenteDao {
	
	public List<DocenteDto> consultaTodosDocentes();
	
	public DocenteDto consultaDocente(int idDoc);
	
	public void guardarRelacionDocenteMateria(List<DocenteDto> listaDocentes);

}
