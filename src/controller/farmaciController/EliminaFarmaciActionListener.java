package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.magazzino.farmaci.LottoFarmaci;

public class EliminaFarmaciActionListener implements ActionListener {
	private JTable table;
	private DbControllerSingleton dbControl;
	private ArrayList<LottoFarmaci> lf;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int elementoSelezionato = table.getSelectedRow();
		model.removeRow(elementoSelezionato);

		dbControl.deleteLotto(lf.get(elementoSelezionato));
		lf.remove(elementoSelezionato);
	}

	public EliminaFarmaciActionListener(JTable table, DbControllerSingleton dbControl, ArrayList<LottoFarmaci> lf) {
		super();
		this.table = table;
		this.dbControl = dbControl;
		this.lf = lf;
	}

}
