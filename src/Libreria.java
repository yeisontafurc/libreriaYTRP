import co.mcic.ctrl.ControlEditarProducto;
import co.mcic.ctrl.ControlLogin;
import co.mcic.vista.EditarProducto;
import co.mcic.vista.Login;

public class Libreria {

	public static void main(String[] args) {
		//Usuario usuario = new Usuario();
		/*Login login = new Login();
		ControlLogin controlLogin = new ControlLogin(login);
		controlLogin.mostrarLogin();
		login.setControlador(controlLogin);*/
		
		
		EditarProducto editarProducto = new EditarProducto();
		ControlEditarProducto controlEditarProducto = new ControlEditarProducto(editarProducto);
		controlEditarProducto.mostrarEditarProducto();
		editarProducto.setEditarControlador(controlEditarProducto);
	}

}
