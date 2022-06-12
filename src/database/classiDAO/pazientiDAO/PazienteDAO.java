package database.classiDAO.pazientiDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.appuntamentiDAO.AppuntamentiDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;

public class PazienteDAO implements IPazienteDAO {

	private DbSingleton db;

	public PazienteDAO() {
		super();

	}

	public Paziente selectPazientefromID(int ID) {

		ResultSet rs1;
		db = DbSingleton.getInstance();

		VeterinariDAO v = new VeterinariDAO();
		ClientiDAO cl = new ClientiDAO();

		try {
			String query = "SELECT * FROM PAZIENTI WHERE ID_PAZ =\"" + ID + "\" ORDER BY ID_PAZ";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Clienti cliente = cl.select_cliente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getDate(5),
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
	
	public int[] selectAllIDpaz() {
		
		int len=0;
		ResultSet rs1;
		db = DbSingleton.getInstance();
		
		try {

			String query = "SELECT COUNT(ID_PAZ) FROM PAZIENTI ";
			rs1 = db.executeQuery(query);
			rs1.next();
			len = rs1.getInt(1);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] result = new int[len];

		try {

			String query = "SELECT ID_PAZ FROM PAZIENTI";
			rs1 = db.executeQuery(query);
			int i=0;

			while (rs1.next()) {

				int ID = rs1.getInt(1);

				result[i++]=ID;

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
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

				Paziente paz = new Paziente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getDate(5),
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
				+ "STERILIZZATO, PESO, DATA_MORTE, PROPRIETARIO, NOTE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
				+ ";" + "";
		
		ResultSet rs;
		PreparedStatement stmt = null;
		int autoID = 0;

		try {
			
			stmt = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
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
			
			rs= stmt.getGeneratedKeys();
			rs.next();
			autoID = rs.getInt(1);
			p.setIDpaz(autoID);
			
			//System.out.println(p + "ID" + auto_id);
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

	public int selectID_PAZ(int rigaSelezionata) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT ID_PAZ FROM\n" + "(\n"
				+ "SELECT  ID_PAZ, ROW_NUMBER() OVER (ORDER BY ID_PAZ) AS RowNumber\n" + "FROM PAZIENTI\n" + ") A\n"
				+ "WHERE RowNumber = \"" + rigaSelezionata + "\"";
		rs1 = db.executeQuery(query);

		try {
			if (rs1.next()) {

				return rs1.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return -1;
	}

	
	public void deletePazienti(int id) {

		String query = "delete from PAZIENTI where ID_PAZ=\"" + id + "\"";
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

	public void updatePaziente(Paziente p) {

		String query = "UPDATE PAZIENTI SET NOME = ?,TIPO = ?,RAZZA = ? ,DATA_NASC = ? ,SESSO = ?,"
				+ " VET_REFERENTE = ? , GRUP_SANG = ?, MICROCHIP = ?, STERILIZZATO = ?, PESO = ?, "
				+ "DATA_MORTE = ?, PROPRIETARIO = ?, NOTE = ?" + " where ID_PAZ=\"" + p.getIDpaz() + "\"";
		
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

			p.setIDpaz(p.getIDpaz());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
			/*VeterinariDAO vdao = new VeterinariDAO();
			Veterinari vet = vdao.select_Veterinari_from_CF("LCSMRA80A43B963A");
			System.out.println(vet);
			
			ClientiDAO cdao = new ClientiDAO();
			Clienti cl = cdao.select_cliente_from_CF("E6GE55G626366BF9");
			System.out.println(cl);
			
			Date nato = new Date(2018-06-07);
			
			PazienteDAO pdao = new PazienteDAO();
			Paziente paz = new Paziente ("robin", "cane", "pastore", nato , "F", vet, "AB", true, true, 23, nato, cl,"eee");
			pdao.insertPaziente(paz);*/

		}
}
