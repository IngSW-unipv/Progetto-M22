package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;

public class AppuntamentiDAO implements IAppuntamentiDAO {
	private DbSingleton db;

	public AppuntamentiDAO() {
		super();

	}

	public ArrayList<Appuntamenti> selectAll() {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.select_Paziente_from_CF(rs1.getString(2));

				Appuntamenti app = new Appuntamenti(rs1.getString(1), p, rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
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

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI where GIORNO = CURDATE() and VET_REFERENTE =\"" + CF_vetReferente
					+ "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.select_Paziente_from_CF(rs1.getString(2));

				Appuntamenti app = new Appuntamenti(rs1.getString(1), p, rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
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
