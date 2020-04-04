package pt.axians.padaria.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.axians.padaria.api.entities.Product;
import pt.axians.padaria.api.entities.RequestValue;
import pt.axians.padaria.api.response.Response;
import pt.axians.padaria.constants.Message;

@RestController
@RequestMapping("/pedido")
public class RequestController {
	
	@GetMapping("finalValue")
	public ResponseEntity<Response<RequestValue>> valorFinal(@RequestParam(required = true) Integer quantity,
			  @RequestParam(required = true) String code) {
		Response<RequestValue> response = new Response<RequestValue>();
		
		try {
			RequestValue finalValue = new RequestValue();
			finalValue.setValor(code);
			response.setData(finalValue);
		} catch (Exception e) {
			response.setErro(Message.ERROR.SEARCH_VALUE);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);	
	}
	
	@PostMapping("total")
	public ResponseEntity<Response<RequestValue>> valor(@RequestBody Product product) {
		Response<RequestValue> response = new Response<RequestValue>();
		
		try {
			RequestValue finalValue = new RequestValue();
			finalValue.setValor(product.getCode());
			response.setData(finalValue);
		} catch (Exception e) {
			response.setErro(Message.ERROR.SEARCH_VALUE);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);	
	}

}
