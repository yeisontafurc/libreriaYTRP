package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
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

	public ControlEditarProducto(EditarProducto editarProducto) {
		this.setEditarProducto(editarProducto);
	}

	public void mostrarEditarProducto(Producto producto) {
		this.producto = producto;
		if (this.editarProducto != null) {
			cargarListaEstadoDiponibilidad();
			// ListaEstadoDisponibilidad listaEstadoDisponibilidad = new
			// ListaEstadoDisponibilidad();

			// editarProducto.getcBoxEstadoDisponibilidad().addItemListener((ItemListener)
			// listaEstadoDisponibilidad.getlistaEstadoDisponibilidad().get(0));
			editarProducto.getTxfIdentificador().setText(this.producto.getIdentificador());
			editarProducto.getTxfNombre().setText(this.producto.getNombre());
			editarProducto.getTxfValorAlquiler().setText(this.producto.getValorAlquilerDia().toString());
			editarProducto.getTxfValorVenta().setText(this.producto.getValorVenta().toString());
			editarProducto.setTitle("Libreria");
			editarProducto.setSize(new Dimension(800, 600));
			editarProducto.setVisible(true);
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
			cargarDatosProducto();
			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {

					int resp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						// guradar
						boolean res = this.producto.actualizarProducto(producto);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuProductos();
							editarProducto.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Error al ejecutar la operación");
							ValidarReintentos();
						}
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

	public Producto cargarDatosProducto() {

		this.producto.setNombre(this.editarProducto.getTxfNombre().getText());
		this.producto.setValorAlquilerDia(Float.parseFloat(this.editarProducto.getTxfValorAlquiler().getText()));
		this.producto.setValorVenta(Float.parseFloat(this.editarProducto.getTxfValorVenta().getText()));
		return this.producto;
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
		return true;
	}

	public boolean ValidarFormatos() {
		return true;
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuProductos();
			editarProducto.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();
		
		JComboBox<String> estadoDisponiblidadCombo = new JComboBox<String>();
		
		List<ListaEstadoDisponibilidad>   listasEstadoDisponibilidad = listaEstadoDisponibilidad.getlistaEstadoDisponibilidad();
		
		for (ListaEstadoDisponibilidad estadoDisponibilidad : listasEstadoDisponibilidad) {
			estadoDisponiblidadCombo.addItem(estadoDisponibilidad.getNombre());
		}
		editarProducto.setcBoxEstadoDisponibilidad(estadoDisponiblidadCombo);		

	}

}
