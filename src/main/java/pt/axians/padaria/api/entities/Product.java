package pt.axians.padaria.api.entities;

import pt.axians.padaria.api.constants.Message;

public abstract class Product {

	public abstract Integer getQuantity();
	public abstract String getCode();
	public abstract void calculateRequest(Integer quantity, String requestProduct) throws Exception;
	public abstract boolean minRequest(Integer quantity);
	public abstract Integer getMinRequest();
	
	@Override
	public String toString() {
		return "Product [Quantity=" + getQuantity() + ", Code=" + getCode() + "]";
	}
	public void calculateValue(String requestProduct, Integer quantity, Product p) throws Exception {
		if (minRequest(quantity)) {
			calculateRequest(quantity, requestProduct);
		} else {
			System.out.println(Message.ERROR.MIN_QUANTITY + p.getMinRequest());
		}
	}
}
