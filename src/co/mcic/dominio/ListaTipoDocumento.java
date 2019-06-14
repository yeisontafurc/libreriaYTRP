package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class ListaTipoDocumento implements Serializable {

	   
	@Id
	private Integer idTipoDocumento;
	@Column(nullable=false)
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
   
}