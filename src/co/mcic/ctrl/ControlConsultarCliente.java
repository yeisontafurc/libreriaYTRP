package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.ConsultarCliente;

public class ControlConsultarCliente implements ActionListener {

	ConsultarCliente consultarCliente;

	public ControlConsultarCliente(ConsultarCliente consultarCliente) {
		this.consultarCliente = consultarCliente;
	}

	public void mostrarConsultarCliente() {
		if (null != this.consultarCliente) {
			this.consultarCliente.setVisible(true);
			this.consultarCliente.setSize(new Dimension(702, 486));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
