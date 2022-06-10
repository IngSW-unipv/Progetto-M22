package database.classiDAO.appuntamentiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

			String query = "SELECT * FROM APPUNTAMENTI ORDER BY GIORNO DESC";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.selectPazientefromID(rs1.getInt(2));

				Appuntamenti app = new Appuntamenti(p, rs1.getString(3), rs1.getString(4), rs1.getDate(5),
						rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	public int[] selectAllIDpaz() {
		
		int len=0;
		ResultSet rs1;
		db = DbSingleton.getInstance();
		
		try {

			String query = "SELECT COUNT(ID_PAZ) FROM APPUNTAMENTI";
			rs1 = db.executeQuery(query);
			rs1.next();
			len = rs1.getInt(1);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] result = new int[len];

		try {

			String query = "SELECT ID_PAZ, GIORNO FROM APPUNTAMENTI ORDER BY GIORNO DESC";
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
	
	public int selectIDappuntamenti(int rigaSelezionata) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT COD_VISITA FROM\n" + "(\n"
				+ "SELECT COD_VISITA,GIORNO, ROW_NUMBER() OVER (ORDER BY GIORNO DESC) AS RowNumber\n" + "FROM APPUNTAMENTI\n" + ") A\n"
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
	
	public void deleteAppuntamenti(int cod) {

		String query = "delete from APPUNTAMENTI where COD_VISITA=\"" + cod + "\"";
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
				Paziente p = paz.selectPazientefromID(rs1.getInt(2));

				Appuntamenti app = new Appuntamenti(p, rs1.getString(3), rs1.getString(4), rs1.getDate(5),
						rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	

	public boolean insertAppuntamenti(Appuntamenti p, int ID_PAZ) {
		
		String query = "INSERT INTO APPUNTAMENTI (ID_PAZ, SALA, TIPO , GIORNO ,"
				+ " ORA, VET_REFERENTE, COSTO, NOTE) values (?,?,?,?,?,?,?,?) ";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setInt(1, ID_PAZ);
			stmt.setString(2, p.getSala());
			stmt.setString(3, p.getTipo());
			stmt.setDate(4, p.getData());
			stmt.setTime(5, p.getTime());
			stmt.setString(6, p.getVeterinario().getCF());
			stmt.setDouble(7, p.getCosto());
			stmt.setString(8, p.getNote());

			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void updateAppuntamenti(int COD, Appuntamenti p, int ID_PAZ) {
		
		String query = "UPDATE APPUNTAMENTI SET ID_PAZ = ?,SALA = ? ,TIPO = ? ,GIORNO = ?,"
				+ " ORA = ? , VET_REFERENTE = ?, COSTO = ?,NOTE = ? " + " where COD_VISITA=\"" + COD + "\" ORDER BY GIORNO";
		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setInt(1, ID_PAZ);
			stmt.setString(2, p.getSala());
			stmt.setString(3, p.getTipo());
			stmt.setDate(4, p.getData());
			stmt.setTime(5, p.getTime());
			stmt.setString(6, p.getVeterinario().getCF());
			stmt.setDouble(7, p.getCosto());
			stmt.setString(8, p.getNote());

			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet) {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI WHERE VET_REFERENTE = \"" + CFvet + "\"  ORDER BY GIORNO DESC ";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Paziente p = paz.selectPazientefromID(rs1.getInt(2));

				Appuntamenti app = new Appuntamenti(p, rs1.getString(3), rs1.getString(4), rs1.getDate(5),
						rs1.getTime(6), vet, rs1.getDouble(8), rs1.getString(9));

				result.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	
	public int[] selectAllIDpazdueToVeterinario(String CFvet) {
		
		int len=0;
		ResultSet rs1;
		db = DbSingleton.getInstance();
		
		try {

			String query = "SELECT COUNT(ID_PAZ) FROM APPUNTAMENTI WHERE VET_REFERENTE = \"" + CFvet + "\"";
			rs1 = db.executeQuery(query);
			rs1.next();
			len = rs1.getInt(1);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] result = new int[len];

		try {

			String query = "SELECT ID_PAZ, GIORNO FROM APPUNTAMENTI "
					+ "WHERE VET_REFERENTE = \"" + CFvet + "\" ORDER BY GIORNO DESC ";
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
	
	public int selectIDappuntamentiDueToVet(int rigaSelezionata, String CFvet) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT COD_VISITA FROM\n" + "(\n"
				+ "SELECT COD_VISITA,GIORNO,CF_VET ROW_NUMBER() OVER (ORDER BY GIORNO DESC) AS RowNumber\n" + "FROM APPUNTAMENTI\n" + ") A\n"
				+ "WHERE RowNumber = \"" + rigaSelezionata + "\" AND VET_REFERENTE = \"" + CFvet + "\"";
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
	
	public void deleteAppuntamenti(String cod) {
		
		String query = "delete from APPUNTAMENTI where COD_VISITA=\"" + cod + "\"";
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

	public static class Engine1 {

		public static void main(String[] args) {

			AppuntamentiDAO pdao = new AppuntamentiDAO();

			ArrayList<Appuntamenti> res = pdao.appuntamentiOggi("LCSMRA80A43B963A");

			for (Appuntamenti r : res)
				System.out.println(r.toString());
		}

	}
}
