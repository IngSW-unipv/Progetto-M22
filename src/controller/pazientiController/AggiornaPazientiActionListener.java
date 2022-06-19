package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
import view.MainView;
import view.PopupError;
import view.pazienti.PazientiPanel;
/**
 * Aggiorna paziente selezionato. Tramite tasto modifica riempio ogni campo
 * di testo con i parametri che voglio modificare e modifico. Leggendo quello
 * che c'è nei textfield aggiorno il paziente con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private PazientiPanel pazientiPanel;

	
	/**
	 * Leggo i campi testo modificati e aggiorno il record selezionato in database,
	 * array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiorna
	 * @exception ParseException data/e non valida/e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		pazientiPanel = view.getPazientiPanel();
		DefaultTableModel modello = (DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel();
	

		int elementoSelezionato = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		int ID_PAZ = (int) modello.getValueAt(elementoSelezionato, 0);

		modello.removeRow(elementoSelezionato);

		
		String nome = pazientiPanel.getNomeText().getText();
		String specie = pazientiPanel.getSpecieText().getText();
		String razza = pazientiPanel.getRazzaText().getText();
		String sesso = pazientiPanel.getSessoBox().getSelectedItem().toString();
		String GruppoSanguigno = pazientiPanel.getGruppoSanguignoBox().getSelectedItem().toString();
		Boolean microchip = pazientiPanel.getMicrochip().isEnabled();
		Boolean sterilizzato = pazientiPanel.getSteril().isEnabled();

		double peso = 0.0;

		try {

			peso = Double.parseDouble(pazientiPanel.getPesoText().getText());

		}

		catch (NumberFormatException nfe) {

			PopupError err = new PopupError();
			err.infoBox("il peso deve contenere solo cifre", "Errore");
			//nfe.printStackTrace();

		}
	
		Clienti cl = costruisciCliente();
		String note = pazientiPanel.getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date dataNascita = null;
		Date dataMorte = null;
		java.sql.Date sqlDate = null;
		java.sql.Date sqlDate2 = null;

		try {

			dataNascita = view.getPazientiPanel().getDataNascita().getDate();
			dataMorte = view.getPazientiPanel().getDataMorte().getDate();

			if (dataNascita != null) {

				dataNascita = sdf.parse(sdf.format(dataNascita));

				sqlDate = new java.sql.Date(dataNascita.getTime());

			}

			if (dataMorte != null) {

				dataMorte = sdf.parse(sdf.format(dataMorte));

				sqlDate2 = new java.sql.Date(dataMorte.getTime());

			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox( "Data/e non valida/e", "Errore");
			//e1.printStackTrace();
		}

		model.getPazientiArray().get(elementoSelezionato).setNome(nome);
		model.getPazientiArray().get(elementoSelezionato).setSpecie(specie);
		model.getPazientiArray().get(elementoSelezionato).setRazza(razza);
		model.getPazientiArray().get(elementoSelezionato).setDataNascita(sqlDate);
		model.getPazientiArray().get(elementoSelezionato).setSesso(sesso);
		model.getPazientiArray().get(elementoSelezionato).setVeterinario(vet);
		model.getPazientiArray().get(elementoSelezionato).setGruppoSanguigno(GruppoSanguigno);
		model.getPazientiArray().get(elementoSelezionato).setMicrochip(microchip);
		model.getPazientiArray().get(elementoSelezionato).setSterilizzato(sterilizzato);
		model.getPazientiArray().get(elementoSelezionato).setPeso(peso);
		model.getPazientiArray().get(elementoSelezionato).setDataMorte(sqlDate2);
		model.getPazientiArray().get(elementoSelezionato).setCliente(cl);
		model.getPazientiArray().get(elementoSelezionato).setNote(note);
		
	

		Paziente paz = new Paziente(ID_PAZ, nome, specie, razza, sqlDate, sesso, vet, GruppoSanguigno, microchip,
				sterilizzato, peso, sqlDate2, cl, note);

		dbControl.updatePaziente(paz);

		Object rowData[] = new Object[14];

		rowData[0] = ID_PAZ;
		rowData[1] = nome;
		rowData[2] = specie;
		rowData[3] = razza;
		rowData[4] = sqlDate;
		rowData[5] = sesso;
		if (vet != null) {
		rowData[6] = vet.getCF();
		}
		else {
			rowData[6] = null;
		}
		rowData[7] = GruppoSanguigno;
		rowData[8] = microchip;
		rowData[9] = sterilizzato;
		rowData[10] = peso;
		rowData[11] = sqlDate2;
		rowData[12] = cl.getCF();
		rowData[13] = note;

		modello.insertRow(elementoSelezionato, rowData);

		pulisciTextField();
	}

	
	
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiornaPazientiActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	/**
	 * legge tutti i dati del veterinario tramite CF letto per poter passare al paziente
	 * aggiornato il veterinario di base esatto
	 * 
	 * @return Veterinario vet letto
	 */
	public Veterinari costruisciVeterinario() {
		String CF = (String) pazientiPanel.getVeterinariBox().getSelectedItem();
		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}

	/**
	 * legge tutti i dati del cliente tramite CF letto per poter passare al paziente
	 * aggiornato il cliente proprietario
	 * 
	 * @return Cliente cliente proprietario
	 */
	public Clienti costruisciCliente() {
		String CF = (String) pazientiPanel.getClientiBox().getSelectedItem();
		Clienti cl = dbControl.selectClienteFromCF(CF);
		return cl;

	}

	/**
	 * pulisce i campi testo una volta aggiornato paziente
	 * 
	 * @return void
	 */
	public void pulisciTextField() {

		pazientiPanel.getNomeText().setText(null);
		view.getPazientiPanel().getDataMorte().setDate(null);
		view.getPazientiPanel().getDataNascita().setDate(null);
		pazientiPanel.getSpecieText().setText(null);
		pazientiPanel.getRazzaText().setText(null);
		pazientiPanel.getSessoBox().setSelectedIndex(0);
		pazientiPanel.getGruppoSanguignoBox().setSelectedIndex(0);
		pazientiPanel.getMicrochip().setSelected(false);
		pazientiPanel.getSteril().setSelected(false);
		pazientiPanel.getPesoText().setText(null);
		pazientiPanel.getClientiBox().setSelectedIndex(0);
		pazientiPanel.getNoteText().setText(null);
		pazientiPanel.getVeterinariBox().setSelectedIndex(0);
	}

}
