package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import view.PopupError;
import view.clienti.ClientiPanel;

public class AggiungiClienteActionListener implements ActionListener {

	private ClientiPanel clientiPanel;
	private ArrayList<Clienti> res;// IMPO se no punta null
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo cliente
		boolean flag = dbControl.addNuovoCliente(clientiPanel.getNuovoClienteTextField());

		if (flag) {

			res.add(clientiPanel.getNuovoClienteTextField());

			String rowData[] = new String[7];

			DefaultTableModel model = (DefaultTableModel) clientiPanel.getTab().getTable().getModel();

			rowData[0] = clientiPanel.getNuovoClienteTextField().getNome();
			rowData[1] = clientiPanel.getNuovoClienteTextField().getCognome();
			rowData[2] = clientiPanel.getNuovoClienteTextField().getCF();
			rowData[3] = clientiPanel.getNuovoClienteTextField().getEmail();
			rowData[4] = clientiPanel.getNuovoClienteTextField().getCellulare();
			rowData[5] = clientiPanel.getNuovoClienteTextField().getCitta();
			rowData[6] = clientiPanel.getNuovoClienteTextField().getIndirizzo();

			model.addRow(rowData);

			pulisciTextField();
		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un cliente con questo CF", "Impossibile inserire cliente");
				pulisciTextField();

			}
		}

	}

	public AggiungiClienteActionListener(ClientiPanel clientiPanel, ArrayList<Clienti> res,
			DbControllerSingleton dbControl) {
		this.clientiPanel = clientiPanel;
		this.res = res;
		this.dbControl = dbControl;

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
