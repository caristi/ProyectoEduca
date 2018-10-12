package com.edu.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IDocenteDao;
import com.edu.dto.DocenteDto;

public class DocenteDaoImpl implements IDocenteDao,Serializable{
	
	private static final long serialVersionUID = -6183732534262605912L;

	private Session sesion;
	
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Transactional
	public List<DocenteDto> consultaTodosDocentes(){
		
    	List<DocenteDto> docentes = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		docentes = sesion.createSQLQuery("SELECT  *  " +
										 "	FROM docentes d, usuarios u  " +
										 " WHERE u.tipusu_id = 3  "
										 + " AND d.usu_id    = u.usu_id " +
										 "ORDER BY u.usu_apellido1, u.usu_apellido2,u.usu_nombre")
										 .addEntity(DocenteDto.class).list();
		
		return docentes;
	}
    
	@Transactional
	public DocenteDto consultaDocente(int idDoc){
		
    	DocenteDto docente = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		docente = (DocenteDto) sesion.createQuery("SELECT d FROM DocenteDto d WHERE d.usuarioDto.id = :idUsu").setParameter("idUsu", idDoc).uniqueResult();
//		
//if(colegios.size() > 0){
//    		
//    		colegio = colegios.get(0);
//    	}

		
		return docente;
	}
    
	@Transactional
    public void guardarRelacionDocenteMateria(List<DocenteDto> listaDocentes){
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	for(DocenteDto docente:listaDocentes){
    		sesion.save(docente);
    	}
    	
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
