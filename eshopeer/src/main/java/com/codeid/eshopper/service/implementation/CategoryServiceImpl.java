package com.codeid.eshopper.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.entities.Category;
import com.codeid.eshopper.repository.CategoryRepository;
import com.codeid.eshopper.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }

}
