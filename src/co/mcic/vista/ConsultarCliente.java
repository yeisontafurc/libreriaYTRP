package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;

import co.mcic.ctrl.ControlConsultarCliente;
import javax.swing.JTable;

public class ConsultarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txfIdentificacion;
	private JTextField txfNombres;

	private JButton btnGuardar;
	private JButton btnVolver;
	private JTable table;

	/**
	 * Initialize the contents of the frame.
	 */
	public ConsultarCliente() {

		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setBounds(45, 196, 897, 259);
		getContentPane().add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[] { "Tipo Documento", "Identificador", "Nombres", "Apellidos",
				"Dirección", "Teléfono", "Celular", "Estado", "Tipo Afiliación", "Fecha Fin Afiliación" }, 0));
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Tipo Documento").setPreferredWidth(132);
		table.getColumn("Identificador").setPreferredWidth(124);
		table.getColumn("Nombres").setPreferredWidth(132);
		table.getColumn("Apellidos").setPreferredWidth(132);
		table.getColumn("Dirección").setPreferredWidth(124);
		table.getColumn("Teléfono").setPreferredWidth(124);
		table.getColumn("Celular").setPreferredWidth(124);
		table.getColumn("Estado").setPreferredWidth(124);
		table.getColumn("Tipo Afiliación").setPreferredWidth(124);
		table.getColumn("Fecha Fin Afiliación").setPreferredWidth(124);
		
		scrollPane.setOpaque(true);

		JLabel lblNewLabel = new JLabel("CONSULTAR CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(45, 112, 93, 14);
		getContentPane().add(lblIdentificador);

		txfIdentificacion = new JTextField();
		txfIdentificacion.setBounds(127, 109, 197, 20);
		getContentPane().add(txfIdentificacion);

		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(345, 108, 93, 14);
		getContentPane().add(lblNombre);

		btnGuardar = new JButton("Buscar");
		btnGuardar.setActionCommand("BUSCAR");
		btnGuardar.setBounds(375, 151, 89, 23);
		getContentPane().add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(257, 151, 89, 23);
		getContentPane().add(btnVolver);

		txfNombres = new JTextField();
		txfNombres.setBounds(428, 109, 197, 20);
		getContentPane().add(txfNombres);

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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
		getContentPane().add(new JScrollPane(table));
	}

	public void setControl(ControlConsultarCliente controlConsultarCliente) {
		this.btnVolver.addActionListener(controlConsultarCliente);
		this.btnGuardar.addActionListener(controlConsultarCliente);
	}
}
