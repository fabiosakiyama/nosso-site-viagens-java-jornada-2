package com.example.demo.aeroporto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
	
	private EntityManager entityManager;
	private NomeUnicoAeroportoValidator nomeUnicoAeroportoValidator;

	public AeroportoController(EntityManager entityManager, NomeUnicoAeroportoValidator nomeUnicoAeroportoValidator) {
		this.entityManager = entityManager;
		this.nomeUnicoAeroportoValidator = nomeUnicoAeroportoValidator;
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeUnicoAeroportoValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> save(@Valid @RequestBody NovoAeroportoRequest request){
		Aeroporto aeroporto = request.toModel(entityManager);
		entityManager.persist(aeroporto);
		return ResponseEntity.ok().build();
	}

}
