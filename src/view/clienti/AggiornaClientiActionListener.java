package view.clienti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import model.anagrafica.clienti.Clienti;

public class AggiornaClientiActionListener implements ActionListener {

	JTextField nomeText;
	JTextField cognomeText;
	JTextField CFText;
	JTextField emailText;
	JTextField cellulareText;
	JTextField cittaText;
	JTextField indirizzoText;
	JTable table; // IMPO se no punta null
	ClientiDAO cdao = new ClientiDAO(); // IMPO se no punta null
	ArrayList<Clienti> res = cdao.selectAll();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Aggiungi nuovo cliente
		int elementoSelezionato = table.getSelectedRow();
		((DefaultTableModel) table.getModel()).removeRow(elementoSelezionato);
		cdao.deleteClienti(res.get(elementoSelezionato));
		res.remove(elementoSelezionato);

		String nome = nomeText.getText();
		String cognome = cognomeText.getText();
		String CF = CFText.getText();
		String email = emailText.getText();
		String cellulare = cellulareText.getText();
		String citta = cittaText.getText();
		String indirizzo = indirizzoText.getText();

		Clienti cl = new Clienti(nome, cognome, CF, email, cellulare, citta, indirizzo);
		boolean flag = cdao.insertClienti(cl);

		ArrayList<Clienti> res = cdao.selectAll(); // correggi
		String rowData[] = new String[res.size()]; // mmmmmmmmm

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (flag) {

			rowData[0] = nome;
			rowData[1] = cognome;
			rowData[2] = CF;
			rowData[3] = email;
			rowData[4] = cellulare;
			rowData[5] = citta;
			rowData[6] = indirizzo;

			model.addRow(rowData);

		}

		// pulisco ogni textField
		nomeText.setText(null);
		cognomeText.setText(null);
		CFText.setText(null);
		emailText.setText(null);
		cellulareText.setText(null);
		cittaText.setText(null);
		indirizzoText.setText(null);
	}

	public AggiornaClientiActionListener(JTextField nomeText, JTextField cognomeText, JTextField CFText,
			JTextField emailText, JTextField cellulareText, JTextField cittaText, JTextField indirizzoText,
			JTable table, ClientiDAO cdao) {
		super();
		this.nomeText = nomeText;
		this.cognomeText = cognomeText;
		this.CFText = CFText;
		this.emailText = emailText;
		this.cellulareText = cellulareText;
		this.cittaText = cittaText;
		this.indirizzoText = indirizzoText;
		this.table = table;
		this.cdao = cdao;

	}

}
