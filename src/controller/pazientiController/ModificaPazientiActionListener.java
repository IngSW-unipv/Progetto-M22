package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import model.SmartVetModel;
import view.MainView;

public class ModificaPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String ID_PAZ = model.getPazientiArray().get(rigaSelezionata).getID_PAZ();
			String nome = model.getPazientiArray().get(rigaSelezionata).getNome();
			String specie = model.getPazientiArray().get(rigaSelezionata).getSpecie();
			String razza = model.getPazientiArray().get(rigaSelezionata).getRazza();
			String sesso = model.getPazientiArray().get(rigaSelezionata).getSesso();
			String GruppoSanguigno = model.getPazientiArray().get(rigaSelezionata).getGruppoSanguigno();
			boolean microchip = model.getPazientiArray().get(rigaSelezionata).getMicrochip();
			boolean sterilizzato = model.getPazientiArray().get(rigaSelezionata).getSterilizzato();
			double peso = model.getPazientiArray().get(rigaSelezionata).getPeso();
			String note = model.getPazientiArray().get(rigaSelezionata).getNote();
			Date dataNascita = model.getPazientiArray().get(rigaSelezionata).getDataNascita();
			Date dataMorte = model.getPazientiArray().get(rigaSelezionata).getDataMorte();
			// int quantita =
			// model.getLottoFarmaciArray().get(rigaSelezionata).getQuantita();

			//view.getPazientiPanel().getID_PAZText().setText(ID_PAZ);
			view.getPazientiPanel().getNomeText().setText(nome);
			view.getPazientiPanel().getSpecieText().setText(specie);
			view.getPazientiPanel().getRazzaText().setText(razza);
			view.getPazientiPanel().getSessoText().setText(sesso);
			view.getPazientiPanel().getGruppoSanguignoText().setText(GruppoSanguigno);
			view.getPazientiPanel().getMicrochip().setSelected(microchip);
			view.getPazientiPanel().getSteril().setSelected(sterilizzato);
			view.getPazientiPanel().getPesoText().setText(Double.toString(peso));
			view.getPazientiPanel().getNoteText().setText(note);
			view.getPazientiPanel().getDataNascita().setDate(dataNascita);
			view.getPazientiPanel().getDataMorte().setDate(dataMorte);
		}

	}

	public ModificaPazientiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}