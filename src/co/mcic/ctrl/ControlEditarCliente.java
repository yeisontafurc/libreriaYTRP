
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
import co.mcic.vista.EditarCliente;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;

public class ControlEditarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona = new Persona();
	private EditarCliente editarCliente;
	private Categoria categoria;
	private ListaEstadoDisponibilidad estadoDisponibilidad;
	private MenuPrincipal menuPrincipal;

	public ControlEditarCliente(EditarCliente editarCliente) {
		this.setEditarCliente(editarCliente);
	}

	public void mostrarRegistrarCliente(Persona persona) {
		if (null != this.editarCliente) {
			cargarListaEstadoDiponibilidad();
			cargarListaTipoDocumento();

			this.persona = persona;
			this.editarCliente.getTxfNombres().setText(this.persona.getNombres());
			this.editarCliente.getTxfIdentificacion().setText(this.persona.getDocumento().toString());
			this.editarCliente.getTxfApellidos().setText(this.persona.getApellidos());
			this.editarCliente.getTxfCelular().setText(this.persona.getCelular().toString());
			this.editarCliente.getTxfTelefono().setText(this.persona.getTelefono().toString());
			this.editarCliente.getTxfDireccion().setText(this.persona.getDireccion());
			this.editarCliente.getcBoxTipoDocumento().setSelectedItem(this.persona.getTipoDocumento().getNombre());
			this.editarCliente.getcBoxEstado().setSelectedItem(this.persona.getEstadoPersona().getNombre());

			this.editarCliente.setVisible(true);
			this.editarCliente.setSize(new Dimension(702, 486));
		}
	}

	public void RegistarCliente(EditarCliente editarCliente) {
		this.editarCliente = editarCliente;
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

	public EditarCliente getEditarCliente() {
		return editarCliente;
	}

	public void setEditarCliente(EditarCliente editarCliente) {
		this.editarCliente = editarCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "VOLVER":
			ejecutarMenuClientes();
			editarCliente.setVisible(false);
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
						boolean res = this.persona.actualizarCliente(this.persona);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuClientes();
							editarCliente.setVisible(false);
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

	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.setMenuPrincipal(this.menuPrincipal);
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
			editarCliente.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Persona cargarDatosPersona() {
		this.persona.setApellidos(this.editarCliente.getTxfApellidos().getText());
		this.persona.setCelular(new BigInteger(this.editarCliente.getTxfCelular().getText()));
		this.persona.setDireccion(this.editarCliente.getTxfDireccion().getText());
		this.persona.setDocumento(new BigInteger(this.editarCliente.getTxfIdentificacion().getText()));
		this.persona.setNombres(this.editarCliente.getTxfNombres().getText());
		this.persona.setTelefono(new BigInteger(this.editarCliente.getTxfTelefono().getText()));

		this.persona.setEstadoPersona(new ListaEstadoPersona()
				.getListaEstadoPersonaByNombre(this.editarCliente.getcBoxEstado().getSelectedItem().toString()));

		this.persona.setTipoDocumento(new ListaTipoDocumento()
				.getListaTipoDocumentoByNombre(this.editarCliente.getcBoxTipoDocumento().getSelectedItem().toString()));
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
			this.editarCliente.getcBoxEstado().addItem(estado.getNombre());
		}

	}

	public void cargarListaTipoDocumento() {
		ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
		List<ListaTipoDocumento> listaTipoDocumentos = listaTipoDocumento.getListaTipoDocumento();
		this.persona.setTipoDocumento(listaTipoDocumentos.get(0));
		for (ListaTipoDocumento tipoDocumento : listaTipoDocumentos) {
			if (null != tipoDocumento && null != tipoDocumento.getNombre()) {
				this.editarCliente.getcBoxTipoDocumento().addItem(tipoDocumento.getNombre());
			}
		}
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

}
