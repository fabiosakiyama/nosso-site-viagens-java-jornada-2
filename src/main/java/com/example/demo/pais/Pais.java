package com.example.demo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String nome;
	
	@JsonCreator
	public Pais(@NotNull @JsonProperty("nome") String nome) {
		this.nome = nome;
	}
}
