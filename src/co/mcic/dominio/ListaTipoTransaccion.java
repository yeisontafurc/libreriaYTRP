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
		@NamedQuery(name = "ListaTipoTransaccionById", query = "select u from ListaTipoTransaccion u where u.idTipoTx =:idTipoTx"),
		@NamedQuery(name = "ListaTipoTransaccionALL", query = "select u from ListaTipoTransaccion u "),
		@NamedQuery(name = "ListaTipoTransaccionByNombre", query = "select u from ListaTipoTransaccion u where u.nombre =:nombre") })
public class ListaTipoTransaccion implements Serializable {

	@Id
	private Integer idTipoTx;
	@Column(nullable = false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaTipoTransaccion() {
		super();
	}

	public Integer getIdTipoTx() {
		return this.idTipoTx;
	}

	public void setIdTipoTx(Integer idTipoTx) {
		this.idTipoTx = idTipoTx;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ListaTipoTransaccion> getListaTipoTransaccion() {
		EntityManager em = Persistencia.getEntityManager();
		List<ListaTipoTransaccion> tipoTx = new ArrayList<>();
		TypedQuery<ListaTipoTransaccion> typeQuery = em.createNamedQuery("ListaTipoTransaccionALL",
				ListaTipoTransaccion.class);
		tipoTx = typeQuery.getResultList();
		return tipoTx;
	}

	public ListaTipoTransaccion getListaTipoTransaccionByNombre(String nombre) {
		EntityManager em = Persistencia.getEntityManager();
		ListaTipoTransaccion listaTipoTransaccion = new ListaTipoTransaccion();
		TypedQuery<ListaTipoTransaccion> typeQuery = em.createNamedQuery("ListaTipoTransaccionByNombre",
				ListaTipoTransaccion.class);
		typeQuery.setParameter("nombre", nombre);
		listaTipoTransaccion = typeQuery.getSingleResult();
		return listaTipoTransaccion;

	}

}
