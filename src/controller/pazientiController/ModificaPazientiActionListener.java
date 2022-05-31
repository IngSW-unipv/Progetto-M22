package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import model.SmartVetModel;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import view.MainView;

public class ModificaPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String ID_PAZ = model.getPazientiPanelArray().get(rigaSelezionata).getIDPAZText();
			String nome = model.getPazientiPanelArray().get(rigaSelezionata).getNomeText();
			String tipo = model.getPazientiPanelArray().get(rigaSelezionata).getSpecieText();
			String razza = model.getPazientiPanelArray().get(rigaSelezionata).getRazzaText();
			String sesso = model.getPazientiPanelArray().get(rigaSelezionata).getSessoText();
			String GruppoSanguigno = model.getPazientiPanelArray().get(rigaSelezionata).getGruppoSanguignoText();
			String microchip = model.getPazientiPanelArray().get(rigaSelezionata).getMicrochipText();
			String sterilizzato = model.getPazientiPanelArray().get(rigaSelezionata).getSterilizzatoText();
			String peso = model.getPazientiPanelArray().get(rigaSelezionata).getPesoText();
			String note = model.getPazientiPanelArray().get(rigaSelezionata).getNoteText();
			Date dataNascita = model.getPazientiPanelArray().get(rigaSelezionata).getDataNascita();
			Date dataMorte = model.getPazientiPanelArray().get(rigaSelezionata).getDataMorte();
			//int quantita = model.getLottoFarmaciArray().get(rigaSelezionata).getQuantita();

			view.getPazientiPanel().getID_PAZText().setText(ID_PAZ);
			view.getPazientiPanel().getNomeText().setText(nome);
			view.getPazientiPanel().getSpecieText().setText(tipo);
			view.getPazientiPanel().getRazzaText().setText(razza);
			view.getPazientiPanel().getSessoText().setText(sesso);
			view.getPazientiPanel().getGruppoSanguignoText().setText(GruppoSanguigno);
			view.getPazientiPanel().getMicrochipText().setText(microchip);
			view.getPazientiPanel().getSterilizzatoText().setText(sterilizzato);
			view.getPazientiPanel().getPesoText().setText(peso);
			view.getPazientiPanel().getNoteText().setText(note);
			view.getPazientiPanel().getSpinner().setValue(0); // quantità???

		}

	}

	public ModificaPazientiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}