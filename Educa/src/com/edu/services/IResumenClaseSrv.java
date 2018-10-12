package com.edu.services;

import java.util.List;

import com.edu.dto.ResumenClaseDto;

public interface IResumenClaseSrv {
	
	public int crearResumenClase(ResumenClaseDto resumenClase);
	
	public List<ResumenClaseDto> listaResumenesClases();

}
