package com.example.demo.company;

import com.example.demo.country.Country;

import javax.persistence.*;
import java.time.LocalDate;

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private LocalDate createdAt = LocalDate.now();

    @ManyToOne
    private Country country;
    
    public Company(String nome) {
        this.name = nome;
    }
}
