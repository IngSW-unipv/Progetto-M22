package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;

public class ModificaClientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

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

	public ModificaClientiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
