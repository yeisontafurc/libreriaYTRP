package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListaEstadoProducto implements Serializable {

	   
	@Id
	private Integer idEstadoProducto;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaEstadoProducto() {
		super();
	}   
	public Integer getIdEstadoProducto() {
		return this.idEstadoProducto;
	}

	public void setIdEstadoProducto(Integer idEstadoProducto) {
		this.idEstadoProducto = idEstadoProducto;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}

