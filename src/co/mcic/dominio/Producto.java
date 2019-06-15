package co.mcic.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import co.mcic.util.Persistencia;

@Entity
@NamedQueries({
		@NamedQuery(name = "ProductoById", query = "select u from Producto u where u.identificador =:identificador"),
		@NamedQuery(name = "ProductoALL", query = "select u from Producto u "),
		@NamedQuery(name = "ProductoByNombre", query = "select u from Producto u where u.nombre =:nombre"),
		@NamedQuery(name = "ProductoNombreId", query = "select u from Producto u where u.nombre =:nombre and u.identificador =:identificador")
		})

public class Producto implements Serializable {

	@Id
	private Integer idProducto;
	@Column(nullable = false)
	private String identificador;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Float valorAlquilerDia;
	@Column(nullable = false)
	private Float valorVenta;
	@JoinColumn(nullable = false)
	private Categoria categoria;
	@JoinColumn(nullable = false)
	private ListaEstadoProducto estadoProducto;
	@JoinColumn(nullable = false)
	private ListaEstadoDisponibilidad estadoDisponibilidad;

	private static final long serialVersionUID = 1L;

	public Producto() {
		super();
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getValorAlquilerDia() {
		return this.valorAlquilerDia;
	}

	public void setValorAlquilerDia(Float valorAlquilerDia) {
		this.valorAlquilerDia = valorAlquilerDia;
	}

	public Float getValorVenta() {
		return this.valorVenta;
	}

	public void setValorVenta(Float valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListaEstadoProducto getEstadoProducto() {
		return this.estadoProducto;
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

	/**
	 * 
	 * @param producto
	 * @return
	 */
	public boolean actualizarProducto(Producto producto) {
		EntityManager em = Persistencia.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(producto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	/**
	 * 
	 * @param identificador
	 * @return
	 */
	public Producto consultarProductoId(String identificador) {
		EntityManager em = Persistencia.getEntityManager();
		Producto producto = null;
		try {
			TypedQuery<Producto> typeQuery = em.createNamedQuery("ProductoById", Producto.class);
			typeQuery.setParameter("identificador", identificador);
			List<Producto> productos = typeQuery.getResultList();
			producto = productos.get(0);
		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return producto;
	}

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public List<Producto> consultarProductoNombre(String nombre) {

		EntityManager em = Persistencia.getEntityManager();
		List<Producto> productos = new ArrayList<>();
		try {
			TypedQuery<Producto> typeQuery = em.createNamedQuery("ProductoByNombre", Producto.class);
			typeQuery.setParameter("nombre", nombre);
			productos = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return productos;
	}

	/**
	 * 
	 * @return
	 */
	public List<Producto> consultarTodos() {

		EntityManager em = Persistencia.getEntityManager();
		List<Producto> productos = new ArrayList<>();
		try {
			TypedQuery<Producto> typeQuery = em.createNamedQuery("ProductoALL", Producto.class);
			productos = typeQuery.getResultList();

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return productos;
	}

	/**
	 * 
	 * @param producto
	 * @return
	 */
	public boolean crearProducto(Producto producto) {
		EntityManager em = Persistencia.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	/**
	 * 
	 * @param nombre
	 * @param identificador
	 * @return
	 */
	public List<Producto> listaProductosNombreId(String nombre, String identificador) {
		EntityManager em = Persistencia.getEntityManager();
		List<Producto> productos = new ArrayList<>();
		try {
			TypedQuery<Producto> typeQuery = null;
			if (null != nombre && !nombre.isEmpty() && null != identificador && !identificador.isEmpty()) {
				typeQuery = em.createNamedQuery("ProductoNombreId", Producto.class);
				typeQuery.setParameter("nombre", nombre);
				typeQuery.setParameter("identificador", identificador);
				productos = typeQuery.getResultList();
			}else if (null != nombre && !nombre.isEmpty()) {
				productos = consultarProductoNombre(nombre);
			}else if(null != identificador && !identificador.isEmpty()){				
				productos.add(consultarProductoId(identificador));  				
			}else{
				productos = consultarTodos();
			}

		} catch (Exception ex) {

		} finally {
			em.close();
		}
		return productos;
	}

}
