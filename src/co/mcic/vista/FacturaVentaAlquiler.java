package co.mcic.vista;


import javax.swing.JFrame;

import co.mcic.ctrl.ControlFacturaVA;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class FacturaVentaAlquiler extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnRegistrarPago, btnAgregarProductos, btnVolver;
	
	public FacturaVentaAlquiler(Integer nRows) {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setBounds(10, 64, 620, 232);
		getContentPane().add(scrollPane);
		
		table = new JTable(new DefaultTableModel(new Object[]{"Identificador", "Producto", "Venta", "Alquiler","Valor"}, 0));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Identificador").setPreferredWidth(124);
		table.getColumn("Producto").setPreferredWidth(124);
		table.getColumn("Venta").setPreferredWidth(122);
		table.getColumn("Alquiler").setPreferredWidth(122);
		table.getColumn("Valor").setPreferredWidth(124);
		
		
		scrollPane.setOpaque(true);
		
		
		JLabel lblVenderOAlquilar = new JLabel("VENDER O ALQUILAR PRODUCTOS", SwingConstants.CENTER);
		lblVenderOAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenderOAlquilar.setBounds(10, 11, 624, 40);
		getContentPane().add(lblVenderOAlquilar);
		
		this.btnRegistrarPago = new JButton("Registrar pago");
		this.btnRegistrarPago.setBounds(496, 358, 138, 23);
		this.btnRegistrarPago.setActionCommand("PAGAR");
		getContentPane().add(this.btnRegistrarPago);
		
		this.btnAgregarProductos = new JButton("Agregar productos");
		this.btnAgregarProductos.setBounds(325, 358, 161, 23);
		this.btnAgregarProductos.setActionCommand("AGREGAR");
		getContentPane().add(this.btnAgregarProductos);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setBounds(226, 358, 89, 23);
		this.btnVolver.setActionCommand("VOLVER");
		getContentPane().add(this.btnVolver);
		
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}



	public void setControl(ControlFacturaVA controlFacturaVA) {
		this.btnRegistrarPago.addActionListener(controlFacturaVA);
		this.btnAgregarProductos.addActionListener(controlFacturaVA);
		this.btnVolver.addActionListener(controlFacturaVA);
	}
}
