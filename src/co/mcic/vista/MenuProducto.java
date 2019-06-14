package co.mcic.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuProducto {

	private JFrame frmMenuProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuProducto window = new MenuProducto();
					window.frmMenuProducto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmMenuProducto = new JFrame();
		frmMenuProducto.setResizable(false);
		frmMenuProducto.setTitle("Libreria");
		frmMenuProducto.setBounds(100, 100, 702, 486);
		frmMenuProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuProducto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(259, 43, 269, 35);
		frmMenuProducto.getContentPane().add(lblNewLabel);
		
		JButton btnConsultarProducto = new JButton("<html><p>Consultar</p><p>Producto</p></html>");
		btnConsultarProducto.setBounds(167, 116, 138, 77);
		frmMenuProducto.getContentPane().add(btnConsultarProducto);
		
		JButton btnRegistrarProducto = new JButton("<html><p>Registrar</p><p>Producto</p></html>");
		btnRegistrarProducto.setBounds(396, 116, 138, 77);
		frmMenuProducto.getContentPane().add(btnRegistrarProducto);
		
		JButton btnEditarProducto = new JButton("<html><p>Editar</p><p>Producto</p></html>");
		btnEditarProducto.setBounds(167, 232, 138, 77);
		frmMenuProducto.getContentPane().add(btnEditarProducto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(526, 392, 89, 23);
		frmMenuProducto.getContentPane().add(btnVolver);
	}
}
