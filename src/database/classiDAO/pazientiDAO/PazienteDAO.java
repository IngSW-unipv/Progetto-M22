package database.classiDAO.pazientiDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
/**
 * permette di fare query sulla tabella pazienti del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class PazienteDAO implements IPazienteDAO {

	private DbSingleton db;

	//costruttore
	public PazienteDAO() {
		super();
		db = DbSingleton.getInstance();

	}

	/**
	 * seleziona tutto il paziente tramite ID passato
	 * 
	 * @param ID del paziente da selezionare
	 * @return Paziente selezionato 
	 * 
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	@Override
	public Paziente selectPazientefromID(int ID) {

		ResultSet rs1;

		VeterinariDAO v = new VeterinariDAO();
		ClientiDAO cl = new ClientiDAO();

		try {
			String query = "SELECT * FROM PAZIENTI WHERE ID_PAZ =\"" + ID + "\" ORDER BY ID_PAZ";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Veterinari vet = v.select_Veterinari_from_CF(rs1.getString(7));
				Clienti cliente = cl.select_cliente_from_CF(rs1.getString(13));

				Paziente paz = new Paziente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getString(6), vet, rs1.getString(8), rs1.getBoolean(9), rs1.getBoolean(10),
						rs1.getDouble(11), rs1.getDate(12), cliente, rs1.getString(14));

				return paz;

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * seleziona tutti i pazienti presenti nel db
	 * 
	 * @return ArrayList<Paziente> tutti i pazienti del db
	 * 
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	@Override
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

				Paziente paz = new Paziente(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getString(6), vet, rs1.getString(8), rs1.getBoolean(9), rs1.getBoolean(10),
						rs1.getDouble(11), rs1.getDate(12), cliente, rs1.getString(14));

				result.add(paz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * inserisce nuovo paziente nel db
	 * 
	 * @param  p paziente nuovo da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
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

			rs = stmt.getGeneratedKeys();
			rs.next();
			autoID = rs.getInt(1);
			p.setIDpaz(autoID);

			// System.out.println(p + "ID" + auto_id);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * seleziona pazientea seconda della riga
	 * della tabella grafica che corrisponde
	 * alla riga del db 
	 * @param  rigaselezionata riga selezionata da tabella
	 * @return int ID del paziente selezionato
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	@Override
	public int selectID_PAZ(int rigaSelezionata) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		rigaSelezionata = rigaSelezionata + 1;
		System.out.println(rigaSelezionata + "riga n");
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
	
	/**
	 * elimina  nel db paziente selezionata tramite cod
	 * 
	 * @param  id	 del paziente da eliminare
	 * @return void
	 * @exception SQLException  qualcosa è andato storto nel delete
	 */
	@Override
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

	/**
	 * aggiorna nel db paziente selezionato
	 * 
	 * @param  p paziente da aggiornare
	 * @return void
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
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
			if (p.getVeterinario() != null) {
			stmt.setString(6, p.getVeterinario().getCF());
			}
			else {
				stmt.setString(6, null);
			}
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

}
