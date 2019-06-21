package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="DinersClub")
public class TarjetaDinersClub extends TarjetaCredito implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TarjetaDinersClub() {
		super();
		this.setLongitud(14);
		this.setPrefijo("30 36 38");
	}

	@Override
	public boolean validarTarjeta() {
		String[] prefijos = this.getPrefijo().split(" ");
		String numTarjeta = this.getNumeroTarjeta().toString();
		if(numTarjeta.length() != this.getLongitud()){
			return false;
		}
		for (String prefijo : prefijos) {
			if(numTarjeta.startsWith(prefijo)){
				return true;
			}
		}
		return false;
	}
   
}
