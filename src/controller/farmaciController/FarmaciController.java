package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class FarmaciController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public FarmaciController(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		addActionListenersMenu();
		fillTable();
		fillComboBox();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		Object rowData[][] = new Object[model.getLottoFarmaciArray().size()][6];

		DefaultTableModel modello = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
				.getModel();

		for (int i = 0; i < model.getLottoFarmaciArray().size(); i++) {

			rowData[i][0] = model.getLottoFarmaciArray().get(i).getIDLotto();
			rowData[i][1] = model.getLottoFarmaciArray().get(i).getMode();
			rowData[i][2] = model.getLottoFarmaciArray().get(i).getType();
			// rowData[i][3] = res.get(i).getFornitore().getPIVA();
			rowData[i][4] = model.getLottoFarmaciArray().get(i).getDataScadenza();
			rowData[i][5] = model.getLottoFarmaciArray().get(i).getQuantita();

			if (model.getLottoFarmaciArray().get(i).getFornitore() == null) {
				rowData[i][3] = null;
			}

			else
				rowData[i][3] = model.getLottoFarmaciArray().get(i).getFornitore().getPIVA();

			modello.addRow(rowData[i]);
		}
	}

	@SuppressWarnings("unchecked")
	public void fillComboBox() {

		ArrayList<String> listaPIVA = new ArrayList<String>();

		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			listaPIVA.add(model.getFornitoriArray().get(i).getPIVA());

			if (listaPIVA != null) {
				view.getFarmaciPanel().getFornitoriBox().addItem(listaPIVA.get(i));
			}
		}
	}

	public void addActionListenersMenu() {
		

		view.getDashboard().getMenu().getMntmFarmaci().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				view.getDashboard().setVisible(false);
				view.add(view.getFarmaciPanel());
				view.getFarmaciPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		
		AggiungiFarmaciActionListener addFarmaci = new AggiungiFarmaciActionListener(model, view, dbControl);
		view.getFarmaciPanel().getBtnAggiungi().addActionListener(addFarmaci);

		EliminaFarmaciActionListener deleteFarmaci = new EliminaFarmaciActionListener(model, view, dbControl);
		view.getFarmaciPanel().getBtnElimina().addActionListener(deleteFarmaci);

		ModificaFarmaciActionListener modificaFarmaci = new ModificaFarmaciActionListener(model, view);
		view.getFarmaciPanel().getBtnModifica().addActionListener(modificaFarmaci);

		AggiornaFarmaciActionListener aggiornaFarmaci = new AggiornaFarmaciActionListener(model, dbControl, view);
		view.getFarmaciPanel().getBtnAggiorna().addActionListener(aggiornaFarmaci);

	}

	public void addActionListenerHome() {
		
		view.getFarmaciPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getFarmaciPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
