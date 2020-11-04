package com.example.demo.company;

import com.example.demo.country.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private EntityManager entityManager;

    public CompanyController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    public ResponseEntity<Void> creatCompanie(@Valid @RequestBody CompanyDTO companyDTO) {
        entityManager.persist(companyDTO.toModel());
        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }
}
