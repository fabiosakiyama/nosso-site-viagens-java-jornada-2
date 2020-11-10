package com.example.demo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pais {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(nullable = false)
	private String nome;

	@Deprecated
	public Pais(){}

	public Pais(@NotNull String nome) {
		this.nome = nome;
	}
}
