package controller.farmaciController;

/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.SmartVetModel;
import view.MainView;

public class ModificaFarmaciActionListener implements ActionListener {

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

		int rigaSelezionata = view.getFarmaciPanel().getTabellaFarmaci().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String IDLotto = model.getLottoFarmaciArray().get(rigaSelezionata).getIDLotto();
			String mode = model.getLottoFarmaciArray().get(rigaSelezionata).getMode();
			String type = model.getLottoFarmaciArray().get(rigaSelezionata).getType();
			String PIVA = null;

			if (model.getLottoFarmaciArray().get(rigaSelezionata).getFornitore() != null)
				PIVA = model.getLottoFarmaciArray().get(rigaSelezionata).getFornitore().getPIVA();

			Date dataScadenza = model.getLottoFarmaciArray().get(rigaSelezionata).getDataScadenza();
			int quantita = model.getLottoFarmaciArray().get(rigaSelezionata).getQuantita();

			view.getFarmaciPanel().getIDLottoText().setText(IDLotto);
			view.getFarmaciPanel().getModeText().setText(mode);
			view.getFarmaciPanel().getTipoText().setText(type);
			view.getFarmaciPanel().getFornitoriBox().setSelectedItem(PIVA);
			view.getFarmaciPanel().getDataScadenza().setDate(dataScadenza);
			view.getFarmaciPanel().getSpinner().setValue(quantita);
		}

	}
	
	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public ModificaFarmaciActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
