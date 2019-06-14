package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
   
}
