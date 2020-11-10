package com.example.demo.aeroporto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
	
	private EntityManager entityManager;
	
	public AeroportoController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Aeroporto> save(@Valid @RequestBody NovoAeroportoRequest request){
		Aeroporto aeroporto = request.toModel(entityManager);
		entityManager.persist(aeroporto);
		return ResponseEntity.ok(aeroporto);
	}

}
