package com.edu.services.impl;

import java.util.List;

import com.edu.dao.IListaValoresDao;
import com.edu.dto.ListaValoresDto;
import com.edu.services.IListaValoresSrv;

public class ListaValoresSrvImpl implements IListaValoresSrv {
	
	IListaValoresDao listaValoresDao;
	
	public List<ListaValoresDto> listaTiposUsuarios(){
		
		return listaValoresDao.listaTiposUsuarios();
	}
	
	public List<ListaValoresDto> listaTipoAsistencias(){
		
		return listaValoresDao.listaTipoAsistencias();
	}
	
	public List<ListaValoresDto> listaGrupos(){
		
		return listaValoresDao.listaGrupos();
	}
	
	public List<ListaValoresDto> listaMaterias(){
		
		return listaValoresDao.listaMaterias();
	}
	
	public List<ListaValoresDto> listaMateriasMateriaSinRelacion(){
		
		return listaValoresDao.listaMateriasMateriaSinRelacion();
	}
	
	public List<ListaValoresDto> listaMateriasXGrupos(String idgrupo){
		
		return listaValoresDao.listaMateriasXGrupos(idgrupo);
	}
	
	public List<ListaValoresDto> listaCicloEscolares(){
		
		return listaValoresDao.listaCicloEscolares();
	}
	
	public void setListaValoresDao(IListaValoresDao listaValoresDao) {
		this.listaValoresDao = listaValoresDao;
	}

}
