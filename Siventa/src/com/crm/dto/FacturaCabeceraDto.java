package com.crm.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabecera_factura")
public class FacturaCabeceraDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cab_id")
	private int id;

	@Column(name="cab_num_factura")
	private String numFactura;

	@Column(name="cab_fecha")
	private Date fechaFactura;
	
	@Column(name="cab_vlr_iva")
	private double vlrIva;
	
    @Column(name="cab_vlr_sub_total")
    private double vlrSubTotal;
    
    @Column(name="cab_vlr_total")
    private double vlrTotal;
    
    @Column(name="cab_observacion")
    private String observacion;
    
//    cli_id
    
//    private List<FacturaDetalleDto> listaDetalleFactura;

	public FacturaCabeceraDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public double getVlrIva() {
		return vlrIva;
	}

	public void setVlrIva(double vlrIva) {
		this.vlrIva = vlrIva;
	}

	public double getVlrSubTotal() {
		return vlrSubTotal;
	}

	public void setVlrSubTotal(double vlrSubTotal) {
		this.vlrSubTotal = vlrSubTotal;
	}

	public double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
