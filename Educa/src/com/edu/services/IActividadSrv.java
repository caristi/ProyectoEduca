package com.edu.services;

import java.util.List;

import com.edu.dto.ActividadDto;

public interface IActividadSrv {
	
    public int guardar(ActividadDto actividad);
    
    public List<ActividadDto> listaActividades();

}
