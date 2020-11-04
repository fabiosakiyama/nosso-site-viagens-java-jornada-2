package com.example.demo.company;

import com.example.demo.country.Country;
import com.example.demo.country.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;

    public CompanyController(CompanyRepository companyRepository, CountryRepository countryRepository) {
        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> creatCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        final Country country = countryRepository.findById(companyDTO.getCountryId())
                .orElseThrow(RuntimeException::new);

        companyRepository.save(companyDTO.toModel(country));

        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }
}
