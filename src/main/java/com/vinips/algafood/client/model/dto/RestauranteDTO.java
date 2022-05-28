package com.vinips.algafood.client.model.dto;

import java.math.BigDecimal;

public class RestauranteDTO {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private boolean ativo;
	private boolean aberto;
	
	private CozinhaDTO cozinha;
	private EnderecoDTO endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	public CozinhaDTO getCozinha() {
		return cozinha;
	}

	public void setCozinha(CozinhaDTO cozinha) {
		this.cozinha = cozinha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	@Override
	public String toString() {
		return "RestauranteDTO [id=" + id + ", nome=" + nome + ", taxaFrete=" + taxaFrete + ", ativo=" + ativo
				+ ", aberto=" + aberto + ", cozinha=" + cozinha + ", endereco=" + endereco + "]";
	}
	
}
