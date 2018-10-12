package com.edu.services.impl;

import com.edu.dao.IColegioDao;
import com.edu.dto.ColegioDto;
import com.edu.services.IColegioSrv;

public class ColegioSrvImpl implements IColegioSrv{
	
	public IColegioDao colegioDao;
	
	public int guardarColegio(ColegioDto colegioDto){
		
		colegioDto.setCodUsr("CARISTI");
		
		return colegioDao.guardarColegio(colegioDto);
	}
	
	public void actualizarColegio(ColegioDto grupoDto){
		colegioDao.actualizarColegio(grupoDto);
	}
	
	public ColegioDto buscarColegio(ColegioDto colegioDto){
		
		return colegioDao.buscarColegio(colegioDto);
	}
	
	public void setColegioDao(IColegioDao colegioDao) {
		this.colegioDao = colegioDao;
	}
}
