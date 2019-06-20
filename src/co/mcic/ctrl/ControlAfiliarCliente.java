package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaTipoAfiliacion;
import co.mcic.dominio.Persona;
import co.mcic.vista.AfiliarCliente;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;

public class ControlAfiliarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona = new Persona();
	private AfiliarCliente afiliarCliente;
	private MenuPrincipal menuPrincipal;

	public ControlAfiliarCliente(AfiliarCliente afiliarCliente) {
		this.afiliarCliente = afiliarCliente;
	}

	public void mostrarAfiliarCliente(Persona persona) {
		this.persona = persona;

		if (null != this.afiliarCliente) {
			cargarListaTipoAfiliacion();

			this.afiliarCliente.setVisible(true);
			this.afiliarCliente.setSize(new Dimension(782, 486));
		}
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "VOLVER":
			ejecutarMenuClientes();
			afiliarCliente.setVisible(false);
			break;
		case "GUARDAR":
			// Primero se debe validar los requeridos
			if (ValidarRequeridos()) {

				// validar los formatos
				if (ValidarFormatos()) {
					cargarDatosAfiliacion();

					int resp = JOptionPane.showConfirmDialog(null, "¿Desea ejecutar la operacion?", null,
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						boolean res = this.persona.actualizarCliente(this.persona);
						if (res) {
							JOptionPane.showMessageDialog(null, "Operación ejecutada exitosamente");
							ejecutarMenuClientes();
							afiliarCliente.setVisible(false);
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

	public void cargarDatosAfiliacion() {

	}

	public void cargarListaTipoAfiliacion() {

		ListaTipoAfiliacion listaTipoAfiliacion = new ListaTipoAfiliacion();
		List<ListaTipoAfiliacion> listasTipoAfiliacion = listaTipoAfiliacion.getListaTipoAfiliacion();

		for (ListaTipoAfiliacion listaTipoAfiliacion2 : listasTipoAfiliacion) {
			this.afiliarCliente.getcBoxTipoAfiliacion().addItem(listaTipoAfiliacion2.getNombre());
		}
	}

	public boolean ValidarRequeridos() {
		return true;
	}

	public boolean ValidarFormatos() {
		return true;
	}

	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.setMenuPrincipal(this.menuPrincipal);
		controlMenuClientes.mostrarMenuCliente();
	}

	public void ValidarReintentos() {
		if (this.reintentos > 3) {
			ejecutarMenuClientes();
			afiliarCliente.setVisible(false);
		} else {
			this.reintentos++;
		}
	}

}
