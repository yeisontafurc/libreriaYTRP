package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.Persona;
import co.mcic.vista.AfiliarCliente;
import co.mcic.vista.ConsultarClienteId;
import co.mcic.vista.EditarCliente;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;

public class ControlConsultarClienteId implements ActionListener {
	private Persona persona = new Persona();
	private ControlConsultarClienteId controConsultarClienteId;
	private ConsultarClienteId consultarClienteId;
	private MenuPrincipal menuPrincipal;
	private String action;
	private int reintentos = 1;

	public ControlConsultarClienteId(ConsultarClienteId consultarClienteId) {
		this.consultarClienteId = consultarClienteId;
	}

	public void mostrarConsultarClienteId() {
		if (null != this.consultarClienteId) {
			cargarListaTipoDocumento();

			this.consultarClienteId.setVisible(true);
			this.consultarClienteId.setSize(new Dimension(702, 486));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":

			if (validarRequeridos()) {
				if (ValidarFormatos()) {
					ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
					this.persona = this.persona.consultaClienteByDocumento(
							listaTipoDocumento.getListaTipoDocumentoByNombre(
									consultarClienteId.getcBoxTipoDocumento().getSelectedItem().toString()),
							new BigInteger(consultarClienteId.getTxtIdentificador().getText()));

					if (null != this.persona && null != this.persona.getNombres()
							&& !this.persona.getNombres().isEmpty()) {
						if (this.action.equals("EDITAR")) {
							ejecutarEditarPersona(this.persona);
						} else if (this.action.equals("AFILIAR")) {
							ejecutarAfiliarPersona(this.persona);
						}

						consultarClienteId.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Cliente no encontrado");
						this.persona = new Persona();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Formato de Identificador no valido");
					ValidarReintentos();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Se requiere el Identidficador");
				ValidarReintentos();
			}
			break;

		case "VOLVER":
			ejecutarMenuClientes();
			consultarClienteId.setVisible(false);
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

	public boolean validarRequeridos() {
		boolean requeridos = true;

		if (consultarClienteId.getTxtIdentificador().getText().isEmpty()) {
			requeridos = false;
		}

		return requeridos;
	}

	public ControlConsultarClienteId getControConsultarClienteId() {
		return controConsultarClienteId;
	}

	public void setControConsultarClienteId(ControlConsultarClienteId controConsultarClienteId) {
		this.controConsultarClienteId = controConsultarClienteId;
	}

	public ConsultarClienteId getConsultarClienteId() {
		return consultarClienteId;
	}

	public void setConsultarClienteId(ConsultarClienteId consultarClienteId) {
		this.consultarClienteId = consultarClienteId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void ejecutarEditarPersona(Persona persona) {

		EditarCliente editarCliente = new EditarCliente();
		ControlEditarCliente controlEditarrCliente = new ControlEditarCliente(editarCliente);
		editarCliente.setControl(controlEditarrCliente);
		controlEditarrCliente.setMenuPrincipal(this.menuPrincipal);
		controlEditarrCliente.mostrarRegistrarCliente(this.persona);

	}

	public void ejecutarAfiliarPersona(Persona persona) {

		AfiliarCliente afiliarCliente = new AfiliarCliente();
		ControlAfiliarCliente controlEditarCliente = new ControlAfiliarCliente(afiliarCliente);
		afiliarCliente.setControl(controlEditarCliente);
		controlEditarCliente.setMenuPrincipal(this.menuPrincipal);
		controlEditarCliente.mostrarAfiliarCliente(this.persona);

	}

	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		controlMenuClientes.setMenuPrincipal(this.menuPrincipal);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.mostrarMenuCliente();
	}

	public void cargarListaTipoDocumento() {
		ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
		List<ListaTipoDocumento> listaTipoDocumentos = listaTipoDocumento.getListaTipoDocumento();
		this.persona.setTipoDocumento(listaTipoDocumentos.get(0));
		for (ListaTipoDocumento tipoDocumento : listaTipoDocumentos) {
			if (null != tipoDocumento && null != tipoDocumento.getNombre()) {
				this.consultarClienteId.getcBoxTipoDocumento().addItem(tipoDocumento.getNombre());
			}
		}
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public boolean ValidarFormatos() {

		try {
			new BigInteger(consultarClienteId.getTxtIdentificador().getText());
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuClientes();
			consultarClienteId.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

}
