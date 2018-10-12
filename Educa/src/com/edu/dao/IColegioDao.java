package com.edu.dao;

import com.edu.dto.ColegioDto;

public interface IColegioDao {
	
	public int guardarColegio(ColegioDto colegioDto);
	
	public ColegioDto buscarColegio(ColegioDto colegioDto);
	
	public void actualizarColegio(ColegioDto colegioDto);
}
