package pt.axians.padaria.api.entities;

public class PastelDeNata extends Product {

	private Integer quantity;
	private String code;
	private static Integer minQuantity = 3;
	
	@Override
	public Integer getQuantity() {
		return this.quantity;
	}
	
	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public Double calculateRequest() {
		return null;
	}

	@Override
	public boolean minRequest(Integer quantity) {
		return quantity > minQuantity;
	}

	@Override
	public Integer getMinRequest() {
		return null;
	}
	
}
