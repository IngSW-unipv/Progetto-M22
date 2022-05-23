package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import view.PopupError;
import view.clienti.ClientiPanel;
import view.fornitori.FornitoriPanel;
import view.veterinari.VeterinariPanel;

public class AggiungiFornitoriActionListener implements ActionListener {

	private FornitoriPanel fornitoriPanel;
	private ArrayList<Fornitori> res;// IMPO se no punta null
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo cliente
		boolean flag = dbControl.addNuovoFornitore(fornitoriPanel.getNuovoFornitoreTextField());

		if (flag) {

			res.add(fornitoriPanel.getNuovoFornitoreTextField());

			String rowData[] = new String[6];

			DefaultTableModel model = (DefaultTableModel) fornitoriPanel.getTab().getTable().getModel();

			rowData[0] = fornitoriPanel.getNuovoFornitoreTextField().getPIVA();
			rowData[1] = fornitoriPanel.getNuovoFornitoreTextField().getNomeAzienda();
			rowData[2] = fornitoriPanel.getNuovoFornitoreTextField().getnTelefono();
			rowData[3] = fornitoriPanel.getNuovoFornitoreTextField().getEmail();
			rowData[4] = fornitoriPanel.getNuovoFornitoreTextField().getSede();
			rowData[5] = fornitoriPanel.getNuovoFornitoreTextField().getIBAN();

			model.addRow(rowData);

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

	public AggiungiFornitoriActionListener(FornitoriPanel fornitoriPanel, ArrayList<Fornitori> res,
			DbControllerSingleton dbControl) {
		this.fornitoriPanel = fornitoriPanel;
		this.res = res;
		this.dbControl = dbControl;

	}

	public void pulisciTextField() {
		
		fornitoriPanel.getPIVAText().setText(null);
		fornitoriPanel.getNomeAziendaText().setText(null);
		fornitoriPanel.getnTelefonoText().setText(null);
		fornitoriPanel.getEmailText().setText(null);
		fornitoriPanel.getSedeText().setText(null);
		fornitoriPanel.getIBANText().setText(null);
	}
}
