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
import view.PopupError;

/**
 * Aggiungi nuovo prodotto utile
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiProdottiUtiliActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	
	/**
	 * aggiunge prodotto nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @return void
	 */

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nome = view.getProdottiUtiliPanel().getNomeText().getText();
		String tipo = view.getProdottiUtiliPanel().getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		int qt = (int) view.getProdottiUtiliPanel().getSpinner().getValue();

		ProdottiUtili nuovoProdottoUtile = new ProdottiUtili(0, nome, tipo, qt, forn);

		boolean flag = dbControl.addProdottiUtili(nuovoProdottoUtile);

		if (flag) {

			model.getProdottiUtiliArray().add(nuovoProdottoUtile);

			Object rowData[] = new Object[4];

			DefaultTableModel model = (DefaultTableModel) view.getProdottiUtiliPanel().getTabellaProdottiUtili()
					.getTable().getModel();

			rowData[0] = nome;
			rowData[1] = tipo;
			rowData[2] = qt;
			rowData[3] = forn.getPIVA();

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

		view.getProdottiUtiliPanel().getNomeText().setText(null);
		view.getProdottiUtiliPanel().getFornitoriBox().setSelectedIndex(0);
		view.getFarmaciPanel().getSpinner().setValue(0);

	}

	/**
	 * legge tutti i dati del fornitore tramite ID letto per poter passare al prodotto utilr
	 * aggiunto il fornitore esatto
	 * 
	 * @return Fornitore fornitore letto
	 */
	private Fornitori costruisciFornitore() {
		String PIVA = view.getProdottiUtiliPanel().getFornitoriBox().getSelectedItem().toString();
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
	public AggiungiProdottiUtiliActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
