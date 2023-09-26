package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
