package com.example.demo.pais;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class PaisController {

    private EntityManager entityManager;

    public PaisController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pais pais) {
        entityManager.persist(pais);
        return ResponseEntity.status(201).build();
    }
}
