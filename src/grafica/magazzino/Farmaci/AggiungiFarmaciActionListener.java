package grafica.magazzino.Farmaci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import magazzino.farmaci.LottoFarmaci;
import magazzino.farmaci.LottoFarmaciDAO;

public class AggiungiFarmaciActionListener implements ActionListener {

	JTextField IDText;
	JTextField modeText;
	JTextField typeText;
	JTextField fornitoreText;
	JDateChooser dataText;
	JSpinner qtText;
	JTable table;
	LottoFarmaciDAO fdao = new LottoFarmaciDAO();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String IDLotto = IDText.getText();
		String mode = modeText.getText();
		String type = typeText.getText();
		String fornitore = fornitoreText.getText();
		Date data = dataText.getDate();
		int qt = (int) qtText.getValue();
		

		LottoFarmaci farmaco = new LottoFarmaci(IDLotto, mode, type, fornitore, data, qt);
		boolean flag = fdao.insertFarmaci(farmaco);

		//ArrayList<LottoFarmaci> res = fdao.selectAll();
		Object rowData[] = new Object[6];
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (flag) {

			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = fornitore;
			rowData[4] = data;
			rowData[5] = qt;

			model.addRow(rowData);

		}

	}

	public AggiungiFarmaciActionListener(JTextField IDText, JTextField modeText, JTextField typeText,
			JTextField fornitoreText, JDateChooser dataText, JSpinner qtText, JTable table, LottoFarmaciDAO fdao) {
		super();
		this.IDText = IDText;
		this.modeText = modeText;
		this.typeText = typeText;
		this.fornitoreText = fornitoreText;
		this.dataText = dataText;
		this.qtText = qtText;
		this.table = table;
		this.fdao = fdao;
	}

}
