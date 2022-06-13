package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.amministrazione.Uscite;

public class UsciteDAO implements IUsciteDAO {

	private DbSingleton db;

	@Override
	public ArrayList<Uscite> selectAll() {

		ArrayList<Uscite> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM USCITE ORDER BY DATA";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Uscite uscite = new Uscite(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getDouble(4),
						rs1.getDate(5));

				result.add(uscite);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	@Override
	public boolean insertUscite(Uscite uscite) {

		String query = "INSERT INTO USCITE (ID, PREZZO, CAUSA, TIPO, DATA) values (?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;
		ResultSet rs;

		int ID = 0;

		try {

			stmt = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, uscite.getID());
			stmt.setString(3, uscite.getCausa());
			stmt.setDouble(2, uscite.getPrezzo());
			stmt.setString(4, uscite.getTipo());
			stmt.setDate(5, uscite.getData());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			rs.next();
			ID = rs.getInt(1);
			uscite.setID(ID);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	@Override
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
	
	
	@Override
	public int selectIDuscita(int rigaSelezionata) {

		ResultSet rs1;

		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT ID FROM\n" + "(\n" + "SELECT ID, ROW_NUMBER() OVER (ORDER BY DATA) AS RowNumber\n"
				+ "FROM USCITE\n" + ") A\n" + "WHERE RowNumber = \"" + rigaSelezionata + "\"";
		rs1 = db.executeQuery(query);

		try {
			if (rs1.next()) {

				return rs1.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return -1;
	}

	public UsciteDAO() {
		super();
		DbSingleton.getInstance();
	}

}
