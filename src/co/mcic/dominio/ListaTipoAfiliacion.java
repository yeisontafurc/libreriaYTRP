package co.mcic.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import co.mcic.util.Persistencia;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Entity
@NamedQueries({ @NamedQuery(name = "ListaTipoAfiliacionALL", query = "select u from ListaTipoAfiliacion u "),
		@NamedQuery(name = "ListaTipoAfiliacionByNombre", query = "select u from ListaTipoAfiliacion u where u.nombre =:nombre") })
public class ListaTipoAfiliacion implements Serializable {

	@Id
	private Integer idTipoAfiliacion;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Integer meses;
	@Column(nullable = false)
	private Integer porcentaje;
	@Column(nullable = false)
	private Integer valor;
	private static final long serialVersionUID = 1L;

	public ListaTipoAfiliacion() {
		super();
	}

	public Integer getIdTipoAfiliacion() {
		return this.idTipoAfiliacion;
	}

	public void setIdTipoAfiliacion(Integer idTipoAfiliacion) {
		this.idTipoAfiliacion = idTipoAfiliacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMeses() {
		return this.meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}

	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public List<ListaTipoAfiliacion> getListaTipoAfiliacion() {
		EntityManager em = Persistencia.getEntityManager();
		List<ListaTipoAfiliacion> listaTipoAfiliacion = new ArrayList<>();
		try {
			TypedQuery<ListaTipoAfiliacion> typeQuery = em.createNamedQuery("ListaTipoAfiliacionALL",
					ListaTipoAfiliacion.class);
			listaTipoAfiliacion = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return listaTipoAfiliacion;

	}

	public ListaTipoAfiliacion getListaTipoAfiliacionByNombre(String nombre) {

		EntityManager em = Persistencia.getEntityManager();
		ListaTipoAfiliacion tipoAfiliacion = new ListaTipoAfiliacion();
		try {
			TypedQuery<ListaTipoAfiliacion> typeQuery = em.createNamedQuery("ListaTipoAfiliacionByNombre",
					ListaTipoAfiliacion.class);
			typeQuery.setParameter("nombre", nombre);
			tipoAfiliacion = typeQuery.getSingleResult();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return tipoAfiliacion;
	}

}