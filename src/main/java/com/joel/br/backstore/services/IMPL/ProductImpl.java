package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.Product;
import com.joel.br.backstore.model.State;

import java.util.List;

public interface ProductImpl {

    List<Product> getAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Long id ,Product product);
    void delete(Long id);
}
