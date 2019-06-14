package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Persona implements Serializable {

	   
	@Id
	private Integer idPersona;
	@JoinColumn(nullable=false)
	private ListaTipoDocumento tipoDocumento;
	@Column(nullable=false)
	private BigInteger documento;
	@Column(nullable=false)
	private String nombres;
	@Column(nullable=false)
	private String apellidos;
	@Column(nullable=false)
	private String direccion;
	private BigInteger telefono;
	private BigInteger celular;
	@JoinColumn(nullable=false)
	private ListaEstadoPersona estadoPersona;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDTIPOPERSONA", nullable=false)
	private ListaTipoPersona tipoPersona;
	@JoinColumn(nullable=true)
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
   
}
