package view.pazienti;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import model.anagrafica.veterinari.Veterinari;
import model.magazzino.farmaci.LottoFarmaci;
import model.pazienti.Paziente;
import model.anagrafica.clienti.*;

public class PazientiPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	private JTextField ID_PAZText;
	private JTextField nomeText;
	private JTextField specieText;
	private JTextField razzaText;
	private JTextField sessoText;
	private JTextField GruppoSanguignoText;
	private JTextField microchipText;
	private JTextField sterilizzatoText;
	private JTextField pesoText;
	private JTextField noteText;
	
	private JComboBox veterinariBox;
	private JComboBox clientiBox;
	private JDateChooser dataNascita;
	private JDateChooser dataMorte;
	private JSpinner spinner;
	
	private JLabel lblID_PAZ;
	private JLabel lblNome;
	private JLabel lblSpecie;
	private JLabel lblVeterinario;
	private JLabel lblCliente;
	private JLabel lblRazza;
	private JLabel lblSesso;
	private JLabel lblGruppoSanguigno;
	private JLabel lblmicrochip;
	private JLabel lblDataNascita;
	private JLabel lblDataMorte;
	private JLabel lblSterilizzato;
	private JLabel lblPeso;
	private JLabel lblNote;
	//private JLabel lblQt;
	
	private JButton btnAggiungi;
	private JButton btnElimina;
	private TabellaPazientiPanel tabellaPazienti;
	private JButton btnModifica;
	private JButton btnAggiorna;
	private JButton btnHome;

	/**
	 * Create the panel.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame principale1 = new JFrame();
					principale1.setVisible(true);
					principale1.setBounds(500, 500, 2700, 2200);
					principale1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					principale1.getContentPane().setLayout(null);

					PazientiPanel frame = new PazientiPanel();
					frame.setVisible(true);
					principale1.getContentPane().add(frame);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PazientiPanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);
	
		ID_PAZText = new JTextField();
		ID_PAZText.setBounds(1096, 12, 100, 25);
		add(ID_PAZText);
		ID_PAZText.setColumns(10);

		nomeText = new JTextField();
		nomeText.setBounds(1096, 72, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		specieText = new JTextField();
		specieText.setColumns(10);
		specieText.setBounds(1096, 192, 100, 25);
		add(specieText);
		
		razzaText = new JTextField();
		razzaText.setBounds(1096, 12, 100, 25);
		add(razzaText);
		razzaText.setColumns(10);

		sessoText = new JTextField();
		sessoText.setBounds(1096, 72, 100, 25);
		add(sessoText);
		sessoText.setColumns(10);

		GruppoSanguignoText = new JTextField();
		GruppoSanguignoText.setColumns(10);
		GruppoSanguignoText.setBounds(1096, 192, 100, 25);
		add(GruppoSanguignoText);
		
		microchipText = new JTextField();
		microchipText.setBounds(1096, 12, 100, 25);
		add(microchipText);
		microchipText.setColumns(10);

		sterilizzatoText = new JTextField();
		sterilizzatoText.setBounds(1096, 72, 100, 25);
		add(sterilizzatoText);
		sterilizzatoText.setColumns(10);

		pesoText = new JTextField();
		pesoText.setColumns(10);
		pesoText.setBounds(1096, 192, 100, 25);
		add(pesoText);
		
		noteText = new JTextField();
		noteText.setBounds(1096, 12, 100, 25);
		add(noteText);
		noteText.setColumns(10);
		
		veterinariBox = new JComboBox();
		veterinariBox.setBounds(1096, 132, 100, 17);
		add(veterinariBox);
		
		clientiBox = new JComboBox();
		clientiBox.setBounds(1096, 132, 100, 17);
		add(clientiBox);

		dataNascita = new JDateChooser();
		dataNascita.setDateFormatString("MM-dd-yyyy");
		dataNascita.setBounds(1096, 252, 100, 25);
		add(dataNascita);
		
		dataMorte = new JDateChooser();
		dataMorte.setDateFormatString("MM-dd-yyyy");
		dataMorte.setBounds(1096, 252, 100, 25);
		add(dataMorte);

		spinner = new JSpinner();
		spinner.setBounds(1118, 312, 48, 39);
		add(spinner);

		lblID_PAZ = new JLabel("ID_PAZ");
		lblID_PAZ.setBounds(970, 12, 70, 15);
		add(lblID_PAZ);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(970, 72, 108, 15);
		add(lblNome);

		lblSpecie = new JLabel("Specie");
		lblSpecie.setBounds(970, 132, 70, 15);
		add(lblSpecie);
		lblSpecie.setBounds(970, 192, 70, 15);

		lblVeterinario = new JLabel("Veterinario");
		lblVeterinario.setBounds(970, 137, 70, 15);
		add(lblVeterinario);

		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(970, 137, 70, 15);
		add(lblCliente);

		lblRazza = new JLabel("Razza");
		lblRazza.setBounds(970, 252, 125, 15);
		add(lblRazza);
		
		lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(970, 12, 70, 15);
		add(lblSesso);

		lblGruppoSanguigno = new JLabel("Gruppo Sanguigno");
		lblGruppoSanguigno.setBounds(970, 72, 108, 15);
		add(lblGruppoSanguigno);

		lblmicrochip = new JLabel("Microchip");
		lblmicrochip.setBounds(970, 132, 70, 15);
		add(lblmicrochip);
		lblmicrochip.setBounds(970, 192, 70, 15);

		lblDataNascita = new JLabel("Data Nascita");
		lblDataNascita.setBounds(970, 137, 70, 15);
		add(lblDataNascita);
		
		lblDataMorte = new JLabel("Data Morte");
		lblDataMorte.setBounds(970, 12, 70, 15);
		add(lblDataMorte);

		lblSterilizzato = new JLabel("Sterilizzato");
		lblSterilizzato.setBounds(970, 72, 108, 15);
		add(lblSterilizzato);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(970, 132, 70, 15);
		add(lblPeso);
		lblPeso.setBounds(970, 192, 70, 15);

		lblNote = new JLabel("Note");
		lblNote.setBounds(970, 137, 70, 15);
		add(lblNote);

		/*lblQt = new JLabel("Qt.");
		lblQt.setBounds(970, 312, 70, 15);
		add(lblQt);*/

		tabellaPazienti = new TabellaPazientiPanel(scrollPane);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 493, 100, 25);
		add(btnModifica);

		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 493, 100, 25);
		add(btnAggiorna);

		btnHome = new JButton();
		btnHome.setBounds(1058, 551, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getID_PAZText() {
		return ID_PAZText;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public JTextField getSpecieText() {
		return specieText;
	}
	
	public JTextField getRazzaText() {
		return razzaText;
	}
	
	public JTextField getSessoText() {
		return sessoText;
	}
	
	public JTextField getGruppoSanguignoText() {
		return GruppoSanguignoText;
	}

	public JTextField getMicrochipText() {
		return microchipText;
	}

	public JTextField getSterilizzatoText() {
		return sterilizzatoText;
	}

	public JTextField getPesoText() {
		return pesoText;
	}
	
	public JTextField getNoteText() {
		return noteText;
	}

	public JDateChooser getDataNascita() {
		return dataNascita;
	}
	
	public JDateChooser getDataMorte() {
		return dataMorte;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JLabel getlblID_PAZ() {
		return lblID_PAZ;
	}

	public JLabel getlblNome() {
		return lblNome;
	}

	public JLabel getLblSpecie() {
		return lblSpecie;
	}

	public JLabel getLblVeterinario() {
		return lblVeterinario;
	}
	
	public JLabel getlblCliente() {
		return lblCliente;
	}
	
	public JLabel getlblRazza() {
		return lblRazza;
	}

	public JLabel getlblSesso() {
		return lblSesso;
	}

	public JLabel getlblGruppoSanguigno() {
		return lblGruppoSanguigno;
	}

	public JLabel getlblmicrochip() {
		return lblmicrochip;
	}

	public JLabel getlblDataNascita() {
		return lblDataNascita;
	}

	public JLabel getlblDataMorte() {
		return lblDataMorte;
	}

	public JLabel getlblSterilizzato() {
		return lblSterilizzato;
	}

	public JLabel getlblPeso() {
		return lblPeso;
	}

	public JLabel getlblNote() {
		return lblNote;
	}
	
	/*public JLabel getLblQt() {
		return lblQt;
	}*/

	public JComboBox getVeterinariBox() {
		return veterinariBox;
	}
	
	public JComboBox getClientiBox() {
		return clientiBox;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public TabellaPazientiPanel getTabellaPazienti() {
		return tabellaPazienti;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
	
	public Paziente getNuovoPazienteTextField() {
		double peso = 0.0;
		Veterinari Vet;
		Clienti Cl;
		
		try {
			
			peso = Double.parseDouble(pesoText.getText());
			
		}
		
		catch(NumberFormatException nfe) {
			
			nfe.printStackTrace();
			
		}
		
		Paziente paz = new Paziente(ID_PAZText.getText(), nomeText.getText(), specieText.getText(), razzaText.getText(),
							sessoText.getText(), dataNascita, GruppoSanguignoText.getText(), microchipText.getText(), Vet, 
							peso, sterilizzatoText.getText(), Cl, dataMorte, noteText.getText());
		return paz;
	}
	

}

