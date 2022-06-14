package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;

/**
 * Aggiunge nuovo fornitore
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AggiungiFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * aggiunge fornitore nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @return void
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		boolean flag = dbControl.addNuovoFornitore(view.getFornitoriPanel().getNuovoFornitoreTextField());

		if (flag) {

			model.getFornitoriArray().add(view.getFornitoriPanel().getNuovoFornitoreTextField());

			// aggiorno combobox delle altre finestre
			view.getFarmaciPanel().getFornitoriBox()
					.addItem(view.getFornitoriPanel().getNuovoFornitoreTextField().getPIVA());
			view.getProdottiUtiliPanel().getFornitoriBox()
					.addItem(view.getFornitoriPanel().getNuovoFornitoreTextField().getPIVA());

			String rowData[] = new String[6];

			DefaultTableModel modello = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();

			rowData[0] = view.getFornitoriPanel().getNuovoFornitoreTextField().getPIVA();
			rowData[1] = view.getFornitoriPanel().getNuovoFornitoreTextField().getNomeAzienda();
			rowData[2] = view.getFornitoriPanel().getNuovoFornitoreTextField().getnTelefono();
			rowData[3] = view.getFornitoriPanel().getNuovoFornitoreTextField().getEmail();
			rowData[4] = view.getFornitoriPanel().getNuovoFornitoreTextField().getSede();
			rowData[5] = view.getFornitoriPanel().getNuovoFornitoreTextField().getIBAN();

			modello.addRow(rowData);

			pulisciTextField();

		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un Fornitore con questo CF", "Impossibile inserire cliente");
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
	public AggiungiFornitoriActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo fornitore
	 * 
	 * @return void
	 */
	public void pulisciTextField() {

		view.getFornitoriPanel().getPIVAText().setText(null);
		view.getFornitoriPanel().getNomeAziendaText().setText(null);
		view.getFornitoriPanel().getnTelefonoText().setText(null);
		view.getFornitoriPanel().getEmailText().setText(null);
		view.getFornitoriPanel().getSedeText().setText(null);
		view.getFornitoriPanel().getIBANText().setText(null);
	}
}
