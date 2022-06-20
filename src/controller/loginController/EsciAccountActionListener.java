package controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connectionSQL.DbControllerSingleton;
import database.connectionSQL.DbSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * permette di uscire dall'account corrente loggato
 * e riporta alla pagina di login
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class EsciAccountActionListener implements ActionListener {

	private DbSingleton db;
	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	
	/**
	 * chiude il sistema
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		/*Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// centra il frame nello schermo
		view.setSize(screenWidth / 3, screenHeight / 3);
		view.setLocationRelativeTo(null); // consente di riposizionare il frame
		view.setResizable(false);

		view.setLayout(null);

		view.getDashboard().setVisible(false);
		view.getLoginView().setVisible(true);
		//db.getInstance().closeConnection();
		view.getDashboard().setVisible(false);
		Test test = new Test();
		test.main(null);*/
		db.getInstance().closeConnection();
		System.exit(0);
		

	}

	/**
	 * costruttore
	 * @param model     modello
	 * @param view      grafica
	 */
	public EsciAccountActionListener(MainView view, SmartVetModel model) {
		super();
		this.view = view;
		this.model = model;
	}

}
