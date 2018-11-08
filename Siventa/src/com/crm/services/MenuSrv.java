package com.crm.services;

import java.io.Serializable;
import java.util.List;

import com.crm.dao.MenuDao;
import com.crm.dto.OpcionDto;

public class MenuSrv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	MenuDao menuDao;

	public List<OpcionDto> consultarOpciones() {
		
		return menuDao.consultarOpciones();
	}
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}