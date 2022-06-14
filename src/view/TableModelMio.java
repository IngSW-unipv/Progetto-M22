package view;

import javax.swing.table.DefaultTableModel;

public class TableModelMio extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public TableModelMio(Object[][] data, String[] col) {
		super(data, col);
		}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
