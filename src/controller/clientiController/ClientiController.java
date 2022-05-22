package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;
import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.dashboard.MenuView;

public class ClientiController {

	private ArrayList<Clienti> res;
	private JFrame principale;
	private DashBoardView panelDash;
	private ClientiPanel clientiPanel;
	private DbControllerSingleton dbControl;

	public ClientiController(ArrayList<Clienti> res, JFrame principale, DashBoardView panelDash,
			ClientiPanel clientiPanel, DbControllerSingleton dbControl) {
		super();
		this.res = res;
		this.principale = principale;
		this.panelDash = panelDash;
		this.clientiPanel = clientiPanel;
		this.dbControl = dbControl;

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		String rowData[][] = new String[res.size()][7];
		DefaultTableModel modello = (DefaultTableModel) clientiPanel.getTab().getTable().getModel();
		for (int i = 0; i < res.size(); i++) {

			rowData[i][0] = res.get(i).getNome();
			rowData[i][1] = res.get(i).getCognome();
			rowData[i][2] = res.get(i).getCF();
			rowData[i][3] = res.get(i).getEmail();
			rowData[i][4] = res.get(i).getCellulare();
			rowData[i][5] = res.get(i).getCitta();
			rowData[i][6] = res.get(i).getIndirizzo();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		panelDash.getMenu().getMntmClienti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDash.setVisible(false);
				principale.add(clientiPanel);
				clientiPanel.setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiClienteActionListener addCliente = new AggiungiClienteActionListener(clientiPanel, res, dbControl);

		clientiPanel.getBtnAggiungi().addActionListener(addCliente);

		EliminaClientiActionListener deleteCliente = new EliminaClientiActionListener(clientiPanel.getTab().getTable(),
				dbControl, res);
		clientiPanel.getBtnElimina().addActionListener(deleteCliente);

		ModificaClientiActionListener modificaCliente = new ModificaClientiActionListener(clientiPanel, res);
		clientiPanel.getBtnModifica().addActionListener(modificaCliente);

		AggiornaClientiActionListener aggiornaCliente = new AggiornaClientiActionListener(clientiPanel, dbControl, res);
		clientiPanel.getBtnAggiorna().addActionListener(aggiornaCliente);

	}

	public void addActionListenerHome() {
		clientiPanel.getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientiPanel.setVisible(false);
				principale.add(panelDash);
				panelDash.setVisible(true);
			}
		});
	}

}
