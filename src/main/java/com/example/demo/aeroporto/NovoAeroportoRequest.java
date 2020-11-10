package com.example.demo.aeroporto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.example.demo.pais.Pais;

public class NovoAeroportoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long paisId;

	public Aeroporto toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, this.paisId);
		Assert.notNull(pais, "Passe um pa�s v�lido, cara!");
		return new Aeroporto(nome, pais);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public String getNome() {
		return this.nome;
	}
}
