package magazzino;

import java.util.ArrayList;
import java.util.Date;

import anagrafica.fornitori.Fornitori;

public class ProdottiVendita implements Vendibile {
	private TipoProdottiVendita type;
	private int quantità;
	private Date dataScadenza;
	private ArrayList<Fornitori> fornitore;
}
