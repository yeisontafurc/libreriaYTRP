package co.mcic.dominio;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import co.mcic.util.Persistencia;

/**
 * Entity implementation class for Entity: TipoPersona
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name="ListaTipoPersonaAll", query="select ltp from ListaTipoPersona ltp")
})
public class ListaTipoPersona implements Serializable {

	@Id
	private Integer idTipoPersona;
	@Column(nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy = "tipoPersona")
	private List<Persona> personas;
	private static final long serialVersionUID = 1L;

	public ListaTipoPersona() {
		super();
	}   
	public Integer getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarPersona(Persona persona){
		this.personas.add(persona);
	}
	public void borrarPersona(Persona persona){
		this.personas.remove(persona);
	}
//	/**
//	 * 
//	 * @param idPersona: recibe el identificador único de la persona
//	 * @return retorna "Persona" en caso de estar asociada al "TipoPersona" del objeto ejemplificado que invoca el método
//	 */
//	public Persona buscarPersonaId(Integer idPersona){
//		return personas.stream().filter(persona -> idPersona == persona.getIdPersona()).findAny().orElse(null);
//	}
   public List<ListaTipoPersona> getListaTipoPersona(){
		EntityManager em = Persistencia.getEntityManager();
		TypedQuery<ListaTipoPersona> consultaTipoProducto= em.createNamedQuery("ListaTipoPersonaAll", ListaTipoPersona.class);
		List<ListaTipoPersona> lista = consultaTipoProducto.getResultList();
		return lista;
   }
}