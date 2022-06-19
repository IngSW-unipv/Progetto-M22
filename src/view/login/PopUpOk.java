package view.login;

import javax.swing.JOptionPane;
/** 
 * 
 * @author MMA
 * version 1.0
 *
 */
public class PopUpOk {
	public static void infoBox(String infoMessage, String titleBar)
    {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE); 
    }
}