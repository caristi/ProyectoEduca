package com.edu.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.dto.GrupoDto;
import com.edu.services.IGrupoSrv;

public class GrupoBean {
	
	private IGrupoSrv grupoSrv;
	
	private List<GrupoDto> listaGrupos;
	
	private GrupoDto grupoDto;
	private GrupoDto selectGrupoDto;
	
	private boolean habilitaActualizar;
	
	public GrupoBean() {

		resert();
	}
	
	public void resert(){
		
		grupoDto = new GrupoDto();
		
		habilitaActualizar = false;
	}
	
	public void guardarGrupo(){
		
		int id;
		
		id = grupoSrv.guardarGrupo(grupoDto);
		
		buscarGrupo();
		
		resert();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo el grupo con codigo " + id));
		
	}
	
	public void buscarGrupo(){
		
		try{
			
			listaGrupos = grupoSrv.buscarGrupo(grupoDto);
		
		}catch(Exception e){
		
			listaGrupos = null;
			
			throw e;
		} 
		
	}
	
	public void actualizarGrupo(){
		
		grupoSrv.actualizarGrupo(this.grupoDto);
		
		buscarGrupo();
		
		String nombreGrupo = grupoDto.getNombre();
		
		resert();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizo la materia " + nombreGrupo));
	}
	
	
	public void limpiar(){
		
		resert();
	}
	
	public boolean isHabilitaActualizar() {
		return habilitaActualizar;
	}

	public void setHabilitaActualizar(boolean habilitaActualizar) {
		this.habilitaActualizar = habilitaActualizar;
	}

	public List<GrupoDto> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<GrupoDto> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public GrupoDto getGrupoDto() {
		return grupoDto;
	}

	public void setGrupoDto(GrupoDto grupoDto) {
		this.grupoDto = grupoDto;
	}
	
	public GrupoDto getSelectGrupoDto() {
		return selectGrupoDto;
	}

	public void setSelectGrupoDto(GrupoDto selectGrupoDto) {
		
		if(selectGrupoDto != null){
			grupoDto = selectGrupoDto;
		}
		
		this.selectGrupoDto = selectGrupoDto;
	}

	public void setGrupoSrv(IGrupoSrv grupoSrv) {
		this.grupoSrv = grupoSrv;
	}

}