package com.edu.dao;

import java.util.List;

import com.edu.dto.ActividadDto;

public interface IActividadDao {
	
	public int guardar(ActividadDto actividad);
	
	public List<ActividadDto> listaActividades();
	
}
