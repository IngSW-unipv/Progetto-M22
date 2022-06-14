package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaPazientiActionListener implements ActionListener {
	/**
	 * Elimina paziente selezionato
	 * 
	 * @author MMA
	 * @version 1.0 (current version number of program)
	 */
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * elimina paziente selezionato da database, array e tabella grafica
	 * anche dalle combobox di altri pannelli
	 * @param e evento schiaccia bottone elimina paziente
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getPazientiPanel().getTabellaPazienti().getTable()
				.getModel();

		int elementoSelezionato = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		int ID_PAZ = dbControl.selectID_PAZ(elementoSelezionato);
		
		//// elimino anche da comboBox delle altre finestre
		view.getAppuntamentiPanel().getIDpazText().removeItem(ID_PAZ);
		
		modello.removeRow(elementoSelezionato);

		dbControl.deletePazienti(ID_PAZ);

		model.getPazientiArray().remove(elementoSelezionato);
	}
	
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaPazientiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
