package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.Afiliacion;
import co.mcic.dominio.ListaTipoAfiliacion;
import co.mcic.dominio.ListaTipoTransaccion;
import co.mcic.dominio.Persona;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.AfiliarCliente;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;
import co.mcic.vista.RegistrarPago;

public class ControlAfiliarCliente implements ActionListener {

	private int reintentos = 1;
	private Persona persona = new Persona();
	private AfiliarCliente afiliarCliente;
	private MenuPrincipal menuPrincipal;
	private Usuario usuario;
	private List<Transaccion> transacciones = new ArrayList<>();

	public ControlAfiliarCliente(AfiliarCliente afiliarCliente) {
		this.afiliarCliente = afiliarCliente;
	}

	public void mostrarAfiliarCliente(Persona persona) {
		this.persona = persona;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		if (null != this.afiliarCliente) {
			cargarListaTipoAfiliacion();
			this.afiliarCliente.getTxfIdentificacion().setText(this.persona.getDocumento().toString());
			this.afiliarCliente.getTxfTipoDocumento().setText(this.persona.getTipoDocumento().getNombre());
			this.afiliarCliente.getTxtInicioAfiliacion().setText(dateFormat.format(new Date()));
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
					registrarPago();

					/*
					 * int resp = JOptionPane.showConfirmDialog(null,
					 * "¿Desea ejecutar la operacion?", null,
					 * JOptionPane.YES_NO_OPTION); if (resp == 0) { boolean res
					 * = this.persona.actualizarCliente(this.persona); if (res)
					 * { JOptionPane.showMessageDialog(null,
					 * "Operación ejecutada exitosamente");
					 * ejecutarMenuClientes(); afiliarCliente.setVisible(false);
					 * } else { JOptionPane.showMessageDialog(null,
					 * "Error al ejecutar la operación"); ValidarReintentos(); }
					 * }
					 */
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

		try {
			Afiliacion afiliacion = new Afiliacion();
			ListaTipoAfiliacion listaTipoAfiliacion = new ListaTipoAfiliacion();

			afiliacion.setFechaInicio(
					new SimpleDateFormat("dd/MM/yyyy").parse(this.afiliarCliente.getTxtInicioAfiliacion().getText()));

			listaTipoAfiliacion = listaTipoAfiliacion.getListaTipoAfiliacionByNombre(
					this.afiliarCliente.getcBoxTipoAfiliacion().getSelectedItem().toString());
			afiliacion.setTipoAfiliacion(listaTipoAfiliacion);

			Calendar cal = Calendar.getInstance();
			cal.setTime(afiliacion.getFechaInicio());
			cal.add(Calendar.DATE, listaTipoAfiliacion.getMeses() * 30);

			afiliacion.setFechaFin(cal.getTime());
			afiliacion.setIdAfiliacion(afiliacion.getMaxId());
			this.persona.setAfiliacion(afiliacion);

		} catch (ParseException e) {

		}

	}

	public void cargarListaTipoAfiliacion() {

		ListaTipoAfiliacion listaTipoAfiliacion = new ListaTipoAfiliacion();
		List<ListaTipoAfiliacion> listasTipoAfiliacion = listaTipoAfiliacion.getListaTipoAfiliacion();

		for (ListaTipoAfiliacion listaTipoAfiliacion2 : listasTipoAfiliacion) {
			this.afiliarCliente.getcBoxTipoAfiliacion().addItem(listaTipoAfiliacion2.getNombre());
		}
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean ValidarRequeridos() {
		if (this.afiliarCliente.getTxtInicioAfiliacion().getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean ValidarFormatos() {

		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(this.afiliarCliente.getTxtInicioAfiliacion().getText());
		} catch (ParseException e) {
			return false;
		}

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

	public void registrarPago() {
		ListaTipoTransaccion listaTipoTransaccion = new ListaTipoTransaccion();
		Transaccion transaccion = new Transaccion();
		transaccion.setTipoAfiliacion(this.persona.getAfiliacion().getTipoAfiliacion());
		transaccion.setTipoTransaccion(listaTipoTransaccion.getListaTipoTransaccionByNombre("Afiliación"));
		transacciones.add(transaccion);

		RegistrarPago registrarPago = new RegistrarPago();
		ControlRegistrarPago controlRegistrarPago = new ControlRegistrarPago(registrarPago);
		registrarPago.setControl(controlRegistrarPago);
		controlRegistrarPago.setTransacciones(transacciones);
		controlRegistrarPago.setCliente(this.persona);
		controlRegistrarPago.setUsuario(usuario);
		controlRegistrarPago.mostrarRegistrarPago();
		afiliarCliente.setVisible(false);
	}

}
