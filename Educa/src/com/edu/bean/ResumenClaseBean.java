package com.edu.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.dto.ResumenClaseDto;
import com.edu.services.IResumenClaseSrv;

public class ResumenClaseBean {
	
	IResumenClaseSrv resumenClaseSrv;
	
	ResumenClaseDto resumenClase;
	
	List<ResumenClaseDto> listaResumenClaseDto;
	
	public ResumenClaseBean() {
		
		reset();
	}
	
	public void reset(){
		
		resumenClase = new ResumenClaseDto();
	}
	
	public void crearResumenClase(){
		
		int id;
		
		id = resumenClaseSrv.crearResumenClase(this.resumenClase);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se guardo el resumen de clase con el código " + id));
	}
	
	public void listarResumenesClases(){
		
		listaResumenClaseDto = resumenClaseSrv.listaResumenesClases();
	}
	
	
	public void setResumenClaseSrv(IResumenClaseSrv resumenClaseSrv) {
		this.resumenClaseSrv = resumenClaseSrv;
	}

	public ResumenClaseDto getResumenClase() {
		return resumenClase;
	}

	public void setResumenClase(ResumenClaseDto resumenClase) {
		this.resumenClase = resumenClase;
	}

	public List<ResumenClaseDto> getListaResumenClaseDto() {
		
		listarResumenesClases();
		
		return listaResumenClaseDto;
	}

	public void setListaResumenClaseDto(List<ResumenClaseDto> listaResumenClaseDto) {
		this.listaResumenClaseDto = listaResumenClaseDto;
	}
}
