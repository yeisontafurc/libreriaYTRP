package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.mcic.ctrl.ControlMenuClientes;

public class MenuCliente extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnConsultarCliente, btnRegistrarCliente, btnAfiliarCliente,btnEditarCliente,btnVolver;

	/**
	 * Create the application.
	 */
	public MenuCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(259, 43, 269, 35);
		getContentPane().add(lblNewLabel);
		
		btnConsultarCliente = new JButton("<html><p>Consultar</p><p>Producto</p></html>");
		btnConsultarCliente.setBounds(167, 116, 138, 77);
		btnConsultarCliente.setActionCommand("CONSULTAR");
		getContentPane().add(btnConsultarCliente);
		
		btnRegistrarCliente = new JButton("<html><p>Registrar</p><p>Producto</p></html>");
		btnRegistrarCliente.setBounds(396, 116, 138, 77);
		btnRegistrarCliente.setActionCommand("REGISTRAR");
		getContentPane().add(btnRegistrarCliente);
		
		btnAfiliarCliente = new JButton("<html><p>Editar</p><p>Producto</p></html>");			
		btnAfiliarCliente.setBounds(167, 232, 138, 77);
		btnAfiliarCliente.setActionCommand("AFILIAR");
		getContentPane().add(btnAfiliarCliente);
		
		btnEditarCliente = new JButton("<html><p>Editar</p><p>Producto</p></html>");			
		btnEditarCliente.setBounds(396, 232, 138, 77);
		btnEditarCliente.setActionCommand("EDITAR");
		getContentPane().add(btnEditarCliente);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(526, 392, 89, 23);
		btnVolver.setActionCommand("VOLVER");
		getContentPane().add(btnVolver);		
	}

	

	public JButton getBtnConsultarCliente() {
		return btnConsultarCliente;
	}

	public void setBtnConsultarCliente(JButton btnConsultarCliente) {
		this.btnConsultarCliente = btnConsultarCliente;
	}

	public JButton getBtnRegistrarCliente() {
		return btnRegistrarCliente;
	}

	public void setBtnRegistrarCliente(JButton btnRegistrarCliente) {
		this.btnRegistrarCliente = btnRegistrarCliente;
	}

	public JButton getBtnAfiliarCliente() {
		return btnAfiliarCliente;
	}

	public void setBtnAfiliarCliente(JButton btnAfiliarCliente) {
		this.btnAfiliarCliente = btnAfiliarCliente;
	}

	public JButton getBtnEditarCliente() {
		return btnEditarCliente;
	}

	public void setBtnEditarCliente(JButton btnEditarCliente) {
		this.btnEditarCliente = btnEditarCliente;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
	public void setControl(ControlMenuClientes controlMenuClientes) {
		/*this.btnConsultarProducto.addActionListener(controlMenuProducto);
		this.btnRegistrarProducto.addActionListener(controlMenuProducto);
		this.btnEditarProducto.addActionListener(controlMenuProducto);*/
		this.btnVolver.addActionListener(controlMenuClientes);
		
	}
	
}
