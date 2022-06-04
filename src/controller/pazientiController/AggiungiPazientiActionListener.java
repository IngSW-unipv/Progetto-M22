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

public class AggiungiPazientiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// String ID_PAZ = view.getPazientiPanel().getID_PAZText().getText();
		String nome = view.getPazientiPanel().getNomeText().getText();
		String specie = view.getPazientiPanel().getSpecieText().getText();
		String razza = view.getPazientiPanel().getRazzaText().getText();
		String sesso = view.getPazientiPanel().getSessoText().getText();
		String GruppoSanguigno = view.getPazientiPanel().getGruppoSanguignoText().getText();
		Boolean microchip = view.getPazientiPanel().getMicrochip().isSelected();
		Boolean sterilizzato = view.getPazientiPanel().getSteril().isSelected();
		double peso = 0.0;

		try {

			peso = Double.parseDouble(view.getPazientiPanel().getPesoText().getText());

		}

		catch (NumberFormatException nfe) {

			nfe.printStackTrace();

		}
		// String proprietario = pazientiPanel.getProprietarioText().getText();
		Clienti cl = costruisciCliente();
		System.out.println(cl);
		String note = view.getPazientiPanel().getNoteText().getText();
		Veterinari vet = costruisciVeterinario();
		Date dataNascita = null;
		Date dataMorte = null;
		java.sql.Date sqlDate = null;
		java.sql.Date sqlDate2 = null;

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

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

		Paziente paz = new Paziente(nome, specie, razza, sqlDate, sesso, vet, GruppoSanguigno, microchip, sterilizzato,
				peso, sqlDate2, cl, note);

		boolean flag = dbControl.addNuovoPaziente(paz);

		if (flag) {

			model.getPazientiArray().add(paz);

			Object rowData[] = new Object[16];

			DefaultTableModel model = (DefaultTableModel) view.getPazientiPanel().getTabellaPazienti().getTable().getModel();
			

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

		// view.getPazientiPanel().getID_PAZText().setText(null);
		view.getPazientiPanel().getNomeText().setText(null);
		view.getPazientiPanel().getSpecieText().setText(null);
		view.getPazientiPanel().getRazzaText().setText(null);
		view.getPazientiPanel().getSessoText().setText(null);
		view.getPazientiPanel().getGruppoSanguignoText().setText(null);
		view.getPazientiPanel().getMicrochip().setSelected(false);
		view.getPazientiPanel().getSteril().setSelected(false);
		view.getPazientiPanel().getPesoText().setText(null);
		view.getPazientiPanel().getClientiBox().setSelectedIndex(0);
		view.getPazientiPanel().getNoteText().setText(null);
		view.getPazientiPanel().getVeterinariBox().setSelectedIndex(0);
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
		System.out.println(CF);
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
