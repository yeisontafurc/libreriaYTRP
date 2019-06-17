package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.mcic.vista.ConsultarCliente;
import co.mcic.vista.ConsultarProductoId;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.RegistrarCliente;
import co.mcic.vista.RegistrarProducto;

public class ControlMenuClientes implements ActionListener {

	private MenuCliente menuCliente; 

	public ControlMenuClientes(MenuCliente menuCliente) {
		this.menuCliente = menuCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "CONSULTAR":
			mostrarConsultaClientes();
			
			break;
		case "REGISTRAR":
			mostrarRegistrarCliente();			
			break;
		case "AFILIAR":
			
			break;
		case "EDITAR":
			
			this.menuCliente.setVisible(false);
			break;
		case "VOLVER":
			mostrarMenuPrincipal();
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}

	}

	public void mostrarMenuPrincipal() {
		MenuPrincipal mp = new MenuPrincipal();
		ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(mp);
		mp.setControl(controlMenuPrincipal);
		controlMenuPrincipal.mostrarMenuPrincipal();
		this.menuCliente.setVisible(false);
	}
	
	
	public void mostrarConsultaClientes() {
		ConsultarCliente consultarCliente = new ConsultarCliente();
		ControlConsultarCliente controlMenuPrincipal = new ControlConsultarCliente(consultarCliente);
		consultarCliente.setControl(controlMenuPrincipal);
		controlMenuPrincipal.mostrarConsultarCliente();
		this.menuCliente.setVisible(false);
	}

	public void mostrarMenuCliente() {
		this.menuCliente.setVisible(true);
		this.menuCliente.setSize(new Dimension(702, 486));
	}

	public void mostrarRegistrarCliente() {
		RegistrarCliente registrarCliente = new RegistrarCliente();
		ControlRegistrarCliente controlRegistrarCliente = new ControlRegistrarCliente(registrarCliente);
		registrarCliente.setControl(controlRegistrarCliente);
		controlRegistrarCliente.mostrarRegistrarCliente();
		this.menuCliente.setVisible(false);
	}

}
