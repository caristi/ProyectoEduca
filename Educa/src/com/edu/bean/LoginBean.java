package com.edu.bean;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.edu.dto.ColegioDto;
import com.edu.dto.DocenteDto;
import com.edu.dto.MateriaDto;
import com.edu.dto.OpcionDto;
import com.edu.dto.UsuarioDto;
import com.edu.services.IColegioSrv;
import com.edu.services.IDocenteSrv;
import com.edu.services.IMateriaSrv;
import com.edu.services.IMenuSrv;
import com.edu.services.IUsuarioSrv;

public class LoginBean implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private IUsuarioSrv usuarioSrv;
	private IMenuSrv menuSrv;
	private IDocenteSrv docenteSrv;
	private IMateriaSrv materiaSrv;
	private IColegioSrv colegioSrv;
	
	private UsuarioDto usuario;
	private ColegioDto colegio;
	
	private List<OpcionDto> opcionesDto;
	
	private String username;
	private String contrasena;
	private boolean rememberMe = false;
	private boolean mostrarImagen;
	
	private MenuModel model;
	
	@SuppressWarnings("unused")
	private StreamedContent imagenColegio;
	
	public LoginBean(){
		
		resert();
	}
	
	public void resert(){
		
		mostrarImagen = false;
		
//		consultarDatosColegios();

	}
	
	public void consultarDatosColegios(){
		
		ColegioDto cole = new ColegioDto();
		
		imagenColegio = null;
		
		colegio = colegioSrv.buscarColegio(cole);
			
		if(colegio.getId() > 0){

			if(colegio.getImage() != null){
				
				mostrarImagen = true;
			}
		}
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
		
		DocenteDto docenteDto = null;
		List<MateriaDto> materiasDto = null;
		
		if(usuario.getTipoUsuarioDto().getId() == 3){
			
			docenteDto = docenteSrv.consultaDocente(usuario.getId());
			
			materiasDto = materiaSrv.listarMateriasDocente(docenteDto.getId());
		}
		
		for(OpcionDto opcion: opcionesDto){
			
			if(opcion.getTipo().equals("M") && opcion.getTipoUsuarioDto().getId() == usuario.getTipoUsuarioDto().getId()){
				
				DefaultSubMenu menu = new DefaultSubMenu(opcion.getDescripcion());
				
				for(OpcionDto opc: opcionesDto){
					
					OpcionDto subOpcion = opc.getCod_principal();
					
					if(subOpcion != null){
						
						if(subOpcion.getCodigo() == opcion.getCodigo()){
							
							if(docenteDto != null && subOpcion.getCodigo() == 1){
								
								for(MateriaDto materia : materiasDto){
									
									DefaultMenuItem item = new DefaultMenuItem(materia.getNombre() +"-" + materia.getGrupoDto().getNombre());
									item.setUrl(opc.getUrl()+materia.getId()+"&nomMat=" + materia.getNombre() +"-" + materia.getGrupoDto().getNombre());
							        item.setIcon(opc.getIconOpc());
							        
							        menu.addElement(item);
								}
								
							}else{
								
								DefaultMenuItem item = new DefaultMenuItem(opc.getDescripcion());
								item.setUrl(opc.getUrl());
						        item.setIcon(opc.getIconOpc());
						        
						        menu.addElement(item);
							}
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

	public void setUsuarioSrv(IUsuarioSrv usuarioSrv) {
		this.usuarioSrv = usuarioSrv;
	}
	
	public void setMenuSrv(IMenuSrv menuSrv) {
		this.menuSrv = menuSrv;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public IDocenteSrv getDocenteSrv() {
		return docenteSrv;
	}

	public void setDocenteSrv(IDocenteSrv docenteSrv) {
		this.docenteSrv = docenteSrv;
	}

	public IMateriaSrv getMateriaSrv() {
		return materiaSrv;
	}

	public void setMateriaSrv(IMateriaSrv materiaSrv) {
		this.materiaSrv = materiaSrv;
	}

	public StreamedContent getImagenColegio() {
		
		FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }
        else {
        	
          return new DefaultStreamedContent(new ByteArrayInputStream(colegio.getImage()));
        }
	}

	public void setImagenColegio(StreamedContent imagenColegio) {
		this.imagenColegio = imagenColegio;
	}

	public boolean isMostrarImagen() {
		return mostrarImagen;
	}

	public void setMostrarImagen(boolean mostrarImagen) {
		this.mostrarImagen = mostrarImagen;
	}

	public void setColegioSrv(IColegioSrv colegioSrv) {
		this.colegioSrv = colegioSrv;
	}

	public ColegioDto getColegio() {
		return colegio;
	}

	public void setColegio(ColegioDto colegio) {
		this.colegio = colegio;
	}
}