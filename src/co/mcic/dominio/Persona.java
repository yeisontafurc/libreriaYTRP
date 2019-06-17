package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import co.mcic.util.Persistencia;

@Entity
@NamedQueries({ @NamedQuery(name = "PersonaById", query = "select u from Persona u where u.documento =:documento"),
		@NamedQuery(name = "PersonaALL", query = "select u from Persona u "),
		@NamedQuery(name = "PersonaByNombre", query = "select u from Persona u where u.nombres =:nombres"),
		@NamedQuery(name = "PersonaNombreId", query = "select u from Persona u where u.nombres =:nombres and u.documento =:documento"),
		@NamedQuery(name = "PersonaMaxidPersona", query = "select count(u.idPersona) from Persona u ") })
public class Persona implements Serializable {

	@Id
	private Integer idPersona;
	@JoinColumn(nullable = false)
	private ListaTipoDocumento tipoDocumento;
	@Column(nullable = false)
	private BigInteger documento;
	@Column(nullable = false)
	private String nombres;
	@Column(nullable = false)
	private String apellidos;
	@Column(nullable = false)
	private String direccion;
	private BigInteger telefono;
	private BigInteger celular;
	@JoinColumn(nullable = false)
	private ListaEstadoPersona estadoPersona;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDTIPOPERSONA", nullable = false)
	private ListaTipoPersona tipoPersona;
	@JoinColumn(nullable = true)
	private Afiliacion afiliacion;
	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public ListaTipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(ListaTipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public BigInteger getDocumento() {
		return this.documento;
	}

	public void setDocumento(BigInteger documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigInteger getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigInteger telefono) {
		this.telefono = telefono;
	}

	public BigInteger getCelular() {
		return this.celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}

	public ListaEstadoPersona getEstadoPersona() {
		return this.estadoPersona;
	}

	public void setEstadoPersona(ListaEstadoPersona estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public ListaTipoPersona getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(ListaTipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Afiliacion getAfiliacion() {
		return this.afiliacion;
	}

	public void setAfiliacion(Afiliacion afiliacion) {
		this.afiliacion = afiliacion;
	}

	/**
	 * 
	 * @param persona
	 * @return
	 */
	public boolean crearCliente(Persona persona) {
		EntityManager em = Persistencia.getEntityManager();

		try {
			em.getTransaction().begin();
			persona.idPersona = this.getMaxId();
			System.out.println(persona.idPersona);
			em.persist(persona);
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getMaxId() {
		EntityManager em = Persistencia.getEntityManager();
		Long id = null;
		try {
			TypedQuery<Long> typeQuery = em.createNamedQuery("PersonaMaxidPersona", Long.class);
			id = typeQuery.getSingleResult();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return (int) (id+1);
	}

	/**
	 * 
	 * @param persona
	 * @return
	 */
	public boolean actualizarCliente(Persona persona) {
		EntityManager em = Persistencia.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(persona);
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Persona consultaCliente(BigInteger documento, String nombres) {

		EntityManager em = Persistencia.getEntityManager();
		Persona persona = new Persona();
		try {
			TypedQuery<Persona> typeQuery = em.createNamedQuery("PersonaNombreId", Persona.class);
			typeQuery.setParameter("nombres", nombres);
			typeQuery.setParameter("documento", documento);
			persona = typeQuery.getSingleResult();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return persona;
	}

	/**
	 * 
	 * @param documento
	 * @param nombres
	 * @return
	 */
	public List<Persona> listaClientes(BigInteger documento, String nombres) {

		EntityManager em = Persistencia.getEntityManager();
		List<Persona> ListaPersonas = new ArrayList<>();
		try {
			TypedQuery<Persona> typeQuery = null;
			if (documento.compareTo(new BigInteger("0")) == 1 && null != nombres && !nombres.isEmpty()) {

				typeQuery = em.createNamedQuery("PersonaNombreId", Persona.class);
				typeQuery.setParameter("nombres", nombres);
				typeQuery.setParameter("documento", documento);
			} else if (null != nombres && !nombres.isEmpty()) {
				typeQuery = em.createNamedQuery("PersonaByNombre", Persona.class);
				typeQuery.setParameter("nombres", nombres);
			} else if (documento.compareTo(new BigInteger("0")) == 1) {
				typeQuery = em.createNamedQuery("PersonaById", Persona.class);
				typeQuery.setParameter("documento", documento);
			} else {
				typeQuery = em.createNamedQuery("PersonaALL", Persona.class);
			}
			ListaPersonas = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return ListaPersonas;
	}
}
