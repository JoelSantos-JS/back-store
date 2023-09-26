package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.Category;
import com.joel.br.backstore.model.State;

import java.util.List;

public interface CategoryImpl {

    List<Category> getAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id ,Category category);
    void delete(Long id);

}
