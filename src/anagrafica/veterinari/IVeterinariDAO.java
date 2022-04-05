package anagrafica.veterinari;

import java.util.ArrayList;

public interface IVeterinariDAO {
	public ArrayList<Veterinari> selectAll();


	public void insertVeterinari(Veterinari vet);

}
