package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Producto implements Serializable {

	   
	@Id
	private Integer idProducto;
	@Column(nullable=false)
	private String identificador;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private Float valorAlquilerDia;
	@Column(nullable=false)
	private Float valorVenta;
	@JoinColumn(nullable=false)
	private Categoria categoria;
	@JoinColumn(nullable=false)
	private ListaEstadoProducto estadoProducto;
	@JoinColumn(nullable=false)
	private ListaEstadoDisponibilidad estadoDisponibilidad;
	
	private static final long serialVersionUID = 1L;

	public Producto() {
		super();
	}   
	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}   
	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Float getValorAlquilerDia() {
		return this.valorAlquilerDia;
	}

	public void setValorAlquilerDia(Float valorAlquilerDia) {
		this.valorAlquilerDia = valorAlquilerDia;
	}   
	public Float getValorVenta() {
		return this.valorVenta;
	}

	public void setValorVenta(Float valorVenta) {
		this.valorVenta = valorVenta;
	}   
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}   
	public ListaEstadoProducto getEstadoProducto() {
		return this.estadoProducto;
	}

	public void setEstadoProducto(ListaEstadoProducto estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	
	public ListaEstadoDisponibilidad getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}
	public void setEstadoDisponibilidad(ListaEstadoDisponibilidad estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}
   
}
