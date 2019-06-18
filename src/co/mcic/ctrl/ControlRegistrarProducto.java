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
import co.mcic.vista.MenuProducto;
import co.mcic.vista.RegistrarProducto;

public class ControlRegistrarProducto implements ActionListener {

	private int reintentos = 1;
	private Producto producto = new Producto();
	private RegistrarProducto registrarProducto;
	private Categoria categoria;
	private ListaEstadoProducto estadoProducto;
	private ListaEstadoDisponibilidad estadoDisponibilidad;

	public ControlRegistrarProducto(RegistrarProducto registrarProducto) {
		this.setRegistrarProducto(registrarProducto);
	}

	public void mostrarRegistrarProducto() {
		if (null != this.registrarProducto) {
			cargarListaEstadoProducto();
			cargarListaCategoria();
			cargarListaEstadoDiponibilidad();
			this.registrarProducto.setVisible(true);
			this.registrarProducto.setSize(new Dimension(702, 486));
		}
	}

	public void RegistarProducto(Producto producto) {
		this.producto = producto;
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

	public RegistrarProducto getRegistrarProducto() {
		return registrarProducto;
	}

	public void setRegistrarProducto(RegistrarProducto registrarProducto) {
		this.registrarProducto = registrarProducto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "VOLVER":
			ejecutarMenuProductos();
			registrarProducto.setVisible(false);
			break;
		case "GUARDAR":
			cargarDatosProducto();
			// Primero se debe validar los requeridos
			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {

					int resp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						// guradar
						boolean res = this.producto.crearProducto(producto);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuProductos();
							registrarProducto.setVisible(false);
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
			registrarProducto.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Producto cargarDatosProducto() {
		this.producto.setIdentificador(this.registrarProducto.getTxfIdentificador().getText());
		this.producto.setNombre(this.registrarProducto.getTxfNombre().getText());
		this.producto.setValorAlquilerDia(Float.parseFloat(this.registrarProducto.getTxfValorAlquiler().getText()));
		this.producto.setValorVenta(Float.parseFloat(this.registrarProducto.getTxfValorVenta().getText()));

		this.producto.setEstadoProducto(this.producto.getEstadoProducto()
				.getEstadoByNombre(registrarProducto.getcBoxEstado().getSelectedItem().toString()));
		this.producto
				.setEstadoDisponibilidad(this.producto.getEstadoDisponibilidad().getListaEstadoDisponibilidadByNombre(
						registrarProducto.getcBoxEstadoDisponibilidad().getSelectedItem().toString()));
		this.producto.setCategoria(this.producto.getCategoria()
				.getCategoriaByNombre(registrarProducto.getcBoxCategoria().getSelectedItem().toString()));

		return this.producto;
	}

	/*
	 * 
	 */
	public void cargarListaEstadoProducto() {

		ListaEstadoProducto listaEstadoProducto = new ListaEstadoProducto();
		List<ListaEstadoProducto> listaEstadoProductos = listaEstadoProducto.getListaEstadoProducto();
		this.producto.setEstadoProducto(listaEstadoProductos.get(0));

		for (ListaEstadoProducto listaEstadoProducto2 : listaEstadoProductos) {
			registrarProducto.getcBoxEstado().addItem(listaEstadoProducto2.getNombre());
		}
	}

	/**
	 * 
	 */
	public void cargarListaCategoria() {
		Categoria categoria = new Categoria();
		List<Categoria> listaCategoria = categoria.getlistaCategoria();
		this.producto.setCategoria(listaCategoria.get(0));

		for (Categoria categoria2 : listaCategoria) {
			registrarProducto.getcBoxCategoria().addItem(categoria2.getNombre());
		}
	}

	/**
	 * 
	 */
	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();

		List<ListaEstadoDisponibilidad> listasEstadoDisponibilidad = listaEstadoDisponibilidad
				.getlistaEstadoDisponibilidad();
		this.producto.setEstadoDisponibilidad(listasEstadoDisponibilidad.get(0));

		for (ListaEstadoDisponibilidad estadoDisponibilidad : listasEstadoDisponibilidad) {

			registrarProducto.getcBoxEstadoDisponibilidad().addItem(estadoDisponibilidad.getNombre());
		}
	}

}
