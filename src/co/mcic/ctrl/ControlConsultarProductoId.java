package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.ConsultarProductoId;
import co.mcic.vista.EditarProducto;
import co.mcic.vista.MenuProducto;

public class ControlConsultarProductoId implements ActionListener{
	
	ConsultarProductoId consultarProductoId;
	
	public ConsultarProductoId getConsultarProductoId() {
		return consultarProductoId;
	}

	public void setConsultarProductoId(ConsultarProductoId consultarProductoId) {
		this.consultarProductoId = consultarProductoId;
	}

	public ControlConsultarProductoId(ConsultarProductoId consultarProductoId) {
		this.setConsultarProductoId(consultarProductoId);
		//this.producto = new Producto();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "BUSCAR":
			EditarProducto editarProducto = new EditarProducto();
			ControlEditarProducto controlEditarProducto = new ControlEditarProducto(editarProducto);
			controlEditarProducto.mostrarEditarProducto();
			editarProducto.setControl(controlEditarProducto);
			consultarProductoId.setVisible(false);			
			break;
			
		case "VOLVER":
			MenuProducto menuProducto = new MenuProducto();
			ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
			menuProducto.setControl(controlMenuProducto);
			controlMenuProducto.mostrarMenuProducto();			
			consultarProductoId.setVisible(false);			
			break;	
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}
	
	public void mostrarConsultarProductoId() {
		this.consultarProductoId.setVisible(true);
		this.consultarProductoId.setSize(new Dimension(702,486));
	}

}
