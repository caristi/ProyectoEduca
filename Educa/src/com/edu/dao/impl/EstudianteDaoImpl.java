package com.edu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IEstudianteDao;
import com.edu.dto.EstudianteDto;
import com.edu.dto.UsuarioDto;

public class EstudianteDaoImpl implements IEstudianteDao{
	
	private Session sesion;
	
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Transactional
	public List<EstudianteDto> consultaEstudiantesXMateria(int idMateria){
		
    	List<EstudianteDto> estudiantes = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		estudiantes = sesion.createSQLQuery("SELECT  * " +
										 	"  FROM usuarios u, estudiante e, grupos g, materias m " +
										 	" WHERE u.usu_id     = e.usu_id " +
										 	"   AND g.gru_id     = e.gru_id " +
										 	"   AND m.gru_id     = g.gru_id " + 
										 	"   AND m.mat_id     = :idMat   " +
										 	"ORDER BY u.usu_apellido1, u.usu_apellido2,u.usu_nombre ")
										 .addEntity(EstudianteDto.class)
										 .setParameter("idMat", idMateria).list();
		return estudiantes;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<EstudianteDto> consultaEstudiantes(int idMateria,int idGrupo){
		
    	String sql = "";
    	
    	List<EstudianteDto> estudiantes = null;
    	
    	if(idMateria != 0 ){
    		
    		sql += " AND m.mat_id  = " + idMateria;
    	}
    	
    	if(idGrupo != 0){
    		sql += " AND g.gru_id = " + idGrupo; 
    	}
		
		sesion = sessionFactory.getCurrentSession();
		
		estudiantes = sesion.createSQLQuery("SELECT  * " +
										 	"  FROM usuarios u, estudiante e, grupos g, materias m " +
										 	" WHERE u.usu_id     = e.usu_id " +
										 	"   AND g.gru_id     = e.gru_id " +
										 	"   AND m.gru_id     = g.gru_id " + sql +
										 	" ORDER BY u.usu_apellido1, u.usu_apellido2,u.usu_nombre ")
										 .addEntity(EstudianteDto.class).list();
		
		return estudiantes;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<UsuarioDto> consultaTodosEstudiantesSinRelacion(){
		
    	List<UsuarioDto> estudiantes = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		estudiantes = sesion.createSQLQuery("SELECT  *  " +
											"	 FROM usuarios u  " +
											"	 WHERE u.tipusu_id = 2  " +
											"	  and not exists (SELECT 0  " +
											"					     FROM estudiante e " +
											"	                    WHERE e.usu_id = u.usu_id  " +
											"					   ) " +
											"	 ORDER BY u.usu_apellido1, u.usu_apellido2,u.usu_nombre")
										 .addEntity(UsuarioDto.class).list();
		
		return estudiantes;
	}
    
	@Transactional
    public void guardarRelacionEstudianteGrupo(List<EstudianteDto> listaEstudiantes){
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	for(EstudianteDto estudiante:listaEstudiantes){
    		sesion.save(estudiante);
    	}
    	
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
