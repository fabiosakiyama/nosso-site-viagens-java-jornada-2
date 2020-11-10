package com.example.demo.companhia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {
    Optional<Companhia> findByNome(String nome);
}
