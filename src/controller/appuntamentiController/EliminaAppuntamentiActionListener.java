package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.appuntamenti.Appuntamenti;
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

		int cod = dbControl.selectIDappuntamenti(elementoSelezionato, model.getCFuser());

		modello.removeRow(elementoSelezionato);
		modelloStorico.removeRow(elementoSelezionato);
		
		
		dbControl.deleteAppuntamenti(cod);
		
	
		
		int index = ricercaLineare(cod, model.getAppuntamentiArray());
		model.getAppuntamentiArray().remove(index);
		model.getStoricoArray().remove(index);
		
		int rigaGiustaSala = dbControl.selectRigaGiustaSala(cod);
		modelloSale.removeRow(rigaGiustaSala - 1);
		
		int indexPromemoria = ricercaLineare(cod, model.getPromemoriaOggiArray());
		modelloPromemoria.removeRow(indexPromemoria);
		model.getPromemoriaOggiArray().remove(indexPromemoria);
		
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
	
	public int ricercaLineare(int COD, ArrayList<Appuntamenti> array) {

		int index = -1;
		for (int i = 0; i < array.size(); i++) {

			if (array.get(i).getCOD() == COD) {
				index = i;
			}

		}
		return index;
	}
	
}
