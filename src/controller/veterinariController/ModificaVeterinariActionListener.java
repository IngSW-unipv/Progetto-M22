package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SmartVetModel;
import view.MainView;
import view.veterinari.VeterinariPanel;

/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ModificaVeterinariActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private VeterinariPanel veterinariPanel;

	
	/**
	 * riempie i campi testo della riga selezionata della tabella
	 * 
	 * @param e evento schiaccia bottone modifica
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		veterinariPanel = view.getVeterinariPanel();
		
		veterinariPanel.getCFText().setEditable(false);

		int rigaSelezionata = veterinariPanel.getTab().getTable().getSelectedRow();
		
		if (rigaSelezionata >= 0) {
 
			String nome = model.getVeterinariArray().get(rigaSelezionata).getNome();
			String cognome = model.getVeterinariArray().get(rigaSelezionata).getCognome();
			String CF = model.getVeterinariArray().get(rigaSelezionata).getCF();
			String email = model.getVeterinariArray().get(rigaSelezionata).getEmail();
			String cell = model.getVeterinariArray().get(rigaSelezionata).getCellulare();
			String citta = model.getVeterinariArray().get(rigaSelezionata).getCitta();
			String indirizzo = model.getVeterinariArray().get(rigaSelezionata).getIndirizzo();
			String piva = model.getVeterinariArray().get(rigaSelezionata).getPIVA();
			String contr = model.getVeterinariArray().get(rigaSelezionata).getContratto();
			double stip = model.getVeterinariArray().get(rigaSelezionata).getStipendio();
			double comm = model.getVeterinariArray().get(rigaSelezionata).getCommissioni();
			String iban = model.getVeterinariArray().get(rigaSelezionata).getIBAN();
			
			veterinariPanel.getNomeText().setText(nome);
			veterinariPanel.getCognomeText().setText(cognome);
			veterinariPanel.getCFText().setText(CF);
			veterinariPanel.getEmailText().setText(email);
			veterinariPanel.getCellulareText().setText(cell);
			veterinariPanel.getCittaText().setText(citta);
			veterinariPanel.getIndirizzoText().setText(indirizzo);
			veterinariPanel.getPivaText().setText(piva);
			veterinariPanel.getContrattoText().setText(contr);
			veterinariPanel.getStipendioText().setText(Double.toString(stip));
			veterinariPanel.getCommissioniText().setText(Double.toString(comm));
			veterinariPanel.getIbanText().setText(iban);
		}
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param view      grafica
	 */
	public ModificaVeterinariActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}
