package co.mcic.ctrl;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.mcic.vista.Login;

public class ControlLogin implements ActionListener{

	private Login login;
	
	public ControlLogin(Login login) {
		this.setLogin(login);
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
		// TODO Auto-generated method stub
		
	}

}
