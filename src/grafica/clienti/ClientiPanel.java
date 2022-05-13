package grafica.clienti;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame principale = new JFrame();
					principale.setVisible(true);
					principale.setBounds(500, 500, 2700, 2200);
					principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					principale.getContentPane().setLayout(null);

					ClientiPanel frame = new ClientiPanel();
					frame.setVisible(true);
					principale.getContentPane().add(frame);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientiPanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		JTextField nomeText = new JTextField();
		nomeText.setBounds(1096, 12, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		JTextField cognomeText = new JTextField();
		cognomeText.setColumns(10);
		cognomeText.setBounds(1096, 72, 100, 25);
		add(cognomeText);

		JTextField CFText = new JTextField();
		CFText.setColumns(10);
		CFText.setBounds(1096, 132, 100, 25);
		add(CFText);

		JTextField emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(1096, 192, 100, 25);
		add(emailText);

		JTextField cellulareText = new JTextField();
		cellulareText.setColumns(10);
		cellulareText.setBounds(1096, 252, 100, 25);
		add(cellulareText);

		JTextField cittaText = new JTextField();
		cittaText.setColumns(10);
		cittaText.setBounds(1096, 312, 100, 25);
		add(cittaText);

		JTextField indirizzoText = new JTextField();
		indirizzoText.setColumns(10);
		indirizzoText.setBounds(1096, 372, 100, 25);
		add(indirizzoText);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(970, 12, 70, 15);
		add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(970, 72, 70, 15);
		add(lblCognome);

		JLabel lblCf = new JLabel("CF");
		lblCf.setBounds(970, 132, 70, 15);
		add(lblCf);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(970, 192, 70, 15);
		add(lblEmail);

		JLabel lblCellulare = new JLabel("Cellulare");
		lblCellulare.setBounds(970, 252, 70, 15);
		add(lblCellulare);

		JLabel lblCitt = new JLabel("Città");
		lblCitt.setBounds(970, 312, 70, 15);
		add(lblCitt);

		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(970, 372, 70, 15);
		add(lblIndirizzo);

		TabellaClientiPanel tab = new TabellaClientiPanel(scrollPane);

		// bottone aggiungi cliente
		AggiungiClienteActionListener addCliente = new AggiungiClienteActionListener(nomeText, cognomeText, CFText,
				emailText, cellulareText, cittaText, indirizzoText, tab.getTable(), tab.getCdao());
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		btnAggiungi.addActionListener(addCliente);
		add(btnAggiungi);

		// bottone elimina cliente
		JButton btnElimina = new JButton("Elimina");
		EliminaClientiActionListener deletecliente = new EliminaClientiActionListener(tab.getTable());
		btnElimina.addActionListener(deletecliente);
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		// bottone per modificare quel cliente: riempie le textField con gli attributi
		// di quel cliente
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab.fillJTextArea(nomeText, cognomeText, CFText, emailText, cellulareText, cittaText, indirizzoText,
						tab.getTable());
			}
		});
		btnModifica.setBounds(964, 493, 100, 25);
		add(btnModifica);

		// bottone per aggiornare le caratteristiche del cliente selezionato
		JButton btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 493, 100, 25);
		AggiornaClientiActionListener update = new AggiornaClientiActionListener(nomeText, cognomeText, CFText,
				emailText, cellulareText, cittaText, indirizzoText, tab.getTable(), tab.getCdao());
		btnAggiorna.addActionListener(update);
		add(btnAggiorna);

	}

}
