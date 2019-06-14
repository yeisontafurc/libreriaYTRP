package co.mcic.vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarProductoId {

	private JFrame frmConsultarProductoId;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProductoId window = new ConsultarProductoId();
					window.frmConsultarProductoId.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultarProductoId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarProductoId = new JFrame();
		frmConsultarProductoId.setResizable(false);
		frmConsultarProductoId.setTitle("Libreria");
		frmConsultarProductoId.setBounds(100, 100, 702, 486);
		frmConsultarProductoId.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultarProductoId.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR PRODUCTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		frmConsultarProductoId.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese c\u00F3digo del producto");
		lblNewLabel_1.setBounds(120, 117, 247, 14);
		frmConsultarProductoId.getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(120, 217, 125, 14);
		frmConsultarProductoId.getContentPane().add(lblIdentificador);
		
		textField = new JTextField();
		textField.setBounds(270, 214, 253, 20);
		frmConsultarProductoId.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(433, 279, 89, 23);
		frmConsultarProductoId.getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(526, 392, 89, 23);
		frmConsultarProductoId.getContentPane().add(btnVolver);		
	}
}
