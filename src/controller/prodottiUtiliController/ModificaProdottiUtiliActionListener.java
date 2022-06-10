package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;

public class ModificaProdottiUtiliActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = view.getProdottiUtiliPanel().getTabellaProdottiUtili().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = model.getProdottiUtiliArray().get(rigaSelezionata).getNome();
			String tipo = model.getProdottiUtiliArray().get(rigaSelezionata).getType();
			String PIVA = null;

			if (model.getProdottiUtiliArray().get(rigaSelezionata).getFornitore() != null)
				PIVA = model.getProdottiUtiliArray().get(rigaSelezionata).getFornitore().getPIVA();

			int quantita = model.getProdottiUtiliArray().get(rigaSelezionata).getQuantita();

			view.getProdottiUtiliPanel().getNomeText().setText(nome);
			view.getProdottiUtiliPanel().getTipoText().setText(tipo);
			view.getProdottiUtiliPanel().getFornitoriBox().setSelectedItem(PIVA);
			view.getProdottiUtiliPanel().getSpinner().setValue(quantita);
		}

	}

	public ModificaProdottiUtiliActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
