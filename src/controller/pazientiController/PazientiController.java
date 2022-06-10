package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class PazientiController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public PazientiController(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		fillTable();
		fillComboBox();
		fillComboBox1();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();

	}

	public void fillTable() {
		Object rowData[][] = new Object[model.getPazientiArray().size()][14];

		DefaultTableModel modello = (DefaultTableModel) view.getPazientiPanel().getTabellaPazienti().getTable()
				.getModel();

		for (int i = 0; i < model.getPazientiArray().size(); i++) {

			// rowData[i][0] = model.getPazientiArray().get(i).getID_PAZ();
			rowData[i][0] = model.getPazientiArray().get(i).getNome();
			rowData[i][1] = model.getPazientiArray().get(i).getSpecie();
			rowData[i][2] = model.getPazientiArray().get(i).getRazza();
			rowData[i][3] = model.getPazientiArray().get(i).getDataNascita();
			rowData[i][4] = model.getPazientiArray().get(i).getSesso();

			rowData[i][6] = model.getPazientiArray().get(i).getGruppoSanguigno();
			rowData[i][7] = model.getPazientiArray().get(i).getMicrochip();

			rowData[i][10] = model.getPazientiArray().get(i).getDataMorte();

			if (model.getPazientiArray().get(i).getVeterinario() == null) {
				rowData[i][5] = null;
			}

			else {
				rowData[i][5] = model.getPazientiArray().get(i).getVeterinario().getCF();

				rowData[i][9] = model.getPazientiArray().get(i).getPeso();
				rowData[i][8] = model.getPazientiArray().get(i).getSterilizzato();

				if (model.getPazientiArray().get(i).getCliente() == null) {
					rowData[i][11] = null;
				}

				else
					rowData[i][11] = model.getPazientiArray().get(i).getCliente().getCF();

			}

			rowData[i][12] = model.getPazientiArray().get(i).getNote();
			modello.addRow(rowData[i]);
		}

	}

	@SuppressWarnings("unchecked")
	public void fillComboBox() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			lista_CF.add(model.getVeterinariArray().get(i).getCF());

			if (lista_CF.get(i) != null) {
				view.getPazientiPanel().getVeterinariBox().addItem(lista_CF.get(i));

			}

			else {

			}

		}
	}

	@SuppressWarnings("unchecked")
	public void fillComboBox1() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < model.getClientiArray().size(); i++) {

			lista_CF.add(model.getClientiArray().get(i).getCF());

			if (lista_CF.get(i) != null) {
				view.getPazientiPanel().getClientiBox().addItem(lista_CF.get(i));
			}
		}
	}

	public void addActionListenersMenu() {

		view.getDashboard().getMenu().getMenuItemPazienti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getPazientiPanel());
				view.getPazientiPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {

		AggiungiPazientiActionListener addPazienti = new AggiungiPazientiActionListener(model, view, dbControl);
		view.getPazientiPanel().getBtnAggiungi().addActionListener(addPazienti);

		EliminaPazientiActionListener deletePazienti = new EliminaPazientiActionListener(model, view, dbControl);
		view.getPazientiPanel().getBtnElimina().addActionListener(deletePazienti);

		ModificaPazientiActionListener modificaPazienti = new ModificaPazientiActionListener(model, view);
		view.getPazientiPanel().getBtnModifica().addActionListener(modificaPazienti);

		AggiornaPazientiActionListener aggiornaPazienti = new AggiornaPazientiActionListener(model, dbControl, view);
		view.getPazientiPanel().getBtnAggiorna().addActionListener(aggiornaPazienti);

	}

	public void addActionListenerHome() {

		view.getPazientiPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getPazientiPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
