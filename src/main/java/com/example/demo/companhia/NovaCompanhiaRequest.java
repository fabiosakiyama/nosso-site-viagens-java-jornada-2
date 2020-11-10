package com.example.demo.companhia;

import com.example.demo.pais.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaCompanhiaRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private Long idPais;
    
    @Deprecated
    public NovaCompanhiaRequest() {}

	public NovaCompanhiaRequest(@NotBlank String nome, @NotNull @Positive Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Companhia toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.idPais);
        return new Companhia(this.nome, pais);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
}
