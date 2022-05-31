package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
import view.MainView;
import view.PopupError;
import view.pazienti.PazientiPanel;

public class AggiungiPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String ID_PAZ = view.getPazientiPanel().getID_PAZText().getText();
		String nome = view.getPazientiPanel().getNomeText().getText();
		String specie = view.getPazientiPanel().getSpecieText().getText();
		String razza = view.getPazientiPanel().getRazzaText().getText();
		String sesso = view.getPazientiPanel().getSessoText().getText();
		String GruppoSanguigno = view.getPazientiPanel().getGruppoSanguignoText().getText();
		String microchip = view.getPazientiPanel().getMicrochipText().getText();
		String sterilizzato = view.getPazientiPanel().getSterilizzatoText().getText();
		double peso = view.getPazientiPanel().getPesoText().getText();
		//String proprietario = pazientiPanel.getProprietarioText().getText();
		Clienti cl = costruisciCliente();
		String note = view.getPazientiPanel().getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		Date dataNascita = view.getPazientiPanel().getDataNascita().getDate();
		Date dataMorte = view.getPazientiPanel().getDataMorte().getDate();
		
		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {
			dataNascita = sdf.parse(sdf.format(dataNascita));
			System.out.println(dataNascita);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			dataMorte = sdf.parse(sdf.format(dataMorte));
			System.out.println(dataMorte);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate1 = new java.sql.Date(dataNascita.getTime());
		int qt1 = (int) view.getPazientiPanel().getSpinner().getValue();
		
		java.sql.Date sqlDate2 = new java.sql.Date(dataMorte.getTime());
		int qt2 = (int) view.getPazientiPanel().getSpinner().getValue();

		Paziente pazienti = new Paziente(ID_PAZ, nome, specie, razza, sesso, dataNascita, GruppoSanguigno, 
											microchip,  vet, peso, sterilizzato, cl, dataMorte, 
											sqlDate1, qt1, sqlDate2, qt2, note);
		boolean flag = dbControl.addNuovoPaziente(pazienti);

		if (flag) {

			model.getPazientiArray().add(pazienti);

			Object rowData[] = new Object[16];

			DefaultTableModel model = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
					.getModel();

			rowData[0] = ID_PAZ;
			rowData[1] = nome;
			rowData[2] = specie;
			rowData[3] = razza;
			rowData[4] = sesso;
			rowData[5] = GruppoSanguigno;
			rowData[6] = microchip;
			rowData[7] = sterilizzato;
			rowData[8] = peso;
			rowData[9] = cl.getCF();
			rowData[10] = note;
			rowData[11] = vet.getCF();
			rowData[12] = sqlDate1;
			rowData[13] = qt1;
			rowData[14] = sqlDate2;
			rowData[15] = qt2;

			model.addRow(rowData);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un paziente con questo ID", "Impossibile inserire paziente");
				pulisciTextField();

			}

		}

	}

	public void pulisciTextField() {

		view.getPazientiPanel().getID_PAZText().setText(null);
		view.getPazientiPanel().getNomeText().setText(null);
		view.getPazientiPanel().getSpecieText().setText(null);
		view.getPazientiPanel().getRazzaText().setText(null);
		view.getPazientiPanel().getSessoText().setText(null);
		view.getPazientiPanel().getGruppoSanguignoText().setText(null);
		view.getPazientiPanel().getMicrochipText().setText(null);
		view.getPazientiPanel().getSterilizzatoText().setText(null);
		view.getPazientiPanel().getPesoText().setText(null);
		view.getPazientiPanel().getClientiBox().setSelectedIndex(0);
		view.getPazientiPanel().getNoteText().setText(null);
		view.getPazientiPanel().getVeterinariBox().setSelectedIndex(0);
		view.getPazientiPanel().getSpinner().setValue(0);
	}

	public Fornitori costruisciFornitore() {
		String PIVA = (String) view.getFarmaciPanel().getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;
	}

	public Veterinari costruisciVeterinario() {
		String CF = (String) view.getPazientiPanel().getVeterinariBox().getSelectedItem();
		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}
		
	public Clienti costruisciCliente() {
		String CF = (String) view.getPazientiPanel().getClientiBox().getSelectedItem();
		Clienti cl = dbControl.selectClienteFromCF(CF);
		return cl;
	}

	public AggiungiPazientiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
