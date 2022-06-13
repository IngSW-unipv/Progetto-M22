package controller.amministrazioneController.usciteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class UsciteController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public UsciteController(SmartVetModel model, MainView view) {
		
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();
		
		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		Object rowData[][] = new Object[model.getUsciteArray().size()][3];

		DefaultTableModel modello = (DefaultTableModel) view.getUscitePanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getUsciteArray().size(); i++) {

			rowData[i][0] = model.getUsciteArray().get(i).getCausa();
			rowData[i][1] = model.getUsciteArray().get(i).getTipo();
			rowData[i][2] = model.getUsciteArray().get(i).getPrezzo();
			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmUscite().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getUscitePanel());
				view.getUscitePanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {

		AggiungiUsciteActionListener addUscite = new AggiungiUsciteActionListener(model, view, dbControl);
		view.getUscitePanel().getBtnAggiungi().addActionListener(addUscite);

		EliminaUsciteActionListener deleteUscite = new EliminaUsciteActionListener(model, view, dbControl);
		view.getUscitePanel().getBtnElimina().addActionListener(deleteUscite);

	}

	public void addActionListenerHome() {

		view.getUscitePanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getUscitePanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}