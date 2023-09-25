package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.State;

import java.util.List;
import java.util.Stack;

public interface StateImpl {

    List<State> getAll();
    State findById(Long id);
    State save(State stack);
    State update(Long id ,State stack);
    void delete(Long id);
}
