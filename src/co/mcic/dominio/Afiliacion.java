package co.mcic.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import co.mcic.util.Persistencia;

@Entity
@NamedQueries({ @NamedQuery(name = "AfiliacionMaxidAfiliacion", query = "select count(u.idAfiliacion) from Afiliacion u "), })
public class Afiliacion implements Serializable {

	@Id
	private Integer idAfiliacion;
	@JoinColumn(nullable = false, name = "TIPOAFILIACION_IDTIPOAFILIACION")
	private ListaTipoAfiliacion tipoAfiliacion;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	private static final long serialVersionUID = 1L;

	public Afiliacion() {
		super();
	}

	public Integer getIdAfiliacion() {
		return this.idAfiliacion;
	}

	public void setIdAfiliacion(Integer idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}

	public ListaTipoAfiliacion getTipoAfiliacion() {
		return this.tipoAfiliacion;
	}

	public void setTipoAfiliacion(ListaTipoAfiliacion tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getMaxId() {
		EntityManager em = Persistencia.getEntityManager();
		Long id = null;
		try {
			TypedQuery<Long> typeQuery = em.createNamedQuery("AfiliacionMaxidAfiliacion", Long.class);
			id = typeQuery.getSingleResult();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return (int) (id + 1);
	}

}
