package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;
/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ModificaProdottiUtiliActionListener implements ActionListener {

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

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param view      grafica
	 */
	public ModificaProdottiUtiliActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
