package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.fornitori.FornitoriPanel;

public class AggiornaFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private FornitoriPanel fornitoriPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		fornitoriPanel = view.getFornitoriPanel();
		fornitoriPanel.getPIVAText().setEditable(true);

		int elementoSelezionato = fornitoriPanel.getTab().getTable().getSelectedRow();
		((DefaultTableModel) fornitoriPanel.getTab().getTable().getModel()).removeRow(elementoSelezionato);
		dbControl.deleteFornitore(model.getFornitoriArray().get(elementoSelezionato));
		model.getFornitoriArray().remove(elementoSelezionato);

		String PIVA = fornitoriPanel.getNuovoFornitoreTextField().getPIVA();
		String nomeAzienda = fornitoriPanel.getNuovoFornitoreTextField().getNomeAzienda();
		String nTelefono = fornitoriPanel.getNuovoFornitoreTextField().getnTelefono();
		String email = fornitoriPanel.getNuovoFornitoreTextField().getEmail();
		String sede = fornitoriPanel.getNuovoFornitoreTextField().getSede();
		String IBAN = fornitoriPanel.getNuovoFornitoreTextField().getIBAN();

		boolean flag = dbControl.addNuovoFornitore(fornitoriPanel.getNuovoFornitoreTextField());

		String rowData[] = new String[6];

		DefaultTableModel model = (DefaultTableModel) fornitoriPanel.getTab().getTable().getModel();

		if (flag) {

			rowData[0] = PIVA;
			rowData[1] = nomeAzienda;
			rowData[2] = nTelefono;
			rowData[3] = email;
			rowData[4] = sede;
			rowData[5] = IBAN;

			model.addRow(rowData);

		}

		pulisciTextField();

	}

	public AggiornaFornitoriActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	public void pulisciTextField() {
		fornitoriPanel.getPIVAText().setText(null);
		fornitoriPanel.getNomeAziendaText().setText(null);
		fornitoriPanel.getnTelefonoText().setText(null);
		fornitoriPanel.getEmailText().setText(null);
		fornitoriPanel.getSedeText().setText(null);
		fornitoriPanel.getIBANText().setText(null);

	}

}
