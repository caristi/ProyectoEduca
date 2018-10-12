package com.edu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.edu.dto.EstudianteDto;
import com.edu.dto.GrupoDto;
import com.edu.dto.ListaValoresDto;
import com.edu.dto.TipoUsuarioDto;
import com.edu.dto.UsuarioDto;
import com.edu.services.IUsuarioSrv;

public class UsuarioBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private IUsuarioSrv usuarioSrv;

	private UsuarioDto usuarioDto;
	private EstudianteDto estudianteDto;
	private UsuarioDto selectedUsuario;
	
	private List<UsuarioDto> listaUsuarios;
	private List<ListaValoresDto> listasPerfilesXtipUsu;
	
	private boolean habilitarListaPerfil;
	private boolean habilitaActualizar;
	
	private String contrasenaRepetir;
	
	public UsuarioBean() {
		
		resert();
	}
	
	public void resert(){
		
		usuarioDto = new UsuarioDto();
		estudianteDto = new EstudianteDto();
		GrupoDto grupoDto = new GrupoDto();
		estudianteDto.setGrupoDto(grupoDto);
		
		usuarioDto.setTipoUsuarioDto(new TipoUsuarioDto());
		habilitarListaPerfil = true;
		habilitaActualizar   = false;
	}
	
	
	public void limpiar(){
		
		resert();
	}
	
	public void buscarUsuario(){
		
		try{
			
			this.listaUsuarios = usuarioSrv.buscarUsuario(usuarioDto); 
		
		}catch(Exception e){
			
				listaUsuarios = null;
			
			throw e;
		}
	}
	
	public void crearUsuario(){
		
	    int id;
	 
	    id = usuarioSrv.guardar(this.usuarioDto,this.estudianteDto);
	 
	    buscarUsuario();
	    
		resert();
	 
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se guardo el usuario con el código " + id));
		
	}
	
	public void actualizarUsuario(){
		
		int id;
		
		usuarioSrv.actualizarTercero(this.usuarioDto);
		
		id = this.usuarioDto.getId();
		
		buscarUsuario();
		
		resert();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se actualizo el usuario con el código " + id));

		
	}
	
	
	/**
	 * GET Y SET
	 * */

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public IUsuarioSrv getUsuarioSrv() {
		return usuarioSrv;
	}

	public void setUsuarioSrv(IUsuarioSrv usuarioSrv) {
		this.usuarioSrv = usuarioSrv;
	}

	public List<UsuarioDto> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioDto> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<ListaValoresDto> getListasPerfilesXtipUsu() {
		return listasPerfilesXtipUsu;
	}

	public void setListasPerfilesXtipUsu(List<ListaValoresDto> listasPerfilesXtipUsu) {
		this.listasPerfilesXtipUsu = listasPerfilesXtipUsu;
	}

	public boolean isHabilitarListaPerfil() {
		return habilitarListaPerfil;
	}

	public void setHabilitarListaPerfil(boolean habilitarListaPerfil) {
		this.habilitarListaPerfil = habilitarListaPerfil;
	}

	public String getContrasenaRepetir() {
		return contrasenaRepetir;
	}

	public void setContrasenaRepetir(String contrasenaRepetir) {
		this.contrasenaRepetir = contrasenaRepetir;
	}

	public UsuarioDto getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(UsuarioDto selectedUsuario) {
		
		if(selectedUsuario != null){
			
			this.usuarioDto = selectedUsuario;
			
			habilitaActualizar = true;
			
		}
	}

	public boolean isHabilitaActualizar() {
		return habilitaActualizar;
	}

	public void setHabilitaActualizar(boolean habilitaActualizar) {
		this.habilitaActualizar = habilitaActualizar;
	}

	public EstudianteDto getEstudianteDto() {
		return estudianteDto;
	}

	public void setEstudianteDto(EstudianteDto estudianteDto) {
		this.estudianteDto = estudianteDto;
	}
}
