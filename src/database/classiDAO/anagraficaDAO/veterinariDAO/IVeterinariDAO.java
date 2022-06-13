package database.classiDAO.anagraficaDAO.veterinariDAO;

import java.util.ArrayList;

import model.anagrafica.veterinari.Veterinari;

public interface IVeterinariDAO {
	
	public ArrayList<Veterinari> selectAll();

	public boolean insertVeterinari(Veterinari vet);

	public Veterinari select_Veterinari_from_CF(String CF);
	
	public ArrayList<String> getCFDAO();
	
	public void deleteVeterinari(Veterinari vet);
}
