package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega i prodotti utili del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ProdottiUtiliController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
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
	
	/**
	 * Visualizza prodotti utili su tabella prodotti utili
	 * 
	 * @return void
	 */

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

	/**
	 * riempie la comboBox con tutti i fornitori presenti nel db
	 * 
	 * @return void
	 */
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

	
	/**
	 * Aggiunge action listener al menu per aprire pannello parodotti utili da dashboard
	 * 
	 * @return void
	 */
	public void addActionListenersMenu() {
		

		view.getDashboard().getMenu().getMntmProdottiutili().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				view.getDashboard().setVisible(false);
				view.add(view.getProdottiUtiliPanel());
				view.getProdottiUtiliPanel().setVisible(true);
			}
		});

	}
	/**
	 * Aggiunge action listener per aggiungere, eliminare,
	 * modificare, aggiornare prodotti utili
	 * 
	 * @return void
	 */
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

	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
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

