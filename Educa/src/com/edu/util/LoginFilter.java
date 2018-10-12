package com.edu.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bean.LoginBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// Obtengo el bean que representa el usuario desde el scope sesion
		LoginBean loginBean = (LoginBean) req.getSession().getAttribute("loginBean");

		//Proceso la URL que esta requiriendo el cliente
		String urlStr = req.getRequestURL().toString().toLowerCase();

		//System.out.println(urlStr + " - desprotegido=[" + noProteger(urlStr) + "]");

		//Si no requiere proteccion continua normalmente.
		if (noProteger(urlStr)) {
			chain.doFilter(request, response);
			return;
		}

		//El usuario no esta logueado
		if (loginBean == null || (loginBean.getUsuario() == null || !loginBean.getUsuario().isAcceso())) {
			res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
			return;
		}

		//El recurso requiere proteccion, pero el usuario ya esta logueado.
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private boolean noProteger(String urlStr) {

		/*
		 * Este es un buen lugar para colocar y programar todos los patrones que
		 * creamos convenientes para determinar cuales de los recursos no
		 * requieren proteccion. Sin duda que habra que crear un mecanismo tal
		 * que se obtengan de un archivo de configuracion o algo que no requiera
		 * compilacion.
		 */
		if ((urlStr.contains("login") ||urlStr.endsWith("js")||urlStr.contains("jpg")||urlStr.contains("css")||urlStr.contains("png")||urlStr.contains("gif")
				||urlStr.contains("srvdownload"))){
			return true;
		}
		if (urlStr.indexOf("/javax.faces.resource/") != -1){
			return true;
		}
		return false;
	}

}