package com.edu.bean;

import java.io.ByteArrayInputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.edu.dto.ColegioDto;
import com.edu.services.IColegioSrv;

public class ColegioBean {

	private IColegioSrv colegioSrv;

	private ColegioDto colegioDto;

	private int idColegio;
	private boolean habBotonGua;
	private boolean mostrarImaggen;

	private UploadedFile file;
	
	@SuppressWarnings("unused")
	private StreamedContent imagenColegio;

	public ColegioBean() {

		resert();
	}

	public void resert(){

		habBotonGua = false;
		mostrarImaggen = false;
		
		file = null;
	}

	public void guardarColegio(){

		colegioSrv.guardarColegio(colegioDto);

		habBotonGua = false;

		if(colegioDto.getImage() != null){

			mostrarImaggen = true;
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo el colegio"));
	}

	public void buscarColegio() {

		ColegioDto cole = new ColegioDto();
		cole.setId(idColegio);
		
		imagenColegio = null;
		
		this.colegioDto = colegioSrv.buscarColegio(cole);
			
		if(colegioDto.getId() == 0){

			habBotonGua = true;
			
		}else if(colegioDto.getImage() != null){
			
			mostrarImaggen = true;
		}
		
	}

	public void actualizarColegio(){

		if(file != null){
			
			byte[] content = file.getContents();
			
			colegioDto.setImage(content);
		}
		
		if(colegioDto.getImage() != null){
					
		  mostrarImaggen = true;
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se actualizo los datos del colegio "));
	}

	public void cargarLogo(FileUploadEvent event){

		file = event.getFile();
		
		byte[] bFile = file.getContents();
		colegioDto.setImage(bFile);
		
		if(colegioDto.getImage() != null){
			
			mostrarImaggen = true;
		}
		
		getImagenColegio();
	}

	public ColegioDto getColegioDto() {

		if(colegioDto == null){
			
			buscarColegio();
		}

		return colegioDto;
	}

	public void setColegioDto(ColegioDto colegioDto) {

		this.colegioDto = colegioDto;
	}

	public void setColegioSrv(IColegioSrv colegioSrv) {
		this.colegioSrv = colegioSrv;
	}

	public boolean isHabBotonGua() {
		return habBotonGua;
	}

	public void setHabBotonGua(boolean habBotonGua) {
		this.habBotonGua = habBotonGua;
	}

	public int getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(int idColegio) {
		this.idColegio = idColegio;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public StreamedContent getImagenColegio() {
       
		FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }
        else {
        	
        	if(colegioDto.getImage() != null){
        		return new DefaultStreamedContent(new ByteArrayInputStream(colegioDto.getImage()));
        	
        	}else{
        		return null;
        	}
        }
	}

	public void setImagenColegio(StreamedContent imagenColegio) {
		this.imagenColegio = imagenColegio;
	}

	public boolean isMostrarImaggen() {
		return mostrarImaggen;
	}

	public void setMostrarImaggen(boolean mostrarImaggen) {
		this.mostrarImaggen = mostrarImaggen;
	}
}