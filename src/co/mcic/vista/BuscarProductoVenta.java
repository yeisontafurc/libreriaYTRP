package co.mcic.vista;

import javax.swing.JFrame;

import co.mcic.ctrl.ControlBuscarProducto;
import co.mcic.dominio.Persona;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BuscarProductoVenta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtCliente;
	private JTextField txtId;
	private JButton btnBuscar, btnVolver;
	public BuscarProductoVenta() {
		getContentPane().setLayout(null);
		
		JLabel lblVenderOAlquilar = new JLabel("VENDER O ALQUILAR PRODUCTOS", SwingConstants.CENTER);
		lblVenderOAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblVenderOAlquilar.setBounds(10, 11, 569, 41);
		getContentPane().add(lblVenderOAlquilar);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(98, 77, 45, 25);
		getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(259, 81, 180, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblIngreseElIdentificador = new JLabel("Ingrese el identificador del producto a vender o alquilar");
		lblIngreseElIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIngreseElIdentificador.setBounds(98, 127, 341, 25);
		getContentPane().add(lblIngreseElIdentificador);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(98, 174, 69, 25);
		getContentPane().add(lblProducto);
		
		txtId = new JTextField();
		txtId.setBounds(259, 176, 180, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		this.btnBuscar = new JButton("Buscar");
		this.btnBuscar.setActionCommand("BUSCAR");
		this.btnBuscar.setBounds(351, 228, 89, 23);
		getContentPane().add(this.btnBuscar);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		this.btnVolver.setBounds(259, 228, 89, 23);
		getContentPane().add(this.btnVolver);
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(JTextField txtCliente) {
		this.txtCliente = txtCliente;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField textField) {
		this.txtId = textField;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public void setControl(ControlBuscarProducto consultarBuscarProducto) {
		this.btnBuscar.addActionListener(consultarBuscarProducto);
		this.btnVolver.addActionListener(consultarBuscarProducto);
		
	}

	public void setCliente(Persona cliente) {
		this.txtCliente.setText(cliente.getNombres()+ " "+cliente.getApellidos());
	}

}
