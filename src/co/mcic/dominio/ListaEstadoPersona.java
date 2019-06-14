package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListaEstadoPersona implements Serializable {

	   
	@Id
	private Integer idEstadoPersona;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaEstadoPersona() {
		super();
	}   
	public Integer getIdEstadoPersona() {
		return this.idEstadoPersona;
	}

	public void setIdEstadoPersona(Integer idEstadoPersona) {
		this.idEstadoPersona = idEstadoPersona;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
