package controller.amministrazioneController.entrateController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * elimina le entrate scelte dalla tabella entrate selezionandole
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class EliminaEntrateActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * elimina entrata da database, array e tabella grafica
	 * 
	 * @param e evento schiaccia bottone elimina
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getEntratePanel().getTab().getTable().getSelectedRow();

		int cod = dbControl.selectIDentrate(elementoSelezionato);

		modello.removeRow(elementoSelezionato);

		dbControl.deleteEntrate(cod);

		model.getEntrateArray().remove(elementoSelezionato);
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaEntrateActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
