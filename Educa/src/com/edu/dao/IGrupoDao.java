package com.edu.dao;

import java.util.List;

import com.edu.dto.GrupoDto;

public interface IGrupoDao {
	
	public int guardarGrupo(GrupoDto grupoDto);
	
	public List<GrupoDto> buscarGrupo(GrupoDto grupoDto);
	
	public void actualizarGrupo(GrupoDto grupodto);
}
