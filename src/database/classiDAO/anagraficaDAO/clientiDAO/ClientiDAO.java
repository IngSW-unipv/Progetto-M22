package database.classiDAO.anagraficaDAO.clientiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;

/**
 * permette di fare query sulla tabella clienti del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ClientiDAO implements IClientiDAO {

	private DbSingleton db;

	/**
	 * costruttore
	 * 
	 */
	public ClientiDAO() {
		super();
		db = DbSingleton.getInstance();

	}

	/**
	 * seleziona cliente in base al CF passato
	 * 
	 * @param CF del cliente da selezionare
	 * @return int ID dell' entrata selezionata
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public Clienti select_cliente_from_CF(String CF) {

		ResultSet rs1;

		try {
			String query = "SELECT * FROM CLIENTI WHERE CF_CL =\"" + CF + "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Clienti f = new Clienti(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7));

				return f;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * seleziona tutti i clienti presenti nel db
	 * 
	 * @return ArrayList<Clienti> tutti i clienti presenti nel db
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Clienti> selectAll() {
		ArrayList<Clienti> result = new ArrayList<>();

		ResultSet rs1;

		try {
			String query = "SELECT * FROM CLIENTI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Clienti f = new Clienti(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7));

				result.add(f);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * inserisce nuovo cliente nel db
	 * 
	 * @param cl cliente da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
	public boolean insertClienti(Clienti cl) {

		String query = "INSERT INTO CLIENTI (NOME,COGNOME,CF_CL,EMAIL,TELEFONO,CITTA,"
				+ "INDIRIZZO) values (?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCognome());
			stmt.setString(3, cl.getCF());
			stmt.setString(4, cl.getEmail());
			stmt.setString(5, cl.getCellulare());
			stmt.setString(6, cl.getCitta());
			stmt.setString(7, cl.getIndirizzo());
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * elimina nel db cliente selezionato
	 * 
	 * @param cl cliente da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
	public void deleteClienti(Clienti cl) {
		String CF_CL = cl.getCF();
		String query = "delete from CLIENTI where CF_CL=\"" + CF_CL + "\"";
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