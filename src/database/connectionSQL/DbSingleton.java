package database.connectionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingleton {

	/**
	 * permette di collegarsi col db con un unica istanza
	 * 
	 * @author MMA
	 * @version 1.0 (current version number of program)
	 */

	private Connection connection;
	private static DbSingleton db;
	private Statement statement;

	//costruttore inizializza in automatico la connessione col db
	private DbSingleton() {

		startConnection();

	}

	/**
	 * restituisce istanza connessione db
	 * 
	 */
	public static DbSingleton getInstance() {

		if (db == null) {

			db = new DbSingleton();

		}

		return db;

	}

	/**
	 * restituisce il risultato della query effettuata passata come parametro
	 * 
	 * @param query da effettuare
	 */
	public ResultSet executeQuery(String query) {

		try {

			statement = connection.createStatement();
			return statement.executeQuery(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * inizializza connessione col db
	 * 
	 * @return void
	 */
	public void startConnection() {

		connection = ConnectionSQL.startConnection(connection, "clinica");

	/**
	 * restituisce connessione col db
	 * 
	 * @return void
	*/
	}

	public Connection getConnection() {
		return connection;
	}

	/**
	 * chiudeconnessione col db
	 * @return void
	 */
	public void closeConnection() {
		connection = ConnectionSQL.closeConnection(connection);
	}

}
