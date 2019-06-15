package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.ConsultarProductoId;

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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrarConsultarProductoId() {
		this.consultarProductoId.setVisible(true);
		this.consultarProductoId.setSize(new Dimension(702,486));
	}

}
