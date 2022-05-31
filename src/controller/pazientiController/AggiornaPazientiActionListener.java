package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.magazzino.farmaci.LottoFarmaci;
import model.pazienti.Paziente;
import view.MainView;
import view.magazzino.farmaci.FarmaciPanel;
import view.pazienti.PazientiPanel;

public class AggiornaPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private PazientiPanel pazientiPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		pazientiPanel = view.getPazientiPanel();

		int elementoSelezionato = pazientiPanel.getTabellaPazienti().getTable().getSelectedRow();
		((DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deletePazienti(model.getPazientiArray().get(elementoSelezionato));
		model.getPazientiArray().remove(elementoSelezionato);

		String ID_PAZ = pazientiPanel.getID_PAZText().getText();
		String nome = pazientiPanel.getNomeText().getText();
		String specie = pazientiPanel.getSpecieText().getText();
		String razza = pazientiPanel.getRazzaText().getText();
		String sesso = pazientiPanel.getSessoText().getText();
		String GruppoSanguigno = pazientiPanel.getGruppoSanguignoText().getText();
		String microchip = pazientiPanel.getMicrochipText().getText();
		String sterilizzato = pazientiPanel.getSterilizzatoText().getText();
		double peso = pazientiPanel.getPesoText().getText();
		//String proprietario = pazientiPanel.getProprietarioText().getText();
		Clienti cl = costruisciCliente();
		String note = pazientiPanel.getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		Date dataNascita = pazientiPanel.getDataNascita().getDate();
		Date dataMorte = pazientiPanel.getDataMorte().getDate();
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
		int qt1 = (int) pazientiPanel.getSpinner().getValue();
		
		java.sql.Date sqlDate2 = new java.sql.Date(dataMorte.getTime());
		int qt2 = (int) pazientiPanel.getSpinner().getValue();

		DefaultTableModel modello = (DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel();
		Paziente paz = new Paziente(ID_PAZ, nome, specie, razza, sesso, dataNascita, GruppoSanguigno, 
									microchip, vet, peso, sterilizzato, cl, dataMorte,  	
									sqlDate1, qt1, sqlDate2, qt2, note);
		
		boolean flag = dbControl.addNuovoPaziente(paz);

		Object rowData[] = new Object[16];

		if (flag) {

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
			
			modello.addRow(rowData);
		}

		pulisciTextField();
	}

	public AggiornaPazientiActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	public Veterinari costruisciVeterinario() {
		String CF = (String) pazientiPanel.getVeterinariBox().getSelectedItem();
		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}
		
	public Clienti costruisciCliente() {
			String CF = (String) pazientiPanel.getClientiBox().getSelectedItem();
			Clienti cl = dbControl.selectClienteFromCF(CF);
			return cl;

	}

	public void pulisciTextField() {
		pazientiPanel.getID_PAZText().setText(null);
		pazientiPanel.getNomeText().setText(null);
		pazientiPanel.getSpecieText().setText(null);
		pazientiPanel.getRazzaText().setText(null);
		pazientiPanel.getSessoText().setText(null);
		pazientiPanel.getGruppoSanguignoText().setText(null);
		pazientiPanel.getMicrochipText().setText(null);
		pazientiPanel.getSterilizzatoText().setText(null);
		pazientiPanel.getPesoText().setText(null);
		pazientiPanel.getClientiBox().setSelectedIndex(0);
		pazientiPanel.getNoteText().setText(null);
		pazientiPanel.getVeterinariBox().setSelectedIndex(0);
		pazientiPanel.getSpinner().setValue(0);
	}

}
