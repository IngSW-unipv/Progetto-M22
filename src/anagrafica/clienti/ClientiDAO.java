package anagrafica.clienti;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import ConnectionSQL.DbSingleton;

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
	public boolean insertClienti(Clienti f) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int GetNumColonne() throws SQLException
	{
		String query = "SELECT * FROM CLIENTI";
		ResultSet rs1 = db.executeQuery(query);
		ResultSetMetaData rsmd =  (ResultSetMetaData) rs1.getMetaData();
		int colonne = rsmd.getColumnCount();
		return colonne;
	}

	public static class Engine2 {

		public static void main(String[] args) throws SQLException {

			ClientiDAO cdao = new ClientiDAO();

			ArrayList<Clienti> res = cdao.selectAll();

			for (Clienti r : res)
				System.out.println(r.toString());
			
			System.out.println(cdao.GetNumColonne());
		}

	}
	
	
}