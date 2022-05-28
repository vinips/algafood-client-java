package com.vinips.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.vinips.algafood.client.api.RestauranteClient;
import com.vinips.algafood.client.exception.ClientApiException;
import com.vinips.algafood.client.model.dto.RestauranteDTO;
import com.vinips.algafood.client.model.input.CidadeIdInput;
import com.vinips.algafood.client.model.input.CozinhaIdInput;
import com.vinips.algafood.client.model.input.EnderecoInput;
import com.vinips.algafood.client.model.input.RestauranteInput;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080";
			
			RestauranteClient client = new RestauranteClient(restTemplate, url);
			
			CidadeIdInput cidadeIdInput = new CidadeIdInput();
			cidadeIdInput.setId(6L);
			
			EnderecoInput enderecoInput = new EnderecoInput();
			enderecoInput.setCep("88974-322");
			enderecoInput.setLogradouro("Rua dos jonicus");
			enderecoInput.setNumero("877");
			enderecoInput.setComplemento("Apartamento - Bl. 2");
			enderecoInput.setBairro("Loteamento Jussara");
			enderecoInput.setCidade(cidadeIdInput);
			
			CozinhaIdInput cozinhaIdInput = new CozinhaIdInput();
			cozinhaIdInput.setId(4L);
			
			RestauranteInput restauranteInput = new RestauranteInput();
			restauranteInput.setNome("Tainhada do Sérgio");
			restauranteInput.setTaxaFrete(new BigDecimal(12.5));
			restauranteInput.setCozinha(cozinhaIdInput);
			restauranteInput.setEndereco(enderecoInput);
			
			RestauranteDTO dto = client.adicionar(restauranteInput);
			
			System.out.println(dto);
			
		} catch (ClientApiException e) {
			if (e.getProblem() != null) {
				System.out.println(e.getProblem().getUserMessage());
		        
		        e.getProblem().getFields().stream()
		          .forEach(f -> System.out.println("- " + f.getUserMessage()));
	        } else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
		
	}
	
}
