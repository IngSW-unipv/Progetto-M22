package ConnectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

	public static Connection startConnection(Connection conn, String schema) {
		String DbDriver = null;
		String DbURL = null;
		String username = null;
		String password = null;

		DbDriver = "com.mysql.jdbc.Driver";
		DbURL = "jdbc:mysql://localhost:3306/clinica";
		// DbURL =
		// "jdbc:mysql://localhost/"+schema+"?socketFactory=SSHSocketFactory&SSHHost=192.168.3.42&SSHUser=nino&SSHPassword=nocera369";
		// System.out.println(DbURL);
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

	public static boolean isOpen(Connection conn) {
		if (conn == null)
			return false;
		else
			return true;
	}

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
