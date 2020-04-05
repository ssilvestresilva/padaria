package pt.axians.padaria.api.constants;

public final class Message {
	
	public static class ERROR {
		public static String SEARCH_VALUE = "Erro ao buscar o valor para os dados inseridos. Exemplo: 10 PN. ";
		public static String QUANTITY_VALUE = "Erro na quantidade informada. Tente inserir um número inteiro seguido de seu código. Exemplo: 10 PN ";
		public static String MIN_QUANTITY = "Erro na quantidade informada. Deve ser superior a: ";
		public static String PACK_VALUE = "Nenhum pacote encontrado para a quantidade informada ou não foi informado o Produto. ";
	}
}
