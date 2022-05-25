package model.anagrafica.fornitori;

public class Fornitori {

	private String PIVA;
	private String nomeAzienda;
	private String nTelefono;
	private String email;
	private String sede;
	private String IBAN;

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public String getPIVA() {
		return PIVA;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public Fornitori(String PIVA, String nomeAzienda, String nTelefono, String email, String sede, String IBAN) {
		super();
		this.PIVA = PIVA;
		this.nomeAzienda = nomeAzienda;
		this.nTelefono = nTelefono;
		this.email = email;
		this.sede = sede;
		this.IBAN = IBAN;
	}

	@Override
	public String toString() {
		return "Fornitori [PIVA=" + PIVA + ", nomeAzienda=" + nomeAzienda + ", nTelefono=" + nTelefono + ", email="
				+ email + ", sede=" + sede + ", IBAN=" + IBAN + "]";
	}

}
