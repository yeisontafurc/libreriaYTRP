package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.mcic.dominio.Producto;
import co.mcic.vista.ConsultarProductoId;
import co.mcic.vista.EditarProducto;
import co.mcic.vista.MenuProducto;

public class ControlConsultarProductoId implements ActionListener {

	ConsultarProductoId consultarProductoId;
	private Producto producto;
	private int reintentos;
	private String identificador;
	
	public ControlConsultarProductoId(ConsultarProductoId consultarProductoId) {
		this.setConsultarProductoId(consultarProductoId);
		this.producto = new Producto();
	}
	
	public void mostrarConsultarProductoId() {
		if(null != this.consultarProductoId){
		this.consultarProductoId.setVisible(true);
		this.consultarProductoId.setSize(new Dimension(702, 486));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":

			identificador = consultarProductoId.getTxtIdentificador().getText();
			this.producto = this.producto.consultarProductoId(identificador);
			if (null != this.producto && !this.producto.getNombre().isEmpty()) {
				ejecutarEditarProducto(this.producto);
				consultarProductoId.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Producto no encontrado");
				this.producto = new Producto();
			}
			break;

		case "VOLVER":
			ejecutarMenuProductos();
			consultarProductoId.setVisible(false);
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

	public ConsultarProductoId getConsultarProductoId() {
		return consultarProductoId;
	}

	public void setConsultarProductoId(ConsultarProductoId consultarProductoId) {
		this.consultarProductoId = consultarProductoId;
	}

	public int getReintentos() {
		return reintentos;
	}

	public void setReintentos(int reintentos) {
		this.reintentos = reintentos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}	

	public void ejecutarMenuProductos() {
		MenuProducto menuProducto = new MenuProducto();
		ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
		menuProducto.setControl(controlMenuProducto);
		controlMenuProducto.mostrarMenuProducto();
	}

	public void ejecutarEditarProducto(Producto producto) {
		EditarProducto editarProducto = new EditarProducto();
		ControlEditarProducto controlEditarProducto = new ControlEditarProducto(editarProducto);
		editarProducto.setControl(controlEditarProducto);
		controlEditarProducto.mostrarEditarProducto(producto);		
	}

	public boolean ValidarRequeridos() {
		return true;
	}

	public boolean ValidarFormatos() {
		return true;
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuProductos();
			consultarProductoId.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

}
