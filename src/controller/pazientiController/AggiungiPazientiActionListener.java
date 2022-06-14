package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
import view.MainView;
import view.PopupError;
/**
 * Aggiungi nuovo paziente
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	
	/**
	 * aggiunge paziente nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @exception NumberFormatException peso non valido
	 * @exception ParseException data/e noncvalida/e
	 * @return void
	 */

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		String nome = view.getPazientiPanel().getNomeText().getText();
		String specie = view.getPazientiPanel().getSpecieText().getText();
		String razza = view.getPazientiPanel().getRazzaText().getText();
		String sesso = view.getPazientiPanel().getSessoBox().getSelectedItem().toString();
		String GruppoSanguigno = view.getPazientiPanel().getGruppoSanguignoBox().getSelectedItem().toString();
		Boolean microchip = view.getPazientiPanel().getMicrochip().isSelected();
		Boolean sterilizzato = view.getPazientiPanel().getSteril().isSelected();
		double peso = 0.0;

		try {

			peso = Double.parseDouble(view.getPazientiPanel().getPesoText().getText());

		}

		catch (NumberFormatException nfe) {

			nfe.printStackTrace();
			PopupError err = new PopupError();
			err.infoBox( "Il peso deve contenere solo cifre", "Errore");

		}

		Clienti cl = costruisciCliente();
		String note = view.getPazientiPanel().getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		Date dataNascita = null;
		Date dataMorte = null;
		java.sql.Date sqlDate = null;
		java.sql.Date sqlDate2 = null;

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			dataNascita = view.getPazientiPanel().getDataNascita().getDate();
			dataMorte = view.getPazientiPanel().getDataMorte().getDate();

			if (dataNascita != null) {

				dataNascita = sdf.parse(sdf.format(dataNascita));
				System.out.println(dataNascita);

				sqlDate = new java.sql.Date(dataNascita.getTime());

			}

			if (dataMorte != null) {

				dataMorte = sdf.parse(sdf.format(dataMorte));
				System.out.println(dataMorte);

				sqlDate2 = new java.sql.Date(dataMorte.getTime());

			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox( "Data/e non valida/e", "Errore");
			e1.printStackTrace();
		}

		Paziente paz = new Paziente(0, nome, specie, razza, sqlDate, sesso, vet, GruppoSanguigno, microchip, sterilizzato,
				peso, sqlDate2, cl, note);

	

		boolean flag = dbControl.addNuovoPaziente(paz);
		
		
		int IDpaz = paz.getIDpaz();

		if (flag) {

			model.getPazientiArray().add(paz);

			Object rowData[] = new Object[14];

			DefaultTableModel modello = (DefaultTableModel) view.getPazientiPanel().getTabellaPazienti().getTable()
					.getModel();

			rowData[0] = IDpaz;
			rowData[1] = nome;
			rowData[2] = specie;
			rowData[3] = razza;
			rowData[4] = sqlDate;
			rowData[5] = sesso;
			rowData[6] = vet.getCF();
			rowData[7] = GruppoSanguigno;
			rowData[8] = microchip;
			rowData[9] = sterilizzato;
			rowData[10] = peso;
			rowData[11] = sqlDate2;
			rowData[12] = cl.getCF();
			rowData[13] = note;

			modello.addRow(rowData);
			
			// aggiungo pazient nelle combobox delle altre finestre
			view.getAppuntamentiPanel().getIDpazText().addItem(IDpaz);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Impossibile inserire paziente", "Errore");
				pulisciTextField();

			}

		}

	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo paziente
	 * 
	 * @return void
	 */

	public void pulisciTextField() {

		view.getPazientiPanel().getNomeText().setText(null);
		view.getPazientiPanel().getSpecieText().setText(null);
		view.getPazientiPanel().getRazzaText().setText(null);
		view.getPazientiPanel().getSessoBox().setSelectedIndex(0);
		view.getPazientiPanel().getDataMorte().setDate(null);
		view.getPazientiPanel().getDataNascita().setDate(null);
		view.getPazientiPanel().getGruppoSanguignoBox().setSelectedIndex(0);
		;
		view.getPazientiPanel().getMicrochip().setSelected(false);
		view.getPazientiPanel().getSteril().setSelected(false);
		view.getPazientiPanel().getPesoText().setText(null);
		view.getPazientiPanel().getClientiBox().setSelectedIndex(0);
		view.getPazientiPanel().getNoteText().setText(null);
		view.getPazientiPanel().getVeterinariBox().setSelectedIndex(0);
	}

	/**
	 * legge tutti i dati del veterinario tramite CF letto per poter passare al paziente
	 * aggiunto il veterinario di base esatto
	 * 
	 * @return Veterinario vet letto
	 */
	public Veterinari costruisciVeterinario() {
		String CF = (String) view.getPazientiPanel().getVeterinariBox().getSelectedItem();
		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}

	/**
	 * legge tutti i dati del cliente tramite CF letto per poter passare al paziente
	 * aggiunto il cliente proprietario
	 * 
	 * @return Cliente cliente proprietario
	 */
	public Clienti costruisciCliente() {
		String CF = (String) view.getPazientiPanel().getClientiBox().getSelectedItem();
		System.out.println(CF);
		Clienti cl = dbControl.selectClienteFromCF(CF);
		return cl;
	}
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiungiPazientiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
