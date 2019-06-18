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
	@NamedQuery(name = "ListaCategoriaALL", query = "select ca from Categoria ca "),
	@NamedQuery(name = "CategoriaByNombre",query="select ca from Categoria ca where ca.nombre =:nombre")	
	})
public class Categoria implements Serializable {

	   
	@Id
	private Integer idCategoria;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}   
	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Categoria> getlistaCategoria() {

		EntityManager em = Persistencia.getEntityManager();
		List<Categoria> listaCategoria = new ArrayList<>();
		try {
			TypedQuery<Categoria> typeQuery = em.createNamedQuery("ListaCategoriaALL", Categoria.class);
			listaCategoria = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return listaCategoria;
	}
	
	public Categoria getCategoriaByNombre(String nombre){
		EntityManager em = Persistencia.getEntityManager();
		Categoria categoria = new Categoria();
		TypedQuery<Categoria> typedQuery = em.createNamedQuery("CategoriaByNombre",Categoria.class);
		typedQuery.setParameter("nombre", nombre);
		categoria = typedQuery.getSingleResult();
		
		return categoria;
	}
   
}

