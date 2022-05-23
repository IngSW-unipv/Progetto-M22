package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import view.fornitori.FornitoriPanel;
import view.dashboard.DashBoardView;
import view.dashboard.MenuView;

public class FornitoriController {

	private ArrayList<Fornitori> res;
	private JFrame principale;
	private DashBoardView panelDash;
	private FornitoriPanel fornitoriPanel;
	private DbControllerSingleton dbControl;

	public FornitoriController(ArrayList<Fornitori> res, JFrame principale, DashBoardView panelDash,
			FornitoriPanel fornitoriPanel, DbControllerSingleton dbControl) {
		super();
		this.res = res;
		this.principale = principale;
		this.panelDash = panelDash;
		this.fornitoriPanel = fornitoriPanel;
		this.dbControl = dbControl;

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		String rowData[][] = new String[res.size()][6];
		DefaultTableModel modello = (DefaultTableModel) fornitoriPanel.getTab().getTable().getModel();
		for (int i = 0; i < res.size(); i++) {
			
			
			rowData[i][0] = res.get(i).getPIVA();
			rowData[i][1] = res.get(i).getNomeAzienda();
			rowData[i][2] = res.get(i).getnTelefono();
			rowData[i][3] = res.get(i).getEmail();
			rowData[i][4] = res.get(i).getSede();
			rowData[i][5] = res.get(i).getIBAN();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		System.out.println("7777");
		panelDash.getMenu().getMntmFornitori().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				panelDash.setVisible(false);
				principale.add(fornitoriPanel);
				fornitoriPanel.setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiFornitoriActionListener addFornitore = new AggiungiFornitoriActionListener(fornitoriPanel, res, dbControl);

		fornitoriPanel.getBtnAggiungi().addActionListener(addFornitore);

		EliminaFornitoriActionListener deleteFornitore = new EliminaFornitoriActionListener(fornitoriPanel.getTab().getTable(),
				dbControl, res);
		fornitoriPanel.getBtnElimina().addActionListener(deleteFornitore);

		ModificaFornitoriActionListener modificaFornitore = new ModificaFornitoriActionListener(fornitoriPanel, res);
		fornitoriPanel.getBtnModifica().addActionListener(modificaFornitore);

		AggiornaFornitoriActionListener aggiornaFornitore = new AggiornaFornitoriActionListener(fornitoriPanel, dbControl, res);
		fornitoriPanel.getBtnAggiorna().addActionListener(aggiornaFornitore);

	}

	public void addActionListenerHome() {
		fornitoriPanel.getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fornitoriPanel.setVisible(false);
				principale.add(panelDash);
				panelDash.setVisible(true);
			}
		});
	}

}
