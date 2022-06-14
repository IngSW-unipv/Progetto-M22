package view.dashboard;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import view.dashboard.farmaciScadenza.TabellaFarmaciScadenzaView;
import view.dashboard.promemoria.PromemoriaView;

/**
 * 
 * @author MMA version 1.0
 *
 */
public class DashBoardView extends JPanel {

	private static final long serialVersionUID = 1L;
	private MenuView menu;
	private JScrollPane promemoriaScrollPane;
	private JScrollPane farmaciScadenzaScrollPane;
	private PromemoriaView promemoria;
	private TabellaFarmaciScadenzaView f;
	private JLabel lblPromemoria;
	private JLabel lblFarmaciScadenzaQuesto;
	private JLabel smartVetLbl;

	public DashBoardView() {

		super();

		menu = new MenuView();
		add(menu);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setVisible(true);
		setBounds(0, 0, screenWidth, screenHeight);
		setLayout(null);

		// creo un pannello con scrollo per promemoria
		promemoriaScrollPane = new JScrollPane();
		promemoriaScrollPane.setBounds(screenHeight / 9, screenHeight / 3, (screenWidth / 5) * 2, screenHeight / 2);
		add(promemoriaScrollPane);

		// creo un pannello con scrollo per farmaci in scadenza
		farmaciScadenzaScrollPane = new JScrollPane();
		farmaciScadenzaScrollPane.setBounds((5 * screenWidth) / 9, screenHeight / 3, (screenWidth / 5) * 2,
				screenHeight / 2);
		add(farmaciScadenzaScrollPane);

		f = new TabellaFarmaciScadenzaView(farmaciScadenzaScrollPane);

		promemoria = new PromemoriaView(promemoriaScrollPane);

		smartVetLbl = new JLabel("SmartVet");
		smartVetLbl.setFont(new Font("Dialog", Font.BOLD, screenHeight / 15));
		smartVetLbl.setBounds(0, screenHeight / 20, screenWidth, screenHeight / 5);
		smartVetLbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(smartVetLbl);

		lblPromemoria = new JLabel("Promemoria appuntamenti oggi");
		lblPromemoria.setFont(new Font("Dialog", Font.BOLD, screenHeight / 35));
		lblPromemoria.setBounds(screenHeight / 9, screenHeight / 25, (screenWidth / 5) * 2, screenHeight / 2);
		lblPromemoria.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPromemoria);

		lblFarmaciScadenzaQuesto = new JLabel("Farmaci scadenza questo mese");
		lblFarmaciScadenzaQuesto.setFont(new Font("Dialog", Font.BOLD, screenHeight / 35));
		lblFarmaciScadenzaQuesto.setBounds((5 * screenWidth) / 9, screenHeight / 25, (screenWidth / 5) * 2,
				screenHeight / 2);
		lblFarmaciScadenzaQuesto.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblFarmaciScadenzaQuesto);
	}

	public MenuView getMenu() {
		return menu;
	}

	public JScrollPane getPromemoriaScrollPane() {
		return promemoriaScrollPane;
	}

	public JScrollPane getFarmaciScadenzaScrollPane() {
		return farmaciScadenzaScrollPane;
	}

	public TabellaFarmaciScadenzaView getTabellaFarmaciView() {
		return f;
	}

	public PromemoriaView getPromemoria() {
		return promemoria;
	}
}