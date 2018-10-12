package com.edu.services.impl;

import java.util.Date;
import java.util.List;

import com.edu.dao.IGrupoDao;
import com.edu.dto.GrupoDto;
import com.edu.services.IGrupoSrv;

public class GrupoSrvImpl implements IGrupoSrv{
	
	public IGrupoDao grupoDao;
	
	public int guardarGrupo(GrupoDto grupoDto){
		
		grupoDto.setFecActu(new Date());
		grupoDto.setCodUsr("CARISTI");
		grupoDto.setNombre(grupoDto.getNombre().toUpperCase());
		
		return grupoDao.guardarGrupo(grupoDto);
	}
	
	public void actualizarGrupo(GrupoDto grupoDto){
		grupoDao.actualizarGrupo(grupoDto);
	}
	
	public List<GrupoDto> buscarGrupo(GrupoDto grupoDto){
		return grupoDao.buscarGrupo(grupoDto);
	}
	
	public void setGrupoDao(IGrupoDao grupoDao) {
		this.grupoDao = grupoDao;
	}
}
