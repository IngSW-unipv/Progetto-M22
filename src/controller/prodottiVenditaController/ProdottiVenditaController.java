package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controller.farmaciController.PopUpGoBtnActionListener;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega i prodotti vendita del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ProdottiVenditaController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param view      grafica
	 */
	public ProdottiVenditaController(SmartVetModel model, MainView view) {
		
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
	 * Visualizza prodotti vendita su tabella prodotti utili
	 * 
	 * @return void
	 */

	public void fillTable() {
		Object rowData[][] = new Object[model.getProdottiVenditaArray().size()][5];

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable()
				.getModel();

		for (int i = 0; i < model.getProdottiVenditaArray().size(); i++) {


			rowData[i][0] = model.getProdottiVenditaArray().get(i).getNome();
			rowData[i][1] = model.getProdottiVenditaArray().get(i).getType();

			
			rowData[i][2] = model.getProdottiVenditaArray().get(i).getQuantita();

			if (model.getProdottiVenditaArray().get(i).getFornitore() == null) {
				rowData[i][3] = null;
			}

			else
				rowData[i][3] = model.getProdottiVenditaArray().get(i).getFornitore().getPIVA();
			
			rowData[i][4] = model.getProdottiVenditaArray().get(i).getDataScadenza();

			modello.addRow(rowData[i]);
		}
	}

	
	/**
	 * riempie la comboBox con tutti i fornitori presenti nel db
	 * 
	 * @return void
	 */
	public void fillComboBox() {

		ArrayList<String> lista_PIVA = new ArrayList<String>();

		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			lista_PIVA.add(model.getFornitoriArray().get(i).getPIVA());

			if (lista_PIVA != null) {
				view.getProdottiVenditaPanel().getFornitoriBox().addItem(lista_PIVA.get(i));
			}
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello prodotti vendita da dashboard
	 * 
	 * @return void
	 */
	public void addActionListenersMenu() {
		

		view.getDashboard().getMenu().getMntmProdottiVendita().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				view.getDashboard().setVisible(false);
				view.add(view.getProdottiVenditaPanel());
				view.getProdottiVenditaPanel().setVisible(true);
			}
		});

	}

	
	/**
	 * Aggiunge action listener per aggiungere, eliminare,
	 * modificare, fatturare, aggiornare prodotti vendita
	 * 
	 * @return void
	 */
	public void addActionListenerButtons() {
		
		AggiungiProdottiVenditaActionListener addProdottiVendita = new AggiungiProdottiVenditaActionListener(model, view, dbControl);
		view.getProdottiVenditaPanel().getBtnAggiungi().addActionListener(addProdottiVendita);

		EliminaProdottiVenditaActionListener deleteProdottiVendita = new EliminaProdottiVenditaActionListener(model, view, dbControl);
		view.getProdottiVenditaPanel().getBtnElimina().addActionListener(deleteProdottiVendita);

		ModificaProdottiVenditaActionListener modificaProdottiVendita = new ModificaProdottiVenditaActionListener(model, view);
		view.getProdottiVenditaPanel().getBtnModifica().addActionListener(modificaProdottiVendita);

		AggiornaProdottiVenditaActionListener aggiornaProdottiVendita = new AggiornaProdottiVenditaActionListener(model, dbControl, view);
		view.getProdottiVenditaPanel().getBtnAggiorna().addActionListener(aggiornaProdottiVendita); 
		
		FatturaProdottiVenditaActionListener fattura = new FatturaProdottiVenditaActionListener(model, view, dbControl);
		view.getProdottiVenditaPanel().getBtnFattura().addActionListener(fattura);
		
		PopUpGoBtnActionListenerPr go = new PopUpGoBtnActionListenerPr(model, view, dbControl, fattura);
		fattura.getPopup().getBtnGo().addActionListener(go);

	}

	
	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
	public void addActionListenerHome() {
		
		view.getProdottiVenditaPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getProdottiVenditaPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}

