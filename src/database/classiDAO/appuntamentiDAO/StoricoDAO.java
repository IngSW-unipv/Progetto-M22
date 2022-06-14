package database.classiDAO.appuntamentiDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.pazienti.Paziente;
/**
 * permette di fare query sulla tabella appuntamenti del database
 * ma si riferisce a tutti gli appuntamenti non solo
 * a quelli dal giorno corrente in poi
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class StoricoDAO implements IStoricoDAO {
	private DbSingleton db;

	//costruttore
	public StoricoDAO() {
		super();
		db = DbSingleton.getInstance();
	}

	/**
	 * seleziona tutti gli appuntamenti presenti nel db
	 * 
	 * @return ArrayList<Appuntamenti> tutti gli appuntamenti presenti nel db
	 * 
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
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

	/**
	 * seleziona tutti gli appuntamenti presenti nel db
	 * in base al CF del veterinario passato come parametro
	 * 
	 * @param CFvet CF del veterinario da cui selezionare appuntamenti
	 * @return ArrayList<Appuntamenti> tutti gli appuntamenti presenti nel db
	 *  del veterinario passato come parametro
	 * 
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
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
