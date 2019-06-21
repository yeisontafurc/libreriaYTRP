package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaTipoDocumento;
import co.mcic.dominio.Persona;
import co.mcic.dominio.Transaccion;
import co.mcic.dominio.Usuario;
import co.mcic.vista.BuscarProductoVenta;
import co.mcic.vista.MenuCliente;
import co.mcic.vista.MenuVentaAlquiler;
import co.mcic.vista.RegistrarCliente;
import co.mcic.vista.VentaUbicaCliente;

public class ControlVentaCliente implements ActionListener {
	private VentaUbicaCliente ventaUbicaCliente;
	private MenuVentaAlquiler mva;
	private List<ListaTipoDocumento> tiposDoc;
	private List<Transaccion> transacciones;
	private Usuario usuario;
	
	public ControlVentaCliente(VentaUbicaCliente ventaUbicaCliente) {
		this.ventaUbicaCliente = ventaUbicaCliente;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
				buscarCliente();
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
	
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}


	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}


	public void buscarCliente(){
		//Ubicar Cliente
		//Creación de objeto "Persona" para acceder a la búsqueda de personaS
		Persona cliente = new Persona();
		//Obtención del tipo de documento seleccionado en la vista
		String tipoDocSelected = ventaUbicaCliente.getComboTipoDoc().getSelectedItem().toString();
		//Búsqueda del objeto "ListaTipoDocumento" que corresponda a la opción seleccionada
		for (ListaTipoDocumento listaTipoDocumento : tiposDoc) {
			//ListaTipoDocumento correspondiente
			if(tipoDocSelected.equals(listaTipoDocumento.getNombre())){
				try
				{
					//Obtención del número de documento registrado
					BigInteger idCliente = new BigInteger(ventaUbicaCliente.getTxtNumeroId().getText());
					//Búsqueda de la "Persona" (esta puede ser interna o externa, ya que existen ventas a internos)
					cliente = cliente.consultaCliente(idCliente, listaTipoDocumento);
					//Si se encuentra:
					if(null !=cliente){
						//Mostrar ventana de búsqueda de producto:
						BuscarProductoVenta buscarProductoVenta = new BuscarProductoVenta();
						ControlBuscarProducto consultarBuscarProducto = new ControlBuscarProducto(buscarProductoVenta);
						consultarBuscarProducto.setVolver(this.ventaUbicaCliente);
						buscarProductoVenta.setControl(consultarBuscarProducto);
						consultarBuscarProducto.setCliente(cliente);
						consultarBuscarProducto.setUsuario(usuario);
						ventaUbicaCliente.setVisible(false);
						ventaUbicaCliente.dispose();
						consultarBuscarProducto.mostrarBuscarProductoVenta();
					//Si no se encuentra:
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
							ControlLogin controlLogin_ = new ControlLogin();
							controlLogin_.setUsuario(usuario);
							controlLogin_.validarAccesos();
							controlLogin_.getMp().setVisible(false);
							MenuCliente menuCliente = new MenuCliente();
							ControlMenuClientes controlMenuClientes = new ControlMenuClientes(menuCliente);
							menuCliente.setControl(controlMenuClientes);
							controlMenuClientes.setMenuPrincipal(controlLogin_.getMp());
							controlMenuClientes.mostrarMenuCliente();
							controlMenuClientes.getMenuCliente().setVisible(false);
							
							RegistrarCliente registrarCliente = new RegistrarCliente();
							ControlRegistrarCliente controlRegistrarCliente = new ControlRegistrarCliente(registrarCliente);
							registrarCliente.setControl(controlRegistrarCliente);
							controlRegistrarCliente.setMenuPrincipal(controlLogin_.getMp());
							controlRegistrarCliente.mostrarRegistrarCliente();
							
							ventaUbicaCliente.setVisible(false);
							ventaUbicaCliente.dispose();
							
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
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
