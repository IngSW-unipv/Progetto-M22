package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;

/**
 * Elimina veterinario selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class EliminaVeterinariActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * elimina veterinario da database, array e tabella grafica
	 * 
	 * @param e evento schiaccia bottone elimina veterinario
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel modello = (DefaultTableModel) view.getVeterinariPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getVeterinariPanel().getTab().getTable().getSelectedRow();

		String CF = model.getVeterinariArray().get(elementoSelezionato).getCF();

		if (model.getCFuser().equals(CF)) {
			PopupError err = new PopupError();
			err.infoBox("Non puoi eliminare veterinario con cui sei loggato", "Errore");
		}

		else {
		///// elimino anche da comboBox delle altre finestre
		view.getPazientiPanel().getVeterinariBox()
				.removeItem(model.getVeterinariArray().get(elementoSelezionato).getCF());

		if (model.getCFuser().equals("direzione")) {

			view.getAppuntamentiPanel().getCFvetText()
					.removeItem(model.getVeterinariArray().get(elementoSelezionato).getCF());
		}
		///

		modello.removeRow(elementoSelezionato);

		dbControl.deleteVeterinario(model.getVeterinariArray().get(elementoSelezionato));
		model.getVeterinariArray().remove(elementoSelezionato);
		
		}
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaVeterinariActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}