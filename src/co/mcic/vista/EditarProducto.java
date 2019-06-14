package co.mcic.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditarProducto {

	private JFrame frmEditarProducto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProducto window = new EditarProducto();
					window.frmEditarProducto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarProducto = new JFrame();
		frmEditarProducto.setResizable(false);
		frmEditarProducto.setBounds(100, 100, 702, 486);
		frmEditarProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditarProducto.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("EDITAR PRODUCTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		frmEditarProducto.getContentPane().add(lblNewLabel);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(71, 135, 93, 14);
		frmEditarProducto.getContentPane().add(lblIdentificador);
		
		textField = new JTextField();
		textField.setBounds(153, 132, 197, 20);
		frmEditarProducto.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(368, 313, 89, 23);
		frmEditarProducto.getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(250, 313, 89, 23);
		frmEditarProducto.getContentPane().add(btnVolver);
		
		JLabel lblValorAlquiler = new JLabel("Valor alquiler");
		lblValorAlquiler.setBounds(365, 135, 93, 14);
		frmEditarProducto.getContentPane().add(lblValorAlquiler);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(447, 132, 197, 20);
		frmEditarProducto.getContentPane().add(textField_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(71, 174, 93, 14);
		frmEditarProducto.getContentPane().add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 171, 197, 20);
		frmEditarProducto.getContentPane().add(textField_2);
		
		JLabel lblValorVenta = new JLabel("Valor Venta");
		lblValorVenta.setBounds(364, 173, 93, 14);
		frmEditarProducto.getContentPane().add(lblValorVenta);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(446, 170, 197, 20);
		frmEditarProducto.getContentPane().add(textField_3);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(70, 212, 93, 14);
		frmEditarProducto.getContentPane().add(lblCategora);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(363, 211, 93, 14);
		frmEditarProducto.getContentPane().add(lblEstado);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(70, 249, 81, 14);
		frmEditarProducto.getContentPane().add(lblDisponibilidad);
		
		
		
	}

}
