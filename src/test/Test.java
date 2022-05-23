package test;

import java.awt.EventQueue;
import javax.swing.JFrame;
import controller.Controller;
import model.SmartVetModel;
import view.MainView;
import view.dashboard.MenuView;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartVetModel model = new SmartVetModel();

					MainView view = new MainView();

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
