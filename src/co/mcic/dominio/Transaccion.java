package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.mcic.util.Persistencia;


@Entity
public class Transaccion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTransaccion;
	@JoinColumn(nullable=true)
	private Producto producto;
	@JoinColumn(nullable=false)
	private ListaTipoTransaccion tipoTransaccion;
	@JoinColumn(nullable=true)
	private ListaTipoAfiliacion tipoAfiliacion;
	@Column(nullable=false)
	private Float valorTransaccion;
	@Column(nullable=true)
	private Integer diasAlquiler;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDFACTURA", nullable=false)
	private Factura factura;
	private static final long serialVersionUID = 1L;

	public Transaccion() {
		super();
	}   
	public Integer getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}   
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}   
	public ListaTipoTransaccion getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(ListaTipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}   
	public ListaTipoAfiliacion getTipoAfiliacion() {
		return this.tipoAfiliacion;
	}

	public void setTipoAfiliacion(ListaTipoAfiliacion tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}   
	public Float getValorTransaccion() {
		return this.valorTransaccion;
	}

	public void setValorTransaccion(Float valorTransaccion) {
		this.valorTransaccion = valorTransaccion;
	}   
	public Integer getDiasAlquiler() {
		return this.diasAlquiler;
	}

	public void setDiasAlquiler(Integer diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
   
}
