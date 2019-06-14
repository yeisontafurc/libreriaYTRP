package co.mcic.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
@Table(name="rol")
public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idRol;
	@Column(nullable=false)
	private String nombre;
	@OneToMany(mappedBy = "rolPermiso")
	private List<ListaPermiso> permisos;
	
	public Rol() {
		super();
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ListaPermiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<ListaPermiso> permisos) {
		this.permisos = permisos;
	}
	public void agregarPermiso(ListaPermiso permiso){
		this.permisos.add(permiso);
	}
	public void borrarPermiso(ListaPermiso permiso){
		this.permisos.remove(permiso);
	}
//	public ListaPermiso buscarPermiso(String permiso){
//		return permisos.stream().filter(listaPermiso -> permiso.equals(listaPermiso.getNombre())).findAny().orElse(null);		
//	}
}
