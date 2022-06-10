package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import view.MainView;

public class EliminaFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel modello = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getFornitoriPanel().getTab().getTable().getSelectedRow();

		Fornitori forn = model.getFornitoriArray().get(elementoSelezionato);

		// elimino anche da comboBox delle altre finestre
		view.getFarmaciPanel().getFornitoriBox().removeItem(forn.getPIVA());
		view.getProdottiUtiliPanel().getFornitoriBox().removeItem(forn.getPIVA());

		model.setNullDueToFornitori(forn);

		modello.removeRow(elementoSelezionato);

		dbControl.deleteFornitore(forn);
		model.getFornitoriArray().remove(elementoSelezionato);

		// setto a null ogni tabella che ha fornitore come foreign key

	}

	public EliminaFornitoriActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}