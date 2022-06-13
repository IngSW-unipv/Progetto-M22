package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class FornitoriController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public FornitoriController(SmartVetModel model, MainView view) {
		
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
		String rowData[][] = new String[model.getFornitoriArray().size()][6];
		DefaultTableModel modello = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();
		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			rowData[i][0] = model.getFornitoriArray().get(i).getPIVA();
			rowData[i][1] = model.getFornitoriArray().get(i).getNomeAzienda();
			rowData[i][2] = model.getFornitoriArray().get(i).getnTelefono();
			rowData[i][3] = model.getFornitoriArray().get(i).getEmail();
			rowData[i][4] = model.getFornitoriArray().get(i).getSede();
			rowData[i][5] = model.getFornitoriArray().get(i).getIBAN();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		System.out.println("7777");
		view.getDashboard().getMenu().getMntmFornitori().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getFornitoriPanel());
				view.getFornitoriPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiFornitoriActionListener addFornitore = new AggiungiFornitoriActionListener(model, view, dbControl);

		view.getFornitoriPanel().getBtnAggiungi().addActionListener(addFornitore);

		EliminaFornitoriActionListener deleteFornitore = new EliminaFornitoriActionListener(model, view, dbControl);
		view.getFornitoriPanel().getBtnElimina().addActionListener(deleteFornitore);

		ModificaFornitoriActionListener modificaFornitore = new ModificaFornitoriActionListener(model, view);
		view.getFornitoriPanel().getBtnModifica().addActionListener(modificaFornitore);

		AggiornaFornitoriActionListener aggiornaFornitore = new AggiornaFornitoriActionListener(model, dbControl, view);
		view.getFornitoriPanel().getBtnAggiorna().addActionListener(aggiornaFornitore);

	}

	public void addActionListenerHome() {
		view.getFornitoriPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getFornitoriPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
