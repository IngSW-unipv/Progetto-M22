package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiUtili.ProdottiUtili;
import view.MainView;
import view.magazzino.prodottiUtili.ProdottiUtiliPanel;

/**
 * Aggiorna prodotto utile selezionato. Tramite tasto modifica riempio ogni campo
 * di testo con i parametri che voglio modificare e modifico. Leggendo quello
 * che c'è nei textfield aggiorno il prodotto utile con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaProdottiUtiliActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private ProdottiUtiliPanel prodottiutiliPanel;

	/**
	 * Leggo i campi testo modificati e aggiorno il record selezionato in database,
	 * array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiorna
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		prodottiutiliPanel = view.getProdottiUtiliPanel();

		int elementoSelezionato = prodottiutiliPanel.getTabellaProdottiUtili().getTable().getSelectedRow();

		int COD = dbControl.selectCODProdottiUtili(elementoSelezionato);

		((DefaultTableModel) prodottiutiliPanel.getTabellaProdottiUtili().getTable().getModel())
				.removeRow(elementoSelezionato);

	

		String nome = prodottiutiliPanel.getNomeText().getText();
		String tipo = prodottiutiliPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		
		int qt = (int) prodottiutiliPanel.getSpinner().getValue();

		DefaultTableModel modello = (DefaultTableModel) prodottiutiliPanel.getTabellaProdottiUtili().getTable()
				.getModel();

		ProdottiUtili pu = new ProdottiUtili(COD, nome, tipo, qt, forn);

		model.getProdottiUtiliArray().get(elementoSelezionato).setNome(nome);
		model.getProdottiUtiliArray().get(elementoSelezionato).setType(tipo);
		model.getProdottiUtiliArray().get(elementoSelezionato).setQuantita(qt);
		model.getProdottiUtiliArray().get(elementoSelezionato).setForn(forn);
		
		dbControl.updateProdottiUtili(pu);

		Object rowData[] = new Object[4];

		rowData[0] = nome;
		rowData[1] = tipo;
		rowData[2] = qt;
		rowData[3] = forn.getPIVA();

		modello.insertRow(elementoSelezionato, rowData);
		
		pulisciTextField();
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */

	public AggiornaProdottiUtiliActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	/**
	 * legge tutti i dati del fornitore tramite ID letto per poter passare al prodotto utilr
	 * aggiornato il fornitore esatto
	 * 
	 * @return Fornitore fornitore letto
	 */
	private Fornitori costruisciFornitore() {
		String PIVA = (String) prodottiutiliPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	/**
	 * pulisce i campi testo una volta aggiornato prodotto
	 * 
	 * @return void
	 */
	private void pulisciTextField() {

		prodottiutiliPanel.getNomeText().setText(null);
		prodottiutiliPanel.getFornitoriBox().setSelectedIndex(0);
		prodottiutiliPanel.getSpinner().setValue(0);
	}
}
