package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.dashboard.DashBoardView;
import view.magazzino.farmaci.FarmaciPanel;

public class FarmaciController {

	private ArrayList<LottoFarmaci> res;
	private JFrame principale;
	private DashBoardView panelDash;
	private FarmaciPanel farmaciPanel;
	private DbControllerSingleton dbControl;
	private ArrayList<Fornitori> forn;

	public FarmaciController(ArrayList<LottoFarmaci> res, JFrame principale, DashBoardView panelDash,
			FarmaciPanel farmaciPanel, DbControllerSingleton dbControl, ArrayList<Fornitori> forn) {
		super();
		this.res = res;
		this.principale = principale;
		this.panelDash = panelDash;
		this.farmaciPanel = farmaciPanel;
		this.dbControl = dbControl;
		this.forn = forn;

		addActionListenersMenu();
		fillTable();
		fillComboBox();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		Object rowData[][] = new Object[res.size()][6];
		DefaultTableModel modello = (DefaultTableModel) farmaciPanel.getTabellaFarmaci().getTable().getModel();
		for (int i = 0; i < res.size(); i++) {

			rowData[i][0] = res.get(i).getIDLotto();
			rowData[i][1] = res.get(i).getMode();
			rowData[i][2] = res.get(i).getType();
			// rowData[i][3] = res.get(i).getFornitore().getPIVA();
			rowData[i][4] = res.get(i).getDataScadenza();
			rowData[i][5] = res.get(i).getQuantita();

			if (res.get(i).getFornitore() == null) {
				rowData[i][3] = null;
			}

			else
				rowData[i][3] = res.get(i).getFornitore().getPIVA();

			modello.addRow(rowData[i]);
		}
	}

	public void fillComboBox() {

		ArrayList<String> lista_PIVA = new ArrayList<String>();

		for (int i = 0; i < forn.size(); i++) {

			lista_PIVA.add(forn.get(i).getPIVA());

			if (lista_PIVA != null) {
				farmaciPanel.getFornitoriBox().addItem(lista_PIVA.get(i));
			}
		}
	}

	public void addActionListenersMenu() {
		panelDash.getMenu().getMntmFarmaci().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDash.setVisible(false);
				principale.add(farmaciPanel);
				farmaciPanel.setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiFarmaciActionListener addFarmaci = new AggiungiFarmaciActionListener(farmaciPanel, res, dbControl);
		farmaciPanel.getBtnAggiungi().addActionListener(addFarmaci);

		EliminaFarmaciActionListener deleteFarmaci = new EliminaFarmaciActionListener(
				farmaciPanel.getTabellaFarmaci().getTable(), dbControl, res);
		farmaciPanel.getBtnElimina().addActionListener(deleteFarmaci);

		ModificaFarmaciActionListener modificaFarmaci = new ModificaFarmaciActionListener(farmaciPanel, res);
		farmaciPanel.getBtnModifica().addActionListener(modificaFarmaci);

		AggiornaFarmaciActionListener aggiornaFarmaci = new AggiornaFarmaciActionListener(farmaciPanel, dbControl, res);
		farmaciPanel.getBtnAggiorna().addActionListener(aggiornaFarmaci);

	}

	public void addActionListenerHome() {
		farmaciPanel.getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmaciPanel.setVisible(false);
				principale.add(panelDash);
				panelDash.setVisible(true);
			}
		});
	}

}
