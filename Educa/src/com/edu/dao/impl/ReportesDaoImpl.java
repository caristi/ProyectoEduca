package com.edu.dao.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.IReportesDao;
import com.edu.dto.ReporteDto;
import com.edu.dto.SubReporteDto;
import com.edu.dto.TipoAsistenciaDto;

public class ReportesDaoImpl implements IReportesDao{
	
	private Session sesion;
	
    private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> informeInasistenciaXMateria(int codigoMateria) {
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("SELECT e.est_id,e.est_codigo, e.usu_nombre, e.usu_apellido1, e.usu_apellido2, " +
											"	     s.cantidad AS cantidad_sin_excusa, " +
											"        c.cantidad AS cantidad_con_excusa, " + 
											"        t.cantidad AS actividad_institucional,   " +   
											"		 ac.cantidad AS cantidad_tarde   " + 
											"  FROM (SELECT u.usu_nombre, u.usu_apellido1, u.usu_apellido2,e.est_id,e.est_codigo " +
											"		  FROM estudiante e, usuarios u " +
											"		 WHERE u.usu_id = e.usU_id " +
											"		) e " +
											"        LEFT JOIN " +
											"        (SELECT a.est_id, count(0) cantidad " +
											"		   FROM asistencia a, tipoasistencia t, materias m " +
											"		  WHERE a.tipasi_cod_asi      = t.tipasi_cod_asi    " +
											"			and t.tipasi_cod_asi = 1 " +
											"			and m.mat_id	     = :codMateria  "	+
											"			and a.mat_id	     = m.mat_id     "   +
											"           GROUP BY a.est_id  " +
											"        ) s " +
											"	    ON e.est_id = s.est_id " +
											"       LEFT JOIN " +
											"        (SELECT a.est_id, count(0) cantidad " +
											"		   FROM asistencia a, tipoasistencia t, materias m " +
											"		  WHERE a.tipasi_cod_asi = t.tipasi_cod_asi " +
											"			and t.tipasi_cod_asi = 2 " +
											"			and m.mat_id  	     = :codMateria  "	+
											"			and a.mat_id	     = m.mat_id     "   +											
											"           GROUP BY a.est_id  " +
											"        ) c " +
											"	    ON e.est_id = c.est_id " +
											"       LEFT JOIN " +
											"       (SELECT a.est_id, count(0) cantidad " +
											"		   FROM asistencia a, tipoasistencia t, materias m " +
											"		  WHERE a.tipasi_cod_asi      = t.tipasi_cod_asi " +
											"			and t.tipasi_cod_asi = 3 " +
											"			and m.mat_id    	 = :codMateria  "	+
											"			and a.mat_id	     = m.mat_id     "   +											
											"           GROUP BY a.est_id " +
											"       ) t " +
											"	    ON e.est_id = t.est_id " + 
										    "	    LEFT JOIN      " +
											"			(SELECT a.est_id, count(0) cantidad   " +   
											"			   FROM asistencia a, tipoasistencia t, materias m     " + 
											"			  WHERE a.tipasi_cod_asi = t.tipasi_cod_asi      " +
											"				and t.tipasi_cod_asi = 4      " +
											"				and m.mat_id    	 = :codMateria  	 " +  
											"				and a.mat_id	     = m.mat_id  " +          											
											"				GROUP BY a.est_id     " +
											"			) ac     " +
											"			ON e.est_id = ac.est_id " +
											"WHERE (s.cantidad is  not null or c.cantidad is not null or t.cantidad is not null or ac.cantidad is not null) " +
											"GROUP BY e.est_id " +
											"ORDER BY e.usu_apellido1,e.usu_apellido2,e.usu_nombre ").setParameter("codMateria", codigoMateria).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setCodigoEst(Integer.parseInt(row[1].toString()));
		    rep.setNombreEst(row[2].toString());
		    rep.setApelledio1Est(row[3].toString());
		    rep.setApelledio2Est(row[4].toString());
		    rep.setCantidadSinExcusas(row[5] != null ? Integer.parseInt(row[5].toString()):0);
		    rep.setCantidadConExcusas(row[6] != null ? Integer.parseInt(row[6].toString()):0);
		    rep.setCantidadActivInstitucional(row[7] != null ? Integer.parseInt(row[7].toString()):0);
		    rep.setCantidadTarde(row[8] != null ? Integer.parseInt(row[8].toString()):0);
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> informeInasistenciaXEstudiantes(String codigoEstudiante) {
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("SELECT EST_ID, e.MAT_ID, m.mat_nombre, SUM(SIN_EXCUSA) SIN_EXCUSA, SUM(CON_EXCUSA) CON_EXCUSA, SUM(TARDE) TARDE " +
													"FROM (SELECT E.EST_ID, MAT_ID,  " +
													"		CASE WHEN T.TIPASI_COD_ASI = 1 THEN  1 " +
													"			ELSE 0 " +
													"		END as 'SIN_EXCUSA', " +
													"		CASE WHEN T.TIPASI_COD_ASI = 2 THEN 1 " +
													"			  ELSE 0  " +
													"		END AS 'CON_EXCUSA', " +
													"		CASE WHEN T.TIPASI_COD_ASI = 3 THEN 1 " +
													"			  ELSE 0  " +
													"		END AS 'TARDE'      " +   
													"	FROM  ESTUDIANTE E LEFT JOIN ASISTENCIA A ON(E.EST_ID = A.EST_ID),TIPOASISTENCIA T " +
													"	WHERE E.EST_CODIGO   = :codEstu " +
												    "      AND T.tipasi_cod_asi = A.tipasi_cod_asi " +
													"	) E , materias m " +
												    " where m.mat_id = e.mat_id " +
												    " GROUP BY E.EST_ID, E.MAT_ID").setParameter("codEstu", codigoEstudiante).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
//		    rep.setCodigoEst(Integer.parseInt(row[0].toString()));
		    rep.setNombreMateria(row[2].toString());
//		    rep.setApelledio2Est(row[3].toString());
		    rep.setCantidadSinExcusas(row[3] != null ? Integer.parseInt(row[3].toString()):0);
		    rep.setCantidadConExcusas(row[4] != null ? Integer.parseInt(row[4].toString()):0);
		    rep.setCantidadTarde(row[5] != null ? Integer.parseInt(row[5].toString()):0);
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> informeInasistenciaXEstudiantesFecha(int codigoEstudiante,int codMateria) {
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("SELECT a.asi_fecha,a.mat_id, m.mat_nombre, " +
													"	CASE WHEN T.TIPASI_COD_ASI = 1 THEN  1 " +
													"		ELSE 0 " +
													"	END as 'SIN_EXCUSA', " +
													"	CASE WHEN T.TIPASI_COD_ASI = 2 THEN 1 " +
													"		  ELSE 0  " +
													"	END AS 'CON_EXCUSA', " +
													"	CASE WHEN T.TIPASI_COD_ASI = 3 THEN 1 " +
													"		  ELSE 0  " +
													"	END AS 'TARDE'     " +    
													" FROM  ESTUDIANTE E LEFT JOIN ASISTENCIA A ON(E.EST_ID = A.EST_ID),TIPOASISTENCIA T, materias m " +
													" WHERE E.EST_CODIGO   = :codEstu " +
													"  AND T.tipasi_cod_asi = A.tipasi_cod_asi "  +
													"  AND m.mat_id	  = a.mat_id"	    +
													"  AND a.mat_id	  = :codMat").setParameter("codEstu", codigoEstudiante).setParameter("codMat", codMateria).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setFechaInasistencia((Date)row[0]);
		    rep.setNombreMateria(row[2].toString());
//		    rep.setApelledio2Est(row[3].toString());
		    rep.setCantidadSinExcusas(row[3] != null ? Integer.parseInt(row[3].toString()):0);
		    rep.setCantidadConExcusas(row[4] != null ? Integer.parseInt(row[4].toString()):0);
		    rep.setCantidadTarde(row[5] != null ? Integer.parseInt(row[5].toString()):0);
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> informeInasistenciaXEstudiantesMateriaFecha(int codigoEstudiante,int codMateria) {
		
		List<SubReporteDto> listsubReporteDto = null;
		List<ReporteDto>    listReporteDto 	  = null;
		
		sesion = sessionFactory.getCurrentSession();
		
    	List<TipoAsistenciaDto> listaAsistencias = new ArrayList<TipoAsistenciaDto>();
    	
    	sesion = sessionFactory.getCurrentSession();
    	
    	listaAsistencias = sesion.createQuery("select t from TipoAsistenciaDto t where t.mcaVisible = 'S' ").list();
    	
    	listReporteDto = new ArrayList<ReporteDto>();
    	
    	for(TipoAsistenciaDto tipAsis:listaAsistencias){
    		
    		    ReporteDto reporte = new ReporteDto();
    		   
    		    reporte.setNombreTipoAsistencia(tipAsis.getNombre());
    		
	    		List<Object[]> rows = sesion.createSQLQuery(" SELECT a.asi_fecha, '' as tipo " +
															"   FROM  estudiante e LEFT JOIN asistencia a ON(e.est_id = a.est_id),tipoasistencia t, materias m   "  + 
															"   WHERE e.est_codigo    = :codEstu     " +
															"    AND t.tipasi_cod_asi 	  = a.tipasi_cod_asi   " +   
															"    AND m.mat_id	      = a.mat_id  "	+
															"    AND a.mat_id	      = :matId "+
															"    and t.tipasi_cod_asi 	  = :tipId")
														.setParameter("codEstu", codigoEstudiante)
														.setParameter("matId", codMateria)
														.setParameter("tipId", tipAsis.getCodigo()).list();

				listsubReporteDto = new ArrayList<SubReporteDto>();
				
				for(Object[] row : rows){
				
					SubReporteDto rep = new SubReporteDto();
					
					rep.setFechas((Date)row[0]);
					
					listsubReporteDto.add(rep);
				}
				
				reporte.setSubReporteDto(listsubReporteDto);
				
				listReporteDto.add(reporte);
    	 }
    	
		
		return listReporteDto;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> informeInasistenciaXDia(Date fechaDia){
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("select e.est_codigo,u.usu_nombre,u.usu_apellido1,u.usu_apellido2, u.usu_telefono_casa,m.mat_nombre, g.gru_nombre, t.tipasi_opcion " +
												  " from asistencia a, tipoasistencia t, estudiante e,  usuarios u, materias m, grupos g " +
												  " where a.asi_fecha = :fechaDia " +
												  "   and t.tipasi_cod_asi = a.tipasi_cod_asi " +
												  "   and a.est_id = e.est_id " +
												  "   and e.usu_id = u.usu_id " +
												  "   and m.mat_id = a.mat_id " +
												  "   and g.gru_id = m.gru_id " +
												  "   and t.tipasi_cod_asi = 1").setParameter("fechaDia", fechaDia).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setCodigoEst(Integer.parseInt(row[0].toString()));
		    rep.setNombreEst(row[1].toString());
		    rep.setApelledio1Est(row[2].toString());
		    rep.setApelledio2Est(row[3].toString());
		    rep.setTelefonoCasa(row[4].toString());
		    rep.setNombreMateria(row[5].toString());
		    rep.setNombreGrupo(row[6].toString());
		    rep.setNombreTipoAsistencia(row[7].toString());
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> reporteInasistenciaXTipoInasistencia(){
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("select t.tipasi_opcion, count(0) cantidad, " +
												    " (select count(0) " + 
												    " from asistencia a) as total" +
													"  from asistencia a, tipoasistencia t " +
													" where a.tipasi_cod_asi = t.tipasi_cod_asi " + 
													" group by t.tipasi_opcion;").list();
		
		listaReporte = new ArrayList<ReporteDto>();
		DecimalFormat df = new DecimalFormat("###.##");
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setNombreTipoAsistencia(row[0].toString());
		    rep.setCantXTipoInasistencia(Integer.parseInt(row[1].toString()));
		    rep.setCantTotalInasistencia(Integer.parseInt(row[2].toString()));
		    
		    float porcentaje = (float) rep.getCantXTipoInasistencia() / (float)rep.getCantTotalInasistencia() * 100;
		    
			rep.setPorcentajeInasis(Float.parseFloat(df.format(porcentaje)));
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> reporteInasistenciaXEstudiante(String codigoEstu){
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("select e.est_codigo,u.usu_nombre,u.usu_apellido1,u.usu_apellido2,m.mat_nombre, g.gru_nombre,a.asi_fecha,t.tipasi_opcion " +
													" from asistencia a, tipoasistencia t, estudiante e,  usuarios u, materias m, grupos g " +
													" where t.tipasi_cod_asi = a.tipasi_cod_asi  " +
													"   and a.est_id = e.est_id  " +
													"   and e.est_codigo = :codigoEstu " +
													"    and e.usu_id = u.usu_id " +  
													"    and m.mat_id = a.mat_id  " +
													"    and g.gru_id = m.gru_id").setParameter("codigoEstu", codigoEstu).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setCodigoEst(Integer.parseInt(row[0].toString()));
		    rep.setNombreEst(row[1].toString());
		    rep.setApelledio1Est(row[2].toString());
		    rep.setApelledio2Est(row[3].toString());
		    rep.setNombreMateria(row[4].toString());
		    rep.setNombreGrupo(row[5].toString());
		    rep.setFechaInasistencia((Date)row[6]);
		    rep.setNombreTipoAsistencia(row[7].toString());
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> reporteInasistenciaTodosEstudiante(){
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("select e.est_codigo,u.usu_nombre,u.usu_apellido1,u.usu_apellido2,g.gru_nombre, " +  
													"		  (select count(0) " +
													"		     from asistencia a, tipoasistencia t  " +
													"		   where a.est_id         = e.est_id  " +
													"		   and a.tipasi_cod_asi      = t.tipasi_cod_asi " +  
													"		   and t.tipasi_cod_asi = 1 ) as 'sin_excusa', " +
													"		 (select ROUND(((count(0) / p.par_valor)* 100),2) " + 
													"		   from asistencia a, tipoasistencia t, grupos g, parametrizacion p" +
													"		  where a.est_id          = e.est_id  " +
													"		    and a.tipasi_cod_asi  = t.tipasi_cod_asi " +  
													"		    and a.tipasi_cod_asi  = 1 " +
													"		    and g.gru_id		  = e.gru_id" +
													"		    and p.par_nombre	  = g.gru_ciclo" +
													"		   ) as 'Porc_sin_excua'," +
													"		  (select count(0)  " +
													"		    from asistencia a, tipoasistencia t" +  
													"		   where a.est_id       = e.est_id  " +
													"		   and a.tipasi_cod_asi = t.tipasi_cod_asi" +  
													"		   and t.tipasi_cod_asi = 2) as 'con_excusa'," +  
													"			(select count(0)" +  
													"			  from asistencia a, tipoasistencia t" +  
													"			 where a.est_id         = e.est_id  " +
													"			   and a.tipasi_cod_asi      = t.tipasi_cod_asi" +  
													"			   and t.tipasi_cod_asi = 3  " +
													"			) as 'actividad_institucional', " +        
													"		(select ROUND(((count(0) / p.par_valor)* 100),2)" + 
													"		   from asistencia a, tipoasistencia t, grupos g, parametrizacion p" +
													"		  where a.est_id          = e.est_id  " +
													"		    and a.tipasi_cod_asi  = t.tipasi_cod_asi" +  
													"		    and a.tipasi_cod_asi != 4" +
													"		    and g.gru_id		  = e.gru_id" +
													"		    and p.par_nombre	  = g.gru_ciclo" +
													"		   ) as 'total' " +
													"		from estudiante e,  usuarios u, grupos g, asistencia a" +  
													"		where e.usu_id    = u.usu_id  " +
													"		 and e.gru_id     = g.gru_id  " +
													"		 and a.est_id     = e.est_id  " +
													"		and a.tipasi_cod_asi != 4" +
													" order by usu_apellido1,usu_apellido2, usu_nombre ").list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setCodigoEst(Integer.parseInt(row[0].toString()));
		    rep.setNombreEst(row[1].toString());
		    rep.setApelledio1Est(row[2].toString());
		    rep.setApelledio2Est(row[3].toString());
		    rep.setNombreGrupo(row[4].toString());
		    rep.setCantidadSinExcusas(row[5] != null ? Integer.parseInt(row[5].toString()):0);
		    rep.setPorcentajeRealInasis(row[6] != null ? Float.parseFloat(row[6].toString()):0);
		    rep.setCantidadConExcusas(row[7] != null ? Integer.parseInt(row[7].toString()):0);
		    rep.setCantidadTarde(row[8] != null ? Integer.parseInt(row[8].toString()):0);
		    rep.setPorcentajeInasis(row[9] != null ? Float.parseFloat(row[9].toString()):0);
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReporteDto> reporteInasistenciaXGrupo(String nomGrupo){
		
		List<ReporteDto> listaReporte = null;
		
		sesion = sessionFactory.getCurrentSession();
		
		List<Object[]> rows = sesion.createSQLQuery("select e.est_codigo,u.usu_nombre,u.usu_apellido1,u.usu_apellido2,g.gru_nombre, " +
													" (select count(0) " +
													"    from asistencia a, tipoasistencia t " +
													"  where a.est_id         = e.est_id " +
											        "    and a.tipasi_cod_asi      = t.tipasi_cod_asi " +
											        "    and t.tipasi_cod_asi = 1 " +
											        " ) as 'sin_excusa', " +
													"	(select ROUND(((count(0) / p.par_valor)* 100),2) " + 
													"		   from asistencia a, tipoasistencia t, grupos g, parametrizacion p" +
													"		  where a.est_id          = e.est_id  " +
													"		    and a.tipasi_cod_asi  = t.tipasi_cod_asi " +  
													"		    and a.tipasi_cod_asi  = 1 " +
													"		    and g.gru_id		  = e.gru_id" +
													"		    and p.par_nombre	  = g.gru_ciclo" +
													"		   ) as 'Porc_sin_excua'," +
													" (select count(0) " +
												    "    from asistencia a, tipoasistencia t " +
													"  where a.est_id         = e.est_id " +
											        "    and a.tipasi_cod_asi      = t.tipasi_cod_asi " +
											        "    and t.tipasi_cod_asi = 2 " +
											        " ) as 'con_excusa', " +
											 		" (select count(0) " +
											         "  from asistencia a, tipoasistencia t " +
													 " where a.est_id         = e.est_id " +
											         "   and a.tipasi_cod_asi      = t.tipasi_cod_asi " +
											         "   and t.tipasi_cod_asi = 3 " +
											        " ) as 'tarde',        " +
													"(select ROUND(((count(0) / p.par_valor)* 100),2)" + 
													"	from asistencia a, tipoasistencia t, grupos g, parametrizacion p" +
													"   where a.est_id          = e.est_id  " +
													"	  and a.tipasi_cod_asi  = t.tipasi_cod_asi" +  
													"	  and a.tipasi_cod_asi != 4" +
													"	  and g.gru_id		  = e.gru_id" +
													"	  and p.par_nombre	  = g.gru_ciclo" +
													"   ) as 'actividad_institucional' " +
											        " from estudiante e,  usuarios u, grupos g, asistencia a " +
											        " where e.usu_id     = u.usu_id " +
											        "  and e.gru_id     = g.gru_id " +
											        "  and g.gru_id = :grupo " +
											        "  and a.est_id     = e.est_id " +
											  		" and a.tipasi_cod_asi != 4 " + 
											        " group by 1 " +
											        " order by usu_apellido1,usu_apellido2, usu_nombre").setParameter("grupo", nomGrupo).list();
		
		listaReporte = new ArrayList<ReporteDto>();
		
		for(Object[] row : rows){
			
		    ReporteDto rep = new ReporteDto();
		    
		    rep.setCodigoEst(Integer.parseInt(row[0].toString()));
		    rep.setNombreEst(row[1].toString());
		    rep.setApelledio1Est(row[2].toString());
		    rep.setApelledio2Est(row[3].toString());
		    rep.setNombreGrupo(row[4].toString());
		    rep.setCantidadSinExcusas(row[5] != null ? Integer.parseInt(row[5].toString()):0);
		    rep.setPorcentajeRealInasis(row[6] != null ? Float.parseFloat(row[6].toString()):0);
		    rep.setCantidadConExcusas(row[7] != null ? Integer.parseInt(row[7].toString()):0);
		    rep.setCantidadTarde(row[8] != null ? Integer.parseInt(row[8].toString()):0);
		    rep.setPorcentajeInasis(row[9] != null ? Float.parseFloat(row[9].toString()):0);
		    
		    listaReporte.add(rep);
		}
		
		return listaReporte;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
