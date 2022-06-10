package database.classiDAO.loginDAO;

import java.sql.ResultSet;

import database.connectionSQL.DbSingleton;

public class LoginDAO implements ILoginDAO {
	private DbSingleton db;

	public boolean isMatching(String user, String password) {

		int number = 0;
		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT count(USERNAME), USERNAME, PASSWORD FROM" + " LOGIN WHERE USERNAME = \"" + user
					+ "\"  AND PASSWORD = \"" + password + "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				number = rs1.getInt(1);
				System.out.println(number);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		if (number > 0)
			return true;
		else
			return false;
	}

	public String getCFuserLoggedIn(String user, String password) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		String CF = null;
		try {
			String query = "SELECT CF FROM LOGIN WHERE USERNAME = \"" + user + "\"  AND PASSWORD = \"" + password
					+ "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				CF = rs1.getString(1);
				System.out.println(CF);
				return CF;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}
