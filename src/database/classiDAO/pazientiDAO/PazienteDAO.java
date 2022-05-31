package database.classiDAO.pazientiDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;

public class PazienteDAO implements IPazienteDAO {

	private DbSingleton db;

	public PazienteDAO() {
		super();

	}

	public Paziente select_Paziente_from_CF(String ID) {

		ResultSet rs1;
		db = DbSingleton.getInstance();

		VeterinariDAO v = new VeterinariDAO();
		ClientiDAO cl = new ClientiDAO();

		try {
			String query = "SELECT * FROM PAZIENTI WHERE ID_PAZ =\"" + ID + "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Clienti cliente = cl.select_paziente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getDate(6), rs1.getString(7), rs1.getString(8), vet, rs1.getDouble(10),
						rs1.getString(11), rs1.getDate(12), rs1.getInt(13), rs1.getString(14));

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Paziente> selectAll() {
		ArrayList<Paziente> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		VeterinariDAO v = new VeterinariDAO();
		ClientiDAO cl = new ClientiDAO();

		try {
			String query = "SELECT * FROM PAZIENTI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Clienti cliente = cl.select_paziente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getDate(6), rs1.getString(7), rs1.getString(8), vet, rs1.getDouble(10),
						rs1.getString(11), cliente, rs1.getDate(13),  null, 0, null, 0, rs1.getString(14));

				result.add(paz);
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

	public void deletePazienti(PazienteDAO paz) {
		// TODO Auto-generated method stub
		
	}
}
