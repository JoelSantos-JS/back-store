package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.City;
import com.joel.br.backstore.model.State;

import java.util.List;

public interface CityImpl {
    List<City> getAll();
    City findById(Long id);
    City save(City city);
    City update(Long id ,City city);
    void delete(Long id);
}
