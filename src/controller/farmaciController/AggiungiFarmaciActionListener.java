package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.MainView;
import view.PopupError;

/**
 * Aggiunge nuovo farmaco
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class AggiungiFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * aggiunge farmaco nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @return void
	 */

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String IDLotto = view.getFarmaciPanel().getIDLottoText().getText();
		String type = view.getFarmaciPanel().getTipoText().getText();
		String mode = view.getFarmaciPanel().getModeText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = null;
		java.sql.Date sqlDate = null;

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			dataScadenza = view.getFarmaciPanel().getDataScadenza().getDate();

			if (dataScadenza != null) {

				dataScadenza = sdf.parse(sdf.format(dataScadenza));
 
				sqlDate = new java.sql.Date(dataScadenza.getTime());
			}
		}

		catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox("Data non valida", "Errore");
			//e1.printStackTrace();
		}

		//

		int quantita = (int) view.getFarmaciPanel().getSpinner().getValue();

		//data di oggi
		Calendar calendar = Calendar.getInstance();
		Date dateObj = calendar.getTime();
		
		LottoFarmaci nuovoLotto = new LottoFarmaci(IDLotto, mode, type, forn, sqlDate, quantita);
		boolean flag = dbControl.addLottoFarmaci(nuovoLotto);
		

		if (flag) {

			model.getLottoFarmaciArray().add(nuovoLotto);

			Object rowData[] = new Object[6];

			DefaultTableModel modello = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
					.getModel();
			DefaultTableModel modelloProm = (DefaultTableModel) view.getDashboard().getTabellaFarmaciView().getTable()
					.getModel();

			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;
			rowData[5] = quantita;

			modello.addRow(rowData);
		
			//promemoria
			if (dateObj.getMonth() == sqlDate.getMonth()  && dateObj.getYear() == sqlDate.getYear()) {
				Object rowData1[] = new Object[5];
				
				rowData1[0] = IDLotto;
				rowData1[4] = type;
				rowData1[2] = sqlDate;
				rowData1[3] = quantita;
				rowData1[1] = mode;
				
				modelloProm.addRow(rowData1);
				model.getFarmaciScadenzaArray().add(nuovoLotto);
				
			}
			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un farmaco con questo n. lotto", "Impossibile inserire farmaco");
				pulisciTextField();

			}

		}

	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo farmaco
	 * 
	 * @return void
	 */

	private void pulisciTextField() {

		view.getFarmaciPanel().getIDLottoText().setText(null);
		view.getFarmaciPanel().getDataScadenza().setDate(null);
		view.getFarmaciPanel().getModeText().setText(null);
		view.getFarmaciPanel().getTipoText().setText(null);
		view.getFarmaciPanel().getFornitoriBox().setSelectedIndex(0);
		view.getFarmaciPanel().getSpinner().setValue(0);
	}

	/**
	 * legge tutti i dati del fornitore tramite ID letto per poter passare al
	 * farmaco aggiunti il fornitore esatto
	 * 
	 * @return Veterinari veterinario letto
	 */
	private Fornitori costruisciFornitore() {
		String PIVA = view.getFarmaciPanel().getFornitoriBox().getSelectedItem().toString();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiungiFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
