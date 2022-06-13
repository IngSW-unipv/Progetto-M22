package database.classiDAO.loginDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.connectionSQL.DbSingleton;

public class LoginDAO implements ILoginDAO {
	
	private DbSingleton db; 

	
	
	@Override
	public boolean isMatching(String user, String password) {

		int number = 0;
		ResultSet rs1;
		

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

	
	
	@Override
	public String getCFuserLoggedIn(String user, String password) {

		ResultSet rs1;
		
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
	
	
	@Override
	public void insertNuovoUtente(String user, String password, String CFdip) {

		String query = "INSERT INTO LOGIN (USERNAME, PASSWORD, CF )" + "values (?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, user);
			stmt.setString(2, password);
			stmt.setString(3, CFdip);

			stmt.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public LoginDAO() {
		super();
		db = DbSingleton.getInstance();
	}
	
	

}
