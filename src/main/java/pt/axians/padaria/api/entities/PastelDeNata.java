package pt.axians.padaria.api.entities;

import java.util.ArrayList;

public class PastelDeNata extends Product {

	private Integer quantity;
	private String code;
	private static Integer minQuantity = 3;
	private static Integer maxQuantity = 5;
	private static Double minValue = 6.99;
	private static Double maxValue = 8.99;
	
	@Override
	public Integer getQuantity() {
		return this.quantity;
	}
	
	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void calculateRequest(Integer quantity, String requestProduct) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		calculate(list, quantity, quantity, requestProduct);
	}

	private void calculate(ArrayList<Integer> list, Integer quantity, Integer firstQuantity, String requestProduct) throws Exception {
		if (quantity == 0) {
			printCalculate(list, firstQuantity, requestProduct);
		} else if (quantity >= minQuantity){
			if (quantity % maxQuantity == 0 || quantity - maxQuantity >= minQuantity) {
				list.add(maxQuantity);
				calculate(list, quantity - maxQuantity, firstQuantity, requestProduct);
			} else if (quantity % minQuantity == 0 || quantity - minQuantity >= minQuantity) {
				list.add(minQuantity);
				calculate(list, quantity - minQuantity, firstQuantity, requestProduct);
			} else {
				throw new Exception();
			}
		} else {
			throw new Exception();
		}
	}

	private void printCalculate(ArrayList<Integer> list, Integer quantity, String requestProduct) {
		ArrayList<String> listStr = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		str.append(quantity).append(" ").append(requestProduct).append(" €");
		Integer min = 0;
		Integer max = 0;
		Double total = 0.00;
		
		for (Integer i : list) {
			if (i.equals(maxQuantity)) {
				total = Double.sum(total, maxValue);
				max += 1;
			} else {
				total = Double.sum(total, minValue);
				min += 1;
			}
		}
		
		if (max > 0) {
			listStr.add(max.toString().concat(" x ").concat(maxQuantity.toString()).concat(" €").concat(maxValue.toString()));
		}
		
		if (min > 0) {
			listStr.add(min.toString().concat(" x ").concat(minQuantity.toString()).concat(" €").concat(minValue.toString()));
		}
		
		str.append(Math.round(total * 100.0)/ 100.0).append(System.getProperty("line.separator"));

		for (String s : listStr) {
			str.append(s).append(System.getProperty("line.separator"));
		}
		
		System.out.println(str.toString());
		
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
