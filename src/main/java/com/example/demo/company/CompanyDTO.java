package com.example.demo.company;

import com.example.demo.country.Country;

import com.example.demo.country.CountryRepository;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanyDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Long countryId;

    public String getNome() {
        return nome;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public Company toModel(CountryRepository countryRepository) {
        Country country=countryRepository.findById(countryId)
            .orElseThrow(RuntimeException::new);
        return new Company(this.nome, country);
    }
}