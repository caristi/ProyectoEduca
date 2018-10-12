package com.edu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.dto.ActividadDto;
import com.edu.dto.GrupoDto;
import com.edu.dto.MateriaDto;
import com.edu.services.IActividadSrv;

public class ActividadBean  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private IActividadSrv actividadSrv;
	private ActividadDto actividad;
	private List<ActividadDto> listActividades;
	
	public ActividadBean() {	
		actividad = new ActividadDto();
	}
	
	public void crearActividad(){
		
		int id;
		
		MateriaDto materia = new MateriaDto();
		
		GrupoDto grupo = new GrupoDto();
		
		grupo.setId(1);
		
		materia.setId(1);
		materia.setGrupoDto(grupo);
		
		actividad.setMateriaDto(materia);
		
		
		id = actividadSrv.guardar(this.actividad);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se guardo la actividad con el código " + id));
	}
	
	public void listaActividades(){

		this.listActividades = actividadSrv.listaActividades();
	}
	
	public void setListActividades(List<ActividadDto> listActividades) {
		this.listActividades = listActividades;
	}
	public List<ActividadDto> getListActividades() {
		 
		listaActividades();
		return listActividades;
	}
	public ActividadDto getActividad() {
		return actividad;
	}
	public void setActividad(ActividadDto actividad) {
		this.actividad = actividad;
	}
	public void setActividadSrv(IActividadSrv actividadSrv) {
		this.actividadSrv = actividadSrv;
	}

}
