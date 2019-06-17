package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.MenuVentaAlquiler;
import co.mcic.vista.RecibirAlquilado;

public class ControlVentaAlquiler implements ActionListener {

	private MenuVentaAlquiler mva;
	private MenuPrincipal menuPrincipal;
	public ControlVentaAlquiler(MenuVentaAlquiler mva) {
		this.mva = mva;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "RECIBIR":
			System.out.println("productos");
			RecibirAlquilado recibirAlquilado = new RecibirAlquilado();
			ControlRecibir controlRecibir = new ControlRecibir(recibirAlquilado);
			recibirAlquilado.setControl(controlRecibir);
			controlRecibir.setAlquiler(mva);
			this.mva.setVisible(false);
			this.mva.dispose();
			controlRecibir.mostrarRecibir();
			break;
		case "VENTA":
			System.out.println("VENTA");
			break;
		case "VOLVER":
			System.out.println("VOLVER");
			this.mva.setVisible(false);
			this.mva.dispose();
			this.menuPrincipal.setVisible(true);
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

	public void mostrarVentaAlquiler() {
		this.mva.setVisible(true);
		this.mva.setSize(new Dimension(702,486));
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

}
