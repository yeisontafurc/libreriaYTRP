package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlConsultarProductoId;

public class ConsultarProductoId extends JFrame {
	
	private JButton btnVolver,btnBuscar;
	private static final long serialVersionUID = 1L;	
	private JTextField txtIdentificador;
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public ConsultarProductoId() {

		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR PRODUCTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese c\u00F3digo del producto");
		lblNewLabel_1.setBounds(120, 117, 247, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(120, 217, 125, 14);
		getContentPane().add(lblIdentificador);
		
		txtIdentificador = new JTextField();
		txtIdentificador.setBounds(270, 214, 253, 20);
		getContentPane().add(txtIdentificador);
		txtIdentificador.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.setBounds(433, 279, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(526, 392, 89, 23);
		getContentPane().add(btnVolver);		
	}
	
	
	public void setControl(ControlConsultarProductoId consultarProductoId) {
		btnBuscar.addActionListener(consultarProductoId);
		btnVolver.addActionListener(consultarProductoId);
	}


	public JTextField getTxtIdentificador() {
		return txtIdentificador;
	}


	public void setTxtIdentificador(JTextField txtIdentificador) {
		this.txtIdentificador = txtIdentificador;
	}
	
	
	
}
