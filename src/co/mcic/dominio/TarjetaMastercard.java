package co.mcic.dominio;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="Mastercard")
public class TarjetaMastercard extends TarjetaCredito implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TarjetaMastercard() {
		super();
		this.setLongitud(16);
		this.setPrefijo("51 52 53 54 55");
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
