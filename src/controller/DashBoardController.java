package controller;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * Collega la parte di dashboard con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class DashBoardController {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public DashBoardController(SmartVetModel model, MainView view) {
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTableFarmaciScadenza();
		fillTableAppuntamentiOggi();
	}

	/**
	 * riempie la tabella farmaci scadenza
	 *  della dashboard con
	 * i farmaci in scadenza questo mese
	 * presenti in magazzino
	 * 
	 * @return void
	 */
	public void fillTableFarmaciScadenza() {

		DefaultTableModel modello = (DefaultTableModel) view.getDashboard().getTabellaFarmaciView().getTable()
				.getModel();
		Object rowData[] = new Object[5];
		for (int i = 0; i < model.getFarmaciScadenzaArray().size(); i++) {

			rowData[0] = model.getFarmaciScadenzaArray().get(i).getIDLotto();
			rowData[4] = model.getFarmaciScadenzaArray().get(i).getType();
			rowData[2] = model.getFarmaciScadenzaArray().get(i).getDataScadenza();
			rowData[3] = model.getFarmaciScadenzaArray().get(i).getQuantita();
			rowData[1] = model.getFarmaciScadenzaArray().get(i).getMode();

			modello.addRow(rowData);
		}
	}

	/**
	 * riempie la tabella promemoria
	 * della dashboard con gli appunatamenti di
	 * oggi del cliente loggato o tutti nel
	 * caso sia loggato l'account direzione
	 * 
	 * @return void
	 */
	public void fillTableAppuntamentiOggi() {

		// personalizzo tabella
		DefaultTableModel model1 = (DefaultTableModel) view.getDashboard().getPromemoria().getTable().getModel();
		Object rowData[][] = new Object[model.getPromemoriaOggiArray().size()][5]; // fix

		for (int i = 0; i < model.getPromemoriaOggiArray().size(); i++) {

			rowData[i][0] = model.getPromemoriaOggiArray().get(i).getSala();
			rowData[i][1] = model.getPromemoriaOggiArray().get(i).getTipo();
			rowData[i][2] = model.getPromemoriaOggiArray().get(i).getData();
			rowData[i][3] = model.getPromemoriaOggiArray().get(i).getTime();
			rowData[i][4] = model.getPromemoriaOggiArray().get(i).getNote();

			model1.addRow(rowData[i]);
		}
	}
}