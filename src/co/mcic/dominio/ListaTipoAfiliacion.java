package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class ListaTipoAfiliacion implements Serializable {

	   
	@Id
	private Integer idTipoAfiliacion;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private Integer meses;
	@Column(nullable=false)
	private Integer porcentaje;
	@Column(nullable=false)
	private Integer valor;
	private static final long serialVersionUID = 1L;

	public ListaTipoAfiliacion() {
		super();
	}   
	public Integer getIdTipoAfiliacion() {
		return this.idTipoAfiliacion;
	}

	public void setIdTipoAfiliacion(Integer idTipoAfiliacion) {
		this.idTipoAfiliacion = idTipoAfiliacion;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Integer getMeses() {
		return this.meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}   
	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}   
	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
   
}