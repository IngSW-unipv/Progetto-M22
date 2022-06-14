package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.SmartVetModel;
import view.MainView;

/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ModificaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	/**
	 * riempie i campi testo della riga selezionata della tabella
	 * 
	 * @param e evento schiaccia bottone modifica
	 * @return void
	 */
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

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param view      grafica
	 */
	public ModificaProdottiVenditaActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
