package controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connectionSQL.DbControllerSingleton;
import view.MainView;
import view.PopupError;

public class RegistratiActionListener implements ActionListener {
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = view.getRegistratiView().getUsernameText().getText();
		String pw = view.getRegistratiView().getPasswordField().getText();
		String verificaPw = view.getRegistratiView().getPasswordField_1().getText();
		String CFvet = view.getRegistratiView().getComboBox().getSelectedItem().toString();

		if (pw.equals(verificaPw)) {

			dbControl.insertNuovoUtente(username, verificaPw, CFvet);
			pulisciTextField();
		}

		else {
			{
				PopupError err = new PopupError();
				err.infoBox("le due password non coincidono", "Errore");
				pulisciTextField();

			}
		}

	}

	public void pulisciTextField() {
		view.getRegistratiView().getUsernameText().setText(null);
		view.getRegistratiView().getPasswordField().setText(null);
		view.getRegistratiView().getPasswordField_1().setText(null);
		view.getRegistratiView().getComboBox().setSelectedItem(0);
	}

	public RegistratiActionListener(MainView view, DbControllerSingleton dbControl) {
		super();
		this.view = view;
		this.dbControl = dbControl;
	}

}
