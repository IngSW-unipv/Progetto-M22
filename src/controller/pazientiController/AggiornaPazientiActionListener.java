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
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
import view.MainView;
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

		//String ID_PAZ = pazientiPanel.getID_PAZText().getText();
		String nome = pazientiPanel.getNomeText().getText();
		String specie = pazientiPanel.getSpecieText().getText();
		String razza = pazientiPanel.getRazzaText().getText();
		String sesso = pazientiPanel.getSessoText().getText();
		String GruppoSanguigno = pazientiPanel.getGruppoSanguignoText().getText();
		Boolean microchip = pazientiPanel.getMicrochip().isEnabled();
		Boolean sterilizzato = pazientiPanel.getSteril().isEnabled();

		double peso = 0.0;

		try {

			peso = Double.parseDouble(pazientiPanel.getPesoText().getText());

		}

		catch (NumberFormatException nfe) {

			nfe.printStackTrace();

		}
		// String proprietario = pazientiPanel.getProprietarioText().getText();
		Clienti cl = costruisciCliente();
		String note = pazientiPanel.getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date dataNascita = pazientiPanel.getDataNascita().getDate();
		Date dataMorte = pazientiPanel.getDataMorte().getDate();

		try {
			dataNascita = sdf.parse(sdf.format(dataNascita));
			dataMorte = sdf.parse(sdf.format(dataMorte));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate = new java.sql.Date(dataNascita.getTime());
		java.sql.Date sqlDate2 = new java.sql.Date(dataMorte.getTime());

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

		DefaultTableModel modello = (DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel();

		Paziente paz = new Paziente(nome, specie, razza, sqlDate, sesso, vet, GruppoSanguigno, microchip,
				sterilizzato, peso, sqlDate2, cl, note);

		boolean flag = dbControl.addNuovoPaziente(paz);

		Object rowData[] = new Object[14];

		if (flag) {

			//rowData[0] = ID_PAZ;
			rowData[0] = nome;
			rowData[1] = specie;
			rowData[2] = razza;
			rowData[3] = sesso;
			rowData[4] = sqlDate;
			rowData[5] = GruppoSanguigno;
			rowData[6] = microchip;
			rowData[7] = vet.getCF();
			rowData[8] = peso;
			rowData[9] = sterilizzato;
			rowData[10] = cl.getCF();
			rowData[11] = sqlDate2;
			rowData[12] = note;

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
		//pazientiPanel.getID_PAZText().setText(null);
		pazientiPanel.getNomeText().setText(null);
		pazientiPanel.getSpecieText().setText(null);
		pazientiPanel.getRazzaText().setText(null);
		pazientiPanel.getSessoText().setText(null);
		pazientiPanel.getGruppoSanguignoText().setText(null);
		pazientiPanel.getMicrochip().setSelected(false);
		pazientiPanel.getSteril().setSelected(false);
		pazientiPanel.getPesoText().setText(null);
		pazientiPanel.getClientiBox().setSelectedIndex(0);
		pazientiPanel.getNoteText().setText(null);
		pazientiPanel.getVeterinariBox().setSelectedIndex(0);
	}

}
