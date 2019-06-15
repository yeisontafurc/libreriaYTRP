package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.MenuVentaAlquiler;

public class ControlVentaAlquiler implements ActionListener {

	private MenuVentaAlquiler mva;
	public ControlVentaAlquiler(MenuVentaAlquiler mva) {
		this.mva = mva;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarVentaAlquiler() {
		this.mva.setVisible(true);
		this.mva.setSize(new Dimension(702,486));
	}

}
