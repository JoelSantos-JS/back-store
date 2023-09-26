package com.joel.br.backstore.services;

import com.joel.br.backstore.model.ImageProduct;
import com.joel.br.backstore.model.Product;
import com.joel.br.backstore.repository.ImageProductRepository;
import com.joel.br.backstore.repository.ProductRepository;
import com.joel.br.backstore.services.IMPL.ImageProductImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class ImageProductService implements ImageProductImpl {
    private final ImageProductRepository imageProductRepository;
    private  final ProductRepository productRepository;

    public ImageProductService(ImageProductRepository imageProductRepository, ProductRepository productRepository) {
        this.imageProductRepository = imageProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ImageProduct> getAll() {
        return imageProductRepository.findAll();
    }

    @Override
    public ImageProduct findById(Long id) {
        return imageProductRepository.findById(id).orElse(null);
    }

    @Override
    public ImageProduct save(ImageProduct imageProduct) {
        return null;
    }

    public ImageProduct save(Long id , MultipartFile file) {
        Product product =  productRepository.findById(id).get();
        ImageProduct imageProduct1 = new ImageProduct();

        try {
            if(!file.isEmpty()){
               byte[] bytes = file.getBytes();
               String nameImage=  String.valueOf(product.getId()) + file.getOriginalFilename();
                Path path = Paths.
                        get("/home/joel/Área de Trabalho/RECRIANDO/im" + nameImage);
                Files.write(path, bytes);
                imageProduct1.setName(nameImage);
            }

        }catch (Exception e) {
        e.printStackTrace();
        }

        imageProduct1.setProduct(product);

        return imageProductRepository.save(imageProduct1);
    }

    @Override
    public ImageProduct update(Long id, ImageProduct imageProduct) {
        ImageProduct imageProduct1 = findById(id);
        if (imageProduct1 != null) {
            BeanUtils.copyProperties(imageProduct, imageProduct1, "id");
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    imageProductRepository.deleteById(id);
    }
}
