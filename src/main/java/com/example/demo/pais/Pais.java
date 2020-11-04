package com.example.demo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;

	public Pais(@NotNull String nome) {
		this.nome = nome;
	}
}
