package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiVendita.ProdottiVendita;
import view.MainView;
import view.PopupError;
import view.magazzino.prodottiVendita.ProdottiVenditaPanel;

/**
 * Aggiorna prodotto vendita selezionato. Tramite tasto modifica riempio ogni campo
 * di testo con i parametri che voglio modificare e modifico. Leggendo quello
 * che c'è nei textfield aggiorno il prodotto vendita con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private ProdottiVenditaPanel prodottivenditaPanel;

	
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

		prodottivenditaPanel = view.getProdottiVenditaPanel(); 

		int elementoSelezionato = prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable().getSelectedRow();

		int COD = dbControl.selectIDProdottiVendita(elementoSelezionato);

		((DefaultTableModel) prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable().getModel())
				.removeRow(elementoSelezionato);


		String nome = prodottivenditaPanel.getNomeText().getText();
		String tipo = prodottivenditaPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = null;
		java.sql.Date sqlDate = null;

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			dataScadenza = view.getFarmaciPanel().getDataScadenza().getDate();

			if (dataScadenza != null) {

				dataScadenza = sdf.parse(sdf.format(dataScadenza));
 
				sqlDate = new java.sql.Date(dataScadenza.getTime());
			}
		}

		catch (ParseException e1) {
			// TODO Auto-generated catch block
			PopupError err = new PopupError();
			err.infoBox("Data non valida", "Errore");
			//e1.printStackTrace();
		}

		
		int qt = (int) prodottivenditaPanel.getSpinner().getValue();
		
		DefaultTableModel modello = (DefaultTableModel) prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable()
				.getModel();

		ProdottiVendita pu = new ProdottiVendita(COD, nome, tipo, qt, forn, sqlDate);

		model.getProdottiVenditaArray().get(elementoSelezionato).setNome(nome);
		model.getProdottiVenditaArray().get(elementoSelezionato).setType(tipo);
		model.getProdottiVenditaArray().get(elementoSelezionato).setQuantita(qt);
		model.getProdottiVenditaArray().get(elementoSelezionato).setForn(forn);
		model.getProdottiVenditaArray().get(elementoSelezionato).setDataScadenza(sqlDate);
		
		dbControl.updateProdottiVendita(pu);

		Object rowData[] = new Object[5];

		rowData[0] = nome;
		rowData[1] = tipo;
		rowData[2] = qt;
		rowData[3] = forn.getPIVA();
		rowData[4] = sqlDate;

		modello.insertRow(elementoSelezionato, rowData);;

		pulisciTextField();
	}

	
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiornaProdottiVenditaActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {

		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	/**
	 * legge tutti i dati del fornitoretramite ID letto per poter passare al prodotto utilr
	 * aggiornato il fornitore esatto
	 * 
	 * @return Fornitore fornitore letto
	 */
	public Fornitori costruisciFornitore() {

		String PIVA = (String) prodottivenditaPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	/**
	 * pulisce i campi testo una volta aggiornato prodotto
	 * 
	 * @return void
	 */
	public void pulisciTextField() {

		view.getProdottiVenditaPanel().getNomeText().setText(null);
		view.getProdottiVenditaPanel().getTipoText().setText(null);
		view.getProdottiVenditaPanel().getFornitoriBox().setSelectedIndex(0);
		view.getProdottiVenditaPanel().getSpinner().setValue(0);

	}
}
