package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;
import model.economia.Entrate;
import model.economia.Uscite;

public class EntrateDAO {
	private DbSingleton db;
	
	public ArrayList<Entrate> selectAll() {
		
		ArrayList<Entrate> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();
 
		try {
			String query = "SELECT * FROM ENTRATE";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Entrate ent = new Entrate(rs1.getInt(1), rs1.getDouble(2), rs1.getString(3));

				result.add(ent);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public boolean insertEntrate(Entrate entrate) {

		String query = "INSERT INTO ENTRATE (ID, PREZZO, CAUSA) values (?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setInt(1, entrate.getID());
			stmt.setDouble(2, entrate.getPrezzo());
			stmt.setString(3, entrate.getCausa());
			
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void deleteEntrate(int ID) {

		String query = "delete from ENTRATE where ID=\"" + ID + "\"";
		
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
