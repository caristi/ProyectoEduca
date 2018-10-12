package com.edu.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.dto.AsistenciaDto;
import com.edu.dto.DocenteDto;
import com.edu.dto.GrupoDto;
import com.edu.dto.MateriaDto;
import com.edu.dto.TipoAsistenciaDto;
import com.edu.services.IDocenteSrv;
import com.edu.services.IMateriaSrv;

public class MateriaBean {
	
	private IMateriaSrv	   materiaSrv;
	private IDocenteSrv    docenteSrv;
	
	private List<AsistenciaDto> listaAsistencia;
	private List<AsistenciaDto> listaAsisRegistrada;
	private List<MateriaDto> listaMaterias;
	private List<DocenteDto> listaDocentes;

	private int idMateria;
	private String nombreMateria;
	
	private TipoAsistenciaDto tipoAsistencia;
	private MateriaDto materiaDto;
	private MateriaDto selecMateriaDto;
	
	private boolean habilitaActualizar;
	
	public MateriaBean() {

		resert();
	}
	
	public void resert(){
		
		tipoAsistencia = new TipoAsistenciaDto();
		
		materiaDto = new MateriaDto();
		
		materiaDto.setGrupoDto(new GrupoDto());
		
		habilitaActualizar = false;
		
	}
	
	public void guardarAsistencia(){
		
		materiaSrv.guardarAsistencia(listaAsistencia);
		
		getListaAsisRegistrada();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "LLAMADO A LISTA REALIZADO CON ÉXITO"));
	}
	
	public void actualizarAsistencia(){
		
		materiaSrv.actualizarAsistencia(this.listaAsisRegistrada);
		
		getListaAsisRegistrada();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "ACTUALIZADO LISTA REALIZADO CON ÉXITO"));
		
	}
	
	public List<AsistenciaDto> getListaAsistencia() {
		
		listaAsistencia = materiaSrv.obtenerListaAsistenciaXEstudiante(idMateria);
			
		return listaAsistencia;
	}
	
	public List<AsistenciaDto> getListaAsisRegistrada() {
		
		listaAsisRegistrada = materiaSrv.obtenerAsistenciaRegistrada(idMateria);
		
		return listaAsisRegistrada;
	}
	
	public void guardarMateria(){
		
		int id;
		
		id = materiaSrv.guardarMateria(materiaDto);
		
		buscarMateria();
		
		resert();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo la materia con codigo " + id));
		
	}
	
	public void buscarMateria(){
		
		try{
			listaMaterias = materiaSrv.buscarMateria(this.materiaDto);
		
		}catch(Exception e){
		
			listaMaterias = null;
			throw e;
		} 
		
	}
	
	public void actualizarMateria(){
		
		materiaSrv.actualizarTercero(this.materiaDto);
		
		buscarMateria();
		
		String nombreMat = materiaDto.getNombre();
		
		resert();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se actualizo la materia " + nombreMat));

	}
	
	public void limpiar(){
		
		resert();
	}
	
	public void setListaAsistencia(List<AsistenciaDto> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}
	
	public TipoAsistenciaDto getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistenciaDto tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public void setMateriaSrv(IMateriaSrv materiaSrv) {
		this.materiaSrv = materiaSrv;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public MateriaDto getMateriaDto() {
		return materiaDto;
	}

	public void setMateriaDto(MateriaDto materiaDto) {
		this.materiaDto = materiaDto;
	}

	public List<MateriaDto> getListaMaterias() {
		
		return listaMaterias;
	}

	public void setListaMaterias(List<MateriaDto> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}

	public MateriaDto getSelecMateriaDto() {
		return selecMateriaDto;
	}

	public void setSelecMateriaDto(MateriaDto selecMateriaDto) {
		
		if(selecMateriaDto != null){
			
			materiaDto = selecMateriaDto;
			
			habilitaActualizar   = true; 
		}
		
		this.selecMateriaDto = selecMateriaDto;
	}

	public boolean isHabilitaActualizar() {
		return habilitaActualizar;
	}

	public void setHabilitaActualizar(boolean habilitaActualizar) {
		this.habilitaActualizar = habilitaActualizar;
	}

	public void setDocenteSrv(IDocenteSrv docenteSrv) {
		this.docenteSrv = docenteSrv;
	}

	public void setListaDocentes(List<DocenteDto> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
	
	public List<DocenteDto> getListaDocentes() {
		
		if(listaDocentes == null){
			listaDocentes = docenteSrv.consultaTodosDocentes();
		}
		
		return listaDocentes;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public void setListaAsisRegistrada(List<AsistenciaDto> listaAsisRegistrada) {
		this.listaAsisRegistrada = listaAsisRegistrada;
	}
}