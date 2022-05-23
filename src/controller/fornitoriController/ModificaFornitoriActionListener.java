package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import view.fornitori.FornitoriPanel;
import view.veterinari.VeterinariPanel;

public class ModificaFornitoriActionListener implements ActionListener {
	
	FornitoriPanel fornitoriPanel;
	ArrayList<Fornitori> fo;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = fornitoriPanel.getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String PIVA = fo.get(rigaSelezionata).getPIVA();
			String nomeAzienda = fo.get(rigaSelezionata).getNomeAzienda();
			String nTelefono = fo.get(rigaSelezionata).getnTelefono();
			String email = fo.get(rigaSelezionata).getEmail();
			String sede = fo.get(rigaSelezionata).getSede();
			String IBAN = fo.get(rigaSelezionata).getIBAN();
			
			fornitoriPanel.getPIVAText().setText(PIVA);
			fornitoriPanel.getNomeAziendaText().setText(nomeAzienda);
			fornitoriPanel.getnTelefonoText().setText(nTelefono);
			fornitoriPanel.getEmailText().setText(email);
			fornitoriPanel.getSedeText().setText(sede);
			fornitoriPanel.getIBANText().setText(IBAN);
		}
	}

	public ModificaFornitoriActionListener(FornitoriPanel fornitoriPanel, ArrayList<Fornitori> fo) {
		super();
		this.fornitoriPanel = fornitoriPanel;
		this.fo = fo;
	}

}

