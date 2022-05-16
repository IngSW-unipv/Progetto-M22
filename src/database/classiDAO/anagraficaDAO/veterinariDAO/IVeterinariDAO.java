package database.classiDAO.anagraficaDAO.veterinariDAO;

import java.util.ArrayList;

import model.anagrafica.veterinari.Veterinari;

public interface IVeterinariDAO {
	public ArrayList<Veterinari> selectAll();


	public void insertVeterinari(Veterinari vet);

}
