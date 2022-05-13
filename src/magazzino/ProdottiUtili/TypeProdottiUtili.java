package magazzino.ProdottiUtili;

public enum TypeProdottiUtili {
	BISTURI("bisturi"), PINZA("pinza"), GARZA("garza"), AGO("ago"), SIRINGA("siringa"), BENDA("benda"),
	DISINFETTANTE("disinfettante"), GUANTI("guanti"), MASCHERINA("mascherina"), COPRISCARPE("copriscarpe"),
	CAMICE("camice"), SCOTTEX("scottex"), LACCIOEMO("laccioemo");

	private String typeProdottiUtili;

	private TypeProdottiUtili(String typeProdottiUtili) {
		this.typeProdottiUtili = typeProdottiUtili;
	}

	@Override
	public String toString() {
		return typeProdottiUtili;
	}
}
