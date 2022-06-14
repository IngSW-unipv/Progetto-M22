package database.classiDAO.loginDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.connectionSQL.DbSingleton;
/**
 * permette di fare query sulla tabella login  del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class LoginDAO implements ILoginDAO {
	
	private DbSingleton db; 

	
	
	
	/**
	 * conta quante volte nel db è presente un record
	 * con la password e il username passati, se il conto
	 * è >0 allora vuol dire che le credenziali
	 * sono effettivamente nel database
	 * 
	 * @param user username di chi si logga
	 * @param password di chi si logga
	 * @return boolean = true se conto > 0
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
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
		} catch (SQLException e) {
			e.printStackTrace();

		}

		if (number > 0)
			return true;
		else
			return false;
	}

	
	/**
	 * seleziona il CF del veterinario loggato
	 * 
	 * @param user username di chi si logga
	 * @param password di chi si logga
	 * @return String CF
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	
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
	
	/**
	 * inserisce nuovo utente nel db
	 * 
	 * @param user username nuovo inserito
	 * @param password nuovo inserita
	 * @return void
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	
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

	//costruttore
	public LoginDAO() {
		super();
		db = DbSingleton.getInstance();
	}
	
	

}
