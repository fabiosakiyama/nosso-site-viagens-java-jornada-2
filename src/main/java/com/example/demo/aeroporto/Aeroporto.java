package com.example.demo.aeroporto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.demo.pais.Pais;

@Entity
public class Aeroporto {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn()
	private Pais pais;
	
	@Deprecated
	public Aeroporto() {}

	public Aeroporto(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
}
