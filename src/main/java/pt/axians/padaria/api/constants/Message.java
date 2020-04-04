package pt.axians.padaria.api.constants;

public final class Message {
	
	private static final String CT_ADM = "Contate o reponsável técnico.";
	
	public static class ERROR {
		public static String SEARCH_VALUE = "Erro ao buscar o valor para os dados inseridos. " + CT_ADM;
		public static String QUANTITY_VALUE = "Erro na quantidade informada. Tente inserir um número inteiro. ";
		public static String MIN_QUANTITY = "Erro na quantidade informada. Deve ser superior a: ";
	}
}
