package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.VentaUbicaCliente;

public class ControlBuscarProducto implements ActionListener {

	private BuscarProductoVenta buscarProductoVenta;
	private VentaUbicaCliente ventaUbicaCliente;
	public ControlBuscarProducto(BuscarProductoVenta buscarProductoVenta) {
		this.buscarProductoVenta = buscarProductoVenta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
			System.out.println("BUSCAR");
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
	public void mostrarBuscarProductoVenta(){
		buscarProductoVenta.setSize(new Dimension(605,330));
		buscarProductoVenta.setVisible(true);
	}

	public void setVolver(VentaUbicaCliente ventaUbicaCliente) {
		this.ventaUbicaCliente = ventaUbicaCliente;
		
	}

}
