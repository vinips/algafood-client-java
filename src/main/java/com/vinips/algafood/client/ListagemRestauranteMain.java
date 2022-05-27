package com.vinips.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.vinips.algafood.client.api.RestauranteClient;

public class ListagemRestauranteMain {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080";
		
		RestauranteClient client = new RestauranteClient(restTemplate, url);
		
		client.listar().stream()
			.forEach(restaurante -> System.out.println(restaurante));
	}
	
}
