package co.mcic.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import co.mcic.ctrl.ControlFormaRecibir;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormaRecibir extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtIdentificadorProducto;
	private JTextField txtNombreProducto;
	private JTextField txtValorAlquiler;
	private JTextField txtValorVenta;
	private JComboBox<String> comboEstadoProducto;
	private JButton btnRecibir, btnVovler;
	public FormaRecibir() {
		getContentPane().setLayout(null);
		
		JLabel lblRecibirProductoAlquilado = new JLabel("RECIBIR PRODUCTO ALQUILADO", SwingConstants.CENTER);
		lblRecibirProductoAlquilado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRecibirProductoAlquilado.setBounds(10, 27, 663, 36);
		getContentPane().add(lblRecibirProductoAlquilado);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProducto.setBounds(54, 95, 154, 26);
		getContentPane().add(lblProducto);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentificador.setBounds(194, 131, 68, 26);
		getContentPane().add(lblIdentificador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(218, 168, 44, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(223, 205, 39, 26);
		getContentPane().add(lblEstado);
		
		this.comboEstadoProducto = new JComboBox<String>();
		this.comboEstadoProducto.setBounds(325, 208, 154, 20);
		getContentPane().add(this.comboEstadoProducto);
		
		txtIdentificadorProducto = new JTextField();
		txtIdentificadorProducto.setEditable(false);
		txtIdentificadorProducto.setBounds(325, 134, 154, 20);
		getContentPane().add(txtIdentificadorProducto);
		txtIdentificadorProducto.setColumns(10);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setBounds(325, 171, 154, 20);
		getContentPane().add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		JLabel lblValorAlquiler = new JLabel("Valor alquiler por d\u00EDa");
		lblValorAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorAlquiler.setBounds(153, 242, 109, 26);
		getContentPane().add(lblValorAlquiler);
		
		txtValorAlquiler = new JTextField();
		txtValorAlquiler.setBounds(325, 246, 154, 20);
		getContentPane().add(txtValorAlquiler);
		txtValorAlquiler.setColumns(10);
		
		JLabel lblValorVenta = new JLabel("Valor venta");
		lblValorVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorVenta.setBounds(200, 279, 62, 26);
		getContentPane().add(lblValorVenta);
		
		txtValorVenta = new JTextField();
		txtValorVenta.setBounds(325, 283, 154, 20);
		getContentPane().add(txtValorVenta);
		txtValorVenta.setColumns(10);
		
		this.btnRecibir = new JButton("Recibir");
		this.btnRecibir.setBounds(390, 336, 89, 23);
		this.btnRecibir.setActionCommand("RECIBIR");
		getContentPane().add(this.btnRecibir);
		
		this.btnVovler = new JButton("Vovler");
		this.btnVovler.setActionCommand("VOLVER");
		this.btnVovler.setBounds(275, 336, 89, 23);
		getContentPane().add(this.btnVovler);
	}
	public JTextField getTxtIdentificadorProducto() {
		return txtIdentificadorProducto;
	}
	public void setTxtIdentificadorProducto(JTextField txtIdentificadorProducto) {
		this.txtIdentificadorProducto = txtIdentificadorProducto;
	}
	public JTextField getTxtNombreProducto() {
		return txtNombreProducto;
	}
	public void setTxtNombreProducto(JTextField txtNombreProducto) {
		this.txtNombreProducto = txtNombreProducto;
	}
	public JTextField getTxtValorAlquiler() {
		return txtValorAlquiler;
	}
	public void setTxtValorAlquiler(JTextField txtValorAlquiler) {
		this.txtValorAlquiler = txtValorAlquiler;
	}
	public JTextField getTxtValorVenta() {
		return txtValorVenta;
	}
	public void setTxtValorVenta(JTextField txtValorVenta) {
		this.txtValorVenta = txtValorVenta;
	}
	public JComboBox<String> getComboEstadoProducto() {
		return comboEstadoProducto;
	}
	public void setComboEstadoProducto(JComboBox<String> comboEstadoProducto) {
		this.comboEstadoProducto = comboEstadoProducto;
	}
	
	public void setControl(ControlFormaRecibir cfr){
		this.btnRecibir.addActionListener(cfr);
		this.btnVovler.addActionListener(cfr);
	}
	
	
}
