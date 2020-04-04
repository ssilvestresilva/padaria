package pt.axians.padaria.api.entities;

public class Product {
	private Integer quantity;
	private String code;
	private String name;

	public Product(Integer quantity, String code, String name) {
		this.quantity = quantity;
		this.code = code;
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
