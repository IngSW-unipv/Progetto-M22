package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;

import grafica.dashboard.DashBoardView;
import grafica.dashboard.MenuView;

public class Engine extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame principale = new JFrame();
					principale.setVisible(true);
					principale.setBounds(500, 500, 2700, 2200);
					principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					principale.getContentPane().setLayout(null);

					DashBoardView dash = new DashBoardView();
					principale.getContentPane().add(dash);

					MenuView menuView = new MenuView(dash, principale);
					menuView.setBounds(-46, -45, 397, 75);
					dash.add(menuView);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
