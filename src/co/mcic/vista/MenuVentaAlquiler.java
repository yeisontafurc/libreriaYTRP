package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import co.mcic.ctrl.ControlVentaAlquiler;


public class MenuVentaAlquiler extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnRecibir, btnVenta, btnVolver;
	
	public MenuVentaAlquiler(){
		getContentPane().setLayout(null);

		this.btnRecibir = new JButton("<html>RECIBIR PRODUCTO<br>ALQUILADO</html>");
		this.btnRecibir.setVisible(true);
		this.btnRecibir.setActionCommand("RECIBIR");
		this.btnRecibir.setBounds(106, 131, 154, 80);
		getContentPane().add(btnRecibir);


		this.btnVenta = new JButton("REGISTRAR VENTA");
		this.btnVenta.setVisible(true);
		this.btnVenta.setActionCommand("VENTA");
		this.btnVenta.setBounds(296, 131, 154, 80);
		getContentPane().add(btnVenta);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(361, 301, 89, 23);
		this.btnVolver.setActionCommand("VOLVER");
		getContentPane().add(btnVolver);

		JLabel MenuVentaAlquiler= new JLabel("VENTAS Y ALQUILER", SwingConstants.CENTER);
		MenuVentaAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MenuVentaAlquiler.setBounds(106, 33, 344, 32);
		
		getContentPane().add(MenuVentaAlquiler);
	}
	public void setControl(ControlVentaAlquiler controlVentaAlquiler){
		// btnRecibir, btnVenta, btnVolver;
		this.btnRecibir.addActionListener(controlVentaAlquiler);
		this.btnVenta.addActionListener(controlVentaAlquiler);
		this.btnVolver.addActionListener(controlVentaAlquiler);
	}
}
