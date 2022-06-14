package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * Elimina appuntamento selezionato
 * @author      MMA
 * @version     1.0                 (current version number of program)
 */
public class EliminaAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * elimina appuntamento selezionato da database, array e tabella grafica di appuntamenti,
	 * storico e sale
	 * 
	 * @param e evento schiaccia bottone elimina uscita
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();
		DefaultTableModel modelloStorico = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();
		DefaultTableModel modelloSale = (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();
		DefaultTableModel modelloPromemoria = (DefaultTableModel) view.getDashboard().getPromemoria().getTable()
				.getModel();

		int elementoSelezionato = view.getAppuntamentiPanel().getTab().getTable().getSelectedRow();

		int cod = dbControl.selectIDappuntamenti(elementoSelezionato);

		modello.removeRow(elementoSelezionato);
		modelloStorico.removeRow(elementoSelezionato);
		modelloSale.removeRow(elementoSelezionato);

		dbControl.deleteAppuntamenti(cod);

		model.getAppuntamentiArray().remove(elementoSelezionato);
		model.getStoricoArray().remove(elementoSelezionato);
		model.getSaleOccupateArray().remove(elementoSelezionato);
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaAppuntamentiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
