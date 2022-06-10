package controller.loginController;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.appuntamentiController.AppuntamentiController;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;

public class GoBtnActionListener implements ActionListener {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private String CF;
	private AppuntamentiController appuntamentiController;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String user = view.getLoginView().getUsernameText().getText().toString();
		String pw = view.getLoginView().getPasswordField().getText().toString();

		boolean isMatching = dbControl.isMatchingLogin(user, pw);

		if (isMatching) {

			view.getLoginView().setVisible(false);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto
														// Dimension
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;

			// centra il frame nello schermo
			view.setSize(screenWidth, screenHeight);
			view.setLocationRelativeTo(null); // consente di riposizionare il frame

			view.setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);

			view.getContentPane().add(view.getDashboard());

			CF = dbControl.getCFuserLoggedIn(user, pw);

			model.populateCFuser(CF);

			if (CF.equals("direzione")) {
				model.populateAppuntamenti(dbControl.selectAllAppuntamenti());
			}

			else {
				model.populateAppuntamenti(dbControl.selectAllAppuntamentiDuetovet(CF));
			}

			appuntamentiController = new AppuntamentiController(model, view, dbControl);

			System.out.println("nel listener" + CF);
		}

		else {

			PopupError err = new PopupError();

			err.infoBox("Errore", "Username o password incorretti");
			pulisciTextField();
		}

	}

	public String getUserEntrato() {
		System.out.println("nel metodo" + CF);
		return CF;
	}

	public void pulisciTextField() {
		view.getLoginView().getUsernameText().setText(null);
		view.getLoginView().getPasswordField().setText(null);
	}

	public GoBtnActionListener(MainView view, SmartVetModel model, DbControllerSingleton dbControl) {
		super();
		this.view = view;
		this.model = model;
		this.dbControl = dbControl;
	}

}
