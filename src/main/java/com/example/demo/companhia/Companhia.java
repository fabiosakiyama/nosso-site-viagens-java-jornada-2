package com.example.demo.companhia;

import com.example.demo.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime instanteCriacao;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Companhia(){}

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.instanteCriacao = LocalDateTime.now();
        this.pais = pais;
    }
}
