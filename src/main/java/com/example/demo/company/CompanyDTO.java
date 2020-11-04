package com.example.demo.company;

import com.example.demo.country.Country;

import javax.validation.constraints.NotBlank;

public class CompanyDTO {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }
    
    public CompanyDTO toModel() {
        return null;
    }
}