package com.vinips.algafood.client.model.dto;

public class CidadeResumoDTO {
	
	private Long id;
	private String nome;
	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CidadeResumoDTO [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	
}
