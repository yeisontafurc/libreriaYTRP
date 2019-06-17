package co.mcic.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import co.mcic.dominio.Rol;
import co.mcic.util.Persistencia;

@Entity
@NamedQueries({
@NamedQuery(name="login", query="select u from Usuario u where u.nombreUsuario =:nombre and u.clave =:pwd")
})
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
	
	public boolean validarCredenciales(){
		EntityManager em = Persistencia.getEntityManager();
		TypedQuery<Usuario> credenciales = em.createNamedQuery("login", Usuario.class);
		credenciales.setParameter("nombre", this.getNombreUsuario());
		credenciales.setParameter("pwd", this.getClave());
		List<Usuario> usuario = credenciales.getResultList();
		em.close();
		if(null != usuario){
			if (usuario.size() == 1){
				this.setPersona(usuario.get(0).getPersona());
				this.setRol(usuario.get(0).getRol());
				return usuario.size() == 1;
			}
		}
		return false;
	}
   
}