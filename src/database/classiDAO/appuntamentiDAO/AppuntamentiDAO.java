package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.appuntamenti.Appuntamenti;


public class AppuntamentiDAO implements IAppuntamentiDAO {
	private DbSingleton db;

	public AppuntamentiDAO() {
		super();

	}

	public ArrayList<Appuntamenti> selectAll() {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM VISITE";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Appuntamenti v = new Appuntamenti(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5), rs1.getTime(6), rs1.getString(7), rs1.getDouble(8),
						rs1.getString(9));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Appuntamenti> appuntamentiOggi(String CF_vetReferente) {
		// restituisce gli appuntamenti promemoria del giorno corrente del vet
		// sopra-elencatp
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM VISITE where GIORNO = CURDATE() and VET_REFERENTE =\"" + CF_vetReferente
					+ "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) { // 3 4 5 6 9
				Appuntamenti v = new Appuntamenti(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5), rs1.getTime(6), rs1.getString(7), rs1.getDouble(8),
						rs1.getString(9));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertAppuntamenti(Appuntamenti p) {
		// TODO Auto-generated method stub
		return false;
	}

	public static class Engine1 {

		public static void main(String[] args) {

			AppuntamentiDAO pdao = new AppuntamentiDAO();

			ArrayList<Appuntamenti> res = pdao.appuntamentiOggi("LCSMRA80A43B963A");

			for (Appuntamenti r : res)
				System.out.println(r.toString());
		}

	}
}
