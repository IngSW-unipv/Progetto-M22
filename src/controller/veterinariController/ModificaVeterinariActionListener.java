package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.anagrafica.veterinari.Veterinari;
import view.veterinari.VeterinariPanel;

public class ModificaVeterinariActionListener implements ActionListener {
	
	VeterinariPanel veterinariPanel;
	ArrayList<Veterinari> vet;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		veterinariPanel.getCFText().setEditable(false);
		
		int rigaSelezionata = veterinariPanel.getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = vet.get(rigaSelezionata).getNome();
			String cognome = vet.get(rigaSelezionata).getCognome();
			String CF = vet.get(rigaSelezionata).getCF();
			String email = vet.get(rigaSelezionata).getEmail();
			String cell = vet.get(rigaSelezionata).getCellulare();
			String citta = vet.get(rigaSelezionata).getCitta();
			String indirizzo = vet.get(rigaSelezionata).getIndirizzo();
			String piva = vet.get(rigaSelezionata).getPIVA();
			String contr = vet.get(rigaSelezionata).getContratto();
			double stip = vet.get(rigaSelezionata).getStipendio();
			double comm = vet.get(rigaSelezionata).getCommissioni();
			String iban = vet.get(rigaSelezionata).getIBAN();

			veterinariPanel.getNomeText().setText(nome);
			veterinariPanel.getCognomeText().setText(cognome);
			veterinariPanel.getCFText().setText(CF);
			veterinariPanel.getEmailText().setText(email);
			veterinariPanel.getCellulareText().setText(cell);
			veterinariPanel.getCittaText().setText(citta);
			veterinariPanel.getIndirizzoText().setText(indirizzo);
			veterinariPanel.getPivaText().setText(piva);
			veterinariPanel.getContrattoText().setText(contr);
			veterinariPanel.getStipendioText().setText(Double.toString(stip));
			veterinariPanel.getCommissioniText().setText(Double.toString(comm));
			veterinariPanel.getIbanText().setText(iban);
		}
	}

	public ModificaVeterinariActionListener(VeterinariPanel veterinariPanel, ArrayList<Veterinari> vet) {
		super();
		this.veterinariPanel = veterinariPanel;
		this.vet = vet;
	}

}

