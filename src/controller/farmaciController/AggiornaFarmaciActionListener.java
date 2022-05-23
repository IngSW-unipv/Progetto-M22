package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		String IDLotto = farmaciPanel.getNuovoLotto().getIDLotto();
		String mode = farmaciPanel.getNuovoLotto().getMode();
		String type = farmaciPanel.getNuovoLotto().getType();
		Fornitori forn = farmaciPanel.getNuovoLotto().getFornitore();
		Date dataScadenza = farmaciPanel.getNuovoLotto().getDataScadenza();
		int qt = farmaciPanel.getNuovoLotto().getQuantita();

		LottoFarmaci lo = new LottoFarmaci(IDLotto, mode, type, forn, dataScadenza, qt);
		boolean flag = dbControl.addNuovoLotto(lo);

		Object rowData[] = new Object[lf.size()];

		if (flag) {
			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = forn;
			rowData[4] = dataScadenza;
			rowData[5] = qt;
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

	public void pulisciTextField() {
		farmaciPanel.getIDLottoText().setText(null);
		farmaciPanel.getModeText().setText(null);
		farmaciPanel.getTipoText().setText(null);
		farmaciPanel.getFornitoriBox().setSelectedIndex(0);
		farmaciPanel.getSpinner().setValue(0);
	}

}
