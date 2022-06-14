package controller.amministrazioneController.usciteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * elimina le uscite registrate
 * @author      MMA
 * @version     1.0                 (current version number of program)
 * @see 		UsciteController
 */

public class EliminaUsciteActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	
	/**
	* elimina uscita da database, array e tabella grafica
	* @param e 	evento schiaccia bottone elimina uscita
	* @return void
	*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel modello = (DefaultTableModel) view.getUscitePanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getUscitePanel().getTab().getTable().getSelectedRow();

		modello.removeRow(elementoSelezionato);

		int COD = dbControl.selectIDuscite(elementoSelezionato);

		dbControl.deleteUscite(COD);

		model.getUsciteArray().remove(elementoSelezionato);
	}

	/**
	 * costruttore
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaUsciteActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
