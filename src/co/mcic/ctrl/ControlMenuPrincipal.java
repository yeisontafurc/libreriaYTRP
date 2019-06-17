package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.MenuProducto;
import co.mcic.vista.MenuVentaAlquiler;

public class ControlMenuPrincipal implements ActionListener{

	private MenuPrincipal menuPrincipal;
	
	public ControlMenuPrincipal(MenuPrincipal mp) {
		this.menuPrincipal = mp;
	}

	public void mostrarMenuPrincipal(){
		this.menuPrincipal.setVisible(true);
		this.menuPrincipal.setSize(new Dimension(702,486));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "PRODUCTOS":
			System.out.println("productos");			
			MenuProducto menuProducto = new MenuProducto();
			ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
			menuProducto.setControl(controlMenuProducto);
			controlMenuProducto.mostrarMenuProducto();
			menuPrincipal.setVisible(false);
			break;
		case "VENTA Y ALQUILER":
			System.out.println("Venta y alquiler");
			MenuVentaAlquiler mva = new MenuVentaAlquiler();
			ControlVentaAlquiler ventaAlquiler = new ControlVentaAlquiler(mva);
			mva.setControl(ventaAlquiler);
			ventaAlquiler.setMenuPrincipal(this.menuPrincipal);
			ventaAlquiler.mostrarVentaAlquiler();
			menuPrincipal.setVisible(false);
			break;
		case "CLIENTES":
			MenuCliente menuCliente = new MenuCliente();
			ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
			menuCliente.setControl(controlMenuClientes);
			controlMenuClientes.mostrarMenuCliente();
			menuPrincipal.setVisible(false);
			break;
		case "SALIR":
			menuPrincipal.setVisible(false);
			menuPrincipal.dispose();
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

}
