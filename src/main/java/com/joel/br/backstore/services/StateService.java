package com.joel.br.backstore.services;

import com.joel.br.backstore.model.State;
import com.joel.br.backstore.repository.StateRepository;
import com.joel.br.backstore.services.IMPL.StateImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Stack;

@Service
public class StateService implements StateImpl {

    private  final StateRepository  stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public State findById(Long id) {
        return stateRepository.findById(id).get();
    }

    @Override
    public State save(State stack) {
        stack.setInitials(stack.getInitials().toUpperCase());

        return stateRepository.save(stack);
    }

    @Override
    public State update(Long id, State stack) {
        State state = stateRepository.findById(id).get();

        state.setName(stack.getName());
        state.setInitials(stack.getInitials().toUpperCase(Locale.ROOT));
        state.setUpdatedAt(stack.getUpdatedAt());
        stateRepository.save(state);
        return state;
    }

    @Override
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
