package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.Persona;
import co.mcic.vista.ConsultarClienteId;

public class ControlConsultarClienteId implements ActionListener {
	private Persona persona = new Persona();
	private ControlConsultarClienteId controConsultarClienteId;
	private ConsultarClienteId consultarClienteId;

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
			ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
			this.persona = this.persona.consultaClienteByDocumento(
					listaTipoDocumento.getListaTipoDocumentoByNombre(
							consultarClienteId.getcBoxTipoDocumento().getSelectedItem().toString()),
					new BigInteger(consultarClienteId.getTxtIdentificador().getText()));

			if (null != this.persona && null != this.persona.getNombres() && !this.persona.getNombres().isEmpty()) {
				ejecutarEditarPersona(this.persona);
				JOptionPane.showMessageDialog(null, "Cliente si encontrado");
				consultarClienteId.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Cliente no encontrado");
				this.persona = new Persona();
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

	public void ejecutarEditarPersona(Persona persona) {

	}

	public void ejecutarMenuClientes() {

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

}