package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.connectionSQL.DbSingleton;

/**
 * permette di fare query sulla tabella sale del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class SalaDAO implements ISalaDAO {

	private DbSingleton db;

	/**
	 * seleziona tutti le sale presenti nel db
	 * 
	 * @return String[] array di tutte le sale del db
	 * 
	 * @exception SQLException qualcosa è andato storto nel db
	 */
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

	// costruttore
	public SalaDAO() {
		super();
		db = DbSingleton.getInstance();
	}

}
