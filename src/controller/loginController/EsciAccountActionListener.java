package controller.loginController;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EsciAccountActionListener implements ActionListener {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Toolkit kit = Toolkit.getDefaultToolkit();
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
	}

	public EsciAccountActionListener(MainView view, SmartVetModel model) {
		super();
		this.view = view;
		this.model = model;
		dbControl = DbControllerSingleton.getInstance();
	}

}
