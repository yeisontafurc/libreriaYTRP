package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.dominio.Categoria;
import co.mcic.dominio.ListaEstadoDisponibilidad;
import co.mcic.dominio.ListaEstadoProducto;
import co.mcic.dominio.Producto;
import co.mcic.vista.EditarProducto;


public class ControlEditarProducto implements ActionListener{
	
	private Producto producto;
	private String identificador;	
	private String nombre;	
	private Float valorAlquilerDia;	
	private Float valorVenta;	
	private Categoria categoria;	
	private ListaEstadoProducto estadoProducto;
	private EditarProducto editarProducto;
	private ListaEstadoDisponibilidad estadoDisponibilidad;
	
	public ControlEditarProducto(EditarProducto editarProducto){
		this.setEditarProducto(editarProducto);
		this.producto = new Producto();
	}
	
	
	public void mostrarEditarProducto(){
		if(this.editarProducto != null){
			editarProducto.setSize(new Dimension(800,600));
			editarProducto.setVisible(true);
			editarProducto.setTitle("Libreria");
		}
	}
	

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getValorAlquilerDia() {
		return valorAlquilerDia;
	}

	public void setValorAlquilerDia(Float valorAlquilerDia) {
		this.valorAlquilerDia = valorAlquilerDia;
	}

	public Float getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Float valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListaEstadoProducto getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(ListaEstadoProducto estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public ListaEstadoDisponibilidad getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}

	public void setEstadoDisponibilidad(ListaEstadoDisponibilidad estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}

	public EditarProducto getEditarProducto() {
		return editarProducto;
	}


	public void setEditarProducto(EditarProducto editarProducto) {
		this.editarProducto = editarProducto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
