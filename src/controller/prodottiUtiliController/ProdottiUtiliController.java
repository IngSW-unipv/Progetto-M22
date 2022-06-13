package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class ProdottiUtiliController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public ProdottiUtiliController(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		addActionListenersMenu();
		fillTable();
		fillComboBox();
		addActionListenerButtons();
		addActionListenerHome();
	}
	
	public void fillTable() {
		Object rowData[][] = new Object[model.getProdottiUtiliArray().size()][4];

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiUtiliPanel().getTabellaProdottiUtili().getTable()
				.getModel();
	
		for (int i = 0; i < model.getProdottiUtiliArray().size(); i++) {

			rowData[i][0] = model.getProdottiUtiliArray().get(i).getNome();
			rowData[i][1] = model.getProdottiUtiliArray().get(i).getType();

			
			rowData[i][2] = model.getProdottiUtiliArray().get(i).getQuantita();

			if (model.getProdottiUtiliArray().get(i).getFornitore() == null) {
				rowData[i][3] = null;
			}

			else
				rowData[i][3] = model.getProdottiUtiliArray().get(i).getFornitore().getPIVA();

			modello.addRow(rowData[i]);
			
			
		}
	}

	@SuppressWarnings("unchecked")
	public void fillComboBox() {

		ArrayList<String> lista_PIVA = new ArrayList<String>();

		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			lista_PIVA.add(model.getFornitoriArray().get(i).getPIVA());

			if (lista_PIVA != null) {
				view.getProdottiUtiliPanel().getFornitoriBox().addItem(lista_PIVA.get(i));
			}
		}
	}

	public void addActionListenersMenu() {
		

		view.getDashboard().getMenu().getMntmProdottiutili().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				view.getDashboard().setVisible(false);
				view.add(view.getProdottiUtiliPanel());
				view.getProdottiUtiliPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		
		AggiungiProdottiUtiliActionListener addProdottiUtili = new AggiungiProdottiUtiliActionListener(model, view, dbControl);
		view.getProdottiUtiliPanel().getBtnAggiungi().addActionListener(addProdottiUtili);
		
		EliminaProdottiUtiliActionListener deleteProdottiUtili = new EliminaProdottiUtiliActionListener(model, view, dbControl);
		view.getProdottiUtiliPanel().getBtnElimina().addActionListener((ActionListener) deleteProdottiUtili);

		ModificaProdottiUtiliActionListener modificaProdottiUtili = new ModificaProdottiUtiliActionListener(model, view);
		view.getProdottiUtiliPanel().getBtnModifica().addActionListener(modificaProdottiUtili);

		AggiornaProdottiUtiliActionListener aggiornaProdottiUtili = new AggiornaProdottiUtiliActionListener(model, dbControl, view);
		view.getProdottiUtiliPanel().getBtnAggiorna().addActionListener(aggiornaProdottiUtili);

	}

	public void addActionListenerHome() {
		
		view.getProdottiUtiliPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getProdottiUtiliPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}

