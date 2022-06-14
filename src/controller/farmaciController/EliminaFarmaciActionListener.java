package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Elimina farmaco selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class EliminaFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * elimina farmaco selezionato da database, array e tabella grafica
	 * 
	 * @param e evento schiaccia bottone elimina uscita
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
				.getModel();

		int elementoSelezionato = view.getFarmaciPanel().getTabellaFarmaci().getTable().getSelectedRow();
		modello.removeRow(elementoSelezionato);

		dbControl.deleteLotto(model.getLottoFarmaciArray().get(elementoSelezionato));

		model.getLottoFarmaciArray().remove(elementoSelezionato);
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
