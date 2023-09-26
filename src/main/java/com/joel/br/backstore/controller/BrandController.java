package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.Brand;
import com.joel.br.backstore.services.BrandServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.management.LockInfo;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {


    private final BrandServices brandServices;

    public BrandController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }


    @GetMapping

    public ResponseEntity<List<Brand>> getAll() {
        return  ResponseEntity.ok(brandServices.getAll());
    }

    @GetMapping
    ("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable  Long id) {
        return ResponseEntity.ok(brandServices.findById(id));
    }

    @PostMapping

    public ResponseEntity<Brand> save(@RequestBody  Brand brand) {
        return ResponseEntity.ok().body(brandServices.save(brand));
    }


    @PutMapping
            ("/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand brand) {
        return ResponseEntity.ok().body(brandServices.update(id, brand));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        brandServices.delete(id);
    }

}
