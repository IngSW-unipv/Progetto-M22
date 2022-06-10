package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		veterinariPanel = view.getVeterinariPanel();

		boolean flag = dbControl.addNuovoVeterinario(veterinariPanel.getNuovoVeterinarioTextField());

		if (flag) {

			model.getVeterinariArray().add(veterinariPanel.getNuovoVeterinarioTextField());

			// aggiungo vet nelle comboBox di altre finestre
			view.getAppuntamentiPanel().getCFvetText().addItem(veterinariPanel.getNuovoVeterinarioTextField().getCF());
			view.getPazientiPanel().getVeterinariBox().addItem(veterinariPanel.getNuovoVeterinarioTextField().getCF());

			Object rowData[] = new Object[12];

			DefaultTableModel model = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();

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

			model.addRow(rowData);

			pulisciTextField();
		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste gi� un veterinario con questo CF", "Impossibile inserire veterinario");
				pulisciTextField();

			}
		}

	}

	public AggiungiVeterinarioActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

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
