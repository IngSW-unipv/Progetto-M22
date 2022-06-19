package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;
import view.MainView;
import view.PopupError;

/**
 * Aggiorna Appuntamento selezionato. Tramite tasto modifica riempio ogni campo
 * di testo con i parametri che voglio modificare e modifico. Leggendo quello
 * che c'è nei textfield aggiorno l'appuntamento con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private int elementoSelezionato;

	/**
	 * Leggo i campi testo modificati e aggiorno il record di appuntamento
	 * selezionato in database, array e grafica di appuntamenti, storico, sale
	 * 
	 * @param e evento schiaccia bottone aggiorna
	 * @exception ParseException        se data inserita non valida
	 * @exception ParseException        se ora inserita non valida
	 * @exception NumberFormatException se costo inserito non valido
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();
		elementoSelezionato = view.getAppuntamentiPanel().getTab().getTable().getSelectedRow();

		int COD = dbControl.selectIDappuntamenti(elementoSelezionato, model.getCFuser());
		int IDpaz = (int) view.getAppuntamentiPanel().getIDpazText().getSelectedItem();
		String sala = view.getAppuntamentiPanel().getSalaText().getSelectedItem().toString();
		String tipo = view.getAppuntamentiPanel().getTipoText().getText().toString();
		Date data = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		java.sql.Date sqlDate = null;
		java.sql.Time timeValue = null;

		try {

			data = view.getAppuntamentiPanel().getDataText().getDate();

			if (data != null) {

				data = sdf.parse(sdf.format(data));

				sqlDate = new java.sql.Date(data.getTime());

			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox("Data non valida", "Errore");
			// e1.printStackTrace();
		}

		String ora = view.getAppuntamentiPanel().getTimeChooserText().getFormatedTime();
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");

		try {

			timeValue = new java.sql.Time(stf.parse(ora).getTime());

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox("Orario non valido", "Errore");
			// e1.printStackTrace();
		}

		double costo = 0.0;

		try {
			costo = Double.parseDouble(view.getAppuntamentiPanel().getCostoText().getText());
		}

		catch (NumberFormatException nfe) {

			PopupError err = new PopupError();
			err.infoBox("Il costo deve contenere solo cifre", "Errore");
			// nfe.printStackTrace();

		}

		String note = view.getAppuntamentiPanel().getNoteText().getText().toString();
		DefaultTableModel modelloStorico = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();
		DefaultTableModel modelloSale = (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();
		DefaultTableModel modelloPromemoria = (DefaultTableModel) view.getDashboard().getPromemoria().getTable()
				.getModel();

		Paziente paz = costruisciPaziente();
		Veterinari vet = costruisciVeterinario();

		Appuntamenti app = new Appuntamenti(COD, paz, sala, tipo, sqlDate, timeValue, vet, costo, note);

		// data di oggi
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		Date oraAdesso = null;
		String orario = stf.format(Calendar.getInstance().getTime());

		try {
			oraAdesso = stf.parse(orario);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!((dateObj.before(data) || (dateObj.getDay() == data.getDay() && dateObj.getMonth() == data.getMonth()
				&& dateObj.getYear() == data.getYear())) && data != null)) {

			PopupError err = new PopupError();
			err.infoBox("non puoi inserire un appuntamento vecchio", "Errore");

			sqlDate = (java.sql.Date) view.getAppuntamentiPanel().getTab().getTable().getValueAt(elementoSelezionato,
					3);

			timeValue = (Time) view.getAppuntamentiPanel().getTab().getTable().getValueAt(elementoSelezionato, 4);

		}

		((DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel()).removeRow(elementoSelezionato);

		int index = ricercaLineare(COD, model.getAppuntamentiArray());

		int rigaGiusta = dbControl.selectRigaGiusta(model.getCFuser(), COD);

		dbControl.updateAppuntamenti(app);


		model.getAppuntamentiArray().get(index).setPaziente(paz);
		model.getAppuntamentiArray().get(index).setSala(sala);
		model.getAppuntamentiArray().get(index).setTipo(tipo);
		model.getAppuntamentiArray().get(index).setData(sqlDate);
		model.getAppuntamentiArray().get(index).setTime(timeValue);
		model.getAppuntamentiArray().get(index).setVeterinario(vet);
		model.getAppuntamentiArray().get(index).setCosto(costo);
		model.getAppuntamentiArray().get(index).setNote(note);

		Object rowData[] = new Object[8];

		rowData[0] = IDpaz;
		rowData[1] = sala;
		rowData[2] = tipo;
		rowData[3] = sqlDate;
		rowData[4] = timeValue;
		rowData[5] = vet.getCF();
		rowData[6] = costo;
		rowData[7] = note;

		System.out.println(rigaGiusta + "RIGA");
		modello.insertRow(rigaGiusta - 1, rowData);

		if ((dateObj.before(data) || (dateObj.getDay() == data.getDay() && dateObj.getMonth() == data.getMonth()
				&& dateObj.getYear() == data.getYear())) && data != null) {
			// storico
			model.getStoricoArray().add(app);
			modelloStorico.removeRow(elementoSelezionato);
			modelloStorico.insertRow(rigaGiusta - 1, rowData);

			// Sale occupate
			Object rowData2[] = new Object[5];

			rowData2[0] = IDpaz;
			rowData2[1] = sala;
			rowData2[2] = tipo;
			rowData2[3] = sqlDate;
			rowData2[4] = timeValue;

			int rigaGiustaSala = dbControl.selectRigaGiustaSala(COD);

			modelloSale.removeRow(rigaGiustaSala - 1);
			modelloSale.insertRow(rigaGiustaSala - 1, rowData2);

		}

		// promemoria
		if (sdf.format(dateObj).equals(sdf.format(sqlDate))
				&& ((model.getCFuser().equals(vet.getCF()) || model.getCFuser().equals("direzione")))) {

			int indexProm = ricercaLineare(COD, model.getPromemoriaOggiArray());

			if (indexProm != -1) {

				modelloPromemoria.removeRow(indexProm);
				model.getPromemoriaOggiArray().remove(indexProm);
			}

			Object rowData3[] = new Object[5];

			rowData3[0] = app.getSala();
			rowData3[1] = app.getTipo();
			rowData3[2] = app.getData();
			rowData3[3] = app.getTime();
			rowData3[4] = app.getNote();

			modelloPromemoria.addRow(rowData3);
			model.getPromemoriaOggiArray().add(app);
		}

		pulisciTextField();
	}

	/**
	 * legge tutti i dati del paziente tramite ID letto per poter passare
	 * all'appuntamento aggiornato il paziente esatto
	 * 
	 * @return Paziente paziente letto
	 */

	public Paziente costruisciPaziente() {

		int ID = (int) view.getAppuntamentiPanel().getIDpazText().getSelectedItem();
		Paziente paz = dbControl.selectPazienteFromID(ID);
		return paz;
	}

	/**
	 * legge tutti i dati del veterinario tramite ID letto per poter passare
	 * all'appuntamento aggiornato il veterinario esatto
	 * 
	 * @return Veterinari veterinario letto
	 */
	public Veterinari costruisciVeterinario() {

		String CF = null;

		if (model.getCFuser() == "direzione") {

			CF = (String) view.getAppuntamentiPanel().getCFvetText().getSelectedItem();
		}

		else {

			CF = model.getCFuser();
		}

		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}

	/**
	 * pulisce i campi testo una volta aggiornato appuntamento
	 * 
	 * @return void
	 */

	public void pulisciTextField() {

		java.sql.Time timeValue = null;
		String ora = "00:00:00";
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");

		try {
			timeValue = new java.sql.Time(stf.parse(ora).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.getAppuntamentiPanel().getIDpazText().setSelectedIndex(0);
		view.getAppuntamentiPanel().getSalaText().setSelectedIndex(0);
		view.getAppuntamentiPanel().getTipoText().setText(null);
		view.getAppuntamentiPanel().getDataText().setDate(null);

		if (view.getAppuntamentiPanel().getCFvetText() != null) {

			view.getAppuntamentiPanel().getCFvetText().setSelectedIndex(0);

		}
		view.getAppuntamentiPanel().getTimeChooserText().setTime(timeValue);
		view.getAppuntamentiPanel().getCostoText().setText(null);
		view.getAppuntamentiPanel().getNoteText().setText(null);
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiornaAppuntamentiActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	public int ricercaLineare(int COD, ArrayList<Appuntamenti> array) {

		int index = -1;
		System.out.println(COD + "coddd");
		for (int i = 0; i < array.size(); i++) {

			if (array.get(i).getCOD() == COD) {
			
				index = i;
				System.out.println(index + "INDEX");
				
			}

		}
		return index;
	}
}
