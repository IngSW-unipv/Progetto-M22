package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

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

	public EliminaPazientiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
