package grafica.magazzino.Farmaci;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class FarmaciView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
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
					FarmaciView frame = new FarmaciView();
					frame.setVisible(true);
					principale.getContentPane().add(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FarmaciView() {

		setBounds(0, 0, 2700, 2200);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		JTextField IDLottoText = new JTextField();
		IDLottoText.setBounds(1096, 12, 100, 25);
		add(IDLottoText);
		IDLottoText.setColumns(10);

		JTextField modeText = new JTextField();
		modeText.setBounds(1096, 72, 100, 25);
		add(modeText);
		modeText.setColumns(10);

		JTextField tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(1096, 132, 100, 25);
		add(tipoText);

		JTextField fornitoreText = new JTextField();
		fornitoreText.setColumns(10);
		fornitoreText.setBounds(1096, 192, 100, 25);
		add(fornitoreText);

		JDateChooser dataScadenza = new JDateChooser();
		dataScadenza.setDateFormatString("MM/dd/yyyy");
		dataScadenza.setBounds(1096, 252, 100, 25);
		add(dataScadenza);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(1118, 312, 48, 39);
		add(spinner);

		JLabel lblIDLotto = new JLabel("Lotto");
		lblIDLotto.setBounds(970, 12, 70, 15);
		add(lblIDLotto);

		JLabel lblMode = new JLabel("Assunzione");
		lblMode.setBounds(970, 72, 108, 15);
		add(lblMode);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(970, 132, 70, 15);
		add(lblTipo);
		lblTipo.setBounds(970, 192, 70, 15);

		JLabel lblFornitore = new JLabel("Fornitore");
		lblFornitore.setBounds(970, 137, 70, 15);
		add(lblFornitore);

		JLabel lblDataScadenza = new JLabel("Data scadenza");
		lblDataScadenza.setBounds(970, 252, 125, 15);
		add(lblDataScadenza);

		JLabel lblQt = new JLabel("Qt.");
		lblQt.setBounds(970, 312, 70, 15);
		add(lblQt);

		TabellaFarmaciPanel tab = new TabellaFarmaciPanel(scrollPane);

		// bottone aggiungi cliente
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		AggiungiFarmaciActionListener addFarmaco = new AggiungiFarmaciActionListener(IDLottoText, modeText, tipoText,
				fornitoreText, dataScadenza, spinner, tab.getTable(), tab.getFdao());
		btnAggiungi.addActionListener(addFarmaco);
		add(btnAggiungi);

		// bottone elimina cliente
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);

		add(btnElimina);

	}
}
