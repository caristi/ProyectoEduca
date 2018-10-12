package com.edu.services.impl;

import java.util.List;

import com.edu.dao.IResumenClaseDao;
import com.edu.dto.ResumenClaseDto;
import com.edu.services.IResumenClaseSrv;

public class ResumenClaseSrvImpl implements IResumenClaseSrv {
	
	IResumenClaseDao resumenClaseDao;
	
	public int crearResumenClase(ResumenClaseDto resumenClase){
		
		return resumenClaseDao.crearResumenClase(resumenClase);
	}
	
	public List<ResumenClaseDto> listaResumenesClases(){
		
		return resumenClaseDao.listaResumenesClases();
		
	}
	
	public void setResumenClaseDao(IResumenClaseDao resumenClaseDao) {
		this.resumenClaseDao = resumenClaseDao;
	}

}
