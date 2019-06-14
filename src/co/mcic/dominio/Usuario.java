package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import co.mcic.dominio.Rol;

@Entity
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	private Integer idUsuario;
	@Column(nullable=false)
	private String nombreUsuario;
	@Column(nullable=false)
	private String clave;
	@JoinColumn(nullable=false)
	private Persona persona;
	@JoinColumn(nullable=false, name = "ROL_USUARIO")
	private Rol rolUsuario;
	

	public Usuario() {
		super();
	}   
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}   
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}   
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}   
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}   
	public Rol getRol() {
		return this.rolUsuario;
	}

	public void setRol(Rol rol) {
		this.rolUsuario = rol;
	}
   
}