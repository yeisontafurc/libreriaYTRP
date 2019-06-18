package co.mcic.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import co.mcic.util.Persistencia;

@Entity
@NamedQueries({ @NamedQuery(name = "ListaTipoDocumentoALL", query = "select u from ListaTipoDocumento u "),
		@NamedQuery(name = "ListaTipoDocumentoByNombre", query = "select u from ListaTipoDocumento u where u.nombre =:nombre") })
public class ListaTipoDocumento implements Serializable {

	@Id
	private Integer idTipoDocumento;
	@Column(nullable = false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaTipoDocumento() {
		super();
	}

	public Integer getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public List<ListaTipoDocumento> getListaTipoDocumento() {

		EntityManager em = Persistencia.getEntityManager();
		List<ListaTipoDocumento> listatipoDocumento = new ArrayList<>();
		try {
			TypedQuery<ListaTipoDocumento> typeQuery = em.createNamedQuery("ListaTipoDocumentoALL",
					ListaTipoDocumento.class);
			listatipoDocumento = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return listatipoDocumento;
	}

	public ListaTipoDocumento getListaTipoDocumentoByNombre(String nombre) {

		EntityManager em = Persistencia.getEntityManager();
		ListaTipoDocumento tipoDocumento = new ListaTipoDocumento();
		try {
			TypedQuery<ListaTipoDocumento> typeQuery = em.createNamedQuery("ListaTipoDocumentoByNombre",
					ListaTipoDocumento.class);
			typeQuery.setParameter("nombre", nombre);
			tipoDocumento = typeQuery.getSingleResult();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return tipoDocumento;
	}

}