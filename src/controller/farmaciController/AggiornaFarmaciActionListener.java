package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.MainView;
import view.PopupError;
import view.magazzino.farmaci.FarmaciPanel;

/**
 * Aggiorna lotto farmaco selezionato. Tramite tasto modifica riempio ogni campo
 * di testo con i parametri che voglio modificare e modifico. Leggendo quello
 * che c'è nei textfield aggiorno il farmaco con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private FarmaciPanel farmaciPanel;

	/**
	 * Leggo i campi testo modificati e aggiorno il record selezionato in database,
	 * array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiorna
	 * @exception ParseException dataScadenza non valida
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		farmaciPanel = view.getFarmaciPanel();

		int elementoSelezionato = farmaciPanel.getTabellaFarmaci().getTable().getSelectedRow();
		((DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel()).removeRow(elementoSelezionato);

		dbControl.deleteLotto(model.getLottoFarmaciArray().get(elementoSelezionato));

		model.getLottoFarmaciArray().remove(elementoSelezionato);

		String IDLotto = farmaciPanel.getIDLottoText().getText();
		String mode = farmaciPanel.getModeText().getText();
		String type = farmaciPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = null;
		java.sql.Date sqlDate = null;
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
			e1.printStackTrace();
			PopupError err = new PopupError();
			err.infoBox("Data non valida", "Errore");
		}

		int qt = (int) farmaciPanel.getSpinner().getValue();

		DefaultTableModel modello = (DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel();
		LottoFarmaci lo = new LottoFarmaci(IDLotto, mode, type, forn, sqlDate, qt);

		boolean flag = dbControl.addLottoFarmaci(lo);

		Object rowData[] = new Object[6];

		if (flag) {

			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;
			rowData[5] = qt;

			modello.addRow(rowData);
			model.getLottoFarmaciArray().add(lo);
		}

		else {
			PopupError err = new PopupError();
			err.infoBox("Impossibile aggiornare Lotto", "Errore");
		}

		pulisciTextField();
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */

	public AggiornaFarmaciActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	/**
	 * legge tutti i dati del fornitore tramite ID letto per poter passare al farmaco
	 * aggiornato il fornitore esatto
	 * 
	 * @return Fornitore fornitore letto
	 */
	public Fornitori costruisciFornitore() {
		String PIVA = (String) farmaciPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

		/**
		 * pulisce i campi testo una volta aggiornato farmaco
		 * 
		 * @return void
		 */
	}

	public void pulisciTextField() {
		farmaciPanel.getIDLottoText().setText(null);
		farmaciPanel.getDataScadenza().setDate(null);
		farmaciPanel.getModeText().setText(null);
		farmaciPanel.getTipoText().setText(null);
		farmaciPanel.getFornitoriBox().setSelectedIndex(0);
		farmaciPanel.getSpinner().setValue(0);
	}

}
