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

		int elementoSelezionato = view.getPazientiPanel().getTabellaPazienti().getTable().getSelectedRow();

		int ID_PAZ = dbControl.selectID_PAZ(elementoSelezionato);

		((DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel()).removeRow(elementoSelezionato);

		model.getPazientiArray().remove(elementoSelezionato);

		// String ID_PAZ = pazientiPanel.getID_PAZText().getText();
		String nome = pazientiPanel.getNomeText().getText();
		String specie = pazientiPanel.getSpecieText().getText();
		String razza = pazientiPanel.getRazzaText().getText();
		String sesso = pazientiPanel.getSessoBox().getSelectedItem().toString();
		String GruppoSanguigno = pazientiPanel.getGruppoSanguignoBox().getSelectedItem().toString();
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
		Date dataNascita = null;
		Date dataMorte = null;
		java.sql.Date sqlDate = null;
		java.sql.Date sqlDate2 = null;

		try {

			dataNascita = view.getPazientiPanel().getDataNascita().getDate();
			dataMorte = view.getPazientiPanel().getDataMorte().getDate();

			if (dataNascita != null) {

				dataNascita = sdf.parse(sdf.format(dataNascita));
				System.out.println(dataNascita);

				sqlDate = new java.sql.Date(dataNascita.getTime());

			}

			if (dataMorte != null) {

				dataMorte = sdf.parse(sdf.format(dataMorte));
				System.out.println(dataMorte);

				sqlDate2 = new java.sql.Date(dataMorte.getTime());

			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		DefaultTableModel modello = (DefaultTableModel) pazientiPanel.getTabellaPazienti().getTable().getModel();

		Paziente paz = new Paziente(nome, specie, razza, sqlDate, sesso, vet, GruppoSanguigno, microchip, sterilizzato,
				peso, sqlDate2, cl, note);

		dbControl.updatePaziente(paz, ID_PAZ);

		// boolean flag = dbControl.addNuovoPaziente(paz);

		Object rowData[] = new Object[13];

		// rowData[0] = ID_PAZ;
		rowData[0] = nome;
		rowData[1] = specie;
		rowData[2] = razza;
		rowData[3] = sqlDate;
		rowData[4] = sesso;
		rowData[5] = vet.getCF();
		rowData[6] = GruppoSanguigno;
		rowData[7] = microchip;
		rowData[8] = sterilizzato;
		rowData[9] = peso;
		rowData[10] = sqlDate2;
		rowData[11] = cl.getCF();
		rowData[12] = note;

		model.getPazientiArray().add(paz);
		modello.addRow(rowData);

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
		
		pazientiPanel.getNomeText().setText(null);
		view.getPazientiPanel().getDataMorte().setDate(null);
		view.getPazientiPanel().getDataNascita().setDate(null);
		pazientiPanel.getSpecieText().setText(null);
		pazientiPanel.getRazzaText().setText(null);
		pazientiPanel.getSessoBox().setSelectedIndex(0);
		pazientiPanel.getGruppoSanguignoBox().setSelectedIndex(0);
		pazientiPanel.getMicrochip().setSelected(false);
		pazientiPanel.getSteril().setSelected(false);
		pazientiPanel.getPesoText().setText(null);
		pazientiPanel.getClientiBox().setSelectedIndex(0);
		pazientiPanel.getNoteText().setText(null);
		pazientiPanel.getVeterinariBox().setSelectedIndex(0);
	}

}
