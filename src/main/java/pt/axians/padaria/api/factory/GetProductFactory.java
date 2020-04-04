package pt.axians.padaria.api.factory;

import pt.axians.padaria.api.entities.PastelDeNata;
import pt.axians.padaria.api.entities.Product;
import pt.axians.padaria.api.entities.Queijadinha;
import pt.axians.padaria.api.entities.TravesseirosDeSintra;

public class GetProductFactory {

	private static final String PN = "PN";
	private static final String TS = "TS";
	private static final String QJD = "QJD";
	
	public Product getProduct(String requestProduct) {

		if (requestProduct == null) {
			return null;
		}
		
		switch (requestProduct) {
		case PN:
			return new PastelDeNata();
		case TS:
			return new TravesseirosDeSintra();
		case QJD:
			return new Queijadinha();
		default:
			break;
		}

		return null;
	}

}
