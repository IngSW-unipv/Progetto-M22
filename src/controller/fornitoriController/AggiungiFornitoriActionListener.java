package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;

public class AggiungiFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		boolean flag = dbControl.addNuovoFornitore(view.getFornitoriPanel().getNuovoFornitoreTextField());

		if (flag) {

			model.getFornitoriArray().add(view.getFornitoriPanel().getNuovoFornitoreTextField());

			String rowData[] = new String[6];

			DefaultTableModel model = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();

			rowData[0] = view.getFornitoriPanel().getNuovoFornitoreTextField().getPIVA();
			rowData[1] = view.getFornitoriPanel().getNuovoFornitoreTextField().getNomeAzienda();
			rowData[2] = view.getFornitoriPanel().getNuovoFornitoreTextField().getnTelefono();
			rowData[3] = view.getFornitoriPanel().getNuovoFornitoreTextField().getEmail();
			rowData[4] = view.getFornitoriPanel().getNuovoFornitoreTextField().getSede();
			rowData[5] = view.getFornitoriPanel().getNuovoFornitoreTextField().getIBAN();

			model.addRow(rowData);

			pulisciTextField();
		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste già un Fornitore con questo CF", "Impossibile inserire cliente");
				pulisciTextField();

			}
		}

	}

	public AggiungiFornitoriActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

	public void pulisciTextField() {

		view.getFornitoriPanel().getPIVAText().setText(null);
		view.getFornitoriPanel().getNomeAziendaText().setText(null);
		view.getFornitoriPanel().getnTelefonoText().setText(null);
		view.getFornitoriPanel().getEmailText().setText(null);
		view.getFornitoriPanel().getSedeText().setText(null);
		view.getFornitoriPanel().getIBANText().setText(null);
	}
}
