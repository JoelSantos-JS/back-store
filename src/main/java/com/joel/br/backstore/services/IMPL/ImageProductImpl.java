package com.joel.br.backstore.services.IMPL;

import com.joel.br.backstore.model.ImageProduct;
import com.joel.br.backstore.model.PermissionP;

import java.util.List;

public interface ImageProductImpl {



    List<ImageProduct> getAll();
    ImageProduct findById(Long id);
    ImageProduct save(ImageProduct imageProduct);
    ImageProduct update(Long id ,ImageProduct imageProduct);
    void delete(Long id);
}

