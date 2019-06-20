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

	public ControlEditarProducto(EditarProducto editarProducto) {
		this.setEditarProducto(editarProducto);
	}

	/**
	 * 
	 * @param producto
	 */
	public void mostrarEditarProducto(Producto producto) {
		this.producto = producto;
		if (this.editarProducto != null) {
			cargarListaEstadoDiponibilidad();
			cargarListaEstadoProducto();
			cargarListaCategoria();

			editarProducto.getcBoxEstadoDisponibilidad()
					.setSelectedItem(this.producto.getEstadoDisponibilidad().getNombre());
			editarProducto.getcBoxCategoria().setSelectedItem(this.producto.getCategoria().getNombre());
			editarProducto.getcBoxEstado().setSelectedItem(this.producto.getEstadoProducto().getNombre());

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

			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {
					cargarDatosProducto();
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
					JOptionPane.showMessageDialog(null, "Campos de valor tienen formato invalido");
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

	/**
	 * 
	 * @return
	 */
	public Producto cargarDatosProducto() {

		this.producto.setNombre(this.editarProducto.getTxfNombre().getText());
		this.producto.setValorAlquilerDia(Float.parseFloat(this.editarProducto.getTxfValorAlquiler().getText()));
		this.producto.setValorVenta(Float.parseFloat(this.editarProducto.getTxfValorVenta().getText()));
		this.producto.setEstadoProducto(this.producto.getEstadoProducto()
				.getEstadoByNombre(this.editarProducto.getcBoxEstado().getSelectedItem().toString()));
		this.producto
				.setEstadoDisponibilidad(this.producto.getEstadoDisponibilidad().getListaEstadoDisponibilidadByNombre(
						this.editarProducto.getcBoxEstadoDisponibilidad().getSelectedItem().toString()));
		this.producto.setCategoria(this.producto.getCategoria()
				.getCategoriaByNombre(this.editarProducto.getcBoxCategoria().getSelectedItem().toString()));

		return this.producto;
	}

	/**
	 * 
	 */
	public void ejecutarMenuProductos() {
		MenuProducto menuProducto = new MenuProducto();
		ControlMenuProducto controlMenuProducto = new ControlMenuProducto(menuProducto);
		menuProducto.setControl(controlMenuProducto);
		controlMenuProducto.mostrarMenuProducto();
	}

	public boolean ValidarRequeridos() {
		boolean requerido = true;

		if (this.editarProducto.getTxfNombre().getText().isEmpty()
				|| this.editarProducto.getTxfValorAlquiler().getText().isEmpty()
				|| this.editarProducto.getTxfValorVenta().getText().isEmpty()
				|| this.editarProducto.getcBoxEstado().getSelectedItem().toString().isEmpty()
				|| this.editarProducto.getcBoxEstadoDisponibilidad().getSelectedItem().toString().isEmpty()
				|| this.editarProducto.getcBoxCategoria().getSelectedItem().toString().isEmpty()) {
			requerido = false;
		}
		return requerido;
	}

	public boolean ValidarFormatos() {

		try {
			this.producto.setValorAlquilerDia(Float.parseFloat(this.editarProducto.getTxfValorAlquiler().getText()));
			this.producto.setValorVenta(Float.parseFloat(this.editarProducto.getTxfValorVenta().getText()));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 */
	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuProductos();
			editarProducto.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

	/*
	 * 
	 */
	public void cargarListaEstadoProducto() {

		ListaEstadoProducto listaEstadoProducto = new ListaEstadoProducto();
		List<ListaEstadoProducto> listaEstadoProductos = listaEstadoProducto.getListaEstadoProducto();
		for (ListaEstadoProducto listaEstadoProducto2 : listaEstadoProductos) {
			editarProducto.getcBoxEstado().addItem(listaEstadoProducto2.getNombre());
		}
	}

	/**
	 * 
	 */
	public void cargarListaCategoria() {
		Categoria categoria = new Categoria();
		List<Categoria> listaCategoria = categoria.getlistaCategoria();

		for (Categoria categoria2 : listaCategoria) {
			editarProducto.getcBoxCategoria().addItem(categoria2.getNombre());
		}
	}

	/**
	 * 
	 */
	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();

		List<ListaEstadoDisponibilidad> listasEstadoDisponibilidad = listaEstadoDisponibilidad
				.getlistaEstadoDisponibilidad();

		for (ListaEstadoDisponibilidad estadoDisponibilidad : listasEstadoDisponibilidad) {

			editarProducto.getcBoxEstadoDisponibilidad().addItem(estadoDisponibilidad.getNombre());
		}
	}

}
