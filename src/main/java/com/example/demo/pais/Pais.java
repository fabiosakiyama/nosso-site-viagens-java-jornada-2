package com.example.demo.pais;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Pais {
	
	@Id
	@NotNull
	private Long id;
	
	
	private String nome;
	
	
	
}
