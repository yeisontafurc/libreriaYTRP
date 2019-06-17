package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlEditarProducto;
import co.mcic.ctrl.ControlRegistrarProducto;

	
public class RegistrarProducto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private  JTextField txfIdentificador;
	private  JTextField txfValorAlquiler;
	private  JTextField txfValorVenta;
	private  JTextField txfNombre;
	private  JComboBox<String> cBoxEstadoDisponibilidad;
	private  JComboBox<String> cBoxCategoria;
	private  JComboBox<String> cBoxEstado;
	private  JButton btnGuardar;
	private  JButton btnVolver;	 
	

	/**
	 * Initialize the contents of the frame.
	 */
	public RegistrarProducto() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR PRODUCTO");
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
		btnVolver.setActionCommand("VOLVER");
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
		
		cBoxEstado = new JComboBox<String>();		
		cBoxEstado.setBounds(447, 209, 197, 20);		
		getContentPane().add(cBoxEstado);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("GUARDAR");
		btnGuardar.setBounds(368, 313, 89, 23);
		getContentPane().add(btnGuardar);		
		
		cBoxCategoria = new JComboBox<String>();
		cBoxCategoria.setBounds(153, 209, 197, 20);
		getContentPane().add(cBoxCategoria);
		
		cBoxEstadoDisponibilidad = new JComboBox<String>();
		cBoxEstadoDisponibilidad.setBounds(153, 246, 197, 20);
		getContentPane().add(cBoxEstadoDisponibilidad);
		
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
	

	public JComboBox<String> getcBoxEstadoDisponibilidad() {
		return cBoxEstadoDisponibilidad;
	}

	public void setcBoxEstadoDisponibilidad(JComboBox<String> cBoxEstadoDisponibilidad) {
		this.cBoxEstadoDisponibilidad = cBoxEstadoDisponibilidad;
	}
	
	

	public JComboBox<String> getcBoxCategoria() {
		return cBoxCategoria;
	}

	public void setcBoxCategoria(JComboBox<String> cBoxCategoria) {
		this.cBoxCategoria = cBoxCategoria;
	}

	public JComboBox<String> getcBoxEstado() {
		return cBoxEstado;
	}

	public void setcBoxEstado(JComboBox<String> cBoxEstado) {
		this.cBoxEstado = cBoxEstado;
	}

	public void setControl(ControlRegistrarProducto controlRegistrarProducto) {		
		this.btnVolver.addActionListener(controlRegistrarProducto);
		this.btnGuardar.addActionListener(controlRegistrarProducto);
	}
}
