package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
