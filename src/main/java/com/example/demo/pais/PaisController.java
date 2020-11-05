package com.example.demo.pais;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
    @Transactional
    public ResponseEntity<?> save(@RequestBody PaisForm pais) {
        entityManager.persist(pais.toModel());
        return ResponseEntity.status(201).build();
    }
}
