package com.example.demo.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createCountries(@Valid @RequestBody CountryDTO countryDTO) {
        countryRepository.save(countryDTO.toModel());
        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }
}