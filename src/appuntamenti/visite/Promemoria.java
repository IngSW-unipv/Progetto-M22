package appuntamenti.visite;

import java.sql.Time;
import java.util.Date;

import anagrafica.veterinari.Veterinari;


public class Promemoria {

	private String sala;
	private String tipo;
	private Date data;
	private Time time;
	private String note;

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Promemoria(String sala, String tipo, Date data, Time time,String note) {
		super();

		this.sala = sala;
		this.tipo = tipo;
		this.data = data;
		this.time = time;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Promemoria [sala=" + sala + ", tipo=" + tipo + ", data=" + data + ", time=" + time + ", note=" + note
				+ "]";
	}
	

}
