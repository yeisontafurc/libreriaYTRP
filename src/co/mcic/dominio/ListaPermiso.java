package co.mcic.dominio;

import co.mcic.dominio.Rol;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ListaPermiso
 *
 */
@Entity

public class ListaPermiso implements Serializable {

	   
	@Id
	private Integer idPermiso;
	private String nombre;
	private Rol rolPermiso;
	private static final long serialVersionUID = 1L;

	public ListaPermiso() {
		super();
	}   
	public Integer getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Rol getRol() {
		return this.rolPermiso;
	}

	public void setRol(Rol rol) {
		this.rolPermiso = rol;
	}
   
}
