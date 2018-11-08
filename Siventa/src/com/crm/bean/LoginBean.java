package com.crm.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.crm.dto.OpcionDto;
import com.crm.dto.UsuarioDto;
import com.crm.services.MenuSrv;
import com.crm.services.UsuarioSrv;

public class LoginBean implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioSrv usuarioSrv;
	private MenuSrv menuSrv;
	
	private UsuarioDto usuario;
	
	private List<OpcionDto> opcionesDto;
	
	private String username;
	private String contrasena;
	private boolean rememberMe = false;

	private MenuModel model;
	
	public LoginBean(){
		
		resert();
	}
	
	public void resert(){

	}
	
	public String login(){
		
		usuario = new UsuarioDto();
		
		model = new DefaultMenuModel();
		
		usuario.setLogin(this.username);
		usuario.setContrasena(this.contrasena);
		
		usuario = usuarioSrv.consultarUsuario(usuario);
		
		if(usuario.isAcceso()){
			
			opcionesDto = menuSrv.consultarOpciones();
			
			establecerPermisos();
			
			return "index.xhtml";
		
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", usuario.getMensajeAcceso()));
			
			return null;
		}
	}
	
	public String logout(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(context != null){
			ExternalContext eContext = context.getExternalContext();
			if(eContext != null){
				HttpSession sesion = (HttpSession) eContext.getSession(false);
				sesion.invalidate();
				eContext.invalidateSession();
			}
		}
		this.usuario.setAcceso(false);
		return "/faces/login.xhtml";
	}
	
	public void establecerPermisos(){

		for(OpcionDto opcion: opcionesDto){

			if(opcion.getTipo().equals("M")){

				DefaultSubMenu menu = new DefaultSubMenu(opcion.getDescripcion());

				for(OpcionDto opc: opcionesDto){

					int subOpcion = opc.getCod_principal();

					if(subOpcion > 0){

						if(subOpcion == opcion.getCodigo()){

							DefaultMenuItem item = new DefaultMenuItem(opc.getDescripcion());
							item.setUrl(opc.getUrl());
							item.setIcon(opc.getIconOpc());

							menu.addElement(item);
						}
					}
				}

				model.addElement(menu);
			}
		}

		DefaultSubMenu menuSalir = new DefaultSubMenu("Opcion");
		DefaultMenuItem opcionSalir = new DefaultMenuItem("Salir");
		opcionSalir.setCommand("#{loginBean.logout}");
		opcionSalir.setIcon("ui-icon-power");

		menuSalir.addElement(opcionSalir);
		model.addElement(menuSalir);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public void setUsuarioSrv(UsuarioSrv usuarioSrv) {
		this.usuarioSrv = usuarioSrv;
	}
	
	public void setMenuSrv(MenuSrv menuSrv) {
		this.menuSrv = menuSrv;
	}
}