package view.clienti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import model.anagrafica.clienti.Clienti;

public class EliminaClientiActionListener implements ActionListener {
	JTable table;
	private ClientiDAO cdao = new ClientiDAO();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Clienti> res = cdao.selectAll();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		int elementoSelezionato = table.getSelectedRow();
		model.removeRow(elementoSelezionato);
		cdao.deleteClienti(res.get(elementoSelezionato));
		res.remove(elementoSelezionato);  
		

	}

	public EliminaClientiActionListener(JTable table) {
		this.table = table;
	}

}