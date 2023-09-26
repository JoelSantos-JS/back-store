package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.Category;
import com.joel.br.backstore.model.PermissionP;
import com.joel.br.backstore.model.Person;
import com.joel.br.backstore.services.PermissionServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {


    private  final PermissionServices permissionServices;

    public PermissionController(PermissionServices permissionServices) {
        this.permissionServices = permissionServices;
    }


    @GetMapping(value = "/person/{persons}")
    public ResponseEntity<List<Person>> getAll(@PathVariable Long persons){
        return ResponseEntity.ok().body(permissionServices.getAllPerson(persons));
    }
    @GetMapping
    public ResponseEntity<List<PermissionP>> getAll() {
        return ResponseEntity.ok().body(permissionServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionP> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(permissionServices.findById(id));
    }
    @PostMapping
    public ResponseEntity<PermissionP> save(@RequestBody PermissionP permissionP) {
        return ResponseEntity.ok().body(permissionServices.save(permissionP));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionP> update(@PathVariable Long id, @RequestBody PermissionP permissionP) {
        return ResponseEntity.ok().body(permissionServices.update(id, permissionP));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        permissionServices.delete(id);
    }
}
