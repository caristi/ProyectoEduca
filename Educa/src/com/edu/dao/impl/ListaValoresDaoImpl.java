package com.edu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IListaValoresDao;
import com.edu.dto.GrupoDto;
import com.edu.dto.ListaValoresDto;
import com.edu.dto.MateriaDto;
import com.edu.dto.ParametrizacionDto;
import com.edu.dto.TipoAsistenciaDto;
import com.edu.dto.TipoUsuarioDto;

public class ListaValoresDaoImpl implements IListaValoresDao{
	
	private Session sesion;
	
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<ListaValoresDto> listaTiposUsuarios(){
    	
    	List<ListaValoresDto> listaValores = new ArrayList<ListaValoresDto>();
    	List<TipoUsuarioDto> tiposUsuarios = new ArrayList<TipoUsuarioDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	tiposUsuarios = sesion.createQuery("select t from TipoUsuarioDto t").list();
    	
    	
    	for(TipoUsuarioDto tipo: tiposUsuarios){
    		
    		ListaValoresDto lista = new ListaValoresDto();
    		
    		lista.setCodItem(tipo.getId());
    		lista.setNomItem(tipo.getNombre());
    		
    		listaValores.add(lista);
    	}
    	
    	return listaValores;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
	public List<ListaValoresDto> listaTipoAsistencias(){
    	
    	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
    	List<TipoAsistenciaDto> listaAsistencias = new ArrayList<TipoAsistenciaDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	listaAsistencias = sesion.createQuery("select t from TipoAsistenciaDto t where t.mcaVisible = 'S' ").list();
    	
    	for(TipoAsistenciaDto tipo: listaAsistencias){
    		
    		ListaValoresDto valores = new ListaValoresDto();
    		valores.setCodItem(tipo.getCodigo());
    		valores.setNomItem(tipo.getNombre());
    		
    		listaValoresDtos.add(valores);
    	}
    	
    	return listaValoresDtos;
    	
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
	public List<ListaValoresDto> listaGrupos(){
    	
    	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
    	List<GrupoDto> grupos = new ArrayList<GrupoDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	grupos = sesion.createQuery("select g from GrupoDto g ").list();
    	
    	for(GrupoDto tipo: grupos){
    		
    		ListaValoresDto valores = new ListaValoresDto();
    		valores.setCodItem(tipo.getId());
    		valores.setNomItem(tipo.getNombre());
    		
    		listaValoresDtos.add(valores);
    	}
    	
    	return listaValoresDtos;
    	
    }   
    
    @SuppressWarnings("unchecked")
    @Transactional
	public List<ListaValoresDto> listaMaterias(){
    	
    	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
    	List<MateriaDto> materias = new ArrayList<MateriaDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	materias = sesion.createQuery("select m from MateriaDto m ").list();
    	
    	for(MateriaDto tipo: materias){
    		
    		ListaValoresDto valores = new ListaValoresDto();
    		valores.setCodItem(tipo.getId());
    		valores.setNomItem(tipo.getNombre());
    		
    		listaValoresDtos.add(valores);
    	}
    	
    	return listaValoresDtos;
    	
    }   
    
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ListaValoresDto> listaMateriasXGrupos(String idgrupo){
    	
    	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
    	List<MateriaDto> materias = new ArrayList<MateriaDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	materias = sesion.createSQLQuery("select * from materias " +
    			                         " where gru_id = :idGrupo " +
    							         " Order by mat_nombre").addEntity(MateriaDto.class)
    							         .setParameter("idGrupo", idgrupo).list();
    	
    	for(MateriaDto tipo: materias){
    		
    		ListaValoresDto valores = new ListaValoresDto();
    		valores.setCodItem(tipo.getId());
    		valores.setNomItem(tipo.getNombre());
    		
    		listaValoresDtos.add(valores);
    	}
    	
    	return listaValoresDtos;
    	
    } 
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<ListaValoresDto> listaMateriasMateriaSinRelacion(){
		
    	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
    	List<MateriaDto> materias = new ArrayList<MateriaDto>();;
		
		sesion = sessionFactory.getCurrentSession();
		
		materias = sesion.createSQLQuery("SELECT  * " +
										    "  FROM materias m " +
											" WHERE NOT EXISTS (SELECT 0  " +
											" 	  	              FROM docentes d " +
											"		  	         WHERE d.mat_id = m.mat_id " +
											"					   ) " +
										    " ORDER BY m.mat_nombre")
										 .addEntity(MateriaDto.class).list();
		
		for(MateriaDto tipo: materias){
    		
    		ListaValoresDto valores = new ListaValoresDto();
    		valores.setCodItem(tipo.getId());
    		valores.setNomItem(tipo.getNombre());
    		
    		listaValoresDtos.add(valores);
    	}
		
		return listaValoresDtos;
	}
    
    @SuppressWarnings("unchecked")
 	@Transactional
 	public List<ListaValoresDto> listaCicloEscolares(){
 		
     	List<ListaValoresDto> listaValoresDtos = new ArrayList<ListaValoresDto>();
     	List<ParametrizacionDto> listaCiclo = new ArrayList<ParametrizacionDto>();;
 		
 		sesion = sessionFactory.getCurrentSession();
 		
 		listaCiclo = sesion.createSQLQuery("select * " +
										 " from parametrizacion p " +
										 " where p.par_nombre IN('CICLO_PREESCOLAR','CICLO_PRIMARIA','CICLO_SECUNDARIA')")
 										 .addEntity(ParametrizacionDto.class).list();
 		
 		for(ParametrizacionDto tipo: listaCiclo){
     		
     		ListaValoresDto valores = new ListaValoresDto();
     		valores.setCodItem(tipo.getId());
     		valores.setNomItem(tipo.getNombre());
     		
     		listaValoresDtos.add(valores);
     	}
 		
 		return listaValoresDtos;
 	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
