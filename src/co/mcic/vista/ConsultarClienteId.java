
package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlConsultarClienteId;
import javax.swing.JComboBox;

public class ConsultarClienteId extends JFrame {

	private JButton btnVolver, btnBuscar;
	private static final long serialVersionUID = 1L;
	private JTextField txtIdentificador;
	private  JComboBox<String> cBoxTipoDocumento;

	/**
	 * Initialize the contents of the frame.
	 */
	public ConsultarClienteId() {

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CONSULTAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 38, 269, 35);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ingrese tipo y número de documento del cliente");
		lblNewLabel_1.setBounds(120, 117, 516, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(120, 231, 125, 14);
		getContentPane().add(lblIdentificador);

		txtIdentificador = new JTextField();
		txtIdentificador.setBounds(270, 228, 253, 20);
		getContentPane().add(txtIdentificador);
		txtIdentificador.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.setBounds(433, 279, 89, 23);
		getContentPane().add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setBounds(526, 392, 89, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(120, 200, 144, 14);
		getContentPane().add(lblTipoDocumento);
		
		cBoxTipoDocumento = new JComboBox<String>();
		cBoxTipoDocumento.setBounds(270, 197, 253, 20);
		getContentPane().add(cBoxTipoDocumento);
	}

	public void setControl(ControlConsultarClienteId consultarClienteId) {
		btnBuscar.addActionListener(consultarClienteId);
		btnVolver.addActionListener(consultarClienteId);
	}

	public JTextField getTxtIdentificador() {
		return txtIdentificador;
	}

	public void setTxtIdentificador(JTextField txtIdentificador) {
		this.txtIdentificador = txtIdentificador;
	}

	public JComboBox<String> getcBoxTipoDocumento() {
		return cBoxTipoDocumento;
	}

	public void setcBoxTipoDocumento(JComboBox<String> cBoxTipoDocumento) {
		this.cBoxTipoDocumento = cBoxTipoDocumento;
	}
	
	
}
