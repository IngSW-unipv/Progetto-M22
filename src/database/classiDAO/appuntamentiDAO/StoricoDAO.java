package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;

public class StoricoDAO implements IStoricoDAO {
	private DbSingleton db;

	public StoricoDAO() {
		super();
		db = DbSingleton.getInstance();
	}

	
	@Override
	public ArrayList<Appuntamenti> selectAll() {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;
		

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI ORDER BY GIORNO DESC";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.selectPazientefromID(rs1.getInt(2));

				Appuntamenti app = new Appuntamenti(rs1.getInt(1), p, rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	@Override
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet) {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI WHERE VET_REFERENTE = \"" + CFvet + "\" ORDER BY GIORNO DESC ";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.selectPazientefromID(rs1.getInt(2));

				Appuntamenti app = new Appuntamenti(rs1.getInt(1), p, rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
