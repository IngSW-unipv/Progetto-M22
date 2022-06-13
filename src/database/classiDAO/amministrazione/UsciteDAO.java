package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;
import model.economia.Uscite;

public class UsciteDAO {

	private DbSingleton db;

	public ArrayList<Uscite> selectAll() {

		ArrayList<Uscite> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM USCITE";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Uscite uscite = new Uscite(rs1.getInt(1), rs1.getDouble(2), rs1.getString(3));

				result.add(uscite);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean insertUscite(Uscite uscite) {

		String query = "INSERT INTO USCITE (ID, PREZZO, CAUSA) values (?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setInt(1, uscite.getID());
			stmt.setDouble(2, uscite.getPrezzo());
			stmt.setString(3, uscite.getCausa());
			
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void deleteUscite(int ID) {

		String query = "delete from USCITE where ID=\"" + ID + "\"";
		
		PreparedStatement stmt = null;
		try {
			stmt = db.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
