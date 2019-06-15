package co.mcic.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlEditarProducto;


public class EditarProducto extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JTextField txfIdentificador;
	private  JTextField txfValorAlquiler;
	private  JTextField txfValorVenta;
	private  JTextField txfNombre;
	private  JButton btnGuardar;
	private  JButton btnVolver;	 
	

	/**
	 * Initialize the contents of the frame.
	 */
	public EditarProducto() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDITAR PRODUCTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(71, 135, 93, 14);
		getContentPane().add(lblIdentificador);
		
		txfIdentificador = new JTextField();
		txfIdentificador.setBounds(153, 132, 197, 20);
		getContentPane().add(txfIdentificador);
		txfIdentificador.setColumns(10);
		
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(250, 313, 89, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblValorAlquiler = new JLabel("Valor alquiler");
		lblValorAlquiler.setBounds(365, 135, 93, 14);
		getContentPane().add(lblValorAlquiler);
		
		txfValorAlquiler = new JTextField();
		txfValorAlquiler.setColumns(10);
		txfValorAlquiler.setBounds(447, 132, 197, 20);
		getContentPane().add(txfValorAlquiler);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(71, 174, 93, 14);
		getContentPane().add(lblNombre);
		
		txfNombre = new JTextField();
		txfNombre.setColumns(10);
		txfNombre.setBounds(153, 171, 197, 20);
		getContentPane().add(txfNombre);
		
		JLabel lblValorVenta = new JLabel("Valor Venta");
		lblValorVenta.setBounds(364, 173, 93, 14);
		getContentPane().add(lblValorVenta);
		
		txfValorVenta = new JTextField();
		txfValorVenta.setColumns(10);
		txfValorVenta.setBounds(446, 170, 197, 20);
		getContentPane().add(txfValorVenta);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(70, 212, 93, 14);
		getContentPane().add(lblCategora);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(363, 211, 93, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(70, 249, 81, 14);
		getContentPane().add(lblDisponibilidad);		
		
		/*cBoxEstadoDisponibilidad = new JComboBox();
		cBoxEstadoDisponibilidad.setBounds(447, 209, 197, 20);		
		getContentPane().add(cBoxEstadoDisponibilidad);*/
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(368, 313, 89, 23);
		getContentPane().add(btnGuardar);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});		
		
	}

	public JTextField getTxfIdentificador() {
		return txfIdentificador;
	}

	public void setTxfIdentificador(JTextField txfIdentificador) {
		this.txfIdentificador = txfIdentificador;
	}

	public JTextField getTxfValorAlquiler() {
		return txfValorAlquiler;
	}

	public void setTxfValorAlquiler(JTextField txfValorAlquiler) {
		this.txfValorAlquiler = txfValorAlquiler;
	}

	public JTextField getTxfValorVenta() {
		return txfValorVenta;
	}

	public void setTxfValorVenta(JTextField txfValorVenta) {
		this.txfValorVenta = txfValorVenta;
	}

	public JTextField getTxfNombre() {
		return txfNombre;
	}

	public void setTxfNombre(JTextField txfNombre) {
		this.txfNombre = txfNombre;
	}
		
	public void setEditarControlador(ControlEditarProducto controlEditarProducto) {
		btnGuardar.addActionListener(controlEditarProducto);
	}
	
	public void setMenuProductoControlador(ControlEditarProducto controlEditarProducto) {
		btnVolver.addActionListener(controlEditarProducto);
	}
}
