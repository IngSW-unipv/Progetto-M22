package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Elimina prodotto vendita selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class EliminaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	

	/**
	 * elimina prodotto selezionato da database, array e tabella grafica
	 * @param e evento schiaccia bottone elimina prodotto
	 * @return void
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel()
				.getTable().getModel(); 

		int elementoSelezionato = view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable()
				.getSelectedRow();
		modello.removeRow(elementoSelezionato);

		int COD = dbControl.selectIDProdottiVendita(elementoSelezionato);

		dbControl.deleteProdottiVendita(COD);

		model.getProdottiVenditaArray().remove(elementoSelezionato);
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EliminaProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
