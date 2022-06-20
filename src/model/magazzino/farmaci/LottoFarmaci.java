package model.magazzino.farmaci;

import model.anagrafica.fornitori.Fornitori;

/**
 * la classe LottoFarmaci contiene i dati dei farmaci acquistabili
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class LottoFarmaci {

	private String IDLotto;
	private String mode;
	private String type;
	private Fornitori fornitore;
	private java.sql.Date dataScadenza;
	private int quantita;

	/**
	 * restituisce l'id lotto
	 * 
	 * @return String IDLotto IDLotto
	 */
	public String getIDLotto() {
		return IDLotto;
	}

	/**
	 * restituisce il modo
	 * 
	 * @return String mode mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * restituisce il tipo
	 * 
	 * @return String type tipo
	 */
	public String getType() {
		return type;
	}

	/**
	 * restituisce la data di scadenza
	 * 
	 * @return Date dataScadenza dataScadenza
	 */
	public java.sql.Date getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * restituisce il fornitore
	 * 
	 * @return Fornitori fornitore fornitore
	 */
	public Fornitori getFornitore() {
		return fornitore;
	}

	/**
	 * assegna il fornitore a fornitore
	 * 
	 * @param fornitore fornitore
	 */
	public void setFornitore(Fornitori fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * restituisce la quantit�
	 * 
	 * @return int quantit� quantit�
	 */
	public int getQuantita() {
		return quantita;
	}
	
	
	/**
	 * setta id lotto come  parametro passato
	 * 
	 * @param idLotto
	 */
	public void setIDLotto(String iDLotto) {
		IDLotto = iDLotto;
	}

	/**
	 * setta modalita assunzione come  parametro passato
	 * 
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * setta tipo come parametro passato
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * setta data scadenza come parametro passato
	 * 
	 * @param dataScadenza
	 */
	public void setDataScadenza(java.sql.Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	/**
	 * setta quantita come  parametro passato
	 * 
	 * @param idLotto
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	/**
	 * costruttore
	 * 
	 * @param IDLotto      IDLotto
	 * @param mode         mode
	 * @param type         type
	 * @param fornitore    fornitore
	 * @param dataScadenza dataScadenza
	 * @param quantita     quantit�
	 */
	public LottoFarmaci(String IDLotto, String mode, String type, Fornitori fornitore, java.sql.Date dataScadenza,
			int quantita) {
		super();
		this.IDLotto = IDLotto;
		this.mode = mode;
		this.type = type;
		this.fornitore = fornitore;
		this.dataScadenza = dataScadenza;
		this.quantita = quantita;
	}

	/**
	 * restituisce il LottoFarmaci con gli attributi sottoforma di stringa
	 */
	@Override
	public String toString() {
		return "LottoFarmaci [IDLotto=" + IDLotto + ", mode=" + mode + ", type=" + type + ", fornitore=" + fornitore
				+ ", dataScadenza=" + dataScadenza + ", quantita=" + quantita + "]";
	}

}
