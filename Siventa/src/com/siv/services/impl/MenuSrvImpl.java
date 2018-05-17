package com.siv.services.impl;

import java.io.Serializable;
import java.util.List;

import com.siv.dao.impl.MenuDaoImpl;
import com.siv.dto.OpcionDto;

public class MenuSrvImpl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	MenuDaoImpl menuDao;

	public List<OpcionDto> consultarOpciones() {
		
		return menuDao.consultarOpciones();
	}
	
	public void setMenuDao(MenuDaoImpl menuDao) {
		this.menuDao = menuDao;
	}
}