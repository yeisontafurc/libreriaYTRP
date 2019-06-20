package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;

import co.mcic.dominio.Factura;
import co.mcic.dominio.ListaTipoPago;
import co.mcic.dominio.Pago;
import co.mcic.dominio.Persona;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.RegistrarPago;

public class ControlRegistrarPago implements ActionListener {

	protected RegistrarPago registrarPago;
	private List<Transaccion> transacciones;
	private Persona cliente;
	private Usuario usuario;
	private Factura factura;
	public ControlRegistrarPago(RegistrarPago registrarPago) {
		this.registrarPago = registrarPago;
		this.registrarPago.getCmbTipoPago().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
			    Object item = e.getItem();
			    System.out.println(item.toString());
			    if (e.getStateChange() == ItemEvent.SELECTED) {
			      	System.out.println("Selected "+ cb.getSelectedItem().toString());
			    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
			    	System.out.println("No selected: " + cb.getSelectedItem().toString());
			    }
			    if(item.toString().equals("Tarjeta de Crédito")){
			    	System.out.println("Item igual a tc");
		      		registrarPago.getTxtDigitosTarjeta().setEnabled(true);
		      		registrarPago.getCmbTC().setEnabled(true);
		      		registrarPago.getTxtDigitosTarjeta().enable();
		      		registrarPago.getCmbTC().enable();
		      	}else{
		      		registrarPago.getTxtDigitosTarjeta().setEnabled(false);
		      		registrarPago.getCmbTC().setEnabled(false);
		      		registrarPago.getTxtDigitosTarjeta().disable();
		      		registrarPago.getCmbTC().disable();
		      	}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "FINALIZAR":
			break;
		case "CANCELAR":
			break;
		default:
			break;
		}
	}

	public void mostrarRegistrarPago() {
		List<ListaTipoPago> tiposPago = new ListaTipoPago().getListaTipoPago();
		for (ListaTipoPago tipoPago : tiposPago) {
			this.registrarPago.getCmbTipoPago().addItem(tipoPago.getNombre());
		}
		
		this.registrarPago.getCmbTC().addItem("DinersClub");
		this.registrarPago.getCmbTC().addItem("Mastercard"); 
		this.registrarPago.getCmbTC().addItem("Visa");
		
		this.factura = new Factura();
		for (Transaccion transaccion : transacciones) {
			this.factura.adicionarTransaccion(transaccion);
		}
		this.factura.calcularValorNeto();
		
		if(null != cliente.getAfiliacion()){
			Integer porcentajeDescuento = cliente.getAfiliacion().getTipoAfiliacion().getPorcentaje();
			this.factura.setPorcentajeDescuento(porcentajeDescuento);
		}
		Pago pago = new Pago();
		this.factura.setPago(pago);
		this.factura.calcularValorTotal();
		this.registrarPago.getTxtValorVenta().setText(this.factura.getPago().getValorPago().toString());
		
		this.factura.finalizarFactura();
		
		
		this.registrarPago.setSize(new Dimension(620,350));
		this.registrarPago.setVisible(true);
		this.registrarPago.getTxtDigitosTarjeta().setEnabled(false);
		this.registrarPago.getCmbTC().setEditable(false);
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public Persona getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	
}
