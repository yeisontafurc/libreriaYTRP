package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlConsultarCliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


	
public class ConsultarCliente extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private  JTextField txfIdentificacion;
	private  JTextField txfNombres;	
	
	private  JButton btnGuardar;
	private  JButton btnVolver; 

	

	/**
	 * Initialize the contents of the frame.
	 */
	public ConsultarCliente() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(45, 112, 93, 14);
		getContentPane().add(lblIdentificador);
		
		txfIdentificacion = new JTextField();
		txfIdentificacion.setBounds(127, 109, 197, 20);
		getContentPane().add(txfIdentificacion);
		
		
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(345, 108, 93, 14);
		getContentPane().add(lblNombre);
						
		
		btnGuardar = new JButton("Buscar");		
		btnGuardar.setActionCommand("BUSCAR");
		btnGuardar.setBounds(375, 151, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(257, 151, 89, 23);
		getContentPane().add(btnVolver);
		
		txfNombres = new JTextField();
		txfNombres.setBounds(428, 109, 197, 20);
		getContentPane().add(txfNombres);
		
	}


	
	
	public JTextField getTxfIdentificacion() {
		return txfIdentificacion;
	}




	public void setTxfIdentificacion(JTextField txfIdentificacion) {
		this.txfIdentificacion = txfIdentificacion;
	}




	public JTextField getTxfNombres() {
		return txfNombres;
	}




	public void setTxfNombres(JTextField txfNombres) {
		this.txfNombres = txfNombres;
	}




	public void setControl(ControlConsultarCliente controlConsultarCliente) {		
		this.btnVolver.addActionListener(controlConsultarCliente);
		this.btnGuardar.addActionListener(controlConsultarCliente);
	}
}
