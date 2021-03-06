package anagrafica.clienti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Popup;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import ConnectionSQL.DbSingleton;
import anagrafica.fornitori.Fornitori;
import grafica.PopupError;

public class ClientiDAO implements IClientiDAO {

	private DbSingleton db;

	public ClientiDAO() {
		super();

	}

	public ArrayList<Clienti> selectAll() {
		ArrayList<Clienti> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

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
			PopupError.infoBox("Esiste già un cliente con questo CF", "ERRORE");
			return false;
		}
		return true;
	} 

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

	/*
	 * public static class Engine2 {
	 * 
	 * public static void main(String[] args) throws SQLException {
	 * 
	 * ClientiDAO cdao = new ClientiDAO();
	 * 
	 * ArrayList<Clienti> res = cdao.selectAll();
	 * 
	 * 
	 * //Clienti cl = new Clienti("a","b","c", "a","a","a","a");
	 * cdao.insertClienti(cl);
	 * 
	 * for (Clienti r : res) System.out.println(r.toString());
	 * 
	 * 
	 * 
	 * System.out.println(cdao.GetNumColonne());
	 * 
	 * 
	 * }
	 */

}