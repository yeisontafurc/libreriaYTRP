package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.mcic.dominio.Persona;
import co.mcic.vista.ConsultarCliente;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuPrincipal;

public class ControlConsultarCliente implements ActionListener {

	private ConsultarCliente consultarCliente;
	private List<Persona> listaPersonas = new ArrayList<Persona>();
	private Persona persona = new Persona();
	private MenuPrincipal menuPrincipal;

	public ControlConsultarCliente(ConsultarCliente consultarCliente) {
		this.consultarCliente = consultarCliente;
	}

	public void mostrarConsultarCliente() {
		if (null != this.consultarCliente) {
			this.consultarCliente.setVisible(true);
			this.consultarCliente.setSize(new Dimension(1002, 520));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
			buscarClientes();
			break;
		case "VOLVER":
			ejecutarMenuClientes();
			consultarCliente.setVisible(false);
			break;
		default:
			System.out.println("El msj en realidad fue:" + e.getActionCommand());
			break;
		}
	}

	/**
	 * 
	 */
	public void ejecutarMenuClientes() {
		MenuCliente menuCliente = new MenuCliente();
		ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
		controlMenuClientes.setMenuPrincipal(this.menuPrincipal);
		menuCliente.setControl(controlMenuClientes);
		controlMenuClientes.mostrarMenuCliente();
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	/**
	 * 
	 */
	public void buscarClientes() {

		BigInteger identificacion = new BigInteger("0");
		if (null != consultarCliente.getTxfIdentificacion().getText()
				&& !consultarCliente.getTxfIdentificacion().getText().isEmpty()) {
			identificacion = new BigInteger(consultarCliente.getTxfIdentificacion().getText());
		}
		listaPersonas = this.persona.listaClientes(identificacion, consultarCliente.getTxfNombres().getText());

		if (listaPersonas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron clientes");
		} else {
			mostrarTabla(listaPersonas);
		}
	}

	public void mostrarTabla(List<Persona> listaPersonas) {

		DefaultTableModel model = (DefaultTableModel) this.consultarCliente.getTable().getModel();
		model.setRowCount(0);

		for (Persona persona : listaPersonas) {
			model.addRow(new Object[] { persona.getTipoDocumento().getNombre(), persona.getDocumento(),
					persona.getNombres(), persona.getApellidos(), persona.getDireccion(), persona.getTelefono(),
					persona.getCelular(), persona.getEstadoPersona().getNombre(),
					null != persona.getAfiliacion() && null != persona.getAfiliacion().getTipoAfiliacion()
							? persona.getAfiliacion().getTipoAfiliacion() : null,
					persona.getAfiliacion() != null && null != persona.getAfiliacion().getFechaFin()
							? persona.getAfiliacion().getFechaFin() : null });

		}

	}

}
