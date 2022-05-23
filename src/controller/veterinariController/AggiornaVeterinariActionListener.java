package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import view.clienti.ClientiPanel;
import view.veterinari.VeterinariPanel;

public class AggiornaVeterinariActionListener implements ActionListener {

	private VeterinariPanel veterinariPanel;
	private DbControllerSingleton dbControl;
	private ArrayList<Veterinari> veterinari;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo vet
		int elementoSelezionato = veterinariPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) veterinariPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deleteVeterinario(veterinari.get(elementoSelezionato));
		veterinari.remove(elementoSelezionato);

		String nome = veterinariPanel.getNuovoVeterinarioTextField().getNome();
		String cognome = veterinariPanel.getNuovoVeterinarioTextField().getCognome();
		String CF = veterinariPanel.getNuovoVeterinarioTextField().getCF();
		String email = veterinariPanel.getNuovoVeterinarioTextField().getEmail();
		String cellulare = veterinariPanel.getNuovoVeterinarioTextField().getCellulare();
		String citta = veterinariPanel.getNuovoVeterinarioTextField().getCitta();
		String indirizzo = veterinariPanel.getNuovoVeterinarioTextField().getIndirizzo();
		String piva = veterinariPanel.getNuovoVeterinarioTextField().getPIVA();
		String contratto = veterinariPanel.getNuovoVeterinarioTextField().getContratto();
		String stipendio = veterinariPanel.getNuovoVeterinarioTextField().getStipendio();
		String commissioni = veterinariPanel.getNuovoVeterinarioTextField().getCommissioni();
		String iban = veterinariPanel.getNuovoVeterinarioTextField().getIBAN();


		Veterinari vet = new Veterinari(nome, cognome, CF, email, cellulare, citta, indirizzo, piva, contratto, stipendio, commissioni, iban);
		boolean flag = dbControl.addNuovoVeterinario(vet);

		String rowData[] = new String[veterinari.size()];

		DefaultTableModel model = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();

		if (flag) {

			rowData[0] = nome;
			rowData[1] = cognome;
			rowData[2] = CF;
			rowData[3] = email;
			rowData[4] = cellulare;
			rowData[5] = citta;
			rowData[6] = indirizzo;
			rowData[7] = piva;
			rowData[8] = contratto;
			rowData[9] = stipendio;
			rowData[10] = commissioni;
			rowData[11] = iban;

			model.addRow(rowData);

		}

		pulisciTextField();

	}

	public AggiornaVeterinariActionListener(VeterinariPanel veterinariPanel, DbControllerSingleton dbControl,
			ArrayList<Veterinari> veterinari) {
		super();
		this.veterinariPanel = veterinariPanel;
		this.dbControl = dbControl;
		this.veterinari = veterinari;

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

	public void actionPerformed1(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
