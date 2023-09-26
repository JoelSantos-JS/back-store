package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.Brand;
import com.joel.br.backstore.model.City;

import java.util.List;

public interface BrandImpl {
    List<Brand> getAll();
    Brand findById(Long id);
    Brand save(Brand brand);
    Brand update(Long id ,Brand brand);
    void delete(Long id);
}
