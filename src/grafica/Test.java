package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenu;
import java.awt.Scrollbar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.TextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuItem;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JToggleButton;

public class Test {

	private JFrame frame;
	//private final Action action = new SwingAction();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(102, 153, 204));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 732, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollBar scrollBar = new JScrollBar();
		frame.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(204, 255, 255));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		desktopPane.setLayer(panel_1, 1);
		panel_1.setBounds(86, 92, 243, 213);
		desktopPane.add(panel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(354, 92, 243, 213);
		desktopPane.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(86, 316, 243, 213);
		desktopPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(354, 316, 243, 213);
		desktopPane.add(panel_5);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("SMART VET");
		lblNewJgoodiesTitle_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 32));
		lblNewJgoodiesTitle_1.setForeground(Color.BLACK);
		lblNewJgoodiesTitle_1.setBackground(Color.WHITE);
		lblNewJgoodiesTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle_1.setBounds(231, 24, 234, 47);
		desktopPane.add(lblNewJgoodiesTitle_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("HOME");
		lblNewJgoodiesTitle.setToolTipText("");
		menuBar.add(lblNewJgoodiesTitle);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JButton Clienti = new JButton("Clienti");
		Clienti.setMaximumSize(new Dimension(200, 23));
		Clienti.setAlignmentX(Component.CENTER_ALIGNMENT);
		Clienti.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Clienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Clienti.setToolTipText("Accedi ai clienti");
		mnNewMenu.add(Clienti);
		
		JButton Pazienti = new JButton("Pazienti");
		Pazienti.setMaximumSize(new Dimension(200, 23));
		Pazienti.setAlignmentX(Component.CENTER_ALIGNMENT);
		mnNewMenu.add(Pazienti);
		
		JButton Magazzino = new JButton("Magazzino");
		Magazzino.setMaximumSize(new Dimension(200, 23));
		Magazzino.setAlignmentX(Component.CENTER_ALIGNMENT);
		mnNewMenu.add(Magazzino);
		
		JButton Agenda = new JButton("Agenda");
		Agenda.setMaximumSize(new Dimension(200, 23));
		Agenda.setAlignmentX(Component.CENTER_ALIGNMENT);
		mnNewMenu.add(Agenda);
		
		JButton Amministrazione = new JButton("Amministrazione");
		Amministrazione.setAlignmentX(Component.CENTER_ALIGNMENT);
		mnNewMenu.add(Amministrazione);
		
		JButton Fornitori = new JButton("Fornitori");
		Fornitori.setMaximumSize(new Dimension(200, 23));
		Fornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Fornitori.setForeground(new Color(0, 0, 0));
		Fornitori.setBackground(new Color(255, 255, 255));
		Fornitori.setAlignmentX(Component.CENTER_ALIGNMENT);
		mnNewMenu.add(Fornitori);
		
		JButton btnNewButton = new JButton("New button");
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		menuBar.add(btnNewButton_2);
	}

}
