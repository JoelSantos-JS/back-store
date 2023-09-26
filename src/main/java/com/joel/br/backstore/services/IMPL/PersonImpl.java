package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.model.State;

import java.util.List;

public interface PersonImpl {
    List<Person> getAll();
    Person findById(Long id);
    Person save(Person person);
    Person update(Long id ,Person person);
    void delete(Long id);
}
