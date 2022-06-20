package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;
import view.clienti.ClientiPanel;

/**
 * Aggiunge nuovo Appuntamento
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiClienteActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private ClientiPanel clientiPanel;

	/**
	 * aggiunge cliente nuovo in database, array e grafica aggiorno anche combobox
	 * nel pannello pazienti che potrà usufruire di un nuovo cliente proprietario
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @return void
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		clientiPanel = view.getClientiPanel();

		boolean flag = dbControl.addNuovoCliente(clientiPanel.getNuovoClienteTextField());

		// aggiorno combobox delle altre finestre
		view.getPazientiPanel().getClientiBox().addItem(clientiPanel.getNuovoClienteTextField().getCF());

		if (flag) {

			model.getClientiArray().add(clientiPanel.getNuovoClienteTextField());

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

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public AggiungiClienteActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo appuntamento
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
