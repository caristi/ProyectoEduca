package com.edu.services.impl;

import java.io.Serializable;
import java.util.List;

import com.edu.dao.IMenuDao;
import com.edu.dto.OpcionDto;
import com.edu.services.IMenuSrv;

public class MenuSrvImpl implements IMenuSrv,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	IMenuDao menuDao;

	@Override
	public List<OpcionDto> consultarOpciones() {
		
		return menuDao.consultarOpciones();
	}
	
	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

}
