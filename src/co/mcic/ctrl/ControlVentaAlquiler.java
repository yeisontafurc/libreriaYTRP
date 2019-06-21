package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.dominio.Usuario;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.MenuVentaAlquiler;
import co.mcic.vista.RecibirAlquilado;
import co.mcic.vista.VentaUbicaCliente;

public class ControlVentaAlquiler implements ActionListener {

	private MenuVentaAlquiler mva;
	private MenuPrincipal menuPrincipal;
	private Usuario usuario;
	public Usuario getUsuario() {
		return usuario;
	}

	public ControlVentaAlquiler(MenuVentaAlquiler mva) {
		this.mva = mva;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "RECIBIR":
			RecibirAlquilado recibirAlquilado = new RecibirAlquilado();
			ControlRecibir controlRecibir = new ControlRecibir(recibirAlquilado);
			recibirAlquilado.setControl(controlRecibir);
			controlRecibir.setAlquiler(mva);
			this.mva.setVisible(false);
			this.mva.dispose();
			controlRecibir.mostrarRecibir();
			break;
		case "VENTA":
			VentaUbicaCliente ventaUbicaCliente = new VentaUbicaCliente();
			ControlVentaCliente controlVentaCliente = new ControlVentaCliente(ventaUbicaCliente);
			ventaUbicaCliente.setControl(controlVentaCliente);
			controlVentaCliente.setVolver(this.mva);
			controlVentaCliente.setUsuario(usuario);
			this.mva.setVisible(false);
			this.mva.dispose();
			controlVentaCliente.mostrarVentaCliente();
			break;
		case "VOLVER":
			System.out.println("VOLVER");
			this.mva.setVisible(false);
			this.mva.dispose();
			this.menuPrincipal.setVisible(true);
			break;
		default:
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

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
