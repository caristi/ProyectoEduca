package com.edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

import com.edu.dto.UsuarioDto;
import com.edu.services.IDocenteSrv;
import com.edu.services.IEstudianteSrv;

public class AsociacionesBean {

	private IEstudianteSrv estudianteSrv;
	private IDocenteSrv docenteSrv;

	private List<UsuarioDto> listaEstudiantes;
	private List<UsuarioDto> listaSelEstuGrupo;
	private List<UsuarioDto> listaFiltroEstudi;
	private List<UsuarioDto> listaFiltroSelEstu;

	private List<UsuarioDto> listaDocentes;
	private List<UsuarioDto> listaSelDocMateria;
	private List<UsuarioDto> listaFiltroDocente;
	private List<UsuarioDto> listaFiltroSelDoc;

	private String seleGrupo;
	private int seleGrupoid;
	private String seleGrupoNom;

	private String seleMateria;
	private int seleMateriaId;
	private String seleMateNom;

	private boolean mostrarGrupo;
	private boolean mostrarMateria;

	public AsociacionesBean() {

		resert();
	}

	public void resert(){

		listaSelEstuGrupo  = new ArrayList<UsuarioDto>();
		listaSelDocMateria = new ArrayList<UsuarioDto>();

		seleGrupo = null;
		seleGrupoid = -1;
		seleGrupoNom = null;

		mostrarGrupo  = true;
		mostrarMateria = false;
	}

	public void seleccionGrupo(){

		if(!seleGrupo.equals("-1")){

			mostrarGrupo = true;

			String[] sele = seleGrupo.split(";;");
			seleGrupoid = Integer.parseInt(sele[0]);
			seleGrupoNom = sele[1];


		}else{
			mostrarGrupo = false;
		}
	}

	public void consultarEstudiantesSinRelacion(){

		try{
			listaEstudiantes = estudianteSrv.consultaTodosEstudiantesSinRelacion();

		}catch(Exception e){

			listaEstudiantes = null;

			throw e;
		} 
	}

	public void onEstudianteDrop(DragDropEvent ddEvent) {

		UsuarioDto estudiante = ((UsuarioDto) ddEvent.getData());

		listaSelEstuGrupo.add(estudiante);
		listaEstudiantes.remove(estudiante);
	}

	public void	quitarEstudiante(UsuarioDto estudiante){

		listaSelEstuGrupo.remove(estudiante);
		listaEstudiantes.add(estudiante);
	}

	public void guardarGrupoEstudi(){

		estudianteSrv.guardarRelacionEstudianteGrupo(listaSelEstuGrupo,seleGrupoid);

		consultarEstudiantesSinRelacion();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo el grupo " + seleGrupoNom));

		resert();
	}


	// Seccion de relacion de Materias - Docente

	public void seleccionMateria(){

		if(!seleMateria.equals("-1")){

			mostrarMateria = true;

			String[] sele = seleMateria.split(";;");
			seleMateriaId = Integer.parseInt(sele[0]);
			seleMateNom = sele[1];

		}else{
			mostrarMateria = false;
		}

		listaSelDocMateria = new ArrayList<UsuarioDto>();

//		consultarDocentes();
	}

//	public void consultarDocentes(){
//
//		try{
//			listaDocentes = docenteSrv.consultaTodosDocentes();
//
//		}catch(Exception e){
//
//			listaDocentes = null;
//
//			throw e;
//		} 
//	}

	public void onDocentesDrop(DragDropEvent ddEvent) {

		if(listaSelDocMateria.size() == 0){

			UsuarioDto docente = ((UsuarioDto) ddEvent.getData());

			listaSelDocMateria.add(docente);
			listaDocentes.remove(docente);

		}else{

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "La materia " + seleMateNom + " no puede contener más de un docente asociado"));
		}
	}
	
	public void quitarDocente(UsuarioDto docente){

		listaSelDocMateria.remove(docente);
		listaDocentes.add(docente);
	}
	
	public void guardarDocenteMateria(){

		docenteSrv.guardarRelacionDocenteMateria(listaSelDocMateria,seleMateriaId);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se guardo la materia " + seleMateNom));

		resert();
	}

	public void limpiar(){

		resert();
	}

	public void setListaEstudiantes(List<UsuarioDto> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<UsuarioDto> getListaEstudiantes() {

		if(listaEstudiantes == null || listaEstudiantes.size() == 0){
			consultarEstudiantesSinRelacion();
		}

		return listaEstudiantes;
	}

	public List<UsuarioDto> getListaSelEstuGrupo() {
		return listaSelEstuGrupo;
	}

	public void setListaSelEstuGrupo(List<UsuarioDto> listaSelEstuGrupo) {
		this.listaSelEstuGrupo = listaSelEstuGrupo;
	}

	public int getSeleGrupoid() {
		return seleGrupoid;
	}

	public void setSeleGrupoid(int seleGrupoid) {
		this.seleGrupoid = seleGrupoid;
	}

	public List<UsuarioDto> getListaFiltroEstudi() {
		return listaFiltroEstudi;
	}

	public void setListaFiltroEstudi(List<UsuarioDto> listaFiltroEstudi) {
		this.listaFiltroEstudi = listaFiltroEstudi;
	}

	public List<UsuarioDto> getListaFiltroSelEstu() {
		return listaFiltroSelEstu;
	}

	public void setListaFiltroSelEstu(List<UsuarioDto> listaFiltroSelEstu) {
		this.listaFiltroSelEstu = listaFiltroSelEstu;
	}

	public boolean isMostrarGrupo() {
		return mostrarGrupo;
	}

	public void setMostrarGrupo(boolean mostrarGrupo) {
		this.mostrarGrupo = mostrarGrupo;
	}

	public String getSeleGrupoNom() {
		return seleGrupoNom;
	}

	public void setSeleGrupoNom(String seleGrupoNom) {
		this.seleGrupoNom = seleGrupoNom;
	}

	public String getSeleGrupo() {
		return seleGrupo;
	}

	public void setSeleGrupo(String seleGrupo) {
		this.seleGrupo = seleGrupo;
	}

	public String getSeleMateria() {
		return seleMateria;
	}

	public void setSeleMateria(String seleMateria) {
		this.seleMateria = seleMateria;
	}

	public int getSeleMateriaId() {
		return seleMateriaId;
	}

	public void setSeleMateriaId(int seleMateriaId) {
		this.seleMateriaId = seleMateriaId;
	}

	public String getSeleMateNom() {
		return seleMateNom;
	}

	public void setSeleMateNom(String seleMateNom) {
		this.seleMateNom = seleMateNom;
	}

	public void setEstudianteSrv(IEstudianteSrv estudianteSrv) {
		this.estudianteSrv = estudianteSrv;
	}

	public void setDocenteSrv(IDocenteSrv docenteSrv) {
		this.docenteSrv = docenteSrv;
	}

	public boolean isMostrarMateria() {
		return mostrarMateria;
	}

	public void setMostrarMateria(boolean mostrarMateria) {
		this.mostrarMateria = mostrarMateria;
	}

	public List<UsuarioDto> getListaDocentes() {

		if(listaDocentes == null || listaDocentes.size() == 0){
//			consultarDocentes();
		}

		return listaDocentes;
	}

	public void setListaDocentes(List<UsuarioDto> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}

	public List<UsuarioDto> getListaFiltroDocente() {
		return listaFiltroDocente;
	}

	public void setListaFiltroDocente(List<UsuarioDto> listaFiltroDocente) {
		this.listaFiltroDocente = listaFiltroDocente;
	}

	public List<UsuarioDto> getListaFiltroSelDoc() {
		return listaFiltroSelDoc;
	}

	public void setListaFiltroSelDoc(List<UsuarioDto> listaFiltroSelDoc) {
		this.listaFiltroSelDoc = listaFiltroSelDoc;
	}

	public List<UsuarioDto> getListaSelDocMateria() {
		return listaSelDocMateria;
	}

	public void setListaSelDocMateria(List<UsuarioDto> listaSelDocMateria) {
		this.listaSelDocMateria = listaSelDocMateria;
	}
}