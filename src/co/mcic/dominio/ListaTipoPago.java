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
	@NamedQuery(name = "ListaTipoPagoAll", query = "select u from ListaTipoPago u ")
	 })
public class ListaTipoPago implements Serializable {

	   
	@Id
	private Integer idTipoPago;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaTipoPago() {
		super();
	}   
	public Integer getIdTipoPago() {
		return this.idTipoPago;
	}

	public void setIdTipoPago(Integer idTipoPago) {
		this.idTipoPago = idTipoPago;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<ListaTipoPago> getListaTipoPago(){
		EntityManager em = Persistencia.getEntityManager();
		List<ListaTipoPago> tipoPago = new ArrayList<>();
		TypedQuery<ListaTipoPago> typeQuery = em.createNamedQuery("ListaTipoPagoAll",ListaTipoPago.class);
		tipoPago = typeQuery.getResultList();
		return tipoPago;
	}
   
}
