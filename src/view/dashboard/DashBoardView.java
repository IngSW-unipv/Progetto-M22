package view.dashboard;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import view.dashboard.farmaciScadenza.TabellaFarmaciScadenzaView;
import view.dashboard.promemoria.PromemoriaView;

public class DashBoardView extends JPanel {

private static final long serialVersionUID = 1L;
private MenuView menu;
private JScrollPane promemoriaScrollPane;
private JScrollPane farmaciScadenzaScrollPane;
private PromemoriaView promemoria;
private TabellaFarmaciScadenzaView f;


public DashBoardView() {

super();
setVisible(true);
setBounds(0, 0, 2700, 2200);
setLayout(null);

menu = new MenuView();
add(menu);

// creo un pannello con scrollo per promemoria
promemoriaScrollPane = new JScrollPane();
promemoriaScrollPane.setBounds(174, 163, 435, 249);
add(promemoriaScrollPane);

// creo un pannello con scrollo per farmaci in scadenza
farmaciScadenzaScrollPane = new JScrollPane();
farmaciScadenzaScrollPane.setBounds(686, 163, 412, 254);
add(farmaciScadenzaScrollPane);

f = new TabellaFarmaciScadenzaView(farmaciScadenzaScrollPane);

promemoria = new PromemoriaView(promemoriaScrollPane);

JLabel lblSmartvet = new JLabel("SmartVet");
lblSmartvet.setFont(new Font("Dialog", Font.BOLD, 41));
lblSmartvet.setBounds(518, 30, 333, 121);
add(lblSmartvet);
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