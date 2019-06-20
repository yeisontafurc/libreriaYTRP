package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import co.mcic.dominio.Persona;
import co.mcic.dominio.Producto;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.FacturaVentaAlquiler;
import co.mcic.vista.RegistrarPago;

public class ControlFacturaVA implements ActionListener {

	private FacturaVentaAlquiler facturaVentaAlquiler;
	private Producto producto;
	private Persona cliente;
	private List<Transaccion> transacciones;
	private Usuario usuario;
	private BuscarProductoVenta buscarProductoVenta;
	private ControlBuscarProducto consultarBuscarProducto;
	
	public ControlFacturaVA(FacturaVentaAlquiler facturaVentaAlquiler) {
		this.facturaVentaAlquiler = facturaVentaAlquiler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "AGREGAR":
			this.buscarProductoVenta = new BuscarProductoVenta();
			this.consultarBuscarProducto = new ControlBuscarProducto(buscarProductoVenta);
			this.buscarProductoVenta.setControl(this.consultarBuscarProducto);
			this.consultarBuscarProducto.setCliente(cliente);
			this.consultarBuscarProducto.setTransacciones(transacciones);
			this.consultarBuscarProducto.setVolver(this.facturaVentaAlquiler);
			this.consultarBuscarProducto.mostrarBuscarProductoVenta();
			facturaVentaAlquiler.setVisible(false);
			facturaVentaAlquiler.dispose();
			break;
		case "PAGAR":
			RegistrarPago registrarPago = new RegistrarPago();
			ControlRegistrarPago controlRegistrarPago = new ControlRegistrarPago(registrarPago);
			registrarPago.setControl(controlRegistrarPago);
			controlRegistrarPago.setTransacciones(transacciones);
			controlRegistrarPago.setCliente(cliente);
			controlRegistrarPago.setUsuario(usuario);
			controlRegistrarPago.mostrarRegistrarPago();
			facturaVentaAlquiler.setVisible(false);
			facturaVentaAlquiler.dispose();
			break;
		case "VOLVER":
			int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de volver?, se perderán todos los productos de la transacción", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
			if(res == JOptionPane.OK_OPTION){
				this.transacciones = new ArrayList<Transaccion>();
				ControlLogin controlLogin = new ControlLogin();
				controlLogin.setUsuario(usuario);
				controlLogin.validarAccesos();
				facturaVentaAlquiler.setVisible(false);
				facturaVentaAlquiler.dispose();
			}
			break;
		}
	}
	public void mostrarFacturaVentaAlquiler(){
		this.facturaVentaAlquiler.setSize(new Dimension(660,430));
		this.facturaVentaAlquiler.setVisible(true);
		DefaultTableModel model = (DefaultTableModel) this.facturaVentaAlquiler.getTable().getModel();
		for (Transaccion transaccion : transacciones) {
			String tipoTx = transaccion.getTipoTransaccion().getNombre();
			if(tipoTx.equals("Alquiler")){
				model.addRow(new Object[]{ transaccion.getProducto().getIdentificador(), transaccion.getProducto().getNombre(), "", tipoTx, transaccion.getProducto().getValorAlquilerDia()*transaccion.getDiasAlquiler() });
			}else{
				model.addRow(new Object[]{ transaccion.getProducto().getIdentificador(), transaccion.getProducto().getNombre(), tipoTx, "", transaccion.getProducto().getValorVenta() });
			}
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Persona getCliente() {
		return cliente;
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

	public void setVolver(BuscarProductoVenta buscarProductoVenta) {
		this.buscarProductoVenta = buscarProductoVenta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
	
}
