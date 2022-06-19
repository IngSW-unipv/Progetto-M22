package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Aggiunge nuovo Appuntamento
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * aggiunge appuntamento nuovo in database, array e grafica di appuntamenti,
	 * storico e sale prendendo i parametri dai campi testo/data. un veterinario
	 * loggato può aggiungere solo suoi appuntamenti, invece se si logga l' account
	 * direzione potrà scegliere per quale veterinario aggiungere l'appuntamento
	 * tramite una combobox
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @exception ParseException        se data inserita non valida
	 * @exception ParseException        se ora inserita non valida
	 * @exception NumberFormatException se costo inserito non valid
	 * @return void
	 */

	@SuppressWarnings({ "static-access", "deprecation" })
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int ID_PAZ = (int) view.getAppuntamentiPanel().getIDpazText().getSelectedItem();
		String sala = view.getAppuntamentiPanel().getSalaText().getSelectedItem().toString();
		String tipo = view.getAppuntamentiPanel().getTipoText().getText();
		java.sql.Date sqlDate = null;
		Date data = null;
		java.sql.Time timeValue = null;

		// data di oggi
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			data = view.getAppuntamentiPanel().getDataText().getDate();

			if (data != null) {

				data = sdf.parse(sdf.format(data));
				sqlDate = new java.sql.Date(data.getTime());

			} else {
				PopupError err = new PopupError();
				err.infoBox("Data non valida", "Errore");
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

		} catch (NumberFormatException nfe) {

			PopupError err = new PopupError();
			err.infoBox("il costo deve contenere solo cifre", "Errore");
			// nfe.printStackTrace();
		}

		String note = view.getAppuntamentiPanel().getNoteText().getText();

		Paziente paz = costruisciPaziente();
		Veterinari vet = costruisciVeterinario();

		Appuntamenti nuovoApp = new Appuntamenti(0, paz, sala, tipo, sqlDate, timeValue, vet, costo, note);

		boolean flag = false;
		int codApp = -1;

	
		
		Date oraAdesso = null;
			
			

	
				String orario  = stf.format(Calendar.getInstance().getTime());
				try {
					oraAdesso = stf.parse(orario);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

		
		
	
		
		if ((dateObj.before(data) || (dateObj.getDay() == data.getDay() && dateObj.getMonth() == data.getMonth() && dateObj.getYear() ==
				data.getYear() && oraAdesso.before(timeValue) )) && data != null) {

			System.out.println(data + "data app" + timeValue);
			System.out.println(dateObj + "data oggi" + oraAdesso);
			
			flag = dbControl.addNuovoAppuntamento(nuovoApp);
			codApp = nuovoApp.getCOD();

		}

		else {
			PopupError err = new PopupError();
			err.infoBox("non puoi inserire un appuntamento vecchio", "Errore");
		}

		if (flag) {

			Object rowData[] = new Object[8];

			DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();
			DefaultTableModel modelloStorico = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();
			DefaultTableModel modelloSale = (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();
			DefaultTableModel modelloPromemoria = (DefaultTableModel) view.getDashboard().getPromemoria().getTable()
					.getModel();

			rowData[0] = ID_PAZ;
			rowData[1] = sala;
			rowData[2] = tipo;
			rowData[3] = sqlDate;
			rowData[4] = timeValue;
			rowData[5] = vet.getCF();
			rowData[6] = costo;
			rowData[7] = note;

			
			int rigaGiusta = dbControl.selectRigaGiusta(model.getCFuser(), codApp);
			
			if (dateObj.before(data) || dateObj.getDay() == data.getDay()) {

				// così è in ordine come nel db
				modello.insertRow(rigaGiusta -1, rowData);

				model.getAppuntamentiArray().add(nuovoApp);
			
				// sale occupate
				Object rowData2[] = new Object[5];

				rowData2[0] = ID_PAZ;
				rowData2[1] = sala;
				rowData2[2] = tipo;
				rowData2[3] = sqlDate;
				rowData2[4] = timeValue;

				int rigaGiustaSala = dbControl.selectRigaGiustaSala(nuovoApp.getCOD());
				modelloSale.insertRow(rigaGiustaSala - 1, rowData2);
			}

			model.getStoricoArray().add(nuovoApp);
			modelloStorico.insertRow(rigaGiusta - 1, rowData);


			if (sdf.format(dateObj).equals(sdf.format(sqlDate))
					&& ((model.getCFuser().equals(vet.getCF()) || model.getCFuser().equals("direzione")))) {

				model.getPromemoriaOggiArray().add(nuovoApp);
				Object rowData3[] = new Object[5];

				rowData3[0] = nuovoApp.getSala();
				rowData3[1] = nuovoApp.getTipo();
				rowData3[2] = nuovoApp.getData();
				rowData3[3] = nuovoApp.getTime();
				rowData3[4] = nuovoApp.getNote();

				modelloPromemoria.addRow(rowData3);
			}

			pulisciTextField();

		}
		

		else {

			PopupError err = new PopupError();
			err.infoBox("Errore", "Impossibile inserire appuntamento");
			pulisciTextField();

		}
		
	}
	

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo appuntamento
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
	 * legge tutti i dati del paziente tramite ID letto per poter passare
	 * all'appuntamento aggiunto il paziente esatto
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
	 * all'appuntamento aggiunti il veterinario esatto
	 * 
	 * @return Veterinari veterinario letto
	 */
	public Veterinari costruisciVeterinario() {

		String CF = null;

		if (model.getCFuser().equals("direzione")) {

			CF = (String) view.getAppuntamentiPanel().getCFvetText().getSelectedItem();
		}

		else {

			CF = model.getCFuser();
		}

		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiungiAppuntamentiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}