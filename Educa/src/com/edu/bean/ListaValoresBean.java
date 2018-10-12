package com.edu.bean;

import java.io.Serializable;
import java.util.List;

import com.edu.dto.ListaValoresDto;
import com.edu.services.IListaValoresSrv;

public class ListaValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private IListaValoresSrv listaValoresSrv;

	private List<ListaValoresDto> listaTipoUsuarios;
	private List<ListaValoresDto> listaTipoAsistencias;
	private List<ListaValoresDto> listaGrupos;
	private List<ListaValoresDto> listaMaterias;
	private List<ListaValoresDto> listaMateriasXgrupo;
	private List<ListaValoresDto> listaMateriasSinAsociacion;
	private List<ListaValoresDto> listaCiclosEscolar;

	public ListaValoresBean() {

	}
	
	public void cambiarListaMateriaXgrupo(String idgrupo){
		
		listaMateriasXgrupo = listaValoresSrv.listaMateriasXGrupos(idgrupo);
	}

	public List<ListaValoresDto> getListaTipoUsuarios() {

		if(listaTipoUsuarios == null || listaTipoUsuarios.isEmpty()){
			listaTipoUsuarios = listaValoresSrv.listaTiposUsuarios();
		}

		return listaTipoUsuarios;
	}

	public List<ListaValoresDto> getListaTipoAsistencias() {

		if(listaTipoAsistencias == null || listaTipoAsistencias.isEmpty()){

			listaTipoAsistencias = listaValoresSrv.listaTipoAsistencias();
		}

		return listaTipoAsistencias;
	}

	public List<ListaValoresDto> getListaGrupos() {

		if(listaGrupos == null || listaGrupos.isEmpty()){

			listaGrupos = listaValoresSrv.listaGrupos();
		}

		return listaGrupos;
	}

	public List<ListaValoresDto> getListaMaterias() {

		if(listaMaterias == null || listaMaterias.isEmpty()){

			listaMaterias = listaValoresSrv.listaMaterias();
		}

		return listaMaterias;
	}
	
	public List<ListaValoresDto> getListaCiclosEscolar() {
		
		if(listaCiclosEscolar == null || listaCiclosEscolar.isEmpty()){
			
			listaCiclosEscolar = listaValoresSrv.listaCicloEscolares();
		}
		
		return listaCiclosEscolar;
	}

	public List<ListaValoresDto> getListaMateriasSinAsociacion() {

		listaMateriasSinAsociacion = listaValoresSrv.listaMateriasMateriaSinRelacion();

		return listaMateriasSinAsociacion;
	}
	
	public List<ListaValoresDto> getListaMateriasXgrupo() {
		return listaMateriasXgrupo;
	}

	public void setListaTipoAsistencias(List<ListaValoresDto> listaTipoAsistencias) {
		this.listaTipoAsistencias = listaTipoAsistencias;
	}
	public void setListaTipoUsuarios(List<ListaValoresDto> listaTipoUsuarios) {
		this.listaTipoUsuarios = listaTipoUsuarios;
	}

	public void setListaValoresSrv(IListaValoresSrv listaValoresSrv) {
		this.listaValoresSrv = listaValoresSrv;
	}

	public void setListaGrupos(List<ListaValoresDto> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public void setListaMaterias(List<ListaValoresDto> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}

	public void setListaMateriasSinAsociacion(
			List<ListaValoresDto> listaMateriasSinAsociacion) {
		this.listaMateriasSinAsociacion = listaMateriasSinAsociacion;
	}

	public void setListaMateriasXgrupo(List<ListaValoresDto> listaMateriasXgrupo) {
		this.listaMateriasXgrupo = listaMateriasXgrupo;
	}

	public void setListaCiclosEscolar(List<ListaValoresDto> listaCiclosEscolar) {
		this.listaCiclosEscolar = listaCiclosEscolar;
	}
}
