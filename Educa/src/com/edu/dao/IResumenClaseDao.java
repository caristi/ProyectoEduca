package com.edu.dao;

import java.util.List;

import com.edu.dto.ResumenClaseDto;

public interface IResumenClaseDao {
	
	public int crearResumenClase(ResumenClaseDto resumenClase);
	
	public List<ResumenClaseDto> listaResumenesClases();

}
