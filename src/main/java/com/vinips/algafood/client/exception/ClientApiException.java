package com.vinips.algafood.client.exception;

import org.springframework.web.client.RestClientResponseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vinips.algafood.client.model.Problem;

public class ClientApiException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Problem problem;

	public ClientApiException(String message, RestClientResponseException cause) {
		super(message, cause);
		
		deserializeProblem(cause);
	}
	
	private void deserializeProblem(RestClientResponseException cause) {
		ObjectMapper mapper = new ObjectMapper();
		
		//Aviso o ObjectMapper para ele não falhar caso não consiga faz origem - destino dos atributos que ele ta deserializando
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//Com isso ele tem capacidade de reconhecer objetos dataHora do pacote JavaTime
		//Sem isso ele não consegue converter uma string em OffSetDateTime
		mapper.registerModule(new JavaTimeModule());
		mapper.findAndRegisterModules();

		try {
			this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
		} catch (JsonProcessingException e) {
			System.out.println("Não foi possível desserealizar a resposta em um problema");
		}
	}

	public Problem getProblem() {
		return problem;
	}


}
