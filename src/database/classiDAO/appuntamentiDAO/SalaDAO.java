package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;

import database.connectionSQL.DbSingleton;

public class SalaDAO implements ISalaDAO {

	private DbSingleton db;

	@Override
	public String[] selectSale() {

		int len = 0;
		ResultSet rs1;

		try {

			String query = "SELECT COUNT(ID) FROM SALA";
			rs1 = db.executeQuery(query);
			rs1.next();
			len = rs1.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] result = new String[len];

		try {

			String query = "SELECT ID FROM SALA";
			rs1 = db.executeQuery(query);

			int i = 0;

			while (rs1.next()) {

				String ID = rs1.getString(1);

				result[i++] = ID;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public SalaDAO() {
		super();
		db = DbSingleton.getInstance();
	}

}
