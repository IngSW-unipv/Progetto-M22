package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.MainView;
import view.PopupError;

public class AggiungiFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String IDLotto = view.getFarmaciPanel().getIDLottoText().getText();
		String type = view.getFarmaciPanel().getTipoText().getText();
		String mode = view.getFarmaciPanel().getModeText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = view.getFarmaciPanel().getDataScadenza().getDate();
		
		// formatto data per togliere time
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {
			dataScadenza = sdf.parse(sdf.format(dataScadenza));
			System.out.println(dataScadenza);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate = new java.sql.Date(dataScadenza.getTime());
		//
		
		int Quantita = (int) view.getFarmaciPanel().getSpinner().getValue();

		LottoFarmaci nuovoLotto = new LottoFarmaci(IDLotto, type, mode, forn, sqlDate, Quantita);
		boolean flag = dbControl.addLottoFarmaci(nuovoLotto);

		if (flag) {

			model.getLottoFarmaciArray().add(nuovoLotto);

			Object rowData[] = new Object[6];

			DefaultTableModel model = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
					.getModel();

			rowData[0] = IDLotto;
			rowData[1] = type;
			rowData[2] = mode;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;
			rowData[5] = Quantita;

			model.addRow(rowData);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un farmaco con questo n. lotto", "Impossibile inserire farmaco");
				pulisciTextField();

			}

		}

	} 

	public void pulisciTextField() {

		view.getFarmaciPanel().getIDLottoText().setText(null);
		view.getFarmaciPanel().getDataScadenza().setDate(null);
		view.getFarmaciPanel().getModeText().setText(null);
		view.getFarmaciPanel().getTipoText().setText(null);
		view.getFarmaciPanel().getFornitoriBox().setSelectedIndex(0);
		view.getFarmaciPanel().getSpinner().setValue(0);
	}

	public Fornitori costruisciFornitore() {
		String PIVA = view.getFarmaciPanel().getFornitoriBox().getSelectedItem().toString();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public AggiungiFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
