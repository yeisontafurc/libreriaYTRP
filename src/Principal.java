import java.util.List;

import co.mcic.dominio.ListaTipoPersona;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaTipoPersona listaTipoPersona = new ListaTipoPersona();
		List<ListaTipoPersona> lista = listaTipoPersona.getListaTipoPersona();
		for (ListaTipoPersona listaTipoPersona2 : lista) {
			System.out.println(listaTipoPersona2.getNombre());
		}
	}

}
