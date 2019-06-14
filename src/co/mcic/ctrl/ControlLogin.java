package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.mcic.dominio.Usuario;
import co.mcic.vista.Login;

public class ControlLogin implements ActionListener{

	private Login login;
	private Usuario usuario;
	
	public ControlLogin(Login login) {
		this.setLogin(login);
		this.usuario = new Usuario();
	}

	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}

	public void mostrarLogin(){
		if(this.login != null){
			login.setSize(new Dimension(450,300));
			login.setVisible(true);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Login!" + login.getTextField().getText() + " pwd: "+ login.getPasswordField().getText());
		this.usuario.setNombreUsuario(login.getTextField().getText());
		this.usuario.setClave(login.getPasswordField().getText());
		if(this.usuario.validarCredenciales()){
			System.out.println("Usuario correctísimo");
		}else{
			System.out.println("Usuario icorrectísimo");
		}
	}

}
