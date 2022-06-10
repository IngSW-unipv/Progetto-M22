package test;

import java.awt.EventQueue;

import controller.Controller;
import model.SmartVetModel;
import view.MainView;
import view.login.LoginView;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartVetModel model = new SmartVetModel();

					//LoginView log = new LoginView();
					MainView view = new MainView();

					@SuppressWarnings("unused")
					Controller ctrl = new Controller(model, view);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() {

	}
}
