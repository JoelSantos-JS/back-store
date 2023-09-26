package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.ImageProduct;
import com.joel.br.backstore.services.ImageProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/imageProduct")
public class ImageProductController {


    private  final ImageProductService  imageProductService;


    public ImageProductController(ImageProductService imageProductService) {
        this.imageProductService = imageProductService;
    }


    @GetMapping
    public ResponseEntity<List<ImageProduct>> getAll() {
        return ResponseEntity.ok(imageProductService.getAll());
    }


    @PostMapping

    public ResponseEntity<ImageProduct> save(@RequestParam Long id ,@RequestParam MultipartFile file) {
        return ResponseEntity.ok(imageProductService.save(id , file));
    }



    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imageProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
