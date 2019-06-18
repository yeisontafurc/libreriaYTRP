package co.mcic.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import co.mcic.ctrl.ControlConsultarCliente;
import javax.swing.JTable;


	
public class ConsultarCliente extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private  JTextField txfIdentificacion;
	private  JTextField txfNombres;	
	
	private  JButton btnGuardar;
	private  JButton btnVolver; 
	
	
    private JTable table;
	

	/**
	 * Initialize the contents of the frame.
	 */
	public ConsultarCliente() {
		
		getContentPane().setLayout(null);
		
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
		
		//private JTable table;
		String[] columns = new String[] {
	            "Id", "Name", "Hourly Rate", "Part Time"
	        };
	    //actual data for the table in a 2d array
	    Object[][] data = new Object[][] {
	        {1, "John", 40.0, false },
	        {2, "Rambo", 70.0, false },
	        {3, "Zorro", 60.0, true },
	    };
	    //create table with data
	    table = new JTable(data, columns);
		table.setBounds(81, 261, 561, -30);
		getContentPane().add(table);
		
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
		this.add(new JScrollPane(table));
	}




	public void setControl(ControlConsultarCliente controlConsultarCliente) {		
		this.btnVolver.addActionListener(controlConsultarCliente);
		this.btnGuardar.addActionListener(controlConsultarCliente);
	}
}
