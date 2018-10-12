package com.edu.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edu.dao.IDocenteDao;
import com.edu.dto.DocenteDto;
import com.edu.dto.MateriaDto;
import com.edu.dto.UsuarioDto;
import com.edu.services.IDocenteSrv;

public class DocenteSrvImpl implements IDocenteSrv, Serializable{
	
	private static final long serialVersionUID = 5022978123519855121L;
	
	
	IDocenteDao docenteDao;
	
	public List<DocenteDto> consultaTodosDocentes(){
		
		return docenteDao.consultaTodosDocentes();
	}
	
	public void guardarRelacionDocenteMateria(List<UsuarioDto> listaDocentes, int idMateria){
		
		List<DocenteDto> lisEst = new ArrayList<DocenteDto>();
		DocenteDto docente;
		
	   MateriaDto materiaDto = new MateriaDto();
	   materiaDto.setId(idMateria);
		
		for(UsuarioDto usuario: listaDocentes){
			
			docente = new DocenteDto();
			
			docente.setUsuarioDto(usuario);
//			docente.setMateriaDto(materiaDto);
			docente.setFecAct(new Date());
			docente.setCodUsr("CARISTI");
			docente.setCargo("Docente");
			
			lisEst.add(docente);
		}
		
		docenteDao.guardarRelacionDocenteMateria(lisEst);
	}
	
	public DocenteDto consultaDocente(int idDoc){
		return docenteDao.consultaDocente(idDoc);
	}
	
	public void setDocenteDao(IDocenteDao docenteDao) {
		this.docenteDao = docenteDao;
	}
}
