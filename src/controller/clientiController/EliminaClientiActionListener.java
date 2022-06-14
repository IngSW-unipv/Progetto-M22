package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Elimina cliente selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class EliminaClientiActionListener implements ActionListener {

	private MainView view;
	private DbControllerSingleton dbControl;
	private SmartVetModel model;

	/**
	 * elimina cliente selezionato da database, array e tabella grafica
	 * 
	 * @param e evento schiaccia bottone elimina uscita
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel modello = (DefaultTableModel) view.getClientiPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getClientiPanel().getTab().getTable().getSelectedRow();

		// elimino anche nelle combobox nelle altre finestre
		view.getPazientiPanel().getClientiBox().removeItem(model.getClientiArray().get(elementoSelezionato).getCF());
		//

		modello.removeRow(elementoSelezionato);

		dbControl.deleteCliente(model.getClientiArray().get(elementoSelezionato));

		model.getClientiArray().get(elementoSelezionato);

	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaClientiActionListener(MainView view, DbControllerSingleton dbControl, SmartVetModel model) {
		super();
		this.view = view;
		this.dbControl = dbControl;
		this.model = model;
	}

}