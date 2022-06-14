package database.classiDAO.amministrazione;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.amministrazioneController.entrateController.EntrateController;
import database.connectionSQL.DbSingleton;
import model.amministrazione.Uscite;

/**
 * permette di fare query sulla tabella uscite del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see EntrateController
 */
public class UsciteDAO implements IUsciteDAO {

	private DbSingleton db;

	/**
	 * seleziona tutte le uscite presenti nel db
	 * 
	 * @return ArrayList<Uscite> tutte le uscite presenti nel db
	 * @exception SQLException qualcosa è andato storto nel db
	 */
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * inserisce nuova uscita nel db
	 * 
	 * @param uscita da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */

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

	/**
	 * elimina uscita nel db selezionata tramite ID
	 * 
	 * @param ID dell'uscita da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
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

	/**
	 * seleziona id uscita a seconda della riga della tabella grafica che
	 * corrisponde alla riga del db
	 * 
	 * @param rigaSelezionata riga selezionata da tabella
	 * @return int Id uscita selezionata
	 * @exception SQLException qualcosa è andato storto nel db
	 */
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

	// costruttore
	public UsciteDAO() {
		super();
		DbSingleton.getInstance();
	}

}
