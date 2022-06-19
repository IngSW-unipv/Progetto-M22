package controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connectionSQL.DbControllerSingleton;
import view.MainView;
import view.PopupError;
import view.login.PopUpOk;

/**
 * permette di registrare un nuovo account riferito a un dipendente già presente
 * nel database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class RegistratiActionListener implements ActionListener {
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * verifica che password e conferma password coincidano, se si registra account
	 * nel database collegato al dipendente selezionato
	 * 
	 * @return void
	 */
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
			PopUpOk ok = new PopUpOk();
			ok.infoBox("Nuovo account creato", "OK");
			view.getRegistratiView().setVisible(false);
		}

		else {
			{
				PopupError err = new PopupError();
				err.infoBox("le due password non coincidono", "Errore");
				pulisciTextField();

			}
		}

	}

	/**
	 * pulisce campi testo una volta registrato account nuovo
	 * 
	 * @return void
	 */
	public void pulisciTextField() {
		view.getRegistratiView().getUsernameText().setText(null);
		view.getRegistratiView().getPasswordField().setText(null);
		view.getRegistratiView().getPasswordField_1().setText(null);
		view.getRegistratiView().getComboBox().setSelectedItem(0);
	}

	/**
	 * costruttore
	 * 
	 * @param model modello
	 * @param view  grafica
	 */
	public RegistratiActionListener(MainView view, DbControllerSingleton dbControl) {
		super();
		this.view = view;
		this.dbControl = dbControl;
	}

}
