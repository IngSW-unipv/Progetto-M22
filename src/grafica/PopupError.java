package grafica;

import javax.swing.JOptionPane;

public class PopupError {
	public static void infoBox(String infoMessage, String titleBar)
    {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
