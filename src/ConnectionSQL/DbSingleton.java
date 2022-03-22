package ConnectionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingleton {

	private Connection connection;
	private static DbSingleton db;
	private Statement statement;

	private DbSingleton() {

		startConnection();

	}

	public static DbSingleton getInstance() {

		if (db == null) {

			db = new DbSingleton();

		}

		return db;

	}

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

	public void startConnection() {

		connection = ConnectionSQL.startConnection(connection, "clinica");

	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {

	}

}
