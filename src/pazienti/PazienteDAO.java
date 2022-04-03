package pazienti;

import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class PazienteDAO implements IPazienteDAO {

	private DbSingleton db;

	public PazienteDAO() {
		super();

	}

	public ArrayList<Paziente> selectAll() {
		ArrayList<Paziente> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM PAZIENTI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Paziente v = new Paziente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
						rs1.getString(10), rs1.getDouble(11), rs1.getDate(12), rs1.getString(13), rs1.getString(14));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertPaziente(Paziente p) {
		// TODO Auto-generated method stub
		return false;
	}

	public static class Engine1 {

		public static void main(String[] args) {

			PazienteDAO pdao = new PazienteDAO();

			ArrayList<Paziente> res = pdao.selectAll();

			for (Paziente r : res)
				System.out.println(r.toString());
		}

	}
}
