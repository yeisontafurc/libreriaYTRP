package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFactura;
	@JoinColumn(nullable = false)
	private Persona cliente;
	@JoinColumn(nullable = false)
	private Persona vendedor;
	@OneToMany(mappedBy = "factura")
	private List<Transaccion> transacciones;
	@JoinColumn(nullable = false)
	private Pago pago;
	@JoinColumn(nullable = false)
	private BigDecimal valorNeto;
	@JoinColumn(nullable = false)
	private Integer porcentajeDescuento;
	private static final long serialVersionUID = 1L;

	public Factura() {
		super();
		transacciones = new ArrayList<Transaccion>();
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

	public void adicionarTransaccion(Transaccion transaccion) {
		this.transacciones.add(transaccion);
	}

	public void borrarTransaccion(Transaccion transaccion) {
		this.transacciones.remove(transaccion);
	}

	public void calcularValorNeto() {
		Float valorTemp = (float) 0;
		Float valorAcum = (float) 0;
		if (null != transacciones) {
			for (Transaccion transaccion : transacciones) {
				if(transaccion.getTipoTransaccion().getNombre().equals("Venta")){
					valorTemp = transaccion.getProducto().getValorVenta();
					 
				}else if(transaccion.getTipoTransaccion().getNombre().equals("Alquiler")){
					valorTemp = transaccion.getProducto().getValorAlquilerDia() * transaccion.getDiasAlquiler();
				}else if(transaccion.getTipoTransaccion().getNombre().equals("Afiliación")){
					valorTemp = (float)transaccion.getTipoAfiliacion().getValor();
				}
				transaccion.setValorTransaccion(valorTemp);
				valorAcum = valorAcum + valorTemp;
			}
			this.setValorNeto(new BigDecimal(valorAcum));
		}
	}

	public void calcularValorTotal() {
		if(null != this.getPorcentajeDescuento()){
			if(this.getPorcentajeDescuento() > 0){
				BigDecimal aux = this.getValorNeto().subtract((this.getValorNeto().multiply(new BigDecimal(this.getPorcentajeDescuento()/100))));
				this.getPago().setValorPago(aux);
			}
		}else{
			this.getPago().setValorPago(this.getValorNeto());
		}
	}

	public void finalizarFactura() {
		// TODO Auto-generated method stub

	}

}
