package com.siv.services.impl;

import com.siv.dao.impl.ColegioDaoImpl;
import com.siv.dto.ColegioDto;

public class ColegioSrvImpl{
	
	public ColegioDaoImpl colegioDao;
	
	public int guardarColegio(ColegioDto colegioDto){
		
		return colegioDao.guardarColegio(colegioDto);
	}
	
	public void setColegioDao(ColegioDaoImpl colegioDao) {
		this.colegioDao = colegioDao;
	}
}
