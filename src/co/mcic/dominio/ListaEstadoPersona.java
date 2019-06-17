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
	@NamedQuery(name = "ListaEstadoPersonaALL", query = "select u from ListaEstadoPersona u ")	
	})
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
	
	public List<ListaEstadoPersona> getListaEstadoPersona() {

		EntityManager em = Persistencia.getEntityManager();
		List<ListaEstadoPersona> estado = new ArrayList<>();
		try {
			TypedQuery<ListaEstadoPersona> typeQuery = em.createNamedQuery("ListaEstadoPersonaALL", ListaEstadoPersona.class);
			estado = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return estado;
	}
   
}
