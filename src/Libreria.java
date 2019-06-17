import co.mcic.ctrl.ControlLogin;
import co.mcic.vista.Login;

public class Libreria {

	public static void main(String[] args) {
		Login login = new Login();
		ControlLogin controlLogin = new ControlLogin(login);
		controlLogin.mostrarLogin();
		login.setControl(controlLogin);

	}

}
