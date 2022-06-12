package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.SmartVetModel;
import view.MainView;

public class ModificaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable()
				.getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = model.getProdottiVenditaArray().get(rigaSelezionata).getNome();
			String tipo = model.getProdottiVenditaArray().get(rigaSelezionata).getType();
			String PIVA = null;

			if (model.getProdottiVenditaArray().get(rigaSelezionata).getFornitore() != null)
				PIVA = model.getProdottiVenditaArray().get(rigaSelezionata).getFornitore().getPIVA();

			Date dataScadenza = model.getProdottiVenditaArray().get(rigaSelezionata).getDataScadenza();
			int quantita = model.getProdottiVenditaArray().get(rigaSelezionata).getQuantita();

			view.getProdottiVenditaPanel().getTipoText().setText(tipo);
			view.getProdottiVenditaPanel().getNomeText().setText(nome);
			view.getProdottiVenditaPanel().getFornitoriBox().setSelectedItem(PIVA);
			view.getProdottiVenditaPanel().getDataScadenza().setDate(dataScadenza);
			view.getProdottiVenditaPanel().getSpinner().setValue(quantita);
		}

	}

	public ModificaProdottiVenditaActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
