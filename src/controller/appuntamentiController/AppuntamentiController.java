package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class AppuntamentiController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public AppuntamentiController(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {

		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
		
		if (model.getCFuser().equals("direzione") ) {
			
			fillTable();
			view.getAppuntamentiPanel().addComboBoxVets();
			fillComboBoxVets();
		}

		else {
	
			fillTableDueToVeterinario();
		}

		fillComboBoxPaz();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {

		Object rowData[][] = new Object[model.getAppuntamentiArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getAppuntamentiArray().size(); i++) {

			rowData[i][0] = model.getAppuntamentiArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getAppuntamentiArray().get(i).getSala();
			rowData[i][2] = model.getAppuntamentiArray().get(i).getTipo();
			rowData[i][3] = model.getAppuntamentiArray().get(i).getData();
			rowData[i][4] = model.getAppuntamentiArray().get(i).getTime();
			rowData[i][5] = model.getAppuntamentiArray().get(i).getVeterinario().getCF();
			rowData[i][6] = model.getAppuntamentiArray().get(i).getCosto();
			rowData[i][7] = model.getAppuntamentiArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	public void fillTableDueToVeterinario() {

		Object rowData[][] = new Object[model.getAppuntamentiArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getAppuntamentiArray().size(); i++) {

			rowData[i][0] = model.getAppuntamentiArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getAppuntamentiArray().get(i).getSala();
			rowData[i][2] = model.getAppuntamentiArray().get(i).getTipo();
			rowData[i][3] = model.getAppuntamentiArray().get(i).getData();
			rowData[i][4] = model.getAppuntamentiArray().get(i).getTime();
			rowData[i][5] = model.getAppuntamentiArray().get(i).getVeterinario().getCF();
			rowData[i][6] = model.getAppuntamentiArray().get(i).getCosto();
			rowData[i][7] = model.getAppuntamentiArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMenuItemAppuntamenti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getAppuntamentiPanel());
				view.getAppuntamentiPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiAppuntamentiActionListener addAppuntamenti = new AggiungiAppuntamentiActionListener(model, view,
				dbControl);

		view.getAppuntamentiPanel().getBtnAggiungi().addActionListener(addAppuntamenti);

		EliminaAppuntamentiActionListener deleteAppuntamenti = new EliminaAppuntamentiActionListener(model, view,
				dbControl);
		view.getAppuntamentiPanel().getBtnElimina().addActionListener(deleteAppuntamenti);

		ModificaAppuntamentiActionListener modificaAppuntamenti = new ModificaAppuntamentiActionListener(model, view);
		view.getAppuntamentiPanel().getBtnModifica().addActionListener(modificaAppuntamenti);

		AggiornaAppuntamentiActionListener aggiornaAppuntamenti = new AggiornaAppuntamentiActionListener(model,
				dbControl, view);
		view.getAppuntamentiPanel().getBtnAggiorna().addActionListener(aggiornaAppuntamenti);

	}

	@SuppressWarnings("unchecked")
	public void fillComboBoxPaz() {

		for (int i = 0; i < model.getPazientiArray().size(); i++) {

			view.getAppuntamentiPanel().getIDpazText().addItem(dbControl.selectID_PAZ(i));
		}

		for (int i = 0; i < dbControl.selectallIDsale().length; i++) {

			view.getAppuntamentiPanel().getSalaText().addItem(dbControl.selectallIDsale()[i]);
		}
	}

	public void fillComboBoxVets() {
		ArrayList<String> listaCFvet = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			listaCFvet.add(model.getVeterinariArray().get(i).getCF());

			if (listaCFvet.get(i) != null && !(listaCFvet.get(i).equals("direzione")) ) {

				view.getAppuntamentiPanel().getCFvetText().addItem(listaCFvet.get(i));
			}
		}
	}

	public void addActionListenerHome() {
		view.getAppuntamentiPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getAppuntamentiPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
