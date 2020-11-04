package com.example.demo.country;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.country.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}