package com.edu.dto;

import java.io.Serializable;

public class ListaValoresDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int codItem;
	private String nomItem;

	public String getNomItem() {
		return nomItem;
	}
	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}
	public int getCodItem() {
		return codItem;
	}
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
}
