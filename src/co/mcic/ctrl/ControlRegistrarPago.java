package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import co.mcic.dominio.Factura;
import co.mcic.dominio.ListaTipoPago;
import co.mcic.dominio.Pago;
import co.mcic.dominio.Persona;
import co.mcic.dominio.TarjetaCredito;
import co.mcic.dominio.TarjetaDinersClub;
import co.mcic.dominio.TarjetaMastercard;
import co.mcic.dominio.TarjetaVisa;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.RegistrarPago;

public class ControlRegistrarPago implements ActionListener {

	protected RegistrarPago registrarPago;
	private List<Transaccion> transacciones;
	private Persona cliente;
	private Usuario usuario;
	private Factura factura;
	private List<ListaTipoPago> tiposPago;

	public ControlRegistrarPago(RegistrarPago registrarPago) {
		this.registrarPago = registrarPago;
		this.registrarPago.getCmbTipoPago().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				Object item = e.getItem();
				System.out.println(item.toString());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Selected " + cb.getSelectedItem().toString());
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("No selected: " + cb.getSelectedItem().toString());
				}
				if (item.toString().equals("Tarjeta de Crédito")) {
					System.out.println("Item igual a tc");
					registrarPago.getTxtDigitosTarjeta().setEnabled(true);
					registrarPago.getCmbTC().setEnabled(true);
					registrarPago.getTxtDigitosTarjeta().enable();
					registrarPago.getCmbTC().enable();
				} else {
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
		boolean flagFactura = false;
		switch (e.getActionCommand()) {
		case "FINALIZAR":
			// Registrar tipopago
			for (ListaTipoPago tipoPago : tiposPago) {
				if (this.registrarPago.getCmbTipoPago().getSelectedItem().toString().equals(tipoPago.getNombre())) {
					this.factura.getPago().setTipoPago(tipoPago);
				}
			}
			// Si se paga con TC:
			if (this.factura.getPago().getTipoPago().getNombre().equals("Tarjeta de Crédito")) {
				try {
					Long tc = new Long(this.registrarPago.getTxtDigitosTarjeta().getText());
					TarjetaCredito credito = null;
					if (this.registrarPago.getCmbTC().getSelectedItem().equals("DinersClub")) {
						credito = new TarjetaDinersClub();
						credito.setNumeroTarjeta(tc);
					} else if (this.registrarPago.getCmbTC().getSelectedItem().equals("Mastercard")) {
						credito = new TarjetaMastercard();
						credito.setNumeroTarjeta(tc);
					} else if (this.registrarPago.getCmbTC().getSelectedItem().equals("Visa")) {
						credito = new TarjetaVisa();
						credito.setNumeroTarjeta(tc);
					}else{
						JOptionPane.showMessageDialog(null, "Tarjeta de crédito no reconocida");
					}
					if(null != credito){
						boolean validez = credito.validarTarjeta();
						if(!validez){
							JOptionPane.showMessageDialog(null, "Tarjeta de crédito inválida");
						}else{
							this.factura.getPago().setTarjetaCredito(credito);
							flagFactura = this.factura.finalizarFactura();
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}
			}else{
				flagFactura = this.factura.finalizarFactura();
			}
			
			if(flagFactura){
				JOptionPane.showMessageDialog(null, "Pago exitoso");
			}else{
				JOptionPane.showMessageDialog(null, "No pudo realizarse el pago");
			}
			ControlLogin controlLogin = new ControlLogin();
			controlLogin.setUsuario(usuario);
			controlLogin.validarAccesos();
			registrarPago.setVisible(false);
			registrarPago.dispose();
			
			break;
		case "CANCELAR":
			int res = JOptionPane.showConfirmDialog(null, "¿Está seguro de volver?, se perderán todos los productos de la transacción", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
			if(res == JOptionPane.OK_OPTION){
				this.transacciones = new ArrayList<Transaccion>();
				ControlLogin controlLogin_ = new ControlLogin();
				controlLogin_.setUsuario(usuario);
				controlLogin_.validarAccesos();
				registrarPago.setVisible(false);
				registrarPago.dispose();
			}
			break;
		default:
			break;
		}
	}

	public void mostrarRegistrarPago() {
		this.tiposPago = new ListaTipoPago().getListaTipoPago();
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

		if (null != cliente.getAfiliacion()) {
			Integer porcentajeDescuento = cliente.getAfiliacion().getTipoAfiliacion().getPorcentaje();
			this.factura.setPorcentajeDescuento(porcentajeDescuento);
		}
		Pago pago = new Pago();
		this.factura.setPago(pago);
		this.factura.calcularValorTotal();
		this.factura.setVendedor(usuario.getPersona());
		this.factura.setCliente(cliente);

		this.registrarPago.getTxtValorVenta().setText(this.factura.getPago().getValorPago().toString());
		this.registrarPago.setSize(new Dimension(620, 350));
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
