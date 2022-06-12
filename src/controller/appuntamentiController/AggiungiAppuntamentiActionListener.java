package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;
import view.MainView;
import view.PopupError;

public class AggiungiAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int ID_PAZ = (int) view.getAppuntamentiPanel().getIDpazText().getSelectedItem();
		String sala = view.getAppuntamentiPanel().getSalaText().getSelectedItem().toString();
		String tipo = view.getAppuntamentiPanel().getTipoText().getText();
		java.sql.Date sqlDate = null;
		Date data = null;
		java.sql.Time timeValue = null;

		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			data = view.getAppuntamentiPanel().getDataText().getDate();

			if (data != null) {

				data = sdf.parse(sdf.format(data));
				System.out.println(data);

				sqlDate = new java.sql.Date(data.getTime());

			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String ora = view.getAppuntamentiPanel().getTimeChooserText().getFormatedTime();

		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");

		try {

			timeValue = new java.sql.Time(stf.parse(ora).getTime());

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double costo = 0.0;

		try {

			costo = Double.parseDouble(view.getAppuntamentiPanel().getCostoText().getText());

		} catch (NumberFormatException nfe) {

			nfe.printStackTrace();
		}

		String note = view.getAppuntamentiPanel().getNoteText().getText();

		Paziente paz = costruisciPaziente();
		Veterinari vet = costruisciVeterinario();

		Appuntamenti nuovoApp = new Appuntamenti(0, paz, sala, tipo, sqlDate, timeValue, vet, costo, note);
		
		boolean flag = dbControl.addNuovoAppuntamento(nuovoApp);
		model.getStoricoArray().add(nuovoApp);
		model.getSaleOccupateArray().add(nuovoApp);

		if (flag) {

			model.getAppuntamentiArray().add(nuovoApp);

			Object rowData[] = new Object[8];

			DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();
			DefaultTableModel modelloStorico = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();
			DefaultTableModel modelloSale= (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();

	
			rowData[0] = ID_PAZ;
			rowData[1] = sala;
			rowData[2] = tipo;
			rowData[3] = sqlDate;
			rowData[4] = timeValue;
			rowData[5] = vet.getCF();
			rowData[6] = costo;
			rowData[7] = note;

			modello.addRow(rowData);
			modelloStorico.addRow(rowData);
			
			Object rowData2[] = new Object[5];
			
			rowData2[0] = ID_PAZ;
			rowData2[1] = sala;
			rowData2[2] = tipo;
			rowData2[3] = sqlDate;
			rowData2[4] = timeValue;
	
			
			modelloSale.addRow(rowData2);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Errore", "Impossibile inserire paziente");
				pulisciTextField();

			}

		}

	}

	public void pulisciTextField() {

		java.sql.Time timeValue = null;
		String ora = "00:00:00";
		SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");

		try {
			timeValue = new java.sql.Time(stf.parse(ora).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.getAppuntamentiPanel().getIDpazText().setSelectedIndex(0);
		view.getAppuntamentiPanel().getSalaText().setSelectedIndex(0);
		view.getAppuntamentiPanel().getTipoText().setText(null);
		view.getAppuntamentiPanel().getDataText().setDate(null);
		
		if (view.getAppuntamentiPanel().getCFvetText() != null) {
		
			view.getAppuntamentiPanel().getCFvetText().setSelectedIndex(0);
		}
		view.getAppuntamentiPanel().getTimeChooserText().setTime(timeValue);
		view.getAppuntamentiPanel().getCostoText().setText(null);
		view.getAppuntamentiPanel().getNoteText().setText(null);
	}

	public Paziente costruisciPaziente() {

		int ID = (int) view.getAppuntamentiPanel().getIDpazText().getSelectedItem();
		Paziente paz = dbControl.selectPazienteFromID(ID);
		return paz;
	}

	public Veterinari costruisciVeterinario() {
		
		String CF = null;
		
		
		if (model.getCFuser().equals("direzione")) {
			
			CF = (String) view.getAppuntamentiPanel().getCFvetText().getSelectedItem();
		}

		else {
			
			CF = model.getCFuser();
		}

		Veterinari vet = dbControl.selectVeterinarioFromCF(CF);
		return vet;
	}

	public AggiungiAppuntamentiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}