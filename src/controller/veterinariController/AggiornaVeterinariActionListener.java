package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.veterinari.Veterinari;
import view.MainView;
import view.veterinari.VeterinariPanel;

public class AggiornaVeterinariActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private VeterinariPanel veterinariPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		veterinariPanel = view.getVeterinariPanel();

		veterinariPanel.getCFText().setEditable(true);

		int elementoSelezionato = veterinariPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) veterinariPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);

		dbControl.deleteVeterinario(model.getVeterinariArray().get(elementoSelezionato));
		model.getVeterinariArray().remove(elementoSelezionato);

		String nome = veterinariPanel.getNuovoVeterinarioTextField().getNome();
		String cognome = veterinariPanel.getNuovoVeterinarioTextField().getCognome();
		String CF = veterinariPanel.getNuovoVeterinarioTextField().getCF();
		String email = veterinariPanel.getNuovoVeterinarioTextField().getEmail();
		String cellulare = veterinariPanel.getNuovoVeterinarioTextField().getCellulare();
		String citta = veterinariPanel.getNuovoVeterinarioTextField().getCitta();
		String indirizzo = veterinariPanel.getNuovoVeterinarioTextField().getIndirizzo();
		String piva = veterinariPanel.getNuovoVeterinarioTextField().getPIVA();
		String contratto = veterinariPanel.getNuovoVeterinarioTextField().getContratto();
		double stipendio = veterinariPanel.getNuovoVeterinarioTextField().getStipendio();
		double commissioni = veterinariPanel.getNuovoVeterinarioTextField().getCommissioni();
		String iban = veterinariPanel.getNuovoVeterinarioTextField().getIBAN();

		Veterinari vet = new Veterinari(nome, cognome, CF, email, cellulare, citta, indirizzo, piva, contratto,
				stipendio, commissioni, iban);

		boolean flag = dbControl.addNuovoVeterinario(vet);

		Object rowData[] = new Object[12];

		DefaultTableModel modello = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();

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

			modello.addRow(rowData);

			model.getVeterinariArray().add(vet);

		}

		pulisciTextField();

	}

	public AggiornaVeterinariActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
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
