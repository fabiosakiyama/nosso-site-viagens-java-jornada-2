package com.example.demo.country;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {


    @GetMapping
    public ResponseEntity getCountries() {

        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }
}
