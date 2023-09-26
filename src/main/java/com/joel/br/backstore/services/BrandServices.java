package com.joel.br.backstore.services;

import com.joel.br.backstore.model.Brand;
import com.joel.br.backstore.repository.BrandRepository;
import com.joel.br.backstore.services.IMPL.BrandImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServices implements BrandImpl
{


    private  final BrandRepository brandRepository;

    public BrandServices(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Long id, Brand brand) {

        Brand brand1 = brandRepository.findById(id).get();
        brand1.setName(brand.getName());
        brand1.setUpdatedAt(brand.getUpdatedAt());

        return      brandRepository.save(brand1);
    }

    @Override
    public void delete(Long id) {
brandRepository.deleteById(id);
    }
}
