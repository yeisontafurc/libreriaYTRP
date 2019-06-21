package co.mcic.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import org.eclipse.persistence.jpa.config.Cascade;

import co.mcic.util.Persistencia;

@Entity
public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFactura;
	@JoinColumn(nullable = false)
	private Persona cliente;
	@JoinColumn(nullable = false)
	private Persona vendedor;
	@OneToMany(mappedBy = "factura", cascade = { CascadeType.PERSIST })
	private List<Transaccion> transacciones;
	@OneToOne(cascade = CascadeType.PERSIST)
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
				if (transaccion.getTipoTransaccion().getNombre().equals("Venta")) {
					valorTemp = transaccion.getProducto().getValorVenta();

				} else if (transaccion.getTipoTransaccion().getNombre().equals("Alquiler")) {
					valorTemp = transaccion.getProducto().getValorAlquilerDia() * transaccion.getDiasAlquiler();
				} else if (transaccion.getTipoTransaccion().getNombre().equals("Afiliación")) {
					valorTemp = (float) transaccion.getTipoAfiliacion().getValor();
				}
				transaccion.setValorTransaccion(valorTemp);
				valorAcum = valorAcum + valorTemp;
			}
			this.setValorNeto(new BigDecimal(valorAcum));
		}
	}

	public void calcularValorTotal() {
		if (null != this.getPorcentajeDescuento()) {
			if (this.getPorcentajeDescuento() > 0) {
				BigDecimal aux = this.getValorNeto()
						.subtract((this.getValorNeto().multiply(new BigDecimal(this.getPorcentajeDescuento() / 100))));
				this.getPago().setValorPago(aux);
			}
		} else {
			this.getPago().setValorPago(this.getValorNeto());
		}
	}

	public void finalizarFactura() {
		boolean flagError = false;
		try {
			EntityManager em = Persistencia.getEntityManager();
			em.getTransaction().begin();
			Factura fac = new Factura();
			fac.setTransacciones(null);
			fac.setCliente(cliente);
			fac.setPago(pago);
			fac.setVendedor(vendedor);
			fac.setPorcentajeDescuento(porcentajeDescuento);
			fac.setValorNeto(valorNeto);
			em.persist(fac);
			em.getTransaction().commit();
			em.getTransaction().begin();
			System.out.println("idFac: " + fac.getIdFactura());
			for (Transaccion transaccion : this.transacciones) {
				transaccion.setFactura(fac);
				em.persist(transaccion);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			flagError = true;
		}

		System.out.println("IDCLIENTE: " + this.getCliente().getIdPersona());
		System.out.println("PAGO (tipopago): " + this.getPago().getTipoPago());
		System.out.println("VENDEDOR: " + this.getVendedor().getNombres());
		System.out.println("PD: " + this.getPorcentajeDescuento());
		System.out.println("VN: " + this.getValorNeto());
		if (!flagError) {
			for (Transaccion transaccion : transacciones) {
				Producto prod = transaccion.getProducto();
				ListaTipoTransaccion tipoTransaccion = transaccion.getTipoTransaccion();
				if(tipoTransaccion.getNombre().equals("Venta")){
					prod.setEstadoDisponibilidad(new ListaEstadoDisponibilidad().getListaEstadoDisponibilidadByNombre("Vendido"));
				}else if(tipoTransaccion.getNombre().equals("Alquiler")){
					prod.setEstadoDisponibilidad(new ListaEstadoDisponibilidad().getListaEstadoDisponibilidadByNombre("Alquiler"));
				}
				
			}
		}

	}

}
