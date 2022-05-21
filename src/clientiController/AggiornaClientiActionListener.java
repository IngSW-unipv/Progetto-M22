package clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import view.clienti.ClientiPanel;

public class AggiornaClientiActionListener implements ActionListener {

	private ClientiPanel clientiPanel;
	private DbControllerSingleton dbControl;
	private ArrayList<Clienti> clienti;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo cliente
		int elementoSelezionato = clientiPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) clientiPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deleteCliente(clienti.get(elementoSelezionato));
		clienti.remove(elementoSelezionato);

		String nome = clientiPanel.getNuovoClienteTextField().getNome();
		String cognome = clientiPanel.getNuovoClienteTextField().getCognome();
		String CF = clientiPanel.getNuovoClienteTextField().getCF();
		String email = clientiPanel.getNuovoClienteTextField().getEmail();
		String cellulare = clientiPanel.getNuovoClienteTextField().getCellulare();
		String citta = clientiPanel.getNuovoClienteTextField().getCitta();
		String indirizzo = clientiPanel.getNuovoClienteTextField().getIndirizzo();

		Clienti cl = new Clienti(nome, cognome, CF, email, cellulare, citta, indirizzo);
		boolean flag = dbControl.addNuovoCliente(cl);

		String rowData[] = new String[clienti.size()];

		DefaultTableModel model = (DefaultTableModel) clientiPanel.getTab().getTable().getModel();

		if (flag) {

			rowData[0] = nome;
			rowData[1] = cognome;
			rowData[2] = CF;
			rowData[3] = email;
			rowData[4] = cellulare;
			rowData[5] = citta;
			rowData[6] = indirizzo;

			model.addRow(rowData);

		}

		pulisciTextField();

	}

	public AggiornaClientiActionListener(ClientiPanel clientiPanel, DbControllerSingleton dbControl,
			ArrayList<Clienti> clienti) {
		super();
		this.clientiPanel = clientiPanel;
		this.dbControl = dbControl;
		this.clienti = clienti;

	}

	public void pulisciTextField() {
		clientiPanel.getNomeText().setText(null);
		clientiPanel.getCognomeText().setText(null);
		clientiPanel.getCFText().setText(null);
		clientiPanel.getEmailText().setText(null);
		clientiPanel.getCellulareText().setText(null);
		clientiPanel.getCittaText().setText(null);
		clientiPanel.getIndirizzoText().setText(null);
	}

}
