package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.vista.MenuProducto;

public class ControlMenuProducto implements ActionListener{
	
	
	private MenuProducto menuProducto;
	public  ControlMenuProducto(MenuProducto menuProducto) {
		this.menuProducto = menuProducto;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarMenuProducto() {
		this.menuProducto.setVisible(true);
		this.menuProducto.setSize(new Dimension(702,486));
	}
	
	

}
