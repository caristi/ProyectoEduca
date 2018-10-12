package com.edu.services.impl;

import java.util.List;

import com.edu.dao.IActividadDao;
import com.edu.dto.ActividadDto;
import com.edu.services.IActividadSrv;

public class ActividadSrvImpl implements IActividadSrv {

	IActividadDao actividadDao;
	
	public int guardar(ActividadDto actividad) {
		
		return actividadDao.guardar(actividad);
	}
	
	public List<ActividadDto> listaActividades(){
		
		List<ActividadDto> listAct = null;
		
		listAct = actividadDao.listaActividades();
		
		return listAct;
	}
	
	public void setActividadDao(IActividadDao actividadDao) {
		this.actividadDao = actividadDao;
	}
	

}
