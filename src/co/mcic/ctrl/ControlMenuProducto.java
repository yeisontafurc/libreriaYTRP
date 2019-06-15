package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.ConsultarProductoId;
import co.mcic.vista.MenuProducto;

public class ControlMenuProducto implements ActionListener {

	private MenuProducto menuProducto;

	public ControlMenuProducto(MenuProducto menuProducto) {
		this.menuProducto = menuProducto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "EDITAR":
			ConsultarProductoId consultarProductoId = new ConsultarProductoId();
			ControlConsultarProductoId controlConsultarProductoId = new ControlConsultarProductoId(consultarProductoId);
			controlConsultarProductoId.mostrarConsultarProductoId();
			consultarProductoId.setControl(controlConsultarProductoId);
			controlConsultarProductoId.mostrarConsultarProductoId();
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}

	}

	public void mostrarMenuProducto() {
		this.menuProducto.setVisible(true);
		this.menuProducto.setSize(new Dimension(702, 486));
	}

}
