package com.example.demo.pais;

import javax.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/pais")
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
