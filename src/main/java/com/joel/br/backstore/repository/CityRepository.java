package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
