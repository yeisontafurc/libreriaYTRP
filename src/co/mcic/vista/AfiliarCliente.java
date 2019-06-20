package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlAfiliarCliente;

public class AfiliarCliente extends JFrame {

	private static final long serialVersionUID = 2626697118900509684L;
	private JTextField txfIdentificacion;
	private JTextField txfTipoDocumento;

	private JButton btnGuardar;
	private JButton btnVolver;
	private JTextField txtInicioAfiliacion;
	private JTextField txtFinAfiliacion;
	private JComboBox<String> cBoxTipoAfiliacion;

	public AfiliarCliente() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("AFILIAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);

		JLabel lblTipoDocumento = new JLabel("Tipo de documento");
		lblTipoDocumento.setBounds(67, 133, 129, 14);
		getContentPane().add(lblTipoDocumento);

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(418, 133, 93, 14);
		getContentPane().add(lblIdentificador);

		txfTipoDocumento = new JTextField();
		txfTipoDocumento.setEditable(false);
		txfTipoDocumento.setBounds(205, 130, 176, 20);
		getContentPane().add(txfTipoDocumento);

		txfIdentificacion = new JTextField();
		txfIdentificacion.setEditable(false);
		txfIdentificacion.setBounds(500, 130, 197, 20);
		getContentPane().add(txfIdentificacion);

		// UtilDateModel model = new UtilDateModel();
		// JDatePanelImpl datePanel = new JDatePanelImpl(model);
		// JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		//
		// getContentPane().add(datePicker);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("GUARDAR");
		btnGuardar.setBounds(427, 351, 89, 23);
		getContentPane().add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(309, 351, 89, 23);
		getContentPane().add(btnVolver);

		JLabel lblFechaInicioAfiliacin = new JLabel("Inicio Afiliaci\u00F3n");
		lblFechaInicioAfiliacin.setBounds(67, 176, 115, 14);
		getContentPane().add(lblFechaInicioAfiliacin);

		txtInicioAfiliacion = new JTextField();
		txtInicioAfiliacion.setBounds(205, 173, 176, 20);
		getContentPane().add(txtInicioAfiliacion);

		JLabel lblFinAfiliacin = new JLabel("Fin Afiliaci\u00F3n");
		lblFinAfiliacin.setBounds(418, 176, 78, 14);
		getContentPane().add(lblFinAfiliacin);

		txtFinAfiliacion = new JTextField();
		txtFinAfiliacion.setEditable(false);
		txtFinAfiliacion.setBounds(500, 173, 197, 20);
		getContentPane().add(txtFinAfiliacion);

		JLabel lblTipoAfiliacin = new JLabel("Tipo Afiliaci\u00F3n");
		lblTipoAfiliacin.setBounds(67, 227, 115, 14);
		getContentPane().add(lblTipoAfiliacin);

		cBoxTipoAfiliacion = new JComboBox<String>();
		cBoxTipoAfiliacion.setBounds(205, 224, 176, 20);
		getContentPane().add(cBoxTipoAfiliacion);

	}

	
	public JTextField getTxfIdentificacion() {
		return txfIdentificacion;
	}


	public void setTxfIdentificacion(JTextField txfIdentificacion) {
		this.txfIdentificacion = txfIdentificacion;
	}


	public JTextField getTxfTipoDocumento() {
		return txfTipoDocumento;
	}


	public void setTxfTipoDocumento(JTextField txfTipoDocumento) {
		this.txfTipoDocumento = txfTipoDocumento;
	}


	public JTextField getTxtInicioAfiliacion() {
		return txtInicioAfiliacion;
	}


	public void setTxtInicioAfiliacion(JTextField txtInicioAfiliacion) {
		this.txtInicioAfiliacion = txtInicioAfiliacion;
	}


	public JTextField getTxtFinAfiliacion() {
		return txtFinAfiliacion;
	}


	public void setTxtFinAfiliacion(JTextField txtFinAfiliacion) {
		this.txtFinAfiliacion = txtFinAfiliacion;
	}


	public JComboBox<String> getcBoxTipoAfiliacion() {
		return cBoxTipoAfiliacion;
	}


	public void setcBoxTipoAfiliacion(JComboBox<String> cBoxTipoAfiliacion) {
		this.cBoxTipoAfiliacion = cBoxTipoAfiliacion;
	}


	public void setControl(ControlAfiliarCliente controlAfiliarCliente) {
		this.btnVolver.addActionListener(controlAfiliarCliente);
		this.btnGuardar.addActionListener(controlAfiliarCliente);
	}
}
