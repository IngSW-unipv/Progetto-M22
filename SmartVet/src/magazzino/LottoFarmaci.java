package magazzino;

import java.util.ArrayList;
import java.util.Date;

import anagrafica.fornitori.Fornitori;

public class LottoFarmaci implements Vendibile {
	private String IDLotto;
	private ModAssunz mode;
	private TipoFarmaci type;
	private Date dataScadenza;
	private ArrayList<Fornitori> fornitore;
	private int quantita;
}
