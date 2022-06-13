package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.amministrazione.Entrate;

public class EntrateDAO implements IEntrateDAO {

	private DbSingleton db;

	@Override
	public ArrayList<Entrate> selectAll() {

		ArrayList<Entrate> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM ENTRATE ORDER BY DATA";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Entrate ent = new Entrate(rs1.getInt(1), rs1.getString(2), rs1.getDouble(3), rs1.getString(4),
						rs1.getDate(5));

				result.add(ent);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertEntrate(Entrate entrate) {

		String query = "INSERT INTO ENTRATE (PREZZO, CAUSA, TIPO, DATA) values (?, ?, ?, ?)";

		PreparedStatement stmt = null;
		ResultSet rs;

		int ID = 0;

		try {

			stmt = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setDouble(1, entrate.getPrezzo());
			stmt.setString(2, entrate.getCausa());
			stmt.setString(3, entrate.getTipo());
			stmt.setDate(4, entrate.getData());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			rs.next();
			ID = rs.getInt(1);
			entrate.setID(ID);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int selectIDentrata(int rigaSelezionata) {

		ResultSet rs1;

		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT ID FROM\n" + "(\n" + "SELECT ID, ROW_NUMBER() OVER (ORDER BY DATA) AS RowNumber\n"
				+ "FROM ENTRATE\n" + ") A\n" + "WHERE RowNumber = \"" + rigaSelezionata + "\"";
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

	@Override
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

	public EntrateDAO() { 

		super();
		db = DbSingleton.getInstance();
	}

}
