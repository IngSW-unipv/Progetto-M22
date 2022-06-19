package database.classiDAO.appuntamentiDAO;

/**
 * permette di fare query sulla tabella appuntamenti  del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;

public class AppuntamentiDAO implements IAppuntamentiDAO {

	private DbSingleton db;

	// costruttore
	public AppuntamentiDAO() {

		super();
		db = DbSingleton.getInstance();

	}

	/**
	 * seleziona tutti gli appuntamenti presenti nel db
	 * 
	 * @return ArrayList<Appuntamenti> tutti gli appuntamenti presenti nel db dal
	 *         giorno corrente in poi
	 * 
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Appuntamenti> selectAll() {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI WHERE GIORNO >= CURDATE() ORDER BY GIORNO";
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

	/**
	 * seleziona appuntamento a seconda della riga della tabella grafica che
	 * corrisponde alla riga del db (solo per appuntamenti da giorno corrente in
	 * poi)
	 * 
	 * @param rigaselezionata riga selezionata da tabella
	 * @return int Id dell'appuntamento selezionato
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public int selectIDappuntamenti(int rigaSelezionata, String CF) {

		ResultSet rs1;

		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT COD_VISITA, RowNumber FROM\n"
				+ "				(SELECT COD_VISITA,GIORNO, ROW_NUMBER() OVER (ORDER BY GIORNO) AS RowNumber\n"
				+ "				FROM APPUNTAMENTI WHERE GIORNO >= CURDATE() AND VET_REFERENTE = \"" + CF + "\")B WHERE B.RowNumber = \"" + rigaSelezionata + "\"";
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

	/**
	 * elimina nel db appuntamento selezionata tramite Icod
	 * 
	 * @param cod dell'appuntamento da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
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

	/**
	 * seleziona tutti gli appuntamenti dal giorno corrente in poi presenti nel db
	 * in base al veterinario passato
	 * 
	 * @param CF_vetReferente CF del veterinario di cui selezionare appuntamenti
	 * @return ArrayList<Appuntamenti> tutti gli appunatamenti presenti nel db dal
	 *         giorno corrente in poi del veterinario passato
	 *
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Appuntamenti> appuntamentiOggiDueToVet(String CF_vetReferente) {
		// restituisce gli appuntamenti promemoria del giorno corrente del vet
		// sopra-elencatp

		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI where GIORNO = CURDATE() and VET_REFERENTE =\"" + CF_vetReferente
					+ "\" ORDER BY GIORNO";
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

	/**
	 * seleziona tutti gli appuntamenti dal giorno corrente in poi presenti nel db
	 * di ogni veterinario
	 * 
	 * @return ArrayList<Appuntamenti> tutti gli appunatamenti presenti nel db dal
	 *         giorno corrente in poi di tutti i veterinari
	 * 
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Appuntamenti> appuntamentiOggi() {
		// restituisce gli appuntamenti promemoria del giorno corrente del vet
		// sopra-elencatp

		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI where GIORNO = CURDATE()";
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

	/**
	 * inserisce nuovo appuntamento nel db
	 * 
	 * @param p appuntamento nuovo da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
	public boolean insertAppuntamenti(Appuntamenti p) {

		String query = "INSERT INTO APPUNTAMENTI (ID_PAZ, SALA, TIPO , GIORNO ,"
				+ " ORA, VET_REFERENTE, COSTO, NOTE) values (?,?,?,?,?,?,?,?) ";

		ResultSet rs;
		PreparedStatement stmt = null;
		int COD = 0;

		try {

			stmt = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, p.getPaziente().getIDpaz());
			stmt.setString(2, p.getSala());
			stmt.setString(3, p.getTipo());
			stmt.setDate(4, p.getData());
			stmt.setTime(5, p.getTime());
			stmt.setString(6, p.getVeterinario().getCF());
			stmt.setDouble(7, p.getCosto());
			stmt.setString(8, p.getNote());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			rs.next();
			COD = rs.getInt(1);
			p.setCOD(COD);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * aggiorna nel db appuntamento selezionato
	 * 
	 * @param p appuntamento da aggiornare
	 * @return void
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
	public void updateAppuntamenti(Appuntamenti p) {

		String query = "UPDATE APPUNTAMENTI SET ID_PAZ = ?,SALA = ? ,TIPO = ? ,GIORNO = ?,"
				+ " ORA = ? , VET_REFERENTE = ?, COSTO = ?,NOTE = ? " + " where COD_VISITA=\"" + p.getCOD()
				+ "\" ORDER BY GIORNO";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setInt(1, p.getPaziente().getIDpaz());
			stmt.setString(2, p.getSala());
			stmt.setString(3, p.getTipo());
			stmt.setDate(4, p.getData());
			stmt.setTime(5, p.getTime());
			stmt.setString(6, p.getVeterinario().getCF());
			stmt.setDouble(7, p.getCosto());
			stmt.setString(8, p.getNote());

			stmt.executeUpdate();

			p.setCOD(p.getCOD());
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

	/**
	 * seleziona tutti gli appuntamenti dal giorno corrente in poi presenti nel db
	 * in base al CF del veterinario passato come parametro
	 * 
	 * @param CFvet CF del veterinario da cui selezionare appuntamenti
	 * @return ArrayList<Appuntamenti> tutti gli appuntamenti presenti nel db dal
	 *         giorno corrente in poi del veterinario passato come parametro
	 * 
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet) {
		ArrayList<Appuntamenti> result = new ArrayList<>();

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		PazienteDAO paz = new PazienteDAO();

		try {

			String query = "SELECT * FROM APPUNTAMENTI WHERE VET_REFERENTE = \"" + CFvet
					+ "\"  AND GIORNO >= CURDATE() ORDER BY GIORNO";
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
	
	
	public int selectRigaGiusta(String CF, int COD) {

		ResultSet rs1;

		String query = "SELECT  RowNumber FROM\n"
				+ "				(SELECT COD_VISITA, ROW_NUMBER()OVER (ORDER BY GIORNO) AS RowNumber\n"
				+ "				FROM APPUNTAMENTI WHERE GIORNO >= CURDATE() AND VET_REFERENTE = \"" + CF + "\")B WHERE B.COD_VISITA = \"" + COD + "\"";
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
	
	public int selectRigaSala(String CF, int COD) {

		ResultSet rs1;

		String query = "SELECT  RowNumber FROM\n"
				+ "				(SELECT COD_VISITA, ROW_NUMBER()OVER (ORDER BY GIORNO) AS RowNumber\n"
				+ "				FROM APPUNTAMENTI WHERE GIORNO >= CURDATE())B WHERE B.COD_VISITA = \"" + COD + "\"";
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

}
