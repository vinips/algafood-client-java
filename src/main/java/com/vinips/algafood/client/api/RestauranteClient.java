package com.vinips.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.vinips.algafood.client.exception.ClientApiException;
import com.vinips.algafood.client.model.dto.RestauranteDTO;
import com.vinips.algafood.client.model.input.RestauranteInput;

public class RestauranteClient {
	
	private static final String RESOURCE_PATH = "/restaurantes";

	private RestTemplate restTemplate;
	private String url;
	
	public RestauranteClient(RestTemplate restTemplate, String url) {
		super();
		this.restTemplate = restTemplate;
		this.url = url;
	}

	public List<RestauranteDTO> listar(){
		try {
			URI resourceUri = URI.create(url + RESOURCE_PATH);
			
			//Vai fazer um get na URL que enviarmos e vai retornar a representação desserializada.
			RestauranteDTO[] restaurantes = restTemplate
					.getForObject(resourceUri, RestauranteDTO[].class);
			
			return Arrays.asList(restaurantes);
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
	public RestauranteDTO adicionar(RestauranteInput restauranteInput) {
		try {
			URI resourceUri = URI.create(url + RESOURCE_PATH);
			
			//Vai fazer um get na URL que enviarmos e vai retornar a representação desserializada.
			RestauranteDTO restaurante = restTemplate
					.postForObject(resourceUri, restauranteInput, RestauranteDTO.class);
			
			return restaurante;
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
}
