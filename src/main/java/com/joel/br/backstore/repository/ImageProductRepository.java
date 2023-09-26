package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageProductRepository extends JpaRepository<ImageProduct, Long> {
}
