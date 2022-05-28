package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.clienti.ClientiPanel;

public class AggiornaClientiActionListener implements ActionListener {

	private MainView view;
	private DbControllerSingleton dbControl;
	private SmartVetModel model;
	private ClientiPanel clientiPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		clientiPanel = view.getClientiPanel();
		clientiPanel.getCFText().setEditable(true);
		
		// Aggiungi nuovo cliente
		int elementoSelezionato = clientiPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) clientiPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);

		dbControl.deleteCliente(model.getClientiArray().get(elementoSelezionato));
		model.getClientiArray().remove(elementoSelezionato);

		boolean flag = dbControl.addNuovoCliente(clientiPanel.getNuovoClienteTextField());

		String nome = clientiPanel.getNuovoClienteTextField().getNome();
		String cognome = clientiPanel.getNuovoClienteTextField().getCognome();
		String CF = clientiPanel.getNuovoClienteTextField().getCF();
		String email = clientiPanel.getNuovoClienteTextField().getEmail();
		String cellulare = clientiPanel.getNuovoClienteTextField().getCellulare();
		String citta = clientiPanel.getNuovoClienteTextField().getCitta();
		String indirizzo = clientiPanel.getNuovoClienteTextField().getIndirizzo();

		String rowData[] = new String[7];

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

	public AggiornaClientiActionListener(MainView view, DbControllerSingleton dbControl, SmartVetModel model) {
		super();
		this.view = view;
		this.dbControl = dbControl;
		this.model = model;
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
