package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import co.mcic.dominio.ListaTipoTransaccion;
import co.mcic.dominio.Persona;
import co.mcic.dominio.Producto;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.DetalleProductoVenta;
import co.mcic.vista.FacturaVentaAlquiler;

public class ControlDetalleProductoVenta implements ActionListener {

	private DetalleProductoVenta detalleProductoVenta;
	private BuscarProductoVenta buscarProductoVenta;
	private Producto producto;
	private Persona cliente;
	private List<Transaccion> transacciones;
	private List<ListaTipoTransaccion> listaTipoTransaccion;
	private Usuario usuario;
	
	public ControlDetalleProductoVenta(DetalleProductoVenta detalleProductoVenta, List<Transaccion> transacciones) {
		this.detalleProductoVenta = detalleProductoVenta;
		this.listaTipoTransaccion = new ListaTipoTransaccion().getListaTipoTransaccion();
		this.transacciones = transacciones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "VENDER":
				//res = 0 aceptar venta, 2 cancelar
				int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de vender este producto?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
				if(res == JOptionPane.OK_OPTION){
					if(null == transacciones){
						transacciones = new ArrayList<Transaccion>();
					}
					Transaccion transaccion = new Transaccion();
					transaccion.setProducto(producto);
					for (ListaTipoTransaccion tipoTransaccion : listaTipoTransaccion) {
						if(tipoTransaccion.getNombre().equals("Venta")){
							transaccion.setTipoTransaccion(tipoTransaccion);
						}
					}
					transacciones.add(transaccion);
					FacturaVentaAlquiler facturaVentaAlquiler = new FacturaVentaAlquiler(transacciones.size());
					ControlFacturaVA controlFacturaVA = new ControlFacturaVA(facturaVentaAlquiler);
					facturaVentaAlquiler.setControl(controlFacturaVA);
					controlFacturaVA.setProducto(producto);
					controlFacturaVA.setCliente(this.cliente);
					controlFacturaVA.setTransacciones(this.transacciones);
					controlFacturaVA.setVolver(buscarProductoVenta);
					controlFacturaVA.setUsuario(usuario);
					detalleProductoVenta.setVisible(false);
					detalleProductoVenta.dispose();
					controlFacturaVA.mostrarFacturaVentaAlquiler();
					
				}
				break;
			case "ALQUILAR":
				SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 100, 1);
				JSpinner spinner = new JSpinner(sModel);
				int option = JOptionPane.showOptionDialog(null, spinner, "Enter valid number", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (option == JOptionPane.CANCEL_OPTION)
				{
				   System.out.println("cancel");
				} else if (option == JOptionPane.OK_OPTION)
				{
					System.out.println("ok " +spinner.getValue().toString());
					//TODO FacturaView
				}
				break;
			case "VOLVER":
					detalleProductoVenta.setVisible(false);
					detalleProductoVenta.dispose();
					buscarProductoVenta.setVisible(true);
				break;
				
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public void setVolver(BuscarProductoVenta buscarProductoVenta) {
		this.buscarProductoVenta = buscarProductoVenta;
	}
	
	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	public void mostrarDetalleProducto(){
		this.detalleProductoVenta.setSize(new Dimension(630,330));
		this.detalleProductoVenta.getTxtIdentificador().setText(this.producto.getIdentificador());
		this.detalleProductoVenta.getTxtNombre().setText(this.producto.getNombre());
		this.detalleProductoVenta.getTxtEstado().setText(this.producto.getEstadoDisponibilidad().getNombre());
		this.detalleProductoVenta.getTxtValorAlquiler().setText(this.producto.getValorAlquilerDia().toString());
		this.detalleProductoVenta.getTxtValorVenta().setText(this.producto.getValorVenta().toString());
		
		this.detalleProductoVenta.setVisible(true);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
