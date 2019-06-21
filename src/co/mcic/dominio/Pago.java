package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pago implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPago;
	@Column(nullable=false)
	private BigDecimal valorPago;
	@JoinColumn(nullable=false)
	private ListaTipoPago tipoPago;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(nullable=false)
	private TarjetaCredito tarjetaCredito;
	private static final long serialVersionUID = 1L;

	public Pago() {
		super();
	}   
	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}   
	public BigDecimal getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}   
	public ListaTipoPago getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(ListaTipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}   
	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
   
}
