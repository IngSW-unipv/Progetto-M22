package controller.loginController;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.DashBoardController;
import controller.appuntamentiController.AppuntamentiController;
import controller.appuntamentiController.StoricoController.StoricoController;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;
/**
 * per confermare le credenziali inserite nel login
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class GoBtnActionListener implements ActionListener {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private String CF;
	private AppuntamentiController appuntamentiController;
	private StoricoController storicoController;
	private DashBoardController dashControl;

	/**
	 * legge le credeniziali inserite nel login
	 * e le confronta vedendo se esistono nel database,
	 * se matchano a seconda che si sia loggato un dipendente
	 * o account direzione avrò popolato in modo
	 * diverso gli array di appuntamenti e storico
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String user = view.getLoginView().getUsernameText().getText().toString();
		String pw = view.getLoginView().getPasswordField().getText().toString();

		boolean isMatching = dbControl.isMatchingLogin(user, pw);

		if (isMatching) {

			CF = dbControl.getCFuserLoggedIn(user, pw);

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
			view.getDashboard().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);

			view.getContentPane().add(view.getDashboard());

			model.populateCFuser(CF);

			System.out.println(CF + "dimmmi");

			if (CF.equals("direzione")) {

				model.populateAppuntamenti(dbControl.selectAllAppuntamenti());
				model.populateStorico(dbControl.selectAllStorico());
				model.populatePromemoriaOggi(dbControl.selectAllPromemoriaOggi());

			}

			else {

				model.populateAppuntamenti(dbControl.selectAllAppuntamentiDuetovet(CF));
				model.populateStorico(dbControl.selectAllStoricoDuetovet(CF));
				model.populatePromemoriaOggi(dbControl.selectAllPromemoriaOggiDueToVet(model.getCFuser()));

			}

			appuntamentiController = new AppuntamentiController(model, view);
			storicoController = new StoricoController(model, view);
			dashControl = new DashBoardController(model, view);

			pulisciTextField();
 
		}

		else {

			PopupError err = new PopupError();

			err.infoBox("Errore", "Username o password incorretti");
			pulisciTextField();
		}

	}

	/**
	 * restituisce il CF user che si è loggato
	 * @return String CF user entrato
	 */
	public String getUserEntrato() {
		return CF;
	}
	
	/**
	 * pulisce campi testo quando user loggato oppure
	 * quando non matcha
	 * @return void
	 */
	private void pulisciTextField() {
		view.getLoginView().getUsernameText().setText(null);
		view.getLoginView().getPasswordField().setText(null);
	}

	/**
	 * costruttore
	 * @param model     modello
	 * @param view      grafica
	 * @param dvcontrol database
	 */
	public GoBtnActionListener(MainView view, SmartVetModel model) {
		super();
		this.view = view;
		this.model = model;
		dbControl = DbControllerSingleton.getInstance();
	}

}
