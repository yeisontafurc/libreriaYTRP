package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {

	   
	@Id
	private Integer idCategoria;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}   
	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}

