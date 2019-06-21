package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.Categoria;
import co.mcic.dominio.ListaEstadoDisponibilidad;
import co.mcic.dominio.ListaEstadoPersona;
import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.ListaTipoPersona;
import co.mcic.dominio.Persona;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.RegistrarCliente;

public class ControlRegistrarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona = new Persona();
	private RegistrarCliente registrarCliente;
	private Categoria categoria;
	private ListaEstadoDisponibilidad estadoDisponibilidad;
	private MenuPrincipal menuPrincipal;

	public ControlRegistrarCliente(RegistrarCliente registrarCliente) {
		this.setRegistrarCliente(registrarCliente);
	}

	public void mostrarRegistrarCliente() {
		if (null != this.registrarCliente) {
			cargarListaEstadoDiponibilidad();
			cargarListaTipoDocumento();
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

			// Primero se debe validar los requeridos
			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {

					cargarDatosPersona();

					int resp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						boolean res = this.persona.crearCliente(persona);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuClientes();
							registrarCliente.setVisible(false);
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

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		controlMenuClientes.setMenuPrincipal(this.menuPrincipal);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.mostrarMenuCliente();
	}

	public boolean ValidarRequeridos() {

		if (this.registrarCliente.getTxfApellidos().getText().isEmpty()
				|| this.registrarCliente.getTxfCelular().getText().isEmpty()
				|| this.registrarCliente.getTxfDireccion().getText().isEmpty()
				|| this.registrarCliente.getTxfIdentificacion().getText().isEmpty()
				|| this.registrarCliente.getTxfNombres().getText().isEmpty()
				|| this.registrarCliente.getTxfTelefono().getText().isEmpty()) {
			return false;
		}

		return true;
	}

	public boolean ValidarFormatos() {

		try {
			new BigInteger(this.registrarCliente.getTxfCelular().getText());
			new BigInteger(this.registrarCliente.getTxfIdentificacion().getText());
			new BigInteger(this.registrarCliente.getTxfTelefono().getText());
		} catch (Exception e) {
			return false;
		}

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
	public Persona cargarDatosPersona() {
		this.persona.setApellidos(this.registrarCliente.getTxfApellidos().getText());
		this.persona.setCelular(new BigInteger(this.registrarCliente.getTxfCelular().getText()));
		this.persona.setDireccion(this.registrarCliente.getTxfDireccion().getText());
		this.persona.setDocumento(new BigInteger(this.registrarCliente.getTxfIdentificacion().getText()));
		this.persona.setNombres(this.registrarCliente.getTxfNombres().getText());
		this.persona.setTelefono(new BigInteger(this.registrarCliente.getTxfTelefono().getText()));

		this.persona.setEstadoPersona(new ListaEstadoPersona()
				.getListaEstadoPersonaByNombre(this.registrarCliente.getcBoxEstado().getSelectedItem().toString()));

		this.persona.setTipoDocumento(new ListaTipoDocumento().getListaTipoDocumentoByNombre(
				this.registrarCliente.getcBoxTipoDocumento().getSelectedItem().toString()));
		// Dado que la funcionalidad es solo para Vendedores solo se va a
		// permitir registrar personas tipo externo
		this.persona.setTipoPersona(new ListaTipoPersona().getListaTipoPersonaByNombre("Externo"));

		return this.persona;
	}

	/**
	 */
	public void cargarListaEstadoDiponibilidad() {
		ListaEstadoPersona listaEstado = new ListaEstadoPersona();

		List<ListaEstadoPersona> listasEstados = listaEstado.getListaEstadoPersona();

		this.persona.setEstadoPersona(listasEstados.get(0));

		for (ListaEstadoPersona estado : listasEstados) {
			this.registrarCliente.getcBoxEstado().addItem(estado.getNombre());
		}

	}

	public void cargarListaTipoDocumento() {
		ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
		List<ListaTipoDocumento> listaTipoDocumentos = listaTipoDocumento.getListaTipoDocumento();
		this.persona.setTipoDocumento(listaTipoDocumentos.get(0));
		for (ListaTipoDocumento tipoDocumento : listaTipoDocumentos) {
			if (null != tipoDocumento && null != tipoDocumento.getNombre()) {
				this.registrarCliente.getcBoxTipoDocumento().addItem(tipoDocumento.getNombre());
			}
		}
	}

}
