package database.connectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Schema;

/**
 * Serve per connettersi a database.
 * Bisogna cambiare username e password a seconda del proprio db
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class ConnectionSQL {
	/**
	 * inizializza connessione col db
	 * 
	 * @param  conn connessione db
	 * @param schema del db che voglio collegare
	 * @exception Exception cercando il db
	 */
	public static Connection startConnection(Connection conn, String schema) {

		String DbURL = null;
		String username = null;
		String password = null;

		DbURL = "jdbc:mysql://localhost:3306/clinica";
		username = "root";
		password = "Alemag1929";
		
		if (isOpen(conn))
			closeConnection(conn);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	/**
	 * restituisce true se connessione db è aperta
	 * 
	 * @param  conn connessione db
	 * @return boolean
	 */
	public static boolean isOpen(Connection conn) {
		if (conn == null)
			return false;
		else
			return true;
	}

	/**
	 * chiude connessione col db
	 * 
	 * @param  conn connessione col db
	 * @exception Exception con chiusura db
	 */
	public static Connection closeConnection(Connection conn) {
		if (!isOpen(conn))
			return null;
		try {

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
