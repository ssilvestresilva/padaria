package pt.axians.padaria.api.entities;

public abstract class Product {

	public abstract Integer getQuantity();
	public abstract String getCode();
	public abstract Double calculateRequest();
	public abstract boolean minRequest(Integer quantity);
	public abstract Integer getMinRequest();
	
	@Override
	public String toString() {
		return "Product [Quantity=" + getQuantity() + ", Code=" + getCode() + "]";
	}
}
