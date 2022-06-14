package model.appuntamenti;

/** 
 * La classe sala rappresenta le sale a disposizione della clinica e vengono occupate su prenotazione appuntamento 
 * @author MMA
 * version 1.0
 *
 */
public class Sala {

	private String ID;

	/**
	 * restituisce l'id
	 * @returs String ID id
	 */
	public String getID() {
		return ID;
	}

	/**
	 * costruttore
	 * @param String iD
	 */
	public Sala(String iD) {
		super();
		ID = iD;
	}

}
