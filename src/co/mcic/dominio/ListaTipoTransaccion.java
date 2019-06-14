package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListaTipoTransaccion implements Serializable {

	   
	@Id
	private Integer idTipoTx;
	@Column(nullable=false)
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ListaTipoTransaccion() {
		super();
	}   
	public Integer getIdTipoTx() {
		return this.idTipoTx;
	}

	public void setIdTipoTx(Integer idTipoTx) {
		this.idTipoTx = idTipoTx;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
