package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
	
public class RegistrarCliente extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private  JTextField txfIdentificacion;
	private  JTextField txfNombres;
	private  JTextField txfApellidos;
	private  JTextField txfCelular;
	private  JTextField txfTelefono;
	private  JTextField txfDireccion;	
	private  JComboBox<String> cBoxEstado;
	private  JComboBox<String> cBoxTipoDocumento;
	
	private  JButton btnGuardar;
	private  JButton btnVolver; 

	

	/**
	 * Initialize the contents of the frame.
	 */
	public RegistrarCliente() {
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(398, 133, 93, 14);
		getContentPane().add(lblIdentificador);
		
		txfIdentificacion = new JTextField();
		txfIdentificacion.setBounds(480, 130, 197, 20);
		getContentPane().add(txfIdentificacion);
		
		
		
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(71, 174, 93, 14);
		getContentPane().add(lblNombre);
		
		
		JLabel lblValorVenta = new JLabel("Apellidos");
		lblValorVenta.setBounds(398, 173, 93, 14);
		getContentPane().add(lblValorVenta);		
		
		
		JLabel lblCategora = new JLabel("Celular");
		lblCategora.setBounds(70, 212, 93, 14);
		getContentPane().add(lblCategora);
		
		JLabel lblEstado = new JLabel("Tel\u00E9fono");
		lblEstado.setBounds(397, 211, 93, 14);
		getContentPane().add(lblEstado);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(398, 243, 81, 14);
		getContentPane().add(lblDisponibilidad);		
		
		cBoxEstado = new JComboBox<String>();		
		cBoxEstado.setBounds(170, 130, 197, 20);		
		getContentPane().add(cBoxEstado);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("GUARDAR");
		btnGuardar.setBounds(385, 338, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(267, 338, 89, 23);
		getContentPane().add(btnVolver);
		
		
		cBoxEstado = new JComboBox<String>();
		cBoxEstado.setBounds(481, 240, 197, 20);
		getContentPane().add(cBoxEstado);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setBounds(71, 133, 93, 14);
		getContentPane().add(lblTipoDeDocumento);
		
		txfNombres = new JTextField();
		txfNombres.setBounds(170, 171, 197, 20);
		getContentPane().add(txfNombres);
		
		
		txfApellidos = new JTextField();
		txfApellidos.setBounds(480, 171, 197, 20);
		getContentPane().add(txfApellidos);
		
		
		txfCelular = new JTextField();
		txfCelular.setBounds(170, 209, 197, 20);
		getContentPane().add(txfCelular);
		
		
		txfTelefono = new JTextField();
		txfTelefono.setBounds(480, 209, 197, 20);
		getContentPane().add(txfTelefono);
		txfTelefono.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(71, 243, 93, 14);
		getContentPane().add(lblDireccin);
		
		txfDireccion = new JTextField();
		txfDireccion.setColumns(10);
		txfDireccion.setBounds(171, 240, 197, 20);
		getContentPane().add(txfDireccion);
		
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


	public JTextField getTxfApellidos() {
		return txfApellidos;
	}


	public void setTxfApellidos(JTextField txfApellidos) {
		this.txfApellidos = txfApellidos;
	}


	public JTextField getTxfCelular() {
		return txfCelular;
	}


	public void setTxfCelular(JTextField txfCelular) {
		this.txfCelular = txfCelular;
	}


	public JTextField getTxfTelefono() {
		return txfTelefono;
	}


	public void setTxfTelefono(JTextField txfTelefono) {
		this.txfTelefono = txfTelefono;
	}


	public JTextField getTxfDireccion() {
		return txfDireccion;
	}


	public void setTxfDireccion(JTextField txfDireccion) {
		this.txfDireccion = txfDireccion;
	}


	public JComboBox<String> getcBoxEstado() {
		return cBoxEstado;
	}


	public void setcBoxEstado(JComboBox<String> cBoxEstado) {
		this.cBoxEstado = cBoxEstado;
	}


	public JComboBox<String> getcBoxTipoDocumento() {
		return cBoxTipoDocumento;
	}


	public void setcBoxTipoDocumento(JComboBox<String> cBoxTipoDocumento) {
		this.cBoxTipoDocumento = cBoxTipoDocumento;
	}
}
