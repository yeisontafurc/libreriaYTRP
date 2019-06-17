package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.mcic.vista.ConsultarProductoId;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
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
			JOptionPane.showMessageDialog(null, "Funcionalidad en construcción");
			break;
		case "REGISTRAR":
			ejecutarRegistrarProductos();
			this.menuCliente.setVisible(false);
			break;
		case "AFILIAR":
			
			break;
		case "EDITAR":
			ConsultarProductoId consultarProductoId = new ConsultarProductoId();
			ControlConsultarProductoId controlConsultarProductoId = new ControlConsultarProductoId(consultarProductoId);
			controlConsultarProductoId.mostrarConsultarProductoId();
			consultarProductoId.setControl(controlConsultarProductoId);
			controlConsultarProductoId.mostrarConsultarProductoId();
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

	public void mostrarMenuCliente() {
		this.menuCliente.setVisible(true);
		this.menuCliente.setSize(new Dimension(702, 486));
	}

	public void ejecutarRegistrarProductos() {
		RegistrarProducto registrarProducto = new RegistrarProducto();
		ControlRegistrarProducto controlRegistrarProducto = new ControlRegistrarProducto(registrarProducto);
		registrarProducto.setControl(controlRegistrarProducto);
		controlRegistrarProducto.mostrarRegistrarProducto();
	}

}

