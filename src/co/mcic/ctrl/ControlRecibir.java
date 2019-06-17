package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.mcic.dominio.Producto;
import co.mcic.vista.MenuVentaAlquiler;
import co.mcic.vista.RecibirAlquilado;

public class ControlRecibir implements ActionListener {

	private RecibirAlquilado recibirAlquilado;
	private MenuVentaAlquiler alquiler;
	private String identificador;
	private Producto producto;

	public ControlRecibir(RecibirAlquilado recibirAlquilado) {
		this.recibirAlquilado = recibirAlquilado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BUSCAR":
			System.out.println("Buscar");
			this.identificador = recibirAlquilado.getTxtProducto().getText();
			this.producto = new Producto();
			this.producto = this.producto.consultarProductoId(identificador);
			if (null == this.producto || !this.producto.getEstadoDisponibilidad().getNombre().equals("Alquilado")) {
				JOptionPane.showMessageDialog(alquiler, "Producto no alquilado");
			}
			break;
		case "VOLVER":
			this.alquiler.setVisible(true);
			this.recibirAlquilado.setVisible(false);
			this.recibirAlquilado.dispose();
			System.out.println("Volver");
			break;
		default:
			System.out.println("La acci�n fue: " + e.getActionCommand());
		}

	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public MenuVentaAlquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(MenuVentaAlquiler alquiler) {
		this.alquiler = alquiler;
	}

	public void mostrarRecibir() {
		this.recibirAlquilado.setSize(new Dimension(702, 338));
		this.recibirAlquilado.setVisible(true);

	}

}