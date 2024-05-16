package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.mappers.CategoriesMapper;
import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import com.prueba.INTCOMEX.repositories.CategoryRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CategoryServiceImp implements CategoryService{


    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoriesMapper mapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoriesMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Long createCategory(CategoriesDTO categoriesDTO) {
        Categories categories = mapper.toEntity(categoriesDTO);
        categoryRepository.save(categories);
        log.info("Save category"+categoriesDTO);
        return categories.getCategoryID();
    }

    @Override
    public List<Categories> getAllCategories() {
        return List.of();
    }
}
