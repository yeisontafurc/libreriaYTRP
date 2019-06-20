package co.mcic.vista;

import javax.swing.JFrame;

import co.mcic.ctrl.ControlRegistrarPago;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPago extends JFrame {
	
	private JButton btnFinalizar;
	private static final long serialVersionUID = 1L;
	private JTextField txtDigitosTarjeta;
	private JTextField txtValorVenta;
	private JComboBox<String> cmbTipoPago, cmbTC;
	
	public RegistrarPago() {
		getContentPane().setLayout(null);
		
		JLabel lblVenderOAlquilar = new JLabel("VENDER O ALQUILAR PRODUCTOS", SwingConstants.CENTER);
		lblVenderOAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenderOAlquilar.setBounds(10, 11, 584, 41);
		getContentPane().add(lblVenderOAlquilar);
		
		JLabel lblRegistrarPago = new JLabel("Registrar pago:");
		lblRegistrarPago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegistrarPago.setBounds(33, 63, 94, 17);
		getContentPane().add(lblRegistrarPago);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago:", SwingConstants.RIGHT);
		lblTipoDePago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDePago.setBounds(161, 93, 80, 20);
		getContentPane().add(lblTipoDePago);
		
		cmbTipoPago = new JComboBox<String>();
		cmbTipoPago.setBounds(302, 93, 178, 20);
		getContentPane().add(cmbTipoPago);
		
		JLabel lblTipoDeTarjeta = new JLabel("Tipo de Tarjeta de Cr\u00E9dito:", SwingConstants.RIGHT);
		lblTipoDeTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDeTarjeta.setBounds(82, 132, 159, 20);
		getContentPane().add(lblTipoDeTarjeta);
		
		this.cmbTC = new JComboBox<String>();
		this.cmbTC.setBounds(302, 132, 178, 20);
		//this.cmbTC.setEnabled(false);
		getContentPane().add(this.cmbTC);
		
		JLabel lblDigitosTarjeta = new JLabel("Digitos Tarjeta:", SwingConstants.RIGHT);
		lblDigitosTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDigitosTarjeta.setBounds(147, 171, 94, 20);
		getContentPane().add(lblDigitosTarjeta);
		
		this.txtDigitosTarjeta = new JTextField();
		//this.txtDigitosTarjeta.setEditable(false);
		this.txtDigitosTarjeta.setBounds(302, 171, 178, 20);
		getContentPane().add(this.txtDigitosTarjeta);
		this.txtDigitosTarjeta.setColumns(10);
		
		JLabel lblValorVenta = new JLabel("Valor venta:", SwingConstants.RIGHT);
		lblValorVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorVenta.setBounds(161, 208, 80, 25);
		getContentPane().add(lblValorVenta);
		
		txtValorVenta = new JTextField();
		txtValorVenta.setBounds(302, 210, 178, 20);
		getContentPane().add(txtValorVenta);
		txtValorVenta.setColumns(10);
		
		this.btnFinalizar = new JButton("Finalizar");
		this.btnFinalizar.setActionCommand("FINALIZAR");
		this.btnFinalizar.setBounds(391, 255, 89, 23);
		getContentPane().add(this.btnFinalizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(291, 255, 89, 23);
		getContentPane().add(btnCancelar);
	}

	public JComboBox<String> getCmbTipoPago() {
		return cmbTipoPago;
	}

	public void setCmbTipoPago(JComboBox<String> cmbTipoPago) {
		this.cmbTipoPago = cmbTipoPago;
	}
	public JComboBox<String> getCmbTC() {
		return cmbTC;
	}

	public void setCmbTC(JComboBox<String> cmbTC) {
		this.cmbTC = cmbTC;
	}
	public JTextField getTxtDigitosTarjeta() {
		return txtDigitosTarjeta;
	}

	public void setTxtDigitosTarjeta(JTextField txtDigitosTarjeta) {
		this.txtDigitosTarjeta = txtDigitosTarjeta;
	}

	public JTextField getTxtValorVenta() {
		return txtValorVenta;
	}

	public void setTxtValorVenta(JTextField txtValorVenta) {
		this.txtValorVenta = txtValorVenta;
	}

	public void setControl(ControlRegistrarPago controlRegistrarPago) {
		this.btnFinalizar.addActionListener(controlRegistrarPago);
		this.cmbTipoPago.addActionListener(controlRegistrarPago);
	}
}
