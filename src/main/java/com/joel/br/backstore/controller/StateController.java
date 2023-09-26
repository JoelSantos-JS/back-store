package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.State;
import com.joel.br.backstore.services.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    private  final StateService  stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ResponseEntity<List<State>> getAll() {
    return  ResponseEntity.ok().body(stateService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable  Long id) {
        return ResponseEntity.ok().body(stateService.findById(id));
    }


    @PostMapping
    public ResponseEntity<State> save(@RequestBody  State state) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(state));
    }


    @PutMapping("/{id}")
    public ResponseEntity<State> update(@PathVariable Long id, @RequestBody  State state) {
        return ResponseEntity.ok().body(stateService.update(id, state));
    }



    @DeleteMapping
    ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stateService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
