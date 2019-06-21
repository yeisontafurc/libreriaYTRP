package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@DiscriminatorColumn(name="tipoTarjeta")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class TarjetaCredito implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTarjetaCredito;
	@Transient
	private String prefijo;
	@Transient
	private Integer longitud;
	@Column(nullable=false)
	private Long numeroTarjeta;
	private static final long serialVersionUID = 1L;

	public TarjetaCredito() {
		super();
	}   
	public Integer getIdTarjetaCredito() {
		return this.idTarjetaCredito;
	}

	public void setIdTarjetaCredito(Integer idTarjetaCredito) {
		this.idTarjetaCredito = idTarjetaCredito;
	}   
	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}   
	public Integer getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}   
	public Long getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public abstract boolean validarTarjeta();
   
}