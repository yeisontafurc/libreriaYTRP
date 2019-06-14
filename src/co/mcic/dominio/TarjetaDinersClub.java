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
	}
   
}
