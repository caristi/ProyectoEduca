package com.siv.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabecera_factura")
public class FacturaDetalleDto implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id")
	private int id;

	@Column(name="det_vlr_producto")
	private double vlrProducto;
	
	@Column(name="det_vlr_iva")
	private double vlrIva;

	@Column(name="det_cantidad")
	private int cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVlrProducto() {
		return vlrProducto;
	}

	public void setVlrProducto(double vlrProducto) {
		this.vlrProducto = vlrProducto;
	}

	public double getVlrIva() {
		return vlrIva;
	}

	public void setVlrIva(double vlrIva) {
		this.vlrIva = vlrIva;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
