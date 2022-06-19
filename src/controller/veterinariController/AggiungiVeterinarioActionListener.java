package controller.veterinariController;

/**
 * Aggiungi nuovo veterinario
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.veterinari.Veterinari;
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

		Veterinari vet = veterinariPanel.getNuovoVeterinarioTextField();

		boolean flag = dbControl.addNuovoVeterinario(vet);

		if (flag) {

			model.getVeterinariArray().add(vet);

			// aggiungo vet nelle comboBox di altre finestre

			if (model.getCFuser().equals("direzione")) {
				
				view.getAppuntamentiPanel().getCFvetText().addItem(vet.getCF());
			}

			view.getPazientiPanel().getVeterinariBox().addItem(vet.getCF());
			view.getRegistratiView().getComboBox().addItem(vet.getCF());

			Object rowData[] = new Object[12];

			DefaultTableModel modello = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();

			rowData[0] = vet.getNome();
			rowData[1] = vet.getCognome();
			rowData[2] = vet.getCF();
			rowData[3] = vet.getEmail();
			rowData[4] = vet.getCellulare();
			rowData[5] = vet.getCitta();
			rowData[6] = vet.getIndirizzo();
			rowData[7] = vet.getPIVA();
			rowData[8] = vet.getContratto();
			rowData[9] = vet.getStipendio();
			rowData[10] = vet.getCommissioni();
			rowData[11] = vet.getIBAN();

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
