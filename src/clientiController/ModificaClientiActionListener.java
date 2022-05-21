package clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.anagrafica.clienti.Clienti;
import view.clienti.ClientiPanel;

public class ModificaClientiActionListener implements ActionListener {
	ClientiPanel clientiPanel;
	ArrayList<Clienti> cl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = clientiPanel.getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = cl.get(rigaSelezionata).getNome();
			String cognome = cl.get(rigaSelezionata).getCognome();
			String CF = cl.get(rigaSelezionata).getCF();
			String email = cl.get(rigaSelezionata).getEmail();
			String cell = cl.get(rigaSelezionata).getCellulare();
			String citta = cl.get(rigaSelezionata).getCitta();
			String indirizzo = cl.get(rigaSelezionata).getIndirizzo();

			clientiPanel.getNomeText().setText(nome);
			clientiPanel.getCognomeText().setText(cognome);
			clientiPanel.getCFText().setText(CF);
			clientiPanel.getEmailText().setText(email);
			clientiPanel.getCellulareText().setText(cell);
			clientiPanel.getCittaText().setText(citta);
			clientiPanel.getIndirizzoText().setText(indirizzo);
		}
	}

	public ModificaClientiActionListener(ClientiPanel clientiPanel, ArrayList<Clienti> cl) {
		super();
		this.clientiPanel = clientiPanel;
		this.cl = cl;
	}

}
