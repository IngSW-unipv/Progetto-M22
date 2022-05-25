package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.magazzino.farmaci.FarmaciPanel;

public class AggiornaFarmaciActionListener implements ActionListener {

	private FarmaciPanel farmaciPanel;
	private DbControllerSingleton dbControl;
	private ArrayList<LottoFarmaci> lf;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int elementoSelezionato = farmaciPanel.getTabellaFarmaci().getTable().getSelectedRow();
		((DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deleteLotto(lf.get(elementoSelezionato));
		lf.remove(elementoSelezionato);

		String IDLotto = farmaciPanel.getIDLottoText().getText();
		String mode = farmaciPanel.getModeText().getText();
		String type = farmaciPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = farmaciPanel.getDataScadenza().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {
			dataScadenza = sdf.parse(sdf.format(dataScadenza));
			System.out.println(dataScadenza);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate = new java.sql.Date(dataScadenza.getTime());
		int qt = (int) farmaciPanel.getSpinner().getValue();

		
		DefaultTableModel modello = (DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel();
		LottoFarmaci lo = new LottoFarmaci(IDLotto, mode, type, forn, sqlDate, qt);
		boolean flag = dbControl.addNuovoLotto(lo);

		Object rowData[] = new Object[lf.size()];

		if (flag) {
			
			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;
			rowData[5] = qt;
			
			modello.addRow(rowData);
		}

		pulisciTextField();
	}

	public AggiornaFarmaciActionListener(FarmaciPanel farmaciPanel, DbControllerSingleton dbControl,
			ArrayList<LottoFarmaci> lf) {
		super();
		this.farmaciPanel = farmaciPanel;
		this.dbControl = dbControl;
		this.lf = lf;
	}

	public Fornitori costruisciFornitore() {
		String PIVA = (String) farmaciPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public void pulisciTextField() {
		farmaciPanel.getIDLottoText().setText(null);
		farmaciPanel.getModeText().setText(null);
		farmaciPanel.getTipoText().setText(null);
		farmaciPanel.getFornitoriBox().setSelectedIndex(0);
		farmaciPanel.getSpinner().setValue(0);
	}

}
