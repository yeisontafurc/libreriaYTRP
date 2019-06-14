package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Factura implements Serializable {

	   
	@Id
	private Integer idFactura;
	@JoinColumn(nullable=false)
	private Persona cliente;
	@JoinColumn(nullable=false)
	private Persona vendedor;
	@OneToMany(mappedBy = "factura")
	private List<Transaccion> transacciones;
	@JoinColumn(nullable=false)
	private Pago pago;
	@JoinColumn(nullable=false)
	private BigDecimal valorNeto;
	@JoinColumn(nullable=false)
	private Integer porcentajeDescuento;
	private static final long serialVersionUID = 1L;

	public Factura() {
		super();
	}   
	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}   
	public Persona getCliente() {
		return this.cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}   
	public Persona getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}   
	public List<Transaccion> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}   
	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}   
	public BigDecimal getValorNeto() {
		return this.valorNeto;
	}

	public void setValorNeto(BigDecimal valorNeto) {
		this.valorNeto = valorNeto;
	}   
	public Integer getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Integer porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public void adicionarTransaccion(Transaccion transaccion){
		this.transacciones.add(transaccion);
	}
	
	public void borrarTransaccion(Transaccion transaccion){
		this.transacciones.remove(transaccion);		
	}
	
//	/**
//	 * 
//	 * @param idTransaccion recibe el identificador único de una transacción
//	 * @return retorna una "Transaccion" si esta hace parte del objeto Factura ejemplificado que invoca el método.
//	 */
//	public Transaccion buscarTransaccion(Integer idTransaccion){
//		return transacciones.stream().filter(transaccion -> idTransaccion == transaccion.getIdTransaccion()).findAny().orElse(null);
//	}
	
	
   
}
