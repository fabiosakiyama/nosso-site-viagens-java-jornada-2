package com.example.demo.companhia;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    private EntityManager manager;

    public CompanhiaController(EntityManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<Void> save( @RequestBody NovaCompanhiaRequest companhiaForm){
        this.manager.persist(companhiaForm.toModel(this.manager));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
