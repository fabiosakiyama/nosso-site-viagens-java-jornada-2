package com.example.demo.country;

import javax.validation.constraints.NotBlank;

public class CountryDTO {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Country toModel() {
        return new Country(this.nome);
    }
}