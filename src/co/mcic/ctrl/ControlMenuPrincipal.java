package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.EditarProducto;
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
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "PRODUCTOS":
			System.out.println("productos");			
			MenuProducto menuProducto = new MenuProducto();
			ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
			controlMenuProducto.mostrarMenuProducto();
			menuPrincipal.setVisible(false);
			break;
		case "VENTA Y ALQUILER":
			System.out.println("Venta y alquiler");
			MenuVentaAlquiler mva = new MenuVentaAlquiler();
			ControlVentaAlquiler ventaAlquiler = new ControlVentaAlquiler(mva);
			ventaAlquiler.mostrarVentaAlquiler();
			menuPrincipal.setVisible(false);
			break;
		case "CLIENTES":
			System.out.println("Clientes");
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

}
