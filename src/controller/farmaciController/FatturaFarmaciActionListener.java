package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.economia.Entrate;
import view.MainView;
import view.PopupError;
import view.PopupQuantitàPrezzo;

public class FatturaFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private PopupQuantitàPrezzo popup;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rigaSelezionata = view.getFarmaciPanel().getTabellaFarmaci().getTable().getSelectedRow();

		String causa = "Farmaci";
		String tipo = model.getLottoFarmaciArray().get(rigaSelezionata).getType();
		double prezzo = .0;

		popup = new PopupQuantitàPrezzo();

		int qt = (int) popup.getQuantitàSpinner().getValue();

		try {

			prezzo = Double.parseDouble(popup.getPrezzotext().getText());
		}

		catch (NumberFormatException e1) {

			PopupError err = new PopupError();
			err.infoBox("il prezzo non è valido", "errore");

		}

		if (qt != 0) {

			prezzo = qt * prezzo;
			Entrate entrata = new Entrate(0, tipo, prezzo, causa);

			dbControl.insertEntrate(entrata);

			model.getEntrateArray().add(entrata);

			DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();
			Object rowData[] = new Object[3];

			rowData[0] = causa;
			rowData[1] = tipo;
			rowData[2] = prezzo;

			modello.addRow(rowData);
			popup.setVisible(false);

		}

		else {

			PopupError err = new PopupError();
			err.infoBox("la quantità non può essere nulla", "errore");
		}

	}

	public FatturaFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
