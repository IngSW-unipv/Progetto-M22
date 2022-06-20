package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.clienti.ClientiPanel;

/**
 * Aggiorna cliente selezionato. Tramite tasto modifica riempio ogni campo di
 * testo con i parametri che voglio modificare e modifico. Leggendo quello che
 * c'è nei textfield aggiorno il cliente con questo action listener.
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiornaClientiActionListener implements ActionListener {

	private MainView view;
	private DbControllerSingleton dbControl;
	private SmartVetModel model;
	private ClientiPanel clientiPanel;

	/**
	 * Leggo i campi testo modificati e aggiorno il record selezionato in database,
	 * array e grafica di clienti
	 * 
	 * @param e evento schiaccia bottone aggiorna
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		clientiPanel = view.getClientiPanel();
		clientiPanel.getCFText().setEditable(true);

		// Aggiungi nuovo cliente
		int elementoSelezionato = clientiPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) clientiPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);

		String nome = clientiPanel.getNuovoClienteTextField().getNome();
		String cognome = clientiPanel.getNuovoClienteTextField().getCognome();
		String CF = clientiPanel.getNuovoClienteTextField().getCF();
		String email = clientiPanel.getNuovoClienteTextField().getEmail();
		String cellulare = clientiPanel.getNuovoClienteTextField().getCellulare();
		String citta = clientiPanel.getNuovoClienteTextField().getCitta();
		String indirizzo = clientiPanel.getNuovoClienteTextField().getIndirizzo();

		//model.getClientiArray().get(elementoSelezionato).setCF(CF);
		model.getClientiArray().get(elementoSelezionato).setCellulare(cellulare);
		model.getClientiArray().get(elementoSelezionato).setCitta(citta);
		model.getClientiArray().get(elementoSelezionato).setCognome(cognome);
		model.getClientiArray().get(elementoSelezionato).setEmail(email);
		model.getClientiArray().get(elementoSelezionato).setIndirizzo(indirizzo);
		model.getClientiArray().get(elementoSelezionato).setNome(nome);

		dbControl.updateCliente(clientiPanel.getNuovoClienteTextField());

		String rowData[] = new String[7];

		DefaultTableModel modello = (DefaultTableModel) clientiPanel.getTab().getTable().getModel();

		rowData[0] = nome;
		rowData[1] = cognome;
		rowData[2] = CF;
		rowData[3] = email;
		rowData[4] = cellulare;
		rowData[5] = citta;
		rowData[6] = indirizzo;

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
	public AggiornaClientiActionListener(MainView view, DbControllerSingleton dbControl, SmartVetModel model) {
		super();
		this.view = view;
		this.dbControl = dbControl;
		this.model = model;
	}

	/**
	 * pulisce i campi testo una volta aggiornato cliente
	 * 
	 * @return void
	 */

	private void pulisciTextField() {
		clientiPanel.getNomeText().setText(null);
		clientiPanel.getCognomeText().setText(null);
		clientiPanel.getCFText().setText(null);
		clientiPanel.getEmailText().setText(null);
		clientiPanel.getCellulareText().setText(null);
		clientiPanel.getCittaText().setText(null);
		clientiPanel.getIndirizzoText().setText(null);
	}

}
