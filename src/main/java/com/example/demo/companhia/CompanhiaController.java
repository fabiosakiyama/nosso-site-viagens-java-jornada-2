package com.example.demo.companhia;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    private EntityManager manager;

    public CompanhiaController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> save(@Valid @RequestBody NovaCompanhiaRequest companhiaForm){
        this.manager.persist(companhiaForm.toModel(this.manager));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
