package com.edu.services;

import java.util.List;

import com.edu.dto.GrupoDto;

public interface IGrupoSrv {
	
	public int guardarGrupo(GrupoDto grupoDto);
	
	public List<GrupoDto> buscarGrupo(GrupoDto grupoDto);
	
	public void actualizarGrupo(GrupoDto grupoDto);
	
}
