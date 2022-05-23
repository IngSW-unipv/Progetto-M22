package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import model.magazzino.farmaci.LottoFarmaci;
import view.magazzino.farmaci.FarmaciPanel;

public class ModificaFarmaciActionListener implements ActionListener {

	FarmaciPanel farmaciPanel;
	ArrayList<LottoFarmaci> lf;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = farmaciPanel.getTabellaFarmaci().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			String IDLotto = lf.get(rigaSelezionata).getIDLotto();
			String mode = lf.get(rigaSelezionata).getMode();
			String type = lf.get(rigaSelezionata).getType();
			String PIVA = lf.get(rigaSelezionata).getFornitore().getPIVA();
			Date dataScadenza = lf.get(rigaSelezionata).getDataScadenza();
			int quantita = lf.get(rigaSelezionata).getQuantita();

			farmaciPanel.getIDLottoText().setText(IDLotto);
			farmaciPanel.getModeText().setText(mode);
			farmaciPanel.getTipoText().setText(type);
			farmaciPanel.getFornitoriBox().setSelectedItem(PIVA);
			farmaciPanel.getDataScadenza().setDate(dataScadenza);
			farmaciPanel.getSpinner().setValue(quantita);
		}

	}

	public ModificaFarmaciActionListener(FarmaciPanel farmaciPanel, ArrayList<LottoFarmaci> lf) {
		super();
		this.farmaciPanel = farmaciPanel;
		this.lf = lf;
	}
	

}
