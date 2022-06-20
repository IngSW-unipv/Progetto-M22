package database.classiDAO.anagraficaDAO.fornitoriDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.anagrafica.fornitori.Fornitori;

/**
 * permette di fare query sulla tabella fornitori del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FornitoriDAO implements IFornitoriDAO {

	private DbSingleton db;

	// costruttore
	public FornitoriDAO() {
		super();
		db = DbSingleton.getInstance();
	}

	/**
	 * seleziona fornitore in base alla PIVA passata
	 * 
	 * @param PIVA fornitore da selezionare
	 * @return Fornitore fornitore selezionato
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public Fornitori select_Forn(String PIVA) {

		ResultSet rs1;

		try {
			String query = "SELECT * FROM FORNITORI WHERE PIVA =\"" + PIVA + "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Fornitori f = new Fornitori(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6));
				return f;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * seleziona tutti i fornitori presenti nel db
	 * 
	 * @return ArrayList<Fornitori> tutti i fornitori presenti nel db
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Fornitori> selectAll() {
		ArrayList<Fornitori> result = new ArrayList<>();

		ResultSet rs1;

		try {
			String query = "SELECT * from FORNITORI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Fornitori f = new Fornitori(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * inserisce nuovo fornitore nel db
	 * 
	 * @param fo fornitore da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
	public boolean insertFornitore(Fornitori fo) {

		String query = "INSERT INTO FORNITORI (PIVA,AZIENDA,TELEFONO,EMAIL,CITTA,IBAN)" + "values (?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, fo.getPIVA());
			stmt.setString(2, fo.getNomeAzienda());
			stmt.setString(3, fo.getnTelefono());
			stmt.setString(4, fo.getEmail());
			stmt.setString(5, fo.getSede());
			stmt.setString(6, fo.getIBAN());
			stmt.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * elimina nel db fornitore selezionato
	 * 
	 * @param fo fornitore da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
	public void deleteFornitori(Fornitori fo) {

		String PIVA = fo.getPIVA();
		if (PIVA != null) {
			// deleteAllElementsWithThisFornitore(fo);

			String query = "delete from FORNITORI where PIVA=\"" + PIVA + "\"";
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

	/**
	 * update nel db fornitore selezionato tramite 
	 * 
	 * @param fo fornitore da aggiornare tramite piva passata estratta da fornitore nel parametro
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
	public void updateFornitori(Fornitori fo) {
		String query = "UPDATE FORNITORI SET AZIENDA = ?,TELEFONO = ?,EMAIL = ?,CITTA = ?,IBAN = ? " + "WHERE PIVA = \""
				+ fo.getPIVA() + "\"";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, fo.getNomeAzienda());
			stmt.setString(2, fo.getnTelefono());
			stmt.setString(3, fo.getEmail());
			stmt.setString(4, fo.getSede());
			stmt.setString(5, fo.getIBAN());
			stmt.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
