package grafica.clienti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import anagrafica.clienti.ClientiDAO;

public class ModificaClientiActionListener implements ActionListener{

	
	
	 JTextField nomeText;
	 JTextField cognomeText;
	 JTextField CFText;
	 JTextField emailText;
	 JTextField cellulareText;
	 JTextField cittaText;
	 JTextField indirizzoText;
	 JTable table;
	


	@Override
	public void actionPerformed(ActionEvent e) {
	
	JTextField nomeText = new JTextField();
	JTextField cognomeText= new JTextField();
	JTextField CFText= new JTextField();
	JTextField emailText= new JTextField();
	JTextField cellulareText= new JTextField();
	JTextField cittaText= new JTextField();
	JTextField indirizzoText= new JTextField();
 
	
		String nome = nomeText.getText(); 
		String cognome = cognomeText.getText();
		String CF = CFText.getText();
		String email = emailText.getText();
		String cellulare = cellulareText.getText();
		String citta = cittaText.getText();
		String indirizzo = indirizzoText.getText();

		nomeText.setText(nome);
		cognomeText.setText(cognome);
		CFText.setText(CF);
		emailText.setText(email);
		cellulareText.setText(cellulare);
		cittaText.setText(citta);
		indirizzoText.setText(indirizzo);
		
	}


	public ModificaClientiActionListener(JTextField nomeText, JTextField cognomeText, JTextField CFText,
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

	}


	public ModificaClientiActionListener(int numeroriga) {
		// TODO Auto-generated constructor stub
	}
	
}
