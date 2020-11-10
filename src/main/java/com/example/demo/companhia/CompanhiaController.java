package com.example.demo.companhia;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    private EntityManager manager;
    private NomeUnicoCompanhiaValidator nomeUnicoCompanhiaValidator;

    public CompanhiaController(EntityManager manager, NomeUnicoCompanhiaValidator nomeUnicoCompanhiaValidator) {
        this.manager = manager;
        this.nomeUnicoCompanhiaValidator = nomeUnicoCompanhiaValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeUnicoCompanhiaValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> save(@Valid @RequestBody NovaCompanhiaRequest companhiaForm){
        this.manager.persist(companhiaForm.toModel(this.manager));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
