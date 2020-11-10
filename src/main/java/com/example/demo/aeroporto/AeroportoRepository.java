package com.example.demo.aeroporto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
    Optional<Aeroporto> findByNome(String nome);
}