package com.vinips.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.vinips.algafood.client.api.RestauranteClient;
import com.vinips.algafood.client.exception.ClientApiException;

public class ListagemRestauranteMain {

	public static void main(String[] args) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080";
			
			RestauranteClient client = new RestauranteClient(restTemplate, url);
			
			client.listar().stream()
				.forEach(restaurante -> System.out.println(restaurante));
		} catch (ClientApiException e) {
			if(e.getProblem() != null) {
				System.out.println(e.getProblem().getUserMessage());
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
		
	}
	
}
