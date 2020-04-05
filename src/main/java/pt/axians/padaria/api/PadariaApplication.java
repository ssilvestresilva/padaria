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
			requestProduct = req[1].toUpperCase().trim();
			
			Product p = productFactory.getProduct(requestProduct);
			
			if (p != null) {
				p.calculateValue(requestProduct, quantity, p);
			}
			
		} catch (IOException e) {
			System.out.println(Message.ERROR.SEARCH_VALUE);
		} catch (NumberFormatException e) {
			System.out.println(Message.ERROR.QUANTITY_VALUE);
		} catch (Exception e) {
			System.out.println(Message.ERROR.PACK_VALUE);
		}
	}
}
