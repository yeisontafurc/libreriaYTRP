package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.Persona;
import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.MenuVentaAlquiler;
import co.mcic.vista.VentaUbicaCliente;

public class ControlVentaCliente implements ActionListener {
	private VentaUbicaCliente ventaUbicaCliente;
	private MenuVentaAlquiler mva;
	private List<ListaTipoDocumento> tiposDoc;
	public ControlVentaCliente(VentaUbicaCliente ventaUbicaCliente) {
		this.ventaUbicaCliente = ventaUbicaCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
			System.out.println("BUSCAR");
			Persona cliente = new Persona();
			String tipoDocSelected = ventaUbicaCliente.getComboTipoDoc().getSelectedItem().toString();
			for (ListaTipoDocumento listaTipoDocumento : tiposDoc) {
				if(tipoDocSelected.equals(listaTipoDocumento.getNombre())){
					try
					{
						BigInteger idCliente = new BigInteger(ventaUbicaCliente.getTxtNumeroId().getText());
						cliente = cliente.consultaCliente(idCliente, listaTipoDocumento);
						if(null !=cliente){
							JOptionPane.showMessageDialog(null, "Encontrada");
							BuscarProductoVenta buscarProductoVenta = new BuscarProductoVenta();
							ControlBuscarProducto consultarBuscarProducto = new ControlBuscarProducto(buscarProductoVenta);
							consultarBuscarProducto.setVolver(this.ventaUbicaCliente);
							buscarProductoVenta.setControl(consultarBuscarProducto);
							buscarProductoVenta.setCliente(cliente);
							consultarBuscarProducto.mostrarBuscarProductoVenta();
							
						}else{
							JOptionPane.showMessageDialog(null, "No encontrada");
							Object[] choices = {"Cancelar", "Registrar"};
							Object defaultChoice = choices[0];
							int res = JOptionPane.showOptionDialog(null,
							             "¿Desea registrar cliente?",
							             "Cliente no encontrado",
							             JOptionPane.YES_NO_OPTION,
							             JOptionPane.QUESTION_MESSAGE,
							             null,
							             choices,
							             defaultChoice);
							if(res == 1){
								//TODO
							}else{
								this.ventaUbicaCliente.setVisible(false);
								this.ventaUbicaCliente.dispose();
								this.mva.setVisible(true);
							}
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Error: "+e1.getMessage());
					}
				}
			}
			break;
		case "VOLVER":
			this.ventaUbicaCliente.setVisible(false);
			this.ventaUbicaCliente.dispose();
			this.mva.setVisible(true);
			break;
		default:
			break;
		}
	}

	public void mostrarVentaCliente() {
		ventaUbicaCliente.setSize(new Dimension(560,305));
		ventaUbicaCliente.setVisible(true);
		ListaTipoDocumento listaTipoDocumento = new ListaTipoDocumento();
		this.tiposDoc = listaTipoDocumento.getListaTipoDocumento();
		if(null!= tiposDoc){
			for (ListaTipoDocumento listaTipoDocumento2 : tiposDoc) {
				ventaUbicaCliente.getComboTipoDoc().addItem(listaTipoDocumento2.getNombre());
			}
		}
	}

	public void setVolver(MenuVentaAlquiler mva) {
		this.mva = mva;
	}

}
