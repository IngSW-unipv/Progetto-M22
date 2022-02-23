package anagrafica.fornitori;

import java.util.ArrayList;

import magazzino.TipoFarmaci;
import magazzino.TipoProdottiVendita;

public class Fornitori {

	private String PIVA;
	private String email;
	private String sede;
	private String nTelefono;
	private String IBAN;

	private String nomeAzienda;

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getPIVA() {
		return PIVA;
	}

	public void setPIVA(String pIVA) {
		PIVA = pIVA;
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

	@Override
	public String toString() {
		return "Fornitori [ PIVA=" + PIVA + ", email=" + email + ", sede=" + sede + ", nTelefono=" + nTelefono
				+ ", IBAN=" + IBAN + ", nomeAzienda=" + nomeAzienda + "]";
	}

	public Fornitori(String nomeAzienda, String pIVA, String email, String sede, String nTelefono, String iBAN) {
		super();
		this.nomeAzienda = nomeAzienda;
		PIVA = pIVA;
		this.email = email;
		this.sede = sede;
		this.nTelefono = nTelefono;
		IBAN = iBAN;
	}

}
