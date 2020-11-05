package com.example.demo.pais;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisForm {

    @NotBlank
    private String nome;

    public Pais toModel(){
        return new Pais(this.nome);
    }

    @JsonCreator
    public PaisForm(@NotNull @JsonProperty("nome") String nome) {
        this.nome = nome;
    }
}
