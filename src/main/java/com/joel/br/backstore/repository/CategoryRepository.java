package com.joel.br.backstore.repository;

import com.joel.br.backstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
