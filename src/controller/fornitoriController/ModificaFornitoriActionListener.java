package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;

public class ModificaFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		view.getFornitoriPanel().getPIVAText().setEditable(false);

		int rigaSelezionata = view.getFornitoriPanel().getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String PIVA = model.getFornitoriArray().get(rigaSelezionata).getPIVA();
			String nomeAzienda = model.getFornitoriArray().get(rigaSelezionata).getNomeAzienda();
			String nTelefono = model.getFornitoriArray().get(rigaSelezionata).getnTelefono();
			String email = model.getFornitoriArray().get(rigaSelezionata).getEmail();
			String sede = model.getFornitoriArray().get(rigaSelezionata).getSede();
			String IBAN = model.getFornitoriArray().get(rigaSelezionata).getIBAN();

			view.getFornitoriPanel().getPIVAText().setText(PIVA);
			view.getFornitoriPanel().getNomeAziendaText().setText(nomeAzienda);
			view.getFornitoriPanel().getnTelefonoText().setText(nTelefono);
			view.getFornitoriPanel().getEmailText().setText(email);
			view.getFornitoriPanel().getSedeText().setText(sede);
			view.getFornitoriPanel().getIBANText().setText(IBAN);
		}
	}

	public ModificaFornitoriActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;

	}

}
