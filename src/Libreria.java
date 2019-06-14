import co.mcic.ctrl.ControlLogin;
import co.mcic.dominio.Usuario;
import co.mcic.vista.Login;

public class Libreria {

	public static void main(String[] args) {
		//Usuario usuario = new Usuario();
		Login login = new Login();
		ControlLogin controlLogin = new ControlLogin(login);
		controlLogin.mostrarLogin();

	}

}
