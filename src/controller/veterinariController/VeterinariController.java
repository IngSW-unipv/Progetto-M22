package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.veterinari.Veterinari;
import view.veterinari.VeterinariPanel;
import view.dashboard.DashBoardView;
import view.dashboard.MenuView;

public class VeterinariController {

	private ArrayList<Veterinari> res;
	private JFrame principale;
	private DashBoardView panelDash;
	private VeterinariPanel veterinariPanel;
	private DbControllerSingleton dbControl;

	public VeterinariController(ArrayList<Veterinari> res, JFrame principale, DashBoardView panelDash,
			VeterinariPanel veterinariPanel, DbControllerSingleton dbControl) {
		super();
		this.res = res;
		this.principale = principale;
		this.panelDash = panelDash;
		this.veterinariPanel = veterinariPanel;
		this.dbControl = dbControl;

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		String rowData[][] = new String[res.size()][12];
		DefaultTableModel modello = (DefaultTableModel) veterinariPanel.getTab().getTable().getModel();
		for (int i = 0; i < res.size(); i++) {

			rowData[i][0] = res.get(i).getNome();
			rowData[i][1] = res.get(i).getCognome();
			rowData[i][2] = res.get(i).getCF();
			rowData[i][3] = res.get(i).getEmail();
			rowData[i][4] = res.get(i).getCellulare();
			rowData[i][5] = res.get(i).getCitta();
			rowData[i][6] = res.get(i).getIndirizzo();
			rowData[i][7] = res.get(i).getPIVA();
			rowData[i][8] = res.get(i).getContratto();
			rowData[i][9] = res.get(i).getStipendio();
			rowData[i][10] = res.get(i).getCommissioni();
			rowData[i][11] = res.get(i).getIBAN();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		panelDash.getMenu().getMntmDipendenti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDash.setVisible(false);
				principale.add(veterinariPanel);
				veterinariPanel.setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiVeterinarioActionListener addVeterinario = new AggiungiVeterinarioActionListener(veterinariPanel, res, dbControl);

		veterinariPanel.getBtnAggiungi().addActionListener(addVeterinario);

		EliminaVeterinariActionListener deleteVeterinario = new EliminaVeterinariActionListener(veterinariPanel.getTab().getTable(),
				dbControl, res);
		veterinariPanel.getBtnElimina().addActionListener(deleteVeterinario);

		ModificaVeterinariActionListener modificaVeterinario = new ModificaVeterinariActionListener(veterinariPanel, res);
		veterinariPanel.getBtnModifica().addActionListener(modificaVeterinario);

		AggiornaVeterinariActionListener aggiornaVeterinario = new AggiornaVeterinariActionListener(veterinariPanel, dbControl, res);
		veterinariPanel.getBtnAggiorna().addActionListener(aggiornaVeterinario);

	}

	public void addActionListenerHome() {
		veterinariPanel.getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veterinariPanel.setVisible(false);
				principale.add(panelDash);
				panelDash.setVisible(true);
			}
		});
	}

}

