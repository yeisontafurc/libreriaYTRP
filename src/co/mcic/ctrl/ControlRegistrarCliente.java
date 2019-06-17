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
import co.mcic.dominio.Persona;
import co.mcic.vista.MenuProducto;
import co.mcic.vista.RegistrarCliente;

public class ControlRegistrarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona;
	private RegistrarCliente registrarCliente;
	private Categoria categoria;
	private ListaEstadoProducto estadoProducto;	
	private ListaEstadoDisponibilidad estadoDisponibilidad;

	public ControlRegistrarCliente(RegistrarCliente registrarCliente) {
		this.setRegistrarCliente(registrarCliente);
	}
	
	public void mostrarRegistrarProducto() {
		if(null != this.registrarCliente){
		this.registrarCliente.setVisible(true);
		this.registrarCliente.setSize(new Dimension(702, 486));
		}
	}

	public void RegistarCliente(RegistrarCliente registrarCliente) {
		this.registrarCliente = registrarCliente;		
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
	

	

	public RegistrarCliente getRegistrarCliente() {
		return registrarCliente;
	}

	public void setRegistrarCliente(RegistrarCliente registrarCliente) {
		this.registrarCliente = registrarCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "VOLVER":
			ejecutarMenuProductos();
			registrarCliente.setVisible(false);
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
						//boolean res = this.producto.crearProducto(producto);
					//	if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuProductos();
							registrarCliente.setVisible(false);
				//		} else {
							JOptionPane.showMessageDialog(null, "Error al ejecutar la operación");
							ValidarReintentos();
						}
					}
				//} else {
					JOptionPane.showMessageDialog(null, "Campos con formato invalido");
					ValidarReintentos();
			//	}
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
			registrarCliente.setVisible(false);
		} else {
			this.reintentos++;
		}
	}
	
	public Persona cargarDatosProducto() {
		this.persona = new Persona();
		/*this.producto.setIdentificador(this.registrarProducto.getTxfIdentificador().getText());
		this.producto.setNombre(this.registrarProducto.getTxfNombre().getText());
		this.producto.setValorAlquilerDia(Float.parseFloat(this.registrarProducto.getTxfValorAlquiler().getText()));
		this.producto.setValorVenta(Float.parseFloat(this.registrarProducto.getTxfValorVenta().getText()));
		///Arreglar todo esto 
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();
		ListaEstadoProducto listaEstadoProducto = new ListaEstadoProducto();
		Categoria categoria = new Categoria();
		
		this.producto.setEstadoDisponibilidad(listaEstadoDisponibilidad.getlistaEstadoDisponibilidad().get(0));
		this.producto.setEstadoProducto(listaEstadoProducto.getListaEstadoProducto().get(0));
		this.producto.setCategoria(categoria.getlistaCategoria().get(0));*/
		
		return this.persona;
	}

	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();
		
		JComboBox<String> estadoDisponiblidadCombo = new JComboBox<String>();
		
		List<ListaEstadoDisponibilidad>   listasEstadoDisponibilidad = listaEstadoDisponibilidad.getlistaEstadoDisponibilidad();
		
		for (ListaEstadoDisponibilidad estadoDisponibilidad : listasEstadoDisponibilidad) {
			estadoDisponiblidadCombo.addItem(estadoDisponibilidad.getNombre());
		}	

	}

}

