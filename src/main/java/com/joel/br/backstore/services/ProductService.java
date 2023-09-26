package com.joel.br.backstore.services;

import com.joel.br.backstore.model.Product;
import com.joel.br.backstore.repository.ProductRepository;
import com.joel.br.backstore.services.IMPL.ProductImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductImpl {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product product1 =  findById(id);
        if (product1 != null) {
            BeanUtils.copyProperties(product, product1, "id");
            return productRepository.save(product1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    productRepository.deleteById(id);
    }
}
