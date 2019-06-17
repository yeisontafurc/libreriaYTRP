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
	@NamedQuery(name = "ListaEstadoDisponibilidadALL", query = "select u from ListaEstadoDisponibilidad u ")	
	})
public class ListaEstadoDisponibilidad implements Serializable {

	   
	@Id
	private Integer idEstadoDisponibilidad;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;
	
	public ListaEstadoDisponibilidad(Integer cod,String nombre) {
		this.idEstadoDisponibilidad = cod;
		this.nombre = nombre;
			}

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
	
	public List<ListaEstadoDisponibilidad> getlistaEstadoDisponibilidad() {

		EntityManager em = Persistencia.getEntityManager();
		List<ListaEstadoDisponibilidad> estadoDisponibilidad = new ArrayList<>();
		try {
			TypedQuery<ListaEstadoDisponibilidad> typeQuery = em.createNamedQuery("ListaEstadoDisponibilidadALL", ListaEstadoDisponibilidad.class);
			estadoDisponibilidad = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return estadoDisponibilidad;
	}
   
}
