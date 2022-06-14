package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.amministrazione.Entrate;

/**
 * permette di fare query sulla tabella entrate del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class EntrateDAO implements IEntrateDAO {

	private DbSingleton db;

	/**
	 * seleziona tutte le entrate presenti nel db
	 * 
	 * @return ArrayList<Entrate> tutte le entrate presenti nel db
	 * @exception SQLException qualcosa è andato storto nel db
	 */
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * inserisce nuova entrata nel db
	 * 
	 * @param entrate da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
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

	/**
	 * seleziona id entrata a seconda della riga della tabella grafica che
	 * corrisponde alla riga del db
	 * 
	 * @param rigaselezionata riga selezionata da tabella
	 * @return int Id dell'entrata selezionata
	 * @exception SQLException qualcosa è andato storto nel db
	 */
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

	/**
	 * elimina nel db entrata selezionata tramite ID
	 * 
	 * @param ID dell'entrata da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
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

	/**
	 * costruttore
	 * 
	 */
	public EntrateDAO() {

		super();
		db = DbSingleton.getInstance();
	}

}
