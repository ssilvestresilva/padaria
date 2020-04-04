package pt.axians.padaria.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pt.axians.padaria.api.constants.Message;
import pt.axians.padaria.api.entities.Product;
import pt.axians.padaria.api.factory.GetProductFactory;

public class PadariaApplication {

	public static void main(String[] args) {
		GetProductFactory productFactory = new GetProductFactory();  

		System.out.print("Entre com a quantidade e o código do produto: ");  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  

		String requestProduct = "";
		Integer quantity = 0;
		
		try {
			requestProduct = br.readLine();
			String[] req = requestProduct.split(" ");
			quantity = Integer.valueOf(req[0]);
			requestProduct = req[1].toUpperCase();
		} catch (IOException e) {
			System.out.println(Message.ERROR.SEARCH_VALUE);
		} catch (NumberFormatException e) {
			System.out.println(Message.ERROR.QUANTITY_VALUE);
		}
	  
		Product p = productFactory.getProduct(requestProduct);
		
		if (p != null) {
			calculateValue(requestProduct, quantity, p);
		} else {
			System.out.println(Message.ERROR.SEARCH_VALUE);
		}
	}

	private static void calculateValue(String requestProduct, Integer quantity, Product p) {
		if (p.minRequest(quantity)) {
			System.out.print(quantity + " " + requestProduct + " €"+ p.calculateRequest());
		} else {
			System.out.println(Message.ERROR.MIN_QUANTITY + p.getMinRequest());
		}
	}  
}
