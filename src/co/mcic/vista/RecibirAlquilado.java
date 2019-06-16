package co.mcic.vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import co.mcic.ctrl.ControlRecibir;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RecibirAlquilado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtProducto;
	private JButton btnBuscar, btnVolver;

	public RecibirAlquilado() {
		getContentPane().setLayout(null);
		
		JLabel recibirAlquiler = new JLabel("RECIBIR PRODUCTO ALQUILADO", SwingConstants.CENTER);
		recibirAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 25));
		recibirAlquiler.setBounds(10, 33, 666, 32);
		getContentPane().add(recibirAlquiler);
		
		JLabel lblIngreseElIdentificador = new JLabel("Ingrese el identificador del producto a recibir");
		lblIngreseElIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngreseElIdentificador.setBounds(71, 112, 460, 14);
		getContentPane().add(lblIngreseElIdentificador);
		
		JLabel lblProducto = new JLabel("Producto ");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProducto.setBounds(179, 162, 113, 22);
		getContentPane().add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProducto.setBounds(292, 163, 167, 20);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		this.btnBuscar = new JButton("Buscar");
		this.btnBuscar.setActionCommand("BUSCAR");
		this.btnBuscar.setBounds(292, 227, 89, 23);
		getContentPane().add(this.btnBuscar);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		this.btnVolver.setBounds(567, 266, 89, 23);
		getContentPane().add(this.btnVolver);
	}

	
	
	public JTextField getTxtProducto() {
		return txtProducto;
	}



	public void setTxtProducto(JTextField txtProducto) {
		this.txtProducto = txtProducto;
	}



	public void setControl(ControlRecibir controlRecibir) {
		this.btnBuscar.addActionListener(controlRecibir);
		this.btnVolver.addActionListener(controlRecibir);
	}


	
}
