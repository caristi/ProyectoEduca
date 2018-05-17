package com.siv.bean;

import com.siv.dto.FacturaCabeceraDto;

public class FacturaBean {

	private FacturaCabeceraDto facCabeceraDto;
	
	public FacturaBean() {
		
	}
	
	public void resetear(){
		facCabeceraDto.getListaDetalleFactura().get(facCabeceraDto.getListaDetalleFactura().size() + 1);
	}

	public FacturaCabeceraDto getFacCabeceraDto() {
		return facCabeceraDto;
	}

	public void setFacCabeceraDto(FacturaCabeceraDto facCabeceraDto) {
		this.facCabeceraDto = facCabeceraDto;
	}


}