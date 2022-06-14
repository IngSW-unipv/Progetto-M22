package controller.veterinariController;

/**
 * Aggiungi nuovo veterinario
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;
import view.veterinari.VeterinariPanel;

public class AggiungiVeterinarioActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private VeterinariPanel veterinariPanel;

	/**
	 * aggiunge veterinario nuovo in database, array e grafica
	 * 
	 * @param e evento schiaccia bottone aggiungi
	 * @return void
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		veterinariPanel = view.getVeterinariPanel();

		boolean flag = dbControl.addNuovoVeterinario(veterinariPanel.getNuovoVeterinarioTextField());

		if (flag) {

			model.getVeterinariArray().add(veterinariPanel.getNuovoVeterinarioTextField());

			// aggiungo vet nelle comboBox di altre finestre

			if (!(model.getCFuser().equals("direzione"))) { 

				view.getAppuntamentiPanel().getCFvetText()
						.addItem(veterinariPanel.getNuovoVeterinarioTextField().getCF());
			}

			view.getPazientiPanel().getVeterinariBox().addItem(veterinariPanel.getNuovoVeterinarioTextField().getCF());
			view.getRegistratiView().getComboBox().addItem(veterinariPanel.getNuovoVeterinarioTextField().getCF());

			Object rowData[] = new Object[12];

			DefaultTableModel modello = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();

			rowData[0] = veterinariPanel.getNuovoVeterinarioTextField().getNome();
			rowData[1] = veterinariPanel.getNuovoVeterinarioTextField().getCognome();
			rowData[2] = veterinariPanel.getNuovoVeterinarioTextField().getCF();
			rowData[3] = veterinariPanel.getNuovoVeterinarioTextField().getEmail();
			rowData[4] = veterinariPanel.getNuovoVeterinarioTextField().getCellulare();
			rowData[5] = veterinariPanel.getNuovoVeterinarioTextField().getCitta();
			rowData[6] = veterinariPanel.getNuovoVeterinarioTextField().getIndirizzo();
			rowData[7] = veterinariPanel.getNuovoVeterinarioTextField().getPIVA();
			rowData[8] = veterinariPanel.getNuovoVeterinarioTextField().getContratto();
			rowData[9] = veterinariPanel.getNuovoVeterinarioTextField().getStipendio();
			rowData[10] = veterinariPanel.getNuovoVeterinarioTextField().getCommissioni();
			rowData[11] = veterinariPanel.getNuovoVeterinarioTextField().getIBAN();

			modello.addRow(rowData);

			pulisciTextField();
		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste gia un veterinario con questo CF", "Impossibile inserire veterinario");
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
	public AggiungiVeterinarioActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

	/**
	 * pulisce i campi testo una volta aggiunta il nuovo veterinario
	 * 
	 * @return void
	 */
	public void pulisciTextField() {

		veterinariPanel.getNomeText().setText(null);
		veterinariPanel.getCognomeText().setText(null);
		veterinariPanel.getCFText().setText(null);
		veterinariPanel.getEmailText().setText(null);
		veterinariPanel.getCellulareText().setText(null);
		veterinariPanel.getCittaText().setText(null);
		veterinariPanel.getIndirizzoText().setText(null);
		veterinariPanel.getPivaText().setText(null);
		veterinariPanel.getContrattoText().setText(null);
		veterinariPanel.getStipendioText().setText(null);
		veterinariPanel.getCommissioniText().setText(null);
		veterinariPanel.getIbanText().setText(null);
	}

}
