package com.joel.br.backstore.services;

import com.joel.br.backstore.model.Category;
import com.joel.br.backstore.repository.CategoryRepository;
import com.joel.br.backstore.services.IMPL.CategoryImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CategoryImpl {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category category1  = findById(id);
        if (category1 != null) {
            BeanUtils.copyProperties(category, category1, "id");
            return categoryRepository.save(category1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    categoryRepository.deleteById(id);
    }
}
