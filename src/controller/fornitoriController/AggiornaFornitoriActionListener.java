package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import view.clienti.ClientiPanel;
import view.fornitori.FornitoriPanel;
import view.veterinari.VeterinariPanel;

public class AggiornaFornitoriActionListener implements ActionListener {

	private FornitoriPanel fornitoriPanel;
	private DbControllerSingleton dbControl;
	private ArrayList<Fornitori> fornitori;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo vet
		int elementoSelezionato = fornitoriPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) fornitoriPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deleteFornitore(fornitori.get(elementoSelezionato));
		fornitori.remove(elementoSelezionato);

		String PIVA = fornitoriPanel.getNuovoFornitoreTextField().getPIVA();
		String nomeAzienda = fornitoriPanel.getNuovoFornitoreTextField().getNomeAzienda();
		String nTelefono = fornitoriPanel.getNuovoFornitoreTextField().getnTelefono();
		String email = fornitoriPanel.getNuovoFornitoreTextField().getEmail();
		String sede = fornitoriPanel.getNuovoFornitoreTextField().getSede();
		String IBAN = fornitoriPanel.getNuovoFornitoreTextField().getIBAN();

		Fornitori fo = new Fornitori(PIVA, nomeAzienda, nTelefono, email, sede, IBAN);
		boolean flag = dbControl.addNuovoFornitore(fo);

		String rowData[] = new String[fornitori.size()];

		DefaultTableModel model = (DefaultTableModel) fornitoriPanel.getTab().getTable().getModel();

		if (flag) {

			rowData[0] = PIVA;
			rowData[1] = nTelefono;
			rowData[2] = email;
			rowData[4] = sede;
			rowData[5] = IBAN;

			model.addRow(rowData);

		}

		pulisciTextField();

	}

	public AggiornaFornitoriActionListener(FornitoriPanel fornitoriPanel, DbControllerSingleton dbControl,
			ArrayList<Fornitori> fornitori) {
		super();
		this.fornitoriPanel = fornitoriPanel;
		this.dbControl = dbControl;
		this.fornitori = fornitori;

	}

	public void pulisciTextField() {
		fornitoriPanel.getPIVAText().setText(null);
		fornitoriPanel.getNomeAziendaText().setText(null);
		fornitoriPanel.getnTelefonoText().setText(null);
		fornitoriPanel.getEmailText().setText(null);
		fornitoriPanel.getSedeText().setText(null);
		fornitoriPanel.getIBANText().setText(null);
		
		
	}

	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
