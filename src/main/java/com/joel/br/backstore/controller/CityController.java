package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.City;
import com.joel.br.backstore.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private  final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping

    public ResponseEntity<List<City>> getAll() {
        return  ResponseEntity.ok().body(cityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(cityService.findById(id));
    }

    @PostMapping

    public ResponseEntity<City> save(@RequestBody City city) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(city));
    }


    @PutMapping("/{id}")

    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        return ResponseEntity.ok().body(cityService.update(id, city));
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
