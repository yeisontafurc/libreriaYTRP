package co.mcic.vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import co.mcic.ctrl.ControlMenuPrincipal;

import java.awt.Font;

public class MenuPrincipal extends JFrame {
	private JButton btnProductos, btnVentasYAlquiler, btnClientes, btnSalir;
	private static final long serialVersionUID = 1L;

	public MenuPrincipal() {
		getContentPane().setLayout(null);

		this.btnProductos = new JButton("PRODUCTOS");
		this.btnProductos.setVisible(false);
		this.btnProductos.setActionCommand("PRODUCTOS");
		this.btnProductos.setBounds(106, 131, 154, 80);
		getContentPane().add(btnProductos);

		this.btnVentasYAlquiler = new JButton("VENTA Y ALQUILER");
		this.btnVentasYAlquiler.setVisible(false);
		this.btnVentasYAlquiler.setActionCommand("VENTA Y ALQUILER");
		this.btnVentasYAlquiler.setBounds(106, 222, 152, 80);
		getContentPane().add(btnVentasYAlquiler);

		this.btnClientes = new JButton("CLIENTES");
		this.btnClientes.setVisible(false);
		this.btnClientes.setActionCommand("CLIENTES");
		this.btnClientes.setBounds(296, 131, 154, 80);
		getContentPane().add(btnClientes);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(361, 301, 89, 23);
		this.btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);

		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL", SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMenuPrincipal.setBounds(106, 33, 344, 32);
		
		getContentPane().add(lblMenuPrincipal);
	}

	public JButton getBtnProductos() {
		return btnProductos;
	}

	public void setBtnProductos(JButton btnProductos) {
		this.btnProductos = btnProductos;
	}

	public JButton getBtnVentasYAlquiler() {
		return btnVentasYAlquiler;
	}

	public void setBtnVentasYAlquiler(JButton btnVentasYAlquiler) {
		this.btnVentasYAlquiler = btnVentasYAlquiler;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public void setBtnClientes(JButton btnClientes) {
		this.btnClientes = btnClientes;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
		this.btnProductos.addActionListener(controlMenuPrincipal);
		this.btnVentasYAlquiler.addActionListener(controlMenuPrincipal);
		this.btnClientes.addActionListener(controlMenuPrincipal);
		this.btnSalir.addActionListener(controlMenuPrincipal);
		
	}

}
