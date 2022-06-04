package database.classiDAO.pazientiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				Clienti cliente = cl.select_cliente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getDate(5),
						rs1.getString(6), vet, rs1.getString(8), rs1.getBoolean(9), rs1.getBoolean(10),
						rs1.getDouble(11), rs1.getDate(12), cliente, rs1.getString(14));

				return paz;

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
				Clienti cliente = cl.select_cliente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getDate(5),
						rs1.getString(6), vet, rs1.getString(8), rs1.getBoolean(9), rs1.getBoolean(10),
						rs1.getDouble(11), rs1.getDate(12), cliente, rs1.getString(14));

				result.add(paz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertPaziente(Paziente p) {
		String query = "INSERT INTO PAZIENTI (NOME,TIPO,RAZZA,DATA_NASC,SESSO, VET_REFERENTE, GRUP_SANG, MICROCHIP,"
				+ "STERILIZZATO, PESO, DATA_MORTE, PROPRIETARIO, NOTE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getSpecie());
			stmt.setString(3, p.getRazza());
			stmt.setDate(4, p.getDataNascita());
			stmt.setString(5, p.getSesso());
			stmt.setString(6, p.getVeterinario().getCF());
			stmt.setString(7, p.getGruppoSanguigno());
			stmt.setBoolean(8, p.getMicrochip());
			stmt.setBoolean(9, p.getSterilizzato());
			stmt.setDouble(10, p.getPeso());
			stmt.setDate(11, p.getDataMorte());
			stmt.setString(12, p.getCliente().getCF());
			stmt.setString(13, p.getNote());

			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
