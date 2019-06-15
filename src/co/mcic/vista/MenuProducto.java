package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.mcic.ctrl.ControlMenuProducto;

public class MenuProducto extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnConsultarProducto, btnRegistrarProducto, btnEditarProducto,btnVolver;

	/**
	 * Create the application.
	 */
	public MenuProducto() {
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
		
		btnConsultarProducto = new JButton("<html><p>Consultar</p><p>Producto</p></html>");
		btnConsultarProducto.setBounds(167, 116, 138, 77);
		btnConsultarProducto.setActionCommand("CONSULTAR");
		getContentPane().add(btnConsultarProducto);
		
		btnRegistrarProducto = new JButton("<html><p>Registrar</p><p>Producto</p></html>");
		btnRegistrarProducto.setBounds(396, 116, 138, 77);
		btnRegistrarProducto.setActionCommand("REGISTRAR");
		getContentPane().add(btnRegistrarProducto);
		
		btnEditarProducto = new JButton("<html><p>Editar</p><p>Producto</p></html>");			
		btnEditarProducto.setBounds(167, 232, 138, 77);
		btnEditarProducto.setActionCommand("EDITAR");
		getContentPane().add(btnEditarProducto);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(526, 392, 89, 23);
		btnVolver.setActionCommand("VOLVER");
		getContentPane().add(btnVolver);		
	}

	public JButton getBtnConsultarProducto() {
		return btnConsultarProducto;
	}

	public void setBtnConsultarProducto(JButton btnConsultarProducto) {
		this.btnConsultarProducto = btnConsultarProducto;
	}

	public JButton getBtnRegistrarProducto() {
		return btnRegistrarProducto;
	}

	public void setBtnRegistrarProducto(JButton btnRegistrarProducto) {
		this.btnRegistrarProducto = btnRegistrarProducto;
	}

	public JButton getBtnEditarProducto() {
		return btnEditarProducto;
	}

	public void setBtnEditarProducto(JButton btnEditarProducto) {
		this.btnEditarProducto = btnEditarProducto;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
	public void setControl(ControlMenuProducto controlMenuProducto) {
		this.btnConsultarProducto.addActionListener(controlMenuProducto);
		this.btnRegistrarProducto.addActionListener(controlMenuProducto);
		this.btnEditarProducto.addActionListener(controlMenuProducto);
		this.btnVolver.addActionListener(controlMenuProducto);
		
	}
	
}
