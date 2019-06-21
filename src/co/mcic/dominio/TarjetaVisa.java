package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="Visa")
public class TarjetaVisa extends TarjetaCredito implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TarjetaVisa() {
		super();
		this.setLongitud(13);
		this.setPrefijo("4");
	}

	@Override
	public boolean validarTarjeta() {
		String numTarjeta = this.getNumeroTarjeta().toString();
		if(numTarjeta.length() != this.getLongitud()){
			return false;
		}
		if(numTarjeta.startsWith(this.getPrefijo())){
			return true;
		}
		return false;
	}
   
}
