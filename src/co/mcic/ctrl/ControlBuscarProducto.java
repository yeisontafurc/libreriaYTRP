package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.mcic.dominio.Persona;
import co.mcic.dominio.Producto;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.DetalleProductoVenta;
import co.mcic.vista.FacturaVentaAlquiler;
import co.mcic.vista.VentaUbicaCliente;

public class ControlBuscarProducto implements ActionListener {

	private BuscarProductoVenta buscarProductoVenta;
	private JFrame ventaUbicaCliente;
	private Persona cliente;
	private List<Transaccion> transacciones;
	private Usuario usuario;

	public ControlBuscarProducto(BuscarProductoVenta buscarProductoVenta) {
		this.buscarProductoVenta = buscarProductoVenta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
			String idProducto = this.buscarProductoVenta.getTxtId().getText();
			if (idProducto.isEmpty() || idProducto.equals("")) {
				JOptionPane.showMessageDialog(null, "Identificador de producto inválido");
			} else {
				Producto producto = new Producto();
				producto = producto.consultarProductoId(idProducto);
				if (null == producto) {
					JOptionPane.showMessageDialog(null, "Producto no disponible");
				} else if (!producto.getEstadoDisponibilidad().getNombre().equals("Disponible")) {
					JOptionPane.showMessageDialog(null, "Producto no disponible");
				} else {
					boolean controlTx = false;
					if(null != transacciones)
						for (Transaccion transaccion : transacciones) {
							if (transaccion.getProducto().getIdentificador().equals(idProducto)) {
								controlTx = true;
							}
						}
					if (!controlTx) {
						DetalleProductoVenta detalleProductoVenta = new DetalleProductoVenta();
						ControlDetalleProductoVenta controlDetalleProductoVenta = new ControlDetalleProductoVenta(
								detalleProductoVenta, transacciones);
						detalleProductoVenta.setControl(controlDetalleProductoVenta);
						controlDetalleProductoVenta.setProducto(producto);
						controlDetalleProductoVenta.setCliente(this.cliente);
						controlDetalleProductoVenta.setTransacciones(this.transacciones);
						controlDetalleProductoVenta.setUsuario(usuario);
						controlDetalleProductoVenta.setVolver(buscarProductoVenta);
						this.buscarProductoVenta.setVisible(false);
						this.buscarProductoVenta.dispose();
						controlDetalleProductoVenta.mostrarDetalleProducto();
					}else{
						JOptionPane.showMessageDialog(null, "Producto no disponible, ya agregado");
					}
				}
			}
			break;
		case "VOLVER":
			this.buscarProductoVenta.setVisible(false);
			this.buscarProductoVenta.dispose();
			this.ventaUbicaCliente.setVisible(true);
			break;
		default:
			break;
		}

	}

	public void mostrarBuscarProductoVenta() {
		buscarProductoVenta.setSize(new Dimension(605, 330));
		buscarProductoVenta.setCliente(this.cliente);
		buscarProductoVenta.setVisible(true);
	}

	public void setVolver(JFrame ventaUbicaCliente) {
		if (ventaUbicaCliente instanceof VentaUbicaCliente) {
			this.ventaUbicaCliente = (VentaUbicaCliente) ventaUbicaCliente;
		} else if (ventaUbicaCliente instanceof FacturaVentaAlquiler) {
			this.ventaUbicaCliente = (FacturaVentaAlquiler) ventaUbicaCliente;
		}

	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public Persona getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
