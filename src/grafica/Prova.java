package grafica;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import anagrafica.clienti.Clienti;
import anagrafica.clienti.ClientiDAO;

public class Prova extends JFrame {
	
	public Prova() {
		initComponents();
	}
	

public void addRowToJTable() {
	DefaultTableModel jTable1;
	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
	ClientiDAO cdao = new ClientiDAO();
	ArrayList<Clienti> res = cdao.selectAll();
	

}
	
}

