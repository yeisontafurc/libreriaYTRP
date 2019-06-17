package co.mcic.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import co.mcic.util.Persistencia;

@Entity
@NamedQueries({	
	@NamedQuery(name = "ListaEstadoProductoALL", query = "select u from ListaEstadoProducto u ")	
	})
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
	
	
	public List<ListaEstadoProducto> getListaEstadoProducto() {

		EntityManager em = Persistencia.getEntityManager();
		List<ListaEstadoProducto> estado = new ArrayList<>();
		try {
			TypedQuery<ListaEstadoProducto> typeQuery = em.createNamedQuery("ListaEstadoProductoALL", ListaEstadoProducto.class);
			estado = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return estado;
	}
   
}

