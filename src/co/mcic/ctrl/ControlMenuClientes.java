package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.ConsultarCliente;
import co.mcic.vista.ConsultarClienteId;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.RegistrarCliente;

public class ControlMenuClientes implements ActionListener {

	private MenuCliente menuCliente;
	private MenuPrincipal menuPrincipal;

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
			mostrarConsultaClientesId("AFILIAR");
			break;
		case "EDITAR":
			mostrarConsultaClientesId("EDITAR");
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
		this.menuPrincipal.setVisible(true);
		this.menuCliente.setVisible(false);
	}

	public void mostrarConsultaClientesId(String action) {
		ConsultarClienteId consultarCliente = new ConsultarClienteId();
		ControlConsultarClienteId controlConsultarClienteId = new ControlConsultarClienteId(consultarCliente);
		consultarCliente.setControl(controlConsultarClienteId);
		controlConsultarClienteId.setAction(action);
		controlConsultarClienteId.setMenuPrincipal(this.menuPrincipal);
		controlConsultarClienteId.mostrarConsultarClienteId();
		this.menuCliente.setVisible(false);
	}

	public void mostrarConsultaClientes() {
		ConsultarCliente consultarCliente = new ConsultarCliente();
		ControlConsultarCliente controlConsultarCliente = new ControlConsultarCliente(consultarCliente);
		consultarCliente.setControl(controlConsultarCliente);
		controlConsultarCliente.setMenuPrincipal(this.menuPrincipal);
		controlConsultarCliente.mostrarConsultarCliente();
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
		controlRegistrarCliente.setMenuPrincipal(this.menuPrincipal);
		controlRegistrarCliente.mostrarRegistrarCliente();
		this.menuCliente.setVisible(false);
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

}
