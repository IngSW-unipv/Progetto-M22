package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;

/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class ModificaClientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	/**
	 * riempie i campi testo della riga selezionata della tabella
	 * 
	 * @param e evento schiaccia bottone modifica
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		view.getClientiPanel().getCFText().setEditable(false);

		int rigaSelezionata = view.getClientiPanel().getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = model.getClientiArray().get(rigaSelezionata).getNome();
			String cognome = model.getClientiArray().get(rigaSelezionata).getCognome();
			String CF = model.getClientiArray().get(rigaSelezionata).getCF();
			String email = model.getClientiArray().get(rigaSelezionata).getEmail();
			String cell = model.getClientiArray().get(rigaSelezionata).getCellulare();
			String citta = model.getClientiArray().get(rigaSelezionata).getCitta();
			String indirizzo = model.getClientiArray().get(rigaSelezionata).getIndirizzo();

			view.getClientiPanel().getNomeText().setText(nome);
			view.getClientiPanel().getCognomeText().setText(cognome);
			view.getClientiPanel().getCFText().setText(CF);
			view.getClientiPanel().getCFText().setEditable(false);
			view.getClientiPanel().getEmailText().setText(email);
			view.getClientiPanel().getCellulareText().setText(cell);
			view.getClientiPanel().getCittaText().setText(citta);
			view.getClientiPanel().getIndirizzoText().setText(indirizzo);
		}
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public ModificaClientiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
