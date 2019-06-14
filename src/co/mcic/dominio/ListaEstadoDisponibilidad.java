package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListaEstadoDisponibilidad implements Serializable {

	   
	@Id
	private Integer idEstadoDisponibilidad;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaEstadoDisponibilidad() {
		super();
	}   
	public Integer getIdEstadoDisponibilidad() {
		return this.idEstadoDisponibilidad;
	}

	public void setIdEstadoDisponibilidad(Integer idEstadoDisponibilidad) {
		this.idEstadoDisponibilidad = idEstadoDisponibilidad;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
