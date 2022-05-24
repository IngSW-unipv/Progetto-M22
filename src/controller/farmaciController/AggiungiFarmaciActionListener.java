package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.DateUtil;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.PopupError;
import view.magazzino.farmaci.FarmaciPanel;

public class AggiungiFarmaciActionListener implements ActionListener {

	private FarmaciPanel farmaciPanel;
	private ArrayList<LottoFarmaci> res;
	private DbControllerSingleton dbControl;
	//private Date dataScadenza;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String IDLotto = farmaciPanel.getIDLottoText().getText();
		String type = farmaciPanel.getTipoText().getText();
		String mode = farmaciPanel.getModeText().getText();
		Fornitori forn = costruisciFornitore();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		/*Date dataScadenza = new Date(0);
		try {
			dataScadenza = sdf.parse(sdf.format(farmaciPanel.getDataScadenza().getDate()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(dataScadenza);*/
		java.sql.Date dataScadenza = (java.sql.Date) farmaciPanel.getDataScadenza().getDate();
		System.out.println(dataScadenza);
		int Quantita = (int) farmaciPanel.getSpinner().getValue();

		LottoFarmaci nuovoLotto = new LottoFarmaci(IDLotto, type, mode, forn, dataScadenza, Quantita);
		//System.out.println(nuovoLotto);
		//boolean flag = dbControl.addNuovoLotto(nuovoLotto);

		//if (flag) {

			res.add(nuovoLotto);

			Object rowData[] = new Object[6];

			DefaultTableModel model = (DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel();

			rowData[0] = IDLotto;
			rowData[1] = type;
			rowData[2] = mode;
			rowData[3] = forn.getPIVA();
			rowData[4] = dataScadenza;
			rowData[5] = Quantita;

			model.addRow(rowData);

			pulisciTextField();

		/*} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un farmaco con questo n. lotto", "Impossibile inserire farmaco");
				pulisciTextField();

			}

		}*/

	}

	public void pulisciTextField() {

		farmaciPanel.getIDLottoText().setText(null);
		farmaciPanel.getModeText().setText(null);
		farmaciPanel.getTipoText().setText(null);
		farmaciPanel.getFornitoriBox().setSelectedIndex(0);
		farmaciPanel.getSpinner().setValue(0);
	}

	public Fornitori costruisciFornitore() {
		String PIVA = (String) farmaciPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public AggiungiFarmaciActionListener(FarmaciPanel farmaciPanel, ArrayList<LottoFarmaci> res,
			DbControllerSingleton dbControl) {
		super();
		this.farmaciPanel = farmaciPanel;
		this.res = res;
		this.dbControl = dbControl;
	}

}
