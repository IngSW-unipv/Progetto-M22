package controller.pazientiController;

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
public class ModificaPazientiActionListener implements ActionListener {

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

		int rigaSelezionata = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String nome = model.getPazientiArray().get(rigaSelezionata).getNome();
			String specie = model.getPazientiArray().get(rigaSelezionata).getSpecie();
			String razza = model.getPazientiArray().get(rigaSelezionata).getRazza();
			String sesso = model.getPazientiArray().get(rigaSelezionata).getSesso();
			String gruppoSanguigno = model.getPazientiArray().get(rigaSelezionata).getGruppoSanguigno();
			boolean microchip = model.getPazientiArray().get(rigaSelezionata).getMicrochip();
			boolean sterilizzato = model.getPazientiArray().get(rigaSelezionata).getSterilizzato();
			double peso = model.getPazientiArray().get(rigaSelezionata).getPeso();
			String note = model.getPazientiArray().get(rigaSelezionata).getNote();
			Date dataNascita = model.getPazientiArray().get(rigaSelezionata).getDataNascita();
			Date dataMorte = model.getPazientiArray().get(rigaSelezionata).getDataMorte();
			String CFvet = null;
			String CFcliente = null;
		

			if (model.getPazientiArray().get(rigaSelezionata).getVeterinario() != null)
				CFvet = model.getPazientiArray().get(rigaSelezionata).getVeterinario().getCF();

			if (model.getPazientiArray().get(rigaSelezionata).getCliente() != null)
				CFcliente = model.getPazientiArray().get(rigaSelezionata).getCliente().getCF();

			
			
			view.getPazientiPanel().getNomeText().setText(nome);
			view.getPazientiPanel().getSpecieText().setText(specie);
			view.getPazientiPanel().getRazzaText().setText(razza);
			view.getPazientiPanel().getSessoBox().setSelectedItem(sesso);
			view.getPazientiPanel().getGruppoSanguignoBox().setSelectedItem(gruppoSanguigno);
			view.getPazientiPanel().getMicrochip().setSelected(microchip);
			view.getPazientiPanel().getSteril().setSelected(sterilizzato);
			view.getPazientiPanel().getPesoText().setText(Double.toString(peso));
			view.getPazientiPanel().getVeterinariBox().setSelectedItem(CFvet);
			view.getPazientiPanel().getClientiBox().setSelectedItem(CFcliente);
			view.getPazientiPanel().getNoteText().setText(note);
			view.getPazientiPanel().getDataNascita().setDate(dataNascita);
			view.getPazientiPanel().getDataMorte().setDate(dataMorte);
		}

	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public ModificaPazientiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}