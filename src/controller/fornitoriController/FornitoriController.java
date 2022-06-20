package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * Collega i fornitori del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FornitoriController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public FornitoriController(SmartVetModel model, MainView view) {
		
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}
	/**
	 * Visualizza fornitori su tabella fornitori
	 * 
	 * @return void
	 */
	private void fillTable() {
		String rowData[][] = new String[model.getFornitoriArray().size()][6];
		DefaultTableModel modello = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();
		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			rowData[i][0] = model.getFornitoriArray().get(i).getPIVA();
			rowData[i][1] = model.getFornitoriArray().get(i).getNomeAzienda();
			rowData[i][2] = model.getFornitoriArray().get(i).getnTelefono();
			rowData[i][3] = model.getFornitoriArray().get(i).getEmail();
			rowData[i][4] = model.getFornitoriArray().get(i).getSede();
			rowData[i][5] = model.getFornitoriArray().get(i).getIBAN();

			modello.addRow(rowData[i]);
		}
	}
	/**
	 * Aggiunge action listener al menu per aprire pannello fornitori da dashboard
	 * 
	 * @return void
	 */
	private void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmFornitori().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getFornitoriPanel());
				view.getFornitoriPanel().setVisible(true);
			}
		});

	}
	/**
	 * Aggiunge action listener per aggiungere, eliminare,
	 * modificare, aggiornare fornitori
	 * 
	 * @return void
	 */
	private void addActionListenerButtons() {
		AggiungiFornitoriActionListener addFornitore = new AggiungiFornitoriActionListener(model, view, dbControl);

		view.getFornitoriPanel().getBtnAggiungi().addActionListener(addFornitore);

		EliminaFornitoriActionListener deleteFornitore = new EliminaFornitoriActionListener(model, view, dbControl);
		view.getFornitoriPanel().getBtnElimina().addActionListener(deleteFornitore);

		ModificaFornitoriActionListener modificaFornitore = new ModificaFornitoriActionListener(model, view);
		view.getFornitoriPanel().getBtnModifica().addActionListener(modificaFornitore);

		AggiornaFornitoriActionListener aggiornaFornitore = new AggiornaFornitoriActionListener(model, dbControl, view);
		view.getFornitoriPanel().getBtnAggiorna().addActionListener(aggiornaFornitore);

	}

	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
	private void addActionListenerHome() {
		view.getFornitoriPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getFornitoriPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
