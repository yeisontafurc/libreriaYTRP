package co.mcic.vista;

import javax.swing.JFrame;

import co.mcic.ctrl.ControlDetalleProductoVenta;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class DetalleProductoVenta extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtIdentificador;
	private JTextField txtNombre;
	private JTextField txtEstado;
	private JTextField txtValorAlquiler;
	private JTextField txtValorVenta;
	private JButton btnVender, btnAlquilar, btnVolver;
	public DetalleProductoVenta() {
		getContentPane().setLayout(null);
		
		JLabel lblVenderOAlquilar = new JLabel("VENDER O ALQUILAR PRODUCTOS", SwingConstants.CENTER);
		lblVenderOAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenderOAlquilar.setBounds(10, 11, 594, 40);
		getContentPane().add(lblVenderOAlquilar);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProducto.setBounds(36, 62, 60, 30);
		getContentPane().add(lblProducto);
		
		JLabel lblIdentificadorproducto = new JLabel("Identificador", SwingConstants.RIGHT);
		lblIdentificadorproducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdentificadorproducto.setBounds(36, 111, 193, 14);
		getContentPane().add(lblIdentificadorproducto);
		
		txtIdentificador = new JTextField();
		txtIdentificador.setEditable(false);
		txtIdentificador.setBounds(294, 108, 215, 20);
		getContentPane().add(txtIdentificador);
		txtIdentificador.setColumns(10);
		
		JLabel lblNombreproducto = new JLabel("Nombre", SwingConstants.RIGHT);
		lblNombreproducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreproducto.setBounds(120, 138, 109, 14);
		getContentPane().add(lblNombreproducto);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(294, 135, 215, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(294, 162, 215, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblEstadoproducto = new JLabel("Estado", SwingConstants.RIGHT);
		lblEstadoproducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstadoproducto.setBounds(183, 165, 46, 14);
		getContentPane().add(lblEstadoproducto);
		
		txtValorAlquiler = new JTextField();
		txtValorAlquiler.setEditable(false);
		txtValorAlquiler.setBounds(294, 189, 215, 20);
		getContentPane().add(txtValorAlquiler);
		txtValorAlquiler.setColumns(10);
		
		JLabel lblValorAlquilerPor = new JLabel("Valor alquiler por d\u00EDa",SwingConstants.RIGHT);
		lblValorAlquilerPor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorAlquilerPor.setBounds(97, 192, 132, 14);
		getContentPane().add(lblValorAlquilerPor);
		
		JLabel lblValorVenta = new JLabel("Valor Venta", SwingConstants.RIGHT);
		lblValorVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorVenta.setBounds(97, 219, 132, 14);
		getContentPane().add(lblValorVenta);
		
		txtValorVenta = new JTextField();
		txtValorVenta.setEditable(false);
		txtValorVenta.setBounds(294, 216, 215, 20);
		getContentPane().add(txtValorVenta);
		txtValorVenta.setColumns(10);
		
		this.btnVender = new JButton("Vender");
		this.btnVender.setBounds(420, 256, 89, 23);
		this.btnVender.setActionCommand("VENDER");
		getContentPane().add(this.btnVender);
		
		this.btnAlquilar = new JButton("Alquilar");
		this.btnAlquilar.setBounds(324, 256, 89, 23);
		this.btnAlquilar.setActionCommand("ALQUILAR");
		getContentPane().add(this.btnAlquilar);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setBounds(224, 256, 89, 23);
		this.btnVolver.setActionCommand("VOLVER");
		getContentPane().add(this.btnVolver);
	}
	
	public JTextField getTxtIdentificador() {
		return txtIdentificador;
	}

	public void setTxtIdentificador(JTextField txtIdentificador) {
		this.txtIdentificador = txtIdentificador;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
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

	public void setControl(ControlDetalleProductoVenta controlDetaleProductoVenta) {
		this.btnAlquilar.addActionListener(controlDetaleProductoVenta);
		this.btnVender.addActionListener(controlDetaleProductoVenta);
		this.btnVolver.addActionListener(controlDetaleProductoVenta);
		
	}
}
