package com.edu.services;

import com.edu.dto.ColegioDto;

public interface IColegioSrv {
	
	public int guardarColegio(ColegioDto colegioDto);
	
	public ColegioDto buscarColegio(ColegioDto colegioDto);
	
	public void actualizarColegio(ColegioDto colegioDto);
	
}
