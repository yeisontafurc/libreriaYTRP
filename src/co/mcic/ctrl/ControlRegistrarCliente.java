package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import co.mcic.dominio.Categoria;
import co.mcic.dominio.ListaEstadoDisponibilidad;
import co.mcic.dominio.ListaEstadoPersona;
import co.mcic.dominio.ListaEstadoProducto;
import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.ListaTipoPersona;
import co.mcic.dominio.Persona;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.RegistrarCliente;

public class ControlRegistrarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona;
	private RegistrarCliente registrarCliente;
	private Categoria categoria;	
	private ListaEstadoDisponibilidad estadoDisponibilidad;

	public ControlRegistrarCliente(RegistrarCliente registrarCliente) {
		this.setRegistrarCliente(registrarCliente);
	}

	public void mostrarRegistrarCliente() {
		if (null != this.registrarCliente) {
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
			ejecutarMenuClientes();
			registrarCliente.setVisible(false);
			break;
		case "GUARDAR":
			cargarDatosProducto();
			// Primero se debe validar los requeridos
			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {

					int resp = JOptionPane.showConfirmDialog(null, "�Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						boolean res = this.persona.crearCliente(persona);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operaci�n ejecutada exitosamente");
							ejecutarMenuClientes();
							registrarCliente.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Error al ejecutar la operaci�n");
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

	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.mostrarMenuCliente();
	}

	public boolean ValidarRequeridos() {
		return true;
	}

	public boolean ValidarFormatos() {
		return true;
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuClientes();
			registrarCliente.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Persona cargarDatosProducto() {

		this.persona = new Persona();
		this.persona.setApellidos(this.registrarCliente.getTxfApellidos().getText());
		this.persona.setCelular(new BigInteger(this.registrarCliente.getTxfCelular().getText()));
		this.persona.setDireccion(this.registrarCliente.getTxfDireccion().getText());
		this.persona.setDocumento(new BigInteger(this.registrarCliente.getTxfIdentificacion().getText()));
		this.persona.setNombres(this.registrarCliente.getTxfNombres().getText());
		this.persona.setTelefono(new BigInteger(this.registrarCliente.getTxfTelefono().getText()));

		// Todo

		ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
		ListaTipoPersona listaTipoPersona = new ListaTipoPersona();
		ListaEstadoPersona listaEstadoPersona = new ListaEstadoPersona();

		this.persona.setTipoDocumento(listaTipoDocumento.getListaTipoDocumento().get(0));
		this.persona.setTipoPersona(listaTipoPersona.getListaTipoPersona().get(0));
		this.persona.setEstadoPersona(listaEstadoPersona.getListaEstadoPersona().get(0));

		return this.persona;
	}

	/**
	 */
	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoDisponibilidad listaEstadoDisponibilidad = new ListaEstadoDisponibilidad();

		JComboBox<String> estadoDisponiblidadCombo = new JComboBox<String>();

		List<ListaEstadoDisponibilidad> listasEstadoDisponibilidad = listaEstadoDisponibilidad
				.getlistaEstadoDisponibilidad();

		for (ListaEstadoDisponibilidad estadoDisponibilidad : listasEstadoDisponibilidad) {
			estadoDisponiblidadCombo.addItem(estadoDisponibilidad.getNombre());
		}

	}

}