package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import view.PopupError;
import view.veterinari.VeterinariPanel;

public class AggiungiVeterinarioActionListener implements ActionListener {

	private VeterinariPanel veterinariPanel;
	private ArrayList<Veterinari> res;// IMPO se no punta null
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo vet
		boolean flag = dbControl.addNuovoVeterinario(veterinariPanel.getNuovoVeterinarioTextField());

		if (flag) {

			res.add(veterinariPanel.getNuovoVeterinarioTextField());

			String rowData[] = new String[12];

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
				err.infoBox("Esiste già un veterinario con questo CF", "Impossibile inserire veterinario");
				pulisciTextField();

			}
		}

	}

	public AggiungiVeterinarioActionListener(VeterinariPanel veterinariPanel, ArrayList<Veterinari> res,
			DbControllerSingleton dbControl) {
		this.veterinariPanel = veterinariPanel;
		this.res = res;
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
