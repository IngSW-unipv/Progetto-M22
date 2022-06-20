package database.classiDAO.anagraficaDAO.veterinariDAO;
/**
 * interfaccia con metodi da implementare
 * in VeterinariDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see VeterinariDAO
 */
import java.util.ArrayList;

import model.anagrafica.veterinari.Veterinari;

public interface IVeterinariDAO {
	
	public ArrayList<Veterinari> selectAll();

	public boolean insertVeterinari(Veterinari vet);

	public Veterinari select_Veterinari_from_CF(String CF);
	
	public void deleteVeterinari(Veterinari vet);

	/**
	 * update nel db vet selezionato
	 * 
	 * @param vet vet da aggiornare
	 * @return void
	 * @exception SQLException qualcosa è andato storto nel delete
	 */
	void updateVeterinari(Veterinari vet);
}
