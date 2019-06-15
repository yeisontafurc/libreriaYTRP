package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVentaAlquiler extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnRecibir, btnVenta, btnSalir;
	
	public MenuVentaAlquiler(){
		getContentPane().setLayout(null);

		this.btnRecibir = new JButton("<html>RECIBIR PRODUCTO<br>ALQUILADO</html>");
		btnRecibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.btnRecibir.setVisible(true);
		this.btnRecibir.setActionCommand("RECIBIR");
		this.btnRecibir.setBounds(106, 131, 154, 80);
		getContentPane().add(btnRecibir);


		this.btnVenta = new JButton("REGISTRAR VENTA");
		this.btnVenta.setVisible(true);
		this.btnVenta.setActionCommand("VENTA");
		this.btnVenta.setBounds(296, 131, 154, 80);
		getContentPane().add(btnVenta);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(361, 301, 89, 23);
		this.btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);

		JLabel MenuVentaAlquiler= new JLabel("VENTAS Y ALQUILER", SwingConstants.CENTER);
		MenuVentaAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MenuVentaAlquiler.setBounds(106, 33, 344, 32);
		
		getContentPane().add(MenuVentaAlquiler);
	}
}
