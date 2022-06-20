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

/**
 * Aggiungi nuovo prodotto vendita
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiProdottiVenditaActionListener implements ActionListener {
	
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	
	/**
	 * aggiunge prodotto nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @exception ParseException data/ora non valida/e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nome = view.getProdottiVenditaPanel().getNomeText().getText();
		String tipo = view.getProdottiVenditaPanel().getTipoText().getText();
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


		int qt = (int) view.getProdottiVenditaPanel().getSpinner().getValue();

		ProdottiVendita nuovoPr = new ProdottiVendita(0, nome, tipo, qt, forn, sqlDate);

		boolean flag = dbControl.addProdottiVendita(nuovoPr);

		if (flag) {

			model.getProdottiVenditaArray().add(nuovoPr);

			Object rowData[] = new Object[5];

			DefaultTableModel model = (DefaultTableModel) view.getProdottiVenditaPanel()
					.getTabellaProdottiVenditaPanel().getTable().getModel();

			rowData[0] = nome;
			rowData[1] = tipo;
			rowData[2] = qt;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;

			model.addRow(rowData);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Impossibile inserire prodotto", "Errore");
				pulisciTextField();

			}

		}

	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo prodotto
	 * 
	 * @return void
	 */
	private void pulisciTextField() {

		view.getProdottiVenditaPanel().getNomeText().setText(null);
		view.getProdottiVenditaPanel().getTipoText().setText(null);
		view.getProdottiVenditaPanel().getFornitoriBox().setSelectedIndex(0);
		view.getProdottiVenditaPanel().getSpinner().setValue(0);

	}

	/**
	 * legge tutti i dati del fornitore tramite ID letto per poter passare al prodotto utilr
	 * aggiunto il fornitore esatto
	 * 
	 * @return Fornitore fornitore letto
	 */
	private Fornitori costruisciFornitore() {
		String PIVA = view.getProdottiVenditaPanel().getFornitoriBox().getSelectedItem().toString();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiungiProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
