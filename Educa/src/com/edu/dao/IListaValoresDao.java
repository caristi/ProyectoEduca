package com.edu.dao;

import java.util.List;

import com.edu.dto.ListaValoresDto;


public interface IListaValoresDao {
	
	public List<ListaValoresDto> listaTiposUsuarios();
	
	public List<ListaValoresDto> listaTipoAsistencias();
	
	public List<ListaValoresDto> listaGrupos();
	
	public List<ListaValoresDto> listaMaterias();
	
	public List<ListaValoresDto> listaMateriasMateriaSinRelacion();
	
	public List<ListaValoresDto> listaMateriasXGrupos(String idgrupo);
	
	public List<ListaValoresDto> listaCicloEscolares();
}
