package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiUtili.ProdottiUtili;
import view.MainView;
import view.PopupError;

public class AggiungiProdottiUtiliActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nome = view.getProdottiUtiliPanel().getNomeText().getText();
		String tipo = view.getProdottiUtiliPanel().getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		int qt = (int) view.getProdottiUtiliPanel().getSpinner().getValue();

		ProdottiUtili nuovoProdottoUtile = new ProdottiUtili(0, nome, tipo, qt, forn);

		boolean flag = dbControl.addProdottiUtili(nuovoProdottoUtile);

		if (flag) {

			model.getProdottiUtiliArray().add(nuovoProdottoUtile);

			Object rowData[] = new Object[4];

			DefaultTableModel model = (DefaultTableModel) view.getProdottiUtiliPanel().getTabellaProdottiUtili()
					.getTable().getModel();

			rowData[0] = nome;
			rowData[1] = tipo;
			rowData[2] = qt;
			rowData[3] = forn.getPIVA();

			model.addRow(rowData);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Errore", "Impossibile inserire prodotto");
				pulisciTextField();

			}
		}

	}

	public void pulisciTextField() {

		view.getProdottiUtiliPanel().getNomeText().setText(null);
		view.getProdottiUtiliPanel().getFornitoriBox().setSelectedIndex(0);
		view.getFarmaciPanel().getSpinner().setValue(0);

	}

	public Fornitori costruisciFornitore() {
		String PIVA = view.getProdottiUtiliPanel().getFornitoriBox().getSelectedItem().toString();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public AggiungiProdottiUtiliActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
