package co.mcic.vista;

import javax.swing.JFrame;

import co.mcic.ctrl.ControlVentaCliente;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentaUbicaCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroId;
	private JComboBox<String> comboTipoDoc;
	private JButton btnBuscar, btnVolver;
	
	public VentaUbicaCliente() {
		getContentPane().setLayout(null);
		
		JLabel lblVenderOAlquilar = new JLabel("VENDER O ALQUILAR PRODUCTOS", SwingConstants.CENTER);
		lblVenderOAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenderOAlquilar.setBounds(10, 27, 519, 35);
		getContentPane().add(lblVenderOAlquilar);
		
		JLabel lblIngreseTipoY = new JLabel("Ingrese tipo y n\u00FAmero de documento del cliente:");
		lblIngreseTipoY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIngreseTipoY.setBounds(51, 85, 304, 27);
		getContentPane().add(lblIngreseTipoY);
		
		JLabel lblTipoDocumento = new JLabel("Tipo documento");
		lblTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDocumento.setBounds(140, 133, 92, 27);
		getContentPane().add(lblTipoDocumento);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmero.setBounds(186, 174, 46, 27);
		getContentPane().add(lblNmero);
		
		txtNumeroId = new JTextField();
		txtNumeroId.setBounds(279, 177, 139, 20);
		getContentPane().add(txtNumeroId);
		txtNumeroId.setColumns(10);
		
		this.comboTipoDoc = new JComboBox<String>();
		this.comboTipoDoc.setBounds(279, 136, 139, 20);
		getContentPane().add(this.comboTipoDoc);
		
		this.btnBuscar = new JButton("Buscar");
		this.btnBuscar.setActionCommand("BUSCAR");
		this.btnBuscar.setBounds(333, 226, 89, 23);
		getContentPane().add(this.btnBuscar);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		this.btnVolver.setBounds(234, 226, 89, 23);
		getContentPane().add(this.btnVolver);
	}
	
	

	public JTextField getTxtNumeroId() {
		return txtNumeroId;
	}

	public void setTxtNumeroId(JTextField txtNumeroId) {
		this.txtNumeroId = txtNumeroId;
	}

	public JComboBox<String> getComboTipoDoc() {
		return comboTipoDoc;
	}

	public void setComboTipoDoc(JComboBox<String> comboBox) {
		this.comboTipoDoc = comboBox;
	}


	public void setControl(ControlVentaCliente controlVentaCliente) {
		this.btnBuscar.addActionListener(controlVentaCliente);
		this.btnVolver.addActionListener(controlVentaCliente);
	}
}
