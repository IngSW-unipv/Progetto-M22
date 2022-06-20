package database.classiDAO.anagraficaDAO.veterinariDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.anagrafica.veterinari.Veterinari;

/**
 * permette di fare query sulla tabella dipendenti del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class VeterinariDAO implements IVeterinariDAO {

	private DbSingleton db;

	// costruttore
	public VeterinariDAO() {

		super();
		db = DbSingleton.getInstance();
	}

	/**
	 * seleziona veterinario in base al CF passato
	 * 
	 * @param CF veterinario da selezionare
	 * @return Veterinari veterinario selezionato
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public Veterinari select_Veterinari_from_CF(String CF) {

		ResultSet rs1;

		try {
			String query = "SELECT * FROM DIPENDENTI WHERE CF_DIP =\"" + CF + "\"";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Veterinari v = new Veterinari(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
						rs1.getDouble(10), rs1.getDouble(11), rs1.getString(12));
				return v;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * seleziona tutti i veterinari presenti nel db
	 * 
	 * @return ArrayList<Veterinari> tutti i veterinari presenti nel db
	 * @exception SQLException qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<Veterinari> selectAll() {

		ArrayList<Veterinari> result = new ArrayList<>();

		ResultSet rs1;

		try {
			String query = "SELECT * FROM DIPENDENTI";
			rs1 = db.executeQuery(query);
			while (rs1.next()) {
				Veterinari v = new Veterinari(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
						rs1.getDouble(10), rs1.getDouble(11), rs1.getString(12));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * inserisce nuovo veterinario nel db
	 * 
	 * @param vet veetrinario da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
	public boolean insertVeterinari(Veterinari vet) {

		String query = "INSERT INTO DIPENDENTI (NOME,COGNOME,CF_DIP,EMAIL,TELEFONO,CITTA,"
				+ "INDIRIZZO,PIVA,TIPO_DI_CONTRATTO,STIPENDIO,COMMISS,IBAN) values (?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, vet.getNome());
			stmt.setString(2, vet.getCognome());
			stmt.setString(3, vet.getCF());
			stmt.setString(4, vet.getEmail());
			stmt.setString(5, vet.getCellulare());
			stmt.setString(6, vet.getCitta());
			stmt.setString(7, vet.getIndirizzo());
			stmt.setString(8, vet.getPIVA());
			stmt.setString(9, vet.getContratto());
			stmt.setDouble(10, vet.getStipendio());
			stmt.setDouble(11, vet.getCommissioni());
			stmt.setString(12, vet.getIBAN());
			stmt.executeUpdate();

			return true;

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * elimina nel db veterinario selezionato
	 * 
	 * @param vet veterinario da eliminare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
	public void deleteVeterinari(Veterinari vet) {

		String CF = vet.getCF();
		String query = "delete from DIPENDENTI where CF_DIP=\"" + CF + "\"";

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
	 * update nel db vet selezionato
	 * 
	 * @param vet vet da aggiornare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	@Override
	public void updateVeterinari(Veterinari vet) {

		String query = "UPDATE DIPENDENTI SET NOME = ?,COGNOME = ?, EMAIL = ?,TELEFONO = ?,"
				+ "CITTA = ?,INDIRIZZO = ?,PIVA = ?,TIPO_DI_CONTRATTO = ?,STIPENDIO = ?,COMMISS = ?,IBAN = ? WHERE CF_DIP = \"" + vet.getCF() + "\"";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, vet.getNome());
			stmt.setString(2, vet.getCognome());
			stmt.setString(3, vet.getEmail());
			stmt.setString(4, vet.getCellulare());
			stmt.setString(5, vet.getCitta());
			stmt.setString(6, vet.getIndirizzo());
			stmt.setString(7, vet.getPIVA());
			stmt.setString(8, vet.getContratto());
			stmt.setDouble(9, vet.getStipendio());
			stmt.setDouble(10, vet.getCommissioni());
			stmt.setString(11, vet.getIBAN());
			stmt.executeUpdate();

			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
