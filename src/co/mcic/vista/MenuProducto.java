package co.mcic.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.mcic.ctrl.ControlEditarProducto;

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
		getContentPane().add(btnConsultarProducto);
		
		btnRegistrarProducto = new JButton("<html><p>Registrar</p><p>Producto</p></html>");
		btnRegistrarProducto.setBounds(396, 116, 138, 77);
		getContentPane().add(btnRegistrarProducto);
		
		btnEditarProducto = new JButton("<html><p>Editar</p><p>Producto</p></html>");
		btnEditarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarProducto editarProducto = new EditarProducto();
				ControlEditarProducto controlEditarProducto = new ControlEditarProducto(editarProducto);
				controlEditarProducto.mostrarEditarProducto();
				editarProducto.setEditarControlador(controlEditarProducto);
				
			}
		});		
		btnEditarProducto.setBounds(167, 232, 138, 77);
		getContentPane().add(btnEditarProducto);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(526, 392, 89, 23);
		getContentPane().add(btnVolver);		
	}
	
}
