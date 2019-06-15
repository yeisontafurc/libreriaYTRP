package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.Categoria;
import co.mcic.dominio.ListaEstadoDisponibilidad;
import co.mcic.dominio.ListaEstadoProducto;
import co.mcic.dominio.Producto;
import co.mcic.vista.EditarProducto;
import co.mcic.vista.MenuProducto;

public class ControlEditarProducto implements ActionListener {

	private int reintentos = 1;
	private Producto producto;	
	private Categoria categoria;
	private ListaEstadoProducto estadoProducto;
	private EditarProducto editarProducto;
	private ListaEstadoDisponibilidad estadoDisponibilidad;

	public ControlEditarProducto(Producto producto) {		
		this.editarProducto = new EditarProducto();
		this.producto = producto;		
		this.getEditarProducto().getTxfIdentificador().setText(this.producto.getIdentificador());
		this.getEditarProducto().getTxfNombre().setText(this.producto.getNombre());
		this.getEditarProducto().getTxfValorAlquiler().setText(this.producto.getValorAlquilerDia().toString());
		this.getEditarProducto().getTxfValorVenta().setText(this.producto.getValorVenta().toString());
	}

	public void mostrarEditarProducto() {	

		if (this.editarProducto != null) {
			editarProducto.setSize(new Dimension(800, 600));
			editarProducto.setVisible(true);
			editarProducto.setTitle("Libreria");
		}
	}

	public int getReintentos() {
		return reintentos;
	}

	public void setReintentos(int reintentos) {
		this.reintentos = reintentos;
	}

		
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListaEstadoProducto getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(ListaEstadoProducto estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public ListaEstadoDisponibilidad getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}

	public void setEstadoDisponibilidad(ListaEstadoDisponibilidad estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public EditarProducto getEditarProducto() {
		return editarProducto;
	}

	public void setEditarProducto(EditarProducto editarProducto) {
		this.editarProducto = editarProducto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "VOLVER":
			ejecutarMenuProductos();
			editarProducto.setVisible(false);
			break;
		case "GUARDAR":
			// Primero se debe validar los requeridos
			if (ValidarRequeridos()) {

				if (ValidarFormatos()) {

					// validar los formatos

					int resp = JOptionPane.showConfirmDialog(null, "�Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						// guradar

						JOptionPane.showMessageDialog(null, "Operaci�n ejecutada exitosamente");
						ejecutarMenuProductos();
						editarProducto.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Campos con formato invalido");
					ValidarReintentos();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
				ValidarReintentos();
			}
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}

	}

	public void cosasConProducto() {

		this.producto.setEstadoDisponibilidad(this.getEstadoDisponibilidad());
		this.producto.setCategoria(this.getCategoria());
		this.producto.setEstadoProducto(this.getEstadoProducto());
		this.producto.setIdentificador("123");

		this.producto = this.producto.consultarProductoId(this.producto.getIdentificador());
		this.producto.setNombre("Infinity War");

		List<Producto> productos = this.producto.listaProductosNombreId("12", "");
		System.out.println("Producto: " + productos.size());
		for (Producto producto : productos) {
			System.out.println("Productos: " + producto.getNombre());
		}
	}

	public void ejecutarMenuProductos() {
		MenuProducto menuProducto = new MenuProducto();
		ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
		menuProducto.setControl(controlMenuProducto);
		controlMenuProducto.mostrarMenuProducto();
	}

	public boolean ValidarRequeridos() {
		return false;
	}

	public boolean ValidarFormatos() {
		return true;
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuProductos();
			editarProducto.setVisible(false);
		}else{
			this.reintentos++;
		}
	}

}
