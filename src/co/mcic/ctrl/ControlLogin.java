package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import co.mcic.dominio.ListaPermiso;
import co.mcic.dominio.Usuario;
import co.mcic.vista.Login;
import co.mcic.vista.MenuPrincipal;

public class ControlLogin implements ActionListener {

	private Login login;
	private Usuario usuario;

	public ControlLogin(Login login) {
		this.setLogin(login);
		this.usuario = new Usuario();
	}
	public ControlLogin(){
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void mostrarLogin() {
		if (this.login != null) {
			login.setSize(new Dimension(450, 300));
			login.setVisible(true);
			login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Login!" + login.getTextField().getText() + " pwd: " + login.getPasswordField().getText());
		this.usuario.setNombreUsuario(login.getTextField().getText());
		this.usuario.setClave(login.getPasswordField().getText());
		boolean usuarioValido = this.usuario.validarCredenciales();
		if (usuarioValido) {
			validarAccesos();
			login.setVisible(false);
		}

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void validarAccesos(){
		MenuPrincipal mp = new MenuPrincipal();
		List<ListaPermiso> listaPermisos = this.usuario.getRol().getPermisos();

		if (null != listaPermisos) {
			for (ListaPermiso permiso : listaPermisos) {
				if(permiso.getNombre().equals("PRODUCTOS")){
					mp.getBtnProductos().setVisible(true);
				}
				if(permiso.getNombre().equals("CLIENTES")){
					mp.getBtnClientes().setVisible(true);
				}
				if(permiso.getNombre().equals("VENTA Y ALQUILER")){
					mp.getBtnVentasYAlquiler().setVisible(true);
				}
				
			}
			ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(mp);
			mp.setControl(controlMenuPrincipal);
			controlMenuPrincipal.mostrarMenuPrincipal();
			controlMenuPrincipal.setUsuario(this.usuario);
		}
	}

}
