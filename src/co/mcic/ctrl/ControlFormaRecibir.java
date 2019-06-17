package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import co.mcic.dominio.ListaEstadoProducto;
import co.mcic.dominio.Producto;
import co.mcic.vista.FormaRecibir;
import co.mcic.vista.RecibirAlquilado;

public class ControlFormaRecibir implements ActionListener {

	private FormaRecibir recibir;
	private RecibirAlquilado recibirAlquilado;
	private Producto producto;
	public ControlFormaRecibir(FormaRecibir recibir) {
		this.recibir = recibir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "RECIBIR":
				System.out.println("recibir");
				int countError = 0;
				try{
					Float valorAlquiler = new Float(recibir.getTxtValorAlquiler().getText());
					this.producto.setValorAlquilerDia(valorAlquiler);
				}catch (NumberFormatException nfe) {
					JOptionPane.showOptionDialog(null, "Valor alquiler inválido " + nfe.getMessage(), "Verificar valores", JOptionPane.DEFAULT_OPTION,
					        JOptionPane.ERROR_MESSAGE, null, null, null);
					countError++;
				}
				try{
					Float valorVenta = new Float(recibir.getTxtValorVenta().getText());
					this.producto.setValorVenta(valorVenta);	
				}catch (NumberFormatException nfe) {
					JOptionPane.showOptionDialog(null, "Valor venta inválido " + nfe.getMessage(), "Verificar valores", JOptionPane.DEFAULT_OPTION,
					        JOptionPane.ERROR_MESSAGE, null, null, null);
					countError++;
				}
				this.producto.setEstadoProducto(this.producto.getEstadoProducto().getEstadoByNombre(recibir.getComboEstadoProducto().getSelectedItem().toString()));
				if(this.producto.actualizarProducto(producto) && countError == 0){
					JOptionPane.showOptionDialog(null, "Producto actualizado", "Producto actualizado", JOptionPane.DEFAULT_OPTION,
					        JOptionPane.INFORMATION_MESSAGE, null, null, null);
					this.recibir.setVisible(false);
					this.recibirAlquilado.getTxtProducto().setText(null);
					this.recibirAlquilado.setVisible(true);
				}

				
				break;
			case "VOLVER":
				recibir.setVisible(false);
				recibirAlquilado.setVisible(true);
				break;
			default:
				System.out.println("el msj fue: " +e.getActionCommand());
		}
	}

	public void setRecibirAlquilado(RecibirAlquilado recibirAlquilado) {
		this.recibirAlquilado = recibirAlquilado;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public void mostrarFormaRecibir(){
		recibir.getTxtIdentificadorProducto().setText(this.producto.getIdentificador());
		recibir.getTxtNombreProducto().setText(this.producto.getNombre());
		ListaEstadoProducto estadoProducto = new ListaEstadoProducto();
		List<ListaEstadoProducto> listaEstadoProducto = estadoProducto.getListaEstadoProducto(); 
		if(null != listaEstadoProducto){
			for (ListaEstadoProducto listaEstadoProducto2 : listaEstadoProducto) {
				recibir.getComboEstadoProducto().addItem(listaEstadoProducto2.getNombre());
			}
		}
		recibir.getComboEstadoProducto().setSelectedItem(this.producto.getEstadoProducto().getNombre());
		recibir.setSize(new Dimension(700,413));
		recibir.setVisible(true);
	}

}
